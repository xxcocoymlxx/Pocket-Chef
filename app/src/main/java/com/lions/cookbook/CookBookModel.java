package com.lions.cookbook;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CookBookModel implements CookBookContract.CookBookMVPModel {

    private DatabaseReference mDatabase;
    private ArrayList<String> RecipeList;
    private ArrayList<String> KeyList;
    private ArrayList<CookBookObserver> observers;

    public CookBookModel(DatabaseReference database){
        mDatabase = database;
        RecipeList = new ArrayList<>();
        KeyList = new ArrayList<>();
        observers = new ArrayList<>();
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query myCookbookQuery = mDatabase.child("users").child(uid).child("cookbook").orderByValue();
        ChildEventListener listener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.d("Cookbook Read", "ChildAdded: "+dataSnapshot.getKey());
                RecipeList.add(dataSnapshot.getValue(String.class));
                KeyList.add(dataSnapshot.getKey());
                notifyAllObservers();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.d("Cookbook Read", "ChildChanged: "+dataSnapshot.getKey());
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                Log.d("Cookbook Read", "ChildRemoved: "+dataSnapshot.getKey());
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.d("Cookbook Read", "ChildMoved: "+dataSnapshot.getKey());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Cookbook Read", "Read Cancelled");
            }
        };

        myCookbookQuery.addChildEventListener(listener);
    }

    @Override
    public ArrayList<String> getRecipeNamesDB() {
        return RecipeList;
    }

    public ArrayList<String> getKeyList() {
        return KeyList;
    }

    @Override
    public List<String> getRecipeImages() {
        return null;
    }

    @Override
    public void addObserver(CookBookObserver observer) {
        this.observers.add(observer);
    }

    public void notifyAllObservers(){
        for (CookBookObserver observer : observers){
            observer.update(getRecipeNamesDB(), getKeyList());
        }
    }

    public void deleteRecipe(String recipeTitle, Boolean isShared){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        mDatabase.child("recipes").child(user.getUid()).child(recipeTitle).removeValue();
        /*This is still theoretical.
        if (isShared) {

            mDatabase.child("shared_recipes").child(user.getUid()).child(recipeTitle).removeValue();
        }
        */
    }

}
