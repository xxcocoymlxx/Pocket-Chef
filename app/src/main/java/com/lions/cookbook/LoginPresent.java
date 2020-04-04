package com.lions.cookbook;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import android.content.SharedPreferences;
import android.content.Context;import android.content.Context;

public class LoginPresent implements LoginContract.LoginPresenter, LoginObserver {

    private LoginContract.LoginView view;
    private LoginContract.LoginModel model;

    private String userEmail;
    private String userPassword;
    private boolean signedIn;

    private FirebaseUser curr_user;

    private SessionManager mPreferences = new SessionManager();


    public LoginPresent(LoginContract.LoginView nView,LoginContract.LoginModel nModel) {
        this.view = nView;
        this.model = nModel;
        this.model.addObserver(this);
        this.signedIn = false;
    }

    public void update(boolean signedIn){
        this.signedIn = signedIn;
        if (this.signedIn){

            //save current user's login state
            mPreferences.setUserLogin(true);
            mPreferences.setLoggedInUserEmail(this.userEmail);

            //this line can be successfully printed
            Log.d("Retrieve info","in the login Presenter: email: " + mPreferences.getLoggedInUserEmail() + " login state:" + mPreferences.isUserLogin());

            curr_user = this.model.getCurrentUser();
            this.view.showLoginSuccess();
            this.view.goToCreateRecipeScreen();

        }else{
            this.view.showLoginFailure();
        }

    }

    @Override
    public void handleLoginClicked(View view) {
        //Get Input from user
        boolean any_errors = false;

        this.userEmail = this.view.getEmail();
        this.userPassword = this.view.getPassword();


        if (this.userEmail == null || this.userEmail.equals("")
        || this.userPassword == null || this.userPassword.equals("") ){

            this.view.showUnfilledError();

        } else{

            //validate user's info from the database
            this.model.signIn(this.userEmail, this.userPassword);
        }

    }

}