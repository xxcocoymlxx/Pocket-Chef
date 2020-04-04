package com.lions.cookbook;

import android.widget.ListView;
import java.util.List;
import java.util.ArrayList;

public interface CookBookContract {
    interface CookBookMVPView{
        void goToCreateRecipeScreen();
        void goToViewRecipe(String recipeClickedOn);

    }

    interface CookBookMVPModel{
        ArrayList<String> getRecipeNamesDB(); //Return ArrayList of all recipe names stored in DB.
        List<String> getRecipeImages(); //THIS WILL BE HARDCODED FOR THE DEMO. Do not change this.
        void addObserver(CookBookObserver observer);
    }

    interface CookBookMVPPresenter{
        ArrayList<String> getRecipeNames(); //Retrieve Recipe names from Model
        void handleCreateRecipeClicked();
        void handleRecipeClicked(int indexClicked);
        void addObserver(CookBookActivityObserver observer);
        void notifyAllObservers();
        void update(ArrayList<String> recipes, ArrayList<String> recipeKeys);
    }
}
