package com.lions.cookbook;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.firebase.auth.FirebaseAuth;


public class CreateAccountPresent implements CreateAccountContract.CreateAccountMVPPresenter, CreateAccountObserver{

    private CreateAccountContract.CreateAccountMVPView view;
    private CreateAccountContract.CreateAccountMVPModel model;
    private ArrayList<CreateAccountObserver> observers;

    private String username;
    private String userPassword;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userPhoneNumber;
    private String error_message;


    CreateAccountPresent(CreateAccountContract.CreateAccountMVPView nView,CreateAccountContract.CreateAccountMVPModel nModel) {
        this.view = nView;
        this.model = nModel;
        this.observers = new ArrayList<CreateAccountObserver>();
        this.model.addObserver(this);
        this.error_message = "";
    }

    @Override
    public void handleCreateAccountClicked(View view) {
        //Get Input from user
        boolean any_errors = false;

        this.username = this.view.getUsername();
        this.userPassword = this.view.getPassword();
    	this.userFirstName = this.view.getFirstName();
    	this.userLastName = this.view.getLastName();
    	this.userPhoneNumber = this.view.getPhoneNumber();
    	this.userEmail = this.view.getEmail();


        if (!validateEmail(this.userEmail)){
            this.view.showInvalidEmailMessage();
            any_errors = true;
        }else if (!validateName(this.userFirstName)){
            this.view.showInvalidNameMessage();
            any_errors = true;
        }else if (!validateName(this.userLastName)){
            this.view.showInvalidNameMessage();
            any_errors = true;
        }else if(!validatePassword(this.userPassword)){
            this.view.showInvalidPasswordMessage();
            any_errors = true;
        }else if(!validateUsername(this.username)){
            this.view.showInvalidUsernameMessage();
            any_errors = true;
        }else if(!validatePhoneNumber(this.userPhoneNumber)){
            this.view.showInvalidPhoneNumberMessage();
            any_errors = true;
        }

        if (any_errors) {
            this.view.showUnfilledError();
        }

        this.model.validateUsername(this.username);
        this.model.validateEmail(this.userEmail);
    }

    public void update(String error){
        this.error_message = error;
        if (this.error_message.equals("")){
            Log.d("successful registration", "successful attempt");
            this.model.addNewUser(this.userEmail, this.userPassword, this.username, this.userFirstName, this.userLastName, this.userPhoneNumber);
            this.view.showCreateAccountSuccess();
            this.view.goToLoginScreen();
        }
        else{
            Log.d("failed registration", "failed attempt");
            this.view.showUserExistsMessage(this.error_message);
            this.view.showCreateAccountFailure();
            this.error_message = ""; //reset error message after failure
        }
    }

    public boolean validateEmail(String email){
        if (email == null || email.equals("")){
            return false;
        }else {
            String gmailRegex = "^[\\w.+\\-]+@gmail\\.com$";
            CharSequence inputStr = email;
            Pattern pattern = Pattern.compile(gmailRegex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(inputStr);
            return matcher.matches();
        }

    }

    public boolean validateUsername(String Username){
        if (Username == null || Username.equals("")){
            return false;
        }else {
            String alphanumericRegex = "^[a-zA-Z0-9]+$";
            Pattern alphanumericPattern = Pattern.compile(alphanumericRegex);
            Matcher matcher = alphanumericPattern.matcher(Username);
            return matcher.matches();
        }
    }

    public boolean validatePassword(String password){
        if (password == null || password.equals("") || password.length() < 6){
            return false;
        }else {
            return true;
        }
    }

    public boolean validatePhoneNumber(String phone){
        if (phone == null || phone.equals("") || phone.length() < 10){
            return false;
        }else {
            String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(phone);
            return matcher.matches();
        }
    }

    public boolean validateName(String name) {
        if (name == null || name.equals("")) {
            return false;
        } else {
            String regex = "[a-zA-Z]+";
            Pattern alphabetPattern = Pattern.compile(regex);
            Matcher matcher = alphabetPattern.matcher(name);
            return matcher.matches();
        }
    }
}
