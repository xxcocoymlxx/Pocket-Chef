package com.lions.cookbook;

import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Defines contract between View {@link CreateRecipeActivity} and Presneter {@link CreateRecipePresent}
 * */
public interface CreateRecipeContract {

    interface CreateRecipeMVPView{
        void goToCookBookScreen(); //Change screen to CookBook
        void showUnfilledError(); //Error if user did not fill up all fields
        void showRecipeNameError(); // Error if recipe name is already taken
        void showSuccessfulCreation(); //Toast for successful Recipe creation
        void showCreationError(); //Toast for unsuccessful Recipe creation
        ArrayList<String> getRecipeIngredients();
        String getServingSize();
        ArrayList<String> getRecipeSteps();
        String getRecipeTitle();
        String getNewStep();
        Boolean getPublished();
        void addNewStep(String new_step);
        String getNewIngredient();
        String getNewIngredientAmount();
        String getNewIngredientType();
        void showIngredientAddError();
        void addNewIngredient(String new_ingredient, String amount, String type);
        void clearIngredientText();
        void clearStepText();
    }


    interface CreateRecipeMVPPresenter{
        void handleCreateRecipeClicked(View view);
        void handleGoToCookBookScreen(View view);
        void handleAddSteps(View view);
        void handleAddIngredient(View view);
        Boolean checkIngredient();
        Boolean conductEmptyErrorChecks();
        Boolean conductUniqueNameCheck();
        List<Ingredient> createIngredientList(ArrayList<String> ingredientList);
    }

    interface CreateRecipeMVPModel {
        Boolean ExistRecipeName(String recipe_name); //Checks if Recipe name already exists, returns True if it already exists. Will be used to ensure Recipe names are unique
        Boolean addRecipe(Recipe new_recipe); //Adds Recipe object to DB. True if successful.
    }

}
