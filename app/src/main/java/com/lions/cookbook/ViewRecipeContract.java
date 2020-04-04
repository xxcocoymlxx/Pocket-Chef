package com.lions.cookbook;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public interface ViewRecipeContract {
    interface ViewRecipeMVPView{
        String getServingSize();
        void showServingNull();
        void updateIngredients(ArrayList<Ingredient> ingredients);
        String getUnits();

        void goToCookBookScreen();
        void showDeleteSuccess();
        void showDeleteFailure();

        void populateTitle(String recipeTitle);
        void populateRecipeSteps(List<String> recipeSteps);
        void populateRecipeIngredients(List<Ingredient> recipeIngredients);
        void populateRecipeServing(int recipeServingSize);
        void populateAuthorName(String recipeOwner);
        void populatePublished(Boolean isPublished);

        void goToViewAuthorProfile(String authorUsername);

        void showToggleChanged();
        void showToggleSuccess();
        void showToggleFailure();

    }

    interface ViewRecipeMVPPresenter{
        void handleAlterPressed();
        void handleDeletePressed();
        List<Ingredient> sizeScaleIngredients(List<Ingredient> ingredients, int originalSize, int NewSize);
        List<Ingredient> unitConversionIngredients(List<Ingredient> ingredients, String units); //units: Metric or Imperial
        Boolean checkEnteredServingSize();
        void populateValues(Recipe theRecipeObject);
        void handleAuthorClicked();
        void setnModel(ViewRecipeMVPModel model);
        void toggleSwitchChange(Boolean isToggleOn);

    }
    interface ViewRecipeMVPModel{
        Boolean deleteRecipe(); // True if successful
        Recipe getRecipe();
        Boolean unpublishRecipe();
        Boolean publishRecipe();
    }
}
