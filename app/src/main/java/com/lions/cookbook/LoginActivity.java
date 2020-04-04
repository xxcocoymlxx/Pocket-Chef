package com.lions.cookbook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.content.Context;


public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {
    private EditText userEmail, userPassword;

    private Button btnLogin;
    private Button btnSignup;

    private LoginPresent LoginPresenter;
    private LoginModel model;

    private SessionManager LoginPref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        PreferencesProvider.init(this);
        this.LoginPref = new SessionManager();


        PreferencesProvider.init(this);
        this.LoginPref = new SessionManager();


        model = new LoginModel();
        LoginPresenter = new LoginPresent(this,model);


        btnLogin = (Button) this.findViewById(R.id.login_btn);
        btnSignup = (Button) this.findViewById(R.id.signUpLink);

        //if the current user is already logged-in
        if (this.LoginPref.isUserLogin()){
            goToCookBookScreen();
            Toast.makeText(this, "Welcome back!", Toast.LENGTH_SHORT).show();
        }

        //set event handler to sign up button
        btnSignup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCreateAccountScreen();
            }
        });

        //set event handler to sign up button
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginPresenter.handleLoginClicked(v);
            }
        });

    }

    @Override
    public String getEmail(){
        this.userEmail = (EditText) this.findViewById(R.id.user_id);
        String value = this.userEmail.getText().toString();
        return value;
    }

    @Override
    public String getPassword(){
        this.userPassword = (EditText) this.findViewById(R.id.user_password);
        String value = this.userPassword.getText().toString();
        return value;
    }

    @Override
    public void goToCreateAccountScreen() {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Taking user to Registration Screen", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void goToCreateRecipeScreen(){
        Intent intent = new Intent(this, CreateRecipeActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Taking user to Create Recipe Screen", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void goToCookBookScreen() {
        Intent intent = new Intent(this, CookBookActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Taking user to Cookbook Screen", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUnfilledError(){
        Toast.makeText(this, "All fields must be filled in!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginFailure(){
        Toast.makeText(this, "There was an error logging in!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginSuccess(){
        Toast.makeText(this, "Login is successful!", Toast.LENGTH_SHORT).show();
    }

    /**
     @Override
     public void onClick(View v) {
     if (v.getId() == R.id.btn_login_login){
     LoginPresent.setProgressBarVisiblity(View.VISIBLE);
     btnLogin.setEnabled(false);
     LoginPresent.doLogin(editUser.getText().toString(), editPass.getText().toString());
     }
     }

     */

    /**
     @Override
     public void onLoginResult(Boolean result, int code) {
     loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
     btnLogin.setEnabled(true);
     if (result){
     Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
     }
     else
     Toast.makeText(this,"Login Failed, code = " + code,Toast.LENGTH_SHORT).show();
     }



     @Override
     protected void onDestroy() {
     super.onDestroy();
     }


     @Override
     protected void onResume() {
     super.onResume();
     presenter.setView(this);
     presenter.getCurrentUser();
     }

     */

    public void showUserSavedMessage() {
        Toast.makeText(this, "User saved successfully", Toast.LENGTH_SHORT).show();
    }


}
