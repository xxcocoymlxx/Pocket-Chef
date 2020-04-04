package com.lions.cookbook;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;


public interface PublicUserProfileContract {

    interface PublicUserProfilePresenter{
        void handleRecipeClicked(int recipeName);
        void update(String fullname, ArrayList<String> recipes, ArrayList<String> recipeIds);

    }

    interface PublicUserProfileModel {
        void findFullname();
        void findRecipes();
        void notifyAllObservers();
        void addObserver(PublicProfileObserver observer);

    }

    interface PublicUserProfileView{
        void goToViewRecipe(String clickedRecipe);
    }
}
