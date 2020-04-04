package com.lions.cookbook;

import android.view.View;

import java.util.ArrayList;


public class PrivateUserProfileContract {

    interface PrivateUserProfilePresenter{
        void handleLogoutClicked();
        ArrayList getRecipeNames();
        void handleRecipeClicked(int recipeIndex);
        String getEmail();
        String[] getFullName();
        String getUsername();
        String getPhoneNumber();
    }

    interface PrivateUserProfileModel {
        String getEmail();
        void signOut();
        void findFullname();
        void findUsername();
        void findPhoneNumber();
        void findRecipes();
        void addObserver(PrivateProfileObserver observer);
        void notifyAllObservers();
    }


    interface PrivateUserProfileView{
        void goToViewRecipe(String clickedRecipe);
        void goToLoginScreen();

}

}
