package com.lions.cookbook;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class PublicUserProfileModel implements PublicUserProfileContract.PublicUserProfileModel {
    FirebaseAuth mAuth;
    DatabaseReference db;
    private ArrayList<PublicProfileObserver> observers = new ArrayList<PublicProfileObserver>();
    //these variables below hold user info read from db
    private String username;
    private String fullname;
    private ArrayList<String> recipes;
    private ArrayList<String> recipeIds;

    public PublicUserProfileModel(DatabaseReference db, String username){
        Log.d("TEST", "Can you initialize the model");

        this.username = username;
        this.mAuth = FirebaseAuth.getInstance();
        this.db = db;
        this.recipes = new ArrayList<String>();
        this.recipeIds = new ArrayList<String>();
        this.findRecipes();
        this.findFullname();
    }

    public void addObserver(PublicProfileObserver observer){
        this.observers.add(observer);
    }

    public void notifyAllObservers(){
        for (PublicProfileObserver observer : this.observers) {
            observer.update(this.fullname, this.recipes, this.recipeIds);
        }
    }

    public String extractID(String accountInfoStr){
        return accountInfoStr.substring(accountInfoStr.indexOf('{')+1, accountInfoStr.indexOf('='));
    }

    public void findFullname(){
        Query query = db.child("users").orderByChild("username").equalTo(this.username);
        ValueEventListener fullNameListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String accountInfoStr = dataSnapshot.getValue().toString();
                    String uid = extractID(accountInfoStr);
                    fullname = dataSnapshot.child(uid).child("fullname").getValue(String.class);
                    if (fullname == null){
                        Log.d("fnn", "full name was null");
                    }
                    notifyAllObservers();
                    if (fullname != null) {
                        Log.d("TEST", "got the correct FULL NAME in public profile MODEL:".concat(fullname));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                fullname = null;
            }
        };
        query.addValueEventListener(fullNameListener);
    }

    public void findRecipes(){
        Query query = db.child("users").orderByChild("username").equalTo(this.username);

        ValueEventListener recipeListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("inside OnDataChange", "inside recipe OnDataChange");
                if (dataSnapshot.exists()){
                    String accountInfoStr = dataSnapshot.getValue().toString();
                    String uid = extractID(accountInfoStr);
                    for (DataSnapshot recipeSnapshot : dataSnapshot.child(uid).child("published_recipes").getChildren()){
                        String recipeId = recipeSnapshot.getKey();
                        Log.d("recipe key", "recipe key found for public: ".concat(recipeId));
                        Log.d("recipe snapshot", "recipe snapshot: ".concat(recipeSnapshot.child(recipeId).toString()));
                        recipeIds.add(recipeId);
                        String recipeName = recipeSnapshot.getValue(String.class);
                        Log.d("recipe title", "recipe title found: ".concat(recipeName));
                        recipes.add(recipeName);
                    }
                    notifyAllObservers();

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                recipes = new ArrayList<String>();
            }
        };
        query.addValueEventListener(recipeListener);
        }
    }
