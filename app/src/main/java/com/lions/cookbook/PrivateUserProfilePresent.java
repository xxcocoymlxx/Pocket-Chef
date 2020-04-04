package com.lions.cookbook;

import android.util.Log;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PrivateUserProfilePresent implements PrivateUserProfileContract.PrivateUserProfilePresenter, PrivateProfileObserver{

    private PrivateUserProfileContract.PrivateUserProfileView nView;
    private PrivateUserProfileContract.PrivateUserProfileModel nModel;
    private SessionManager UserPref;

    private ArrayList<PrivateProfileActivityObserver> observers = new ArrayList<PrivateProfileActivityObserver>();

    String userEmail;
    String userPhoneNumber;
    String userUsername;
    String userFullName;
    String[] arrOfNames;
    ArrayList<String> recipeNames;
    private ArrayList<String> RecipeKeyList;


    PrivateUserProfilePresent(PrivateUserProfileContract.PrivateUserProfileView view, PrivateUserProfileContract.PrivateUserProfileModel model){
        this.nView = view;
        this.nModel = model;
        //add the observer to the observer array list
        this.nModel.addObserver(this);
        this.UserPref = new SessionManager();
    }

    public void addObserver(PrivateProfileActivityObserver observer){
        this.observers.add(observer);
    }

    public void notifyAllObservers(){
        for (PrivateProfileActivityObserver observer : this.observers) {
            observer.update(this.userEmail, this.userPhoneNumber, this.userUsername, this.arrOfNames, this.recipeNames, this.RecipeKeyList);
        }
    }

    @Override
    public void update(String email, String phone, String username, String Fullname, ArrayList<String> recipes,ArrayList<String> recipeIDs){
        this.userEmail = email;
        this.userFullName = Fullname;
        this.userUsername = username;
        this.userPhoneNumber = phone;
        this.recipeNames = recipes;
        this.RecipeKeyList = recipeIDs;

        if(this.userFullName!= null){
            this.arrOfNames = this.userFullName.split(" ");
        }

        notifyAllObservers();

    }

    @Override
    public ArrayList getRecipeNames() {
        //return this.recipeNames;
        String[] filler_recipes = {"Spaghetti", "Whole Wheat Bread", "Bread Pudding", "Chow Mein"};
        ArrayList<String> RecipeList = new ArrayList<>(Arrays.asList(filler_recipes));
        return RecipeList;
    }

    @Override
    public void handleLogoutClicked() {
        this.UserPref.clearUser();
        nView.goToLoginScreen();
        nModel.signOut();
    }

    @Override
    public String[] getFullName(){
        return this.arrOfNames;
    }

    @Override
    public String getEmail(){ return this.userEmail;
    }

    @Override
    public String getPhoneNumber(){
        return this.userPhoneNumber;
    }

    @Override
    public String getUsername(){
        return this.userUsername;
    }

    @Override
    public void handleRecipeClicked(int indexClicked) {
        Log.d("TEST", "Finish getting recipe");
        nView.goToViewRecipe(this.RecipeKeyList.get(indexClicked));
        Log.d("TEST", "able to go to view recipe");
    }

}
