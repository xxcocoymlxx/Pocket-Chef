package com.lions.cookbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ViewRecipeActivity extends AppCompatActivity implements ViewRecipeContract.ViewRecipeMVPView {
    private ViewRecipeContract.ViewRecipeMVPModel model;
    private ViewRecipeContract.ViewRecipeMVPPresenter presenter;
    private ArrayList<String> recipesteps;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> ingredients_list;
    private ArrayAdapter<String> ingredientsAdapter;

    private Button authorBtn;
    private Button alterBtn;
    private Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);


        //Set up values
        String recipeKey = getIntent().getStringExtra("RECIPE");
        presenter = new ViewRecipePresenter(this);
        model = new ViewRecipeModel(presenter, recipeKey);
        presenter.setnModel(model);


        //Set up button listeners
        //Alter button
        alterBtn = (Button) findViewById(R.id.btnAlterRecipe);
        alterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.handleAlterPressed();
            }
        });


        //Delete button
        deleteBtn = findViewById(R.id.btnDeleteRecipe);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.handleDeletePressed();
                Log.d("TEST", "Delete clicked 1");
            }
        });

        //Username Button
        authorBtn = findViewById(R.id.RecipeAuthor);
        authorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.handleAuthorClicked();
            }
        });

        //Set up listener for public/private toggler
        Switch mySwitch = (Switch)  findViewById(R.id.publishSwitch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                presenter.toggleSwitchChange(isChecked);
            }
        });

        //Set up Navigation panel
        BottomNavigationView navigationPanel = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationPanel.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_create:
                                Intent intent1 = new Intent(ViewRecipeActivity.this, CreateRecipeActivity.class);
                                startActivity(intent1);
                                break;

                            case R.id.navigation_cookbook:
                                Intent intent2 = new Intent(ViewRecipeActivity.this, CookBookActivity.class);
                                startActivity(intent2);
                                break;

                            case R.id.navigation_account:
                                Intent intent3 = new Intent(ViewRecipeActivity.this, PrivateUserProfileActivity.class);
                                startActivity(intent3);
                                break;
                        }
                        return false;
                    }
                });

    }

    @Override
    public void populateTitle(String recipeTitle){
        TextView tv = (TextView)findViewById(R.id.RecipeTitle) ;
        tv.setText(recipeTitle);
    }

    @Override
    public void populateRecipeSteps(List<String> recipeSteps){
        recipesteps = new ArrayList<String>(recipeSteps);
        final ListView RecipeList = (ListView)findViewById(R.id.steps); //Fill in with actual id of List view
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recipesteps);
        RecipeList.setAdapter(arrayAdapter);
    }

    @Override
    public void populateRecipeIngredients(List<Ingredient> recipeIngredients){
        //Populate Recipe ingredients
        List<Ingredient> ingredients = recipeIngredients;
        ingredients_list = new ArrayList<String>();
        for (int i = 0; i< ingredients.size(); i ++){
            String ingredient_compiled = ingredients.get(i).getName() + ", " + String.valueOf(ingredients.get(i).getQuantity()) + ", " + ingredients.get(i).getQuantityType();
            ingredients_list.add(ingredient_compiled);
        }
        final ListView ingredients_view = (ListView)findViewById(R.id.ingredients); //Fill in with actual id of List view
        ingredientsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredients_list);
        ingredients_view.setAdapter(ingredientsAdapter);
    }

    @Override
    public void populateRecipeServing(int recipeServingSize){
        TextView servingSize = findViewById(R.id.ServingSize);
        servingSize.setText(String.valueOf(recipeServingSize));
    }

    @Override
    public void populateAuthorName(String authorUsername){
        this.authorBtn = (Button) this.findViewById(R.id.RecipeAuthor);
        this.authorBtn.setText(authorUsername);
    }

    @Override
    public void populatePublished(Boolean isPublished) {
        Switch mySwitch = (Switch)  findViewById(R.id.publishSwitch);
        mySwitch.setChecked(isPublished);
    }


    @Override
    public String getServingSize() {
        EditText text = findViewById(R.id.newServingSize);
        String value = text.getText().toString();
        return value;
    }

    @Override
    public void showServingNull() {
        Toast.makeText(this, "Please enter a valid Serving size", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void updateIngredients(ArrayList<Ingredient> ingredients) {
        ingredients_list.clear();
        for (int i = 0 ; i< ingredients.size(); i++){
            String new_ingredient = ingredients.get(i).getName() + ", " + ingredients.get(i).getQuantity() + ", " + ingredients.get(i).getQuantityType();
            ingredients_list.add(new_ingredient);
        }
        ingredientsAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Serving size scaled", Toast.LENGTH_SHORT).show();

    }


    @Override
    public String getUnits() {
        Spinner mySpinner = (Spinner) findViewById(R.id.newMeasurementTypes);
        return mySpinner.getSelectedItem().toString();
    }


    @Override
    public void goToCookBookScreen() {
        Log.d("TEST", "Delete clicked 4");
        Intent intent = new Intent(this, CookBookActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Taking user to CookBook Screen", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDeleteSuccess() {
        Log.d("TEST", "Delete clicked 3");
        Toast.makeText(this, "Successful Deletion.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDeleteFailure() {
        Toast.makeText(this, "Deletion Failure.", Toast.LENGTH_SHORT).show();

    }

    public void goToViewAuthorProfile(String authorUsername) {
        Log.d("TEST", "I can get the corroct username: ".concat(authorUsername));
        Intent intent = new Intent(this, PublicUserProfileActivity.class);
        intent.putExtra("USERNAME", authorUsername);
        startActivity(intent);
        Log.d("TEST", "Starting new intent");

    }

    //Private/Publish options
    @Override
    public void showToggleChanged() {
        Toast.makeText(this, "Publish status updating...", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showToggleSuccess() {
        Toast.makeText(this, "Publish status update complete", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToggleFailure() {
        Toast.makeText(this, "Publish status update failed", Toast.LENGTH_SHORT).show();
    }
}
