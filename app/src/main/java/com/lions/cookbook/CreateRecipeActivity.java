package com.lions.cookbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lions.cookbook.databinding.CreateRecipeActivityBinding;

import java.util.ArrayList;

/**
 * VIEW: Displays the create recipe screen
 */
public class CreateRecipeActivity extends AppCompatActivity implements CreateRecipeContract.CreateRecipeMVPView {
    private CreateRecipeContract.CreateRecipeMVPModel model;
    private CreateRecipeContract.CreateRecipeMVPPresenter presenter;
    private DatabaseReference mDatabase;

    //private CreateRecipePresent presenter;
    private ArrayList<String> recipeSteps;
    private ArrayAdapter<String> recipeStepsAdapter;
    private ArrayList<String> ingredients;
    private ArrayAdapter<String> ingredientsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.create_recipe_activity);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        model = new CreateRecipeModel(mDatabase);
        presenter = new CreateRecipePresent(this, model);

        //Set binding for createRecipe_activity and presenter
        CreateRecipeActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.create_recipe_activity);
        binding.setPresenter(this.presenter);


        //Set up display of recipe steps entered
        ListView recipeStepsLV = findViewById(R.id.steps);
        recipeSteps = new ArrayList<>();
        recipeStepsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recipeSteps);
        recipeStepsLV.setAdapter(recipeStepsAdapter);

        //Set up display of ingredients entered
        ListView ingredients_lv = findViewById(R.id.ingredients);
        ingredients = new ArrayList<>();
        ingredientsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredients);
        ingredients_lv.setAdapter(ingredientsAdapter);

        //Set up Navigation panel
        BottomNavigationView navigationPanel = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationPanel.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_create:
                                Intent intent1 = new Intent(CreateRecipeActivity.this, CreateRecipeActivity.class);
                                startActivity(intent1);
                                break;

                            case R.id.navigation_cookbook:
                                Intent intent2 = new Intent(CreateRecipeActivity.this, CookBookActivity.class);
                                startActivity(intent2);
                                break;

                            case R.id.navigation_account:
                                Intent intent3 = new Intent(CreateRecipeActivity.this, PrivateUserProfileActivity.class);
                                startActivity(intent3);
                                break;
                        }
                        return false;
                    }
                });

    }

    @Override
    public void goToCookBookScreen() {
        Intent intent = new Intent(this, CookBookActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Taking user to CookBook Screen", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showUnfilledError() {
        Toast.makeText(this, "All fields must be filled in!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRecipeNameError() {
        Toast.makeText(this, "This recipe name has already been taken!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessfulCreation() {
        Toast.makeText(this, "Recipe has been successfully made!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCreationError() {
        Toast.makeText(this, "There was an error in saving your recipe", Toast.LENGTH_SHORT).show();

    }

    @Override
    public ArrayList<String> getRecipeIngredients() {
        return this.ingredients;
    }

    @Override
    public String getServingSize() {
        EditText text = findViewById(R.id.serving_size);
        String value = text.getText().toString();
        return value;
    }

    @Override
    public ArrayList<String> getRecipeSteps() {
        return this.recipeSteps;
    }

    @Override
    public String getRecipeTitle() {
        EditText text = findViewById(R.id.recipe_title);
        return text.getText().toString();
    }

    @Override
    public String getNewStep() {
        EditText text = findViewById(R.id.stepField);
        String aStep = text.getText().toString();
        return aStep;
    }

    @Override
    public Boolean getPublished(){
        Switch toggle = findViewById(R.id.publishSwitch);
        return toggle.isChecked();

    }

    @Override
    public void addNewStep(String new_step) {
        recipeSteps.add(new_step);
        recipeStepsAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Added new step", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getNewIngredient() {
        EditText text = findViewById(R.id.ingredientField);
        return text.getText().toString();
    }

    @Override
    public String getNewIngredientAmount() {
        EditText text = findViewById(R.id.amountField);
        return text.getText().toString();
    }

    @Override
    public String getNewIngredientType() {
        Spinner mySpinner = (Spinner) findViewById(R.id.measurements);
        return mySpinner.getSelectedItem().toString();
    }

    @Override
    public void showIngredientAddError() {
        Toast.makeText(this, "Please fill in all fields for ingredients correctly", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addNewIngredient(String new_ingredient, String amount, String type) {
        String compile = new_ingredient + ", " + amount + ", " + type;
        ingredients.add(compile);
        ingredientsAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Added new ingredients", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void clearIngredientText(){
        EditText text = findViewById(R.id.ingredientField);
        text.setText("");
        EditText amount = findViewById(R.id.amountField);
        amount.setText("");
    }

    @Override
    public void clearStepText() {
        EditText text = findViewById(R.id.stepField);
        text.setText("");
    }
}
