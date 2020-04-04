package com.lions.cookbook;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountModel implements CreateAccountContract.CreateAccountMVPModel {
    private DatabaseReference db;
    private FirebaseAuth mAuth;
    private String errorMessage;
    private ArrayList<CreateAccountObserver> observers;
    private Object fetchRes;

    public CreateAccountModel(DatabaseReference db){
        this.db = db;
        this.mAuth = FirebaseAuth.getInstance();
        this.errorMessage = "";
        this.observers = new ArrayList<CreateAccountObserver>();
    }

    public void addObserver(CreateAccountObserver observer){
        this.observers.add(observer);
    }

    public void notifyObservers(){
        for (CreateAccountObserver observer: this.observers){
            observer.update(this.errorMessage);
        }
    }

    //doesn't notify observers because must check emails too
    public void validateUsername(String username){
        errorMessage = "";
        Query query = db.child("users").orderByChild("username").equalTo(username);
        ValueEventListener usernameListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    errorMessage = "username already in use";
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                errorMessage = "";
            }
        };
        query.addListenerForSingleValueEvent(usernameListener);
    }

    //only emails notifies observers
    public void validateEmail(String email) {
        Query query = db.child("users").orderByChild("email").equalTo(email);
        ValueEventListener emailListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    errorMessage = "email already in use";
                }
                notifyObservers();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                errorMessage = "";
            }
        };
        query.addListenerForSingleValueEvent(emailListener);
    }

    public void addNewUser(String email, String userPassword, String username, String firstname, String lastname, String phone){
        OnCompleteListener accountCreationListener = new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                storeUserInfo(email, username, firstname, lastname, phone );
            }
        };
        //ensure never called if provided email or username can't be used
        if (this.errorMessage.equals("")){
            mAuth.createUserWithEmailAndPassword(email, userPassword).addOnCompleteListener(accountCreationListener);
        }
    }

    public void storeUserInfo(String email, String userName, String firstName, String lastName, String phone) {
        FirebaseUser curr_user = mAuth.getCurrentUser();
        String fullname = firstName.concat((" ").concat((lastName)));
        db.child("users").child(curr_user.getUid()).child("username").setValue(userName);
        db.child("users").child(curr_user.getUid()).child("fullname").setValue(fullname);
        db.child("users").child(curr_user.getUid()).child("phone").setValue(phone);
        db.child("users").child(curr_user.getUid()).child("email").setValue(email);
    }
}