package com.lions.cookbook;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class LoginModel implements LoginContract.LoginModel{
    private FirebaseAuth mAuth;
    private boolean signedIn;
    private ArrayList<LoginObserver> observers = new ArrayList<LoginObserver>();

    public LoginModel(){
        mAuth = FirebaseAuth.getInstance();
        this.signedIn = false;
    }

    public void addObserver(LoginObserver observer){
        this.observers.add(observer);
    }

    public void notifyObservers(){
        for (LoginObserver observer: this.observers){
            observer.update(this.signedIn);
        }
    }

    public void signIn(String email, String password){
        OnCompleteListener signInListeneter = new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                signedIn = true;
                notifyObservers();
            }
        };
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(signInListeneter);
    }

    public boolean getSignedIn(){
        return this.signedIn;
    }

    //returns FirebaseUser if someone signed in, returns null otw
    public FirebaseUser getCurrentUser(){
        return mAuth.getCurrentUser();
    }

    public void signOut(){
        mAuth.signOut();
    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }
}
