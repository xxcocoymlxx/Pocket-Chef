package com.lions.cookbook;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ViewRecipePresenter implements ViewRecipeContract.ViewRecipeMVPPresenter {
    private ViewRecipeContract.ViewRecipeMVPView nView;
    private ViewRecipeContract.ViewRecipeMVPModel nModel;

    ViewRecipePresenter(ViewRecipeContract.ViewRecipeMVPView view){
        nView = view;
    }

    ViewRecipePresenter(ViewRecipeContract.ViewRecipeMVPView view, ViewRecipeContract.ViewRecipeMVPModel model){
        nView = view;
        nModel = model;
    }

    public void setnModel(ViewRecipeContract.ViewRecipeMVPModel nModel) {
        this.nModel = nModel;
    }

    @Override
    public void handleAlterPressed() {
        if (checkEnteredServingSize()){
            nView.showServingNull();
        } else {
            Recipe originalRecipe = nModel.getRecipe();
            ArrayList<Ingredient> newList = new ArrayList<Ingredient>(sizeScaleIngredients(originalRecipe.getIngredients(), originalRecipe.getServingSize(), Integer.parseInt(nView.getServingSize())));
            String alterUnits = nView.getUnits();
            ArrayList<Ingredient> unitUpdateList = new ArrayList<>(unitConversionIngredients(newList, alterUnits));
            nView.updateIngredients(unitUpdateList);
        }
    }

    @Override
    public void handleDeletePressed() {
        if (nModel.deleteRecipe()){
            Log.d("TEST", "Delete clicked 2");
            nView.showDeleteSuccess();
            nView.goToCookBookScreen();
        } else {
            nView.showDeleteFailure();
        }
    }

    @Override
    public List<Ingredient> sizeScaleIngredients(List<Ingredient> ingredients, int originalSize, int NewSize) {
        List<Ingredient> new_list = new ArrayList<Ingredient>();
        for (int i = 0; i < ingredients.size() ; i++){
            float originalQuantity = ingredients.get(i).getQuantity();
            String originalName = ingredients.get(i).getName();
            String originalType = ingredients.get(i).getQuantityType();
            float newQuantity = (originalQuantity/originalSize)*NewSize;
            Ingredient changed = new Ingredient(originalName, newQuantity, originalType);
            new_list.add(changed);
        }
        return new_list;
    }


    //Conducts the unit conversion so that the final quantity and type match 'units'
    @Override
    public List<Ingredient> unitConversionIngredients(List<Ingredient> ingredients, String units) {
        List<Ingredient> new_list = new ArrayList<Ingredient>();
        for (int i = 0; i < ingredients.size() ; i++){
            float originalQuantity = ingredients.get(i).getQuantity();
            String originalName = ingredients.get(i).getName();
            String originalType = ingredients.get(i).getQuantityType();
            String ingredientType = getIngredientType(originalType);
            /*
            Log.d("TEST", "ingredientType" + ingredientType);
            Log.d("TEST", "originalName" + originalName);
            Log.d("TEST", "originalType" + originalType);
            Log.d("TEST", "originalQuantity" + Float.toString(originalQuantity));
             */

            if (!(units.equals(ingredientType))){
                //Log.d("TEST", "Does not match units needed");
                float newQuantity;
                String newType;
                switch(originalType){
                    case "tsp":
                        //Log.d("TEST", "tsp");
                        newType = "ml";
                        newQuantity = 5 * originalQuantity;
                        break;

                    case "tbsp":
                        //Log.d("TEST", "tbsp");
                        newType = "ml";
                        newQuantity = 15 * originalQuantity;
                        break;

                    case "cup":
                        //Log.d("TEST", "cup");
                        newType = "ml";
                        newQuantity = 237 * originalQuantity;
                        break;

                    case "fl. oz.":
                        //Log.d("TEST", "fl. oz.");
                        newType = "ml";
                        newQuantity = (float)(originalQuantity *29.57);
                        break;

                    case "gallon":
                        //Log.d("TEST", "gallon");
                        newType = "ml";
                        newQuantity = (float) ( 3785 *originalQuantity);
                        break;

                    case "quart":
                        //Log.d("TEST", "quart");
                        newType = "ml";
                        newQuantity = (float)(946*originalQuantity);
                        break;

                    case "ml":
                        //Log.d("TEST", "ml");
                        newType = "cup";
                        newQuantity = (float)(originalQuantity / 237);
                        break;

                    case "L":
                        //Log.d("TEST", "L");
                        newType = "cup";
                        newQuantity = (float)(originalQuantity * 4.227);
                        break;

                    case "oz":
                        //Log.d("TEST", "oz");
                        newType = "g";
                        newQuantity = originalQuantity * 30;
                        break;

                    case "lb":
                        //Log.d("TEST", "lb");
                        newType = "g";
                        newQuantity = originalQuantity * 454;
                        break;

                    case "g":
                        //Log.d("TEST", "g");
                        newType = "lb";
                        newQuantity = originalQuantity/454;
                        break;

                    case "kg":
                        //Log.d("TEST", "kg");
                        newType = "lb";
                        newQuantity = (float) (originalQuantity * 2.205);
                        break;

                    default:
                        newType = originalType;
                        newQuantity = originalQuantity;


                }
                Ingredient changed = new Ingredient(originalName, newQuantity, newType);
                new_list.add(changed);
            } else {
                Ingredient changed = new Ingredient(originalName, originalQuantity, originalType);
                new_list.add(changed);
            }

        }
        return new_list;
    }

    //Returns the ingredient type: either metric, imperial, or other
    public String getIngredientType(String givenType){
        Set<String> metricSet = new HashSet<String>();
        Set<String> imperialSet = new HashSet<String>();
        metricSet.add("g");
        metricSet.add("kg");
        metricSet.add("ml");
        metricSet.add("L");
        imperialSet.add("oz");
        imperialSet.add("fl. oz.");
        imperialSet.add("gallon");
        imperialSet.add("quart");
        imperialSet.add("lb");
        imperialSet.add("tsp");
        imperialSet.add("tbsp");
        imperialSet.add("cup");

        if (metricSet.contains(givenType)){
            return "metric";
        } else if (imperialSet.contains(givenType)){
            return "imperial";
        } else {
            return "other";
        }
    }
    @Override
    public Boolean checkEnteredServingSize() {
        boolean any_errors = false;
        if (nView.getServingSize() == null || nView.getServingSize().equals("")){
            any_errors = true;
        } else {
            try {
                float temp = Integer.parseInt(nView.getServingSize());
            } catch (NumberFormatException ex) {
                any_errors = true;
            }
        }
        return any_errors;
    }

    @Override
    public void populateValues(Recipe currentRecipe) {
        Log.d("Recipe View: ", "Populating Recipe");
        nView.populateTitle(currentRecipe.getTitle());
        nView.populateRecipeServing(currentRecipe.getServingSize());
        nView.populateRecipeIngredients(currentRecipe.getIngredients());
        nView.populateRecipeSteps(currentRecipe.getSteps());
        nView.populateAuthorName(currentRecipe.getUsername());
        nView.populatePublished(currentRecipe.getPublished());
    }

    @Override
    public void handleAuthorClicked() {
        nView.goToViewAuthorProfile(nModel.getRecipe().getUsername());
    }

    @Override
    public void toggleSwitchChange(Boolean isToggleOn) {
        nView.showToggleChanged();
        Boolean status;
        if (isToggleOn){
            status = nModel.publishRecipe();
        } else {
            status = nModel.unpublishRecipe();
        }
        if (status){
            nView.showToggleSuccess();
        } else {
            nView.showToggleFailure();
        }
    }

}
