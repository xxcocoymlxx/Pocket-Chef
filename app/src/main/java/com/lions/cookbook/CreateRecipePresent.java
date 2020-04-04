package com.lions.cookbook;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CreateRecipePresent implements CreateRecipeContract.CreateRecipeMVPPresenter{
    private CreateRecipeContract.CreateRecipeMVPView nView;
    private CreateRecipeContract.CreateRecipeMVPModel nModel;
    //private RecipeModel firebase_db;
    private List<String> recipesteps;
    private String username;





    CreateRecipePresent(CreateRecipeContract.CreateRecipeMVPView view, CreateRecipeContract.CreateRecipeMVPModel model){
        nView = view;
        nModel = model;
        username = null;
        DatabaseReference users = FirebaseDatabase.getInstance().getReference().child("users");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        users.child(user.getUid()).child("username").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                setUsername((String) dataSnapshot.getValue());
                Log.d("username", "Username accessed");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("username", "could not access username");
            }
        });
    }
    @Override
    public void handleCreateRecipeClicked(View view) {

        if (conductEmptyErrorChecks()){ //Check if any fields are empty
            nView.showUnfilledError();
        } else if (conductUniqueNameCheck()){ //Check if name is unique
            nView.showRecipeNameError();
        } else { //Attempt to add Recipe
            //Populate new Recipe object
            String title = nView.getRecipeTitle();
            int serving_size = Integer.parseInt(nView.getServingSize());
            List<Ingredient> ingredients = createIngredientList(nView.getRecipeIngredients());
            List<String> steps = nView.getRecipeSteps();
            List<String> fake_tags = new ArrayList<String>();
            fake_tags.add("Beginner");
            Boolean isPublished = nView.getPublished();
            while (this.username == null) {} // Just making sure the username is pulled.
            Recipe new_recipe = new Recipe(title, this.username, serving_size, ingredients, fake_tags, steps); //Note: Tags feature has not been added
            for (int i =0; i<ingredients.size();i++){
                Log.d("ingredient", new_recipe.getIngredients().get(i).getName());
            }
            new_recipe.setPublished(isPublished);
            Boolean addSuccess = nModel.addRecipe(new_recipe);
            if (addSuccess){
                nView.showSuccessfulCreation();
                nView.goToCookBookScreen();
            } else {
                nView.showCreationError();
            }
        }
    }

    @Override
    public void handleGoToCookBookScreen(View view){
        nView.goToCookBookScreen();
    }

    @Override
    public void handleAddSteps(View view) {
        String new_step = nView.getNewStep();
        nView.addNewStep(new_step);
        nView.clearStepText();
    }

    @Override
    public void handleAddIngredient(View view) {
        if (checkIngredient()){
            nView.showIngredientAddError();
        } else {
            //Add Ingredients to list
            nView.addNewIngredient(nView.getNewIngredient(), nView.getNewIngredientAmount(), nView.getNewIngredientType());
            nView.clearIngredientText();
        }
    }

    @Override
    public Boolean checkIngredient() {
        boolean any_empty =false;
        if (nView.getNewIngredient().isEmpty()){
            any_empty = true;
        }
        if (nView.getNewIngredientAmount().isEmpty()){
            any_empty = true;
        }
        if (nView.getNewIngredientType().isEmpty()){
            any_empty = true;
        }
        try {
            float temp = Float.parseFloat(nView.getNewIngredientAmount());
        } catch (NumberFormatException ex) {
            any_empty = true;
        }
        return any_empty;
    }

    @Override
    //Return True if there is an error
    public Boolean conductEmptyErrorChecks() {
        //Check if any fields are empty
        boolean any_empty = false;
        if (nView.getRecipeSteps().isEmpty()){
            any_empty = true;
        }
        if (nView.getRecipeIngredients().isEmpty()){
            any_empty = true;
        }
        if (nView.getRecipeTitle() == null || nView.getRecipeTitle().equals("")){
            any_empty = true;
        }
        if (nView.getServingSize() == null || nView.getServingSize().equals("")){
            any_empty = true;
        } else {
            try {
                int temp = Integer.parseInt(nView.getServingSize());
            } catch (NumberFormatException ex) {
                any_empty = true;
            }
        }

        return any_empty;
    }

    @Override
    //Return True if name is not unique
    public Boolean conductUniqueNameCheck() {
        String recipe_title = nView.getRecipeTitle();
        return nModel.ExistRecipeName(recipe_title);
    }

    @Override
    public List<Ingredient> createIngredientList(ArrayList<String> ingredientList) {
        //Ingredient[] ingredients = new Ingredient[nView.getRecipeIngredients().size()];
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        for (int i = 0; i < ingredientList.size(); i++){
            String[] values = ingredientList.get(i).split(",");
            Ingredient new_ingredient = new Ingredient(values[0], Float.parseFloat(values[1]), values[2]);
            ingredients.add(new_ingredient);
        }
        return ingredients;
    }

    public void setUsername(String username){
        this.username = username;
    }

}
