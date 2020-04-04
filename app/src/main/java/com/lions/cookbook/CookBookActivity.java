package com.lions.cookbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.ArrayList;

/**
 * VIEW: Displays the CookBook Screen
 */
public class CookBookActivity extends AppCompatActivity implements CookBookContract.CookBookMVPView, CookBookActivityObserver{
    private CookBookPresent presenter;
    private CookBookModel model1;
    private DatabaseReference mDatabase;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> recipeNames;

    //Good Tutorial on listView: https://abhiandroid.com/ui/listview for texts and pictures
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cookbook_activity);

        //Set up values
        mDatabase = FirebaseDatabase.getInstance().getReference();
        model1 = new CookBookModel(mDatabase);
        presenter = new CookBookPresent(this, model1);
        presenter.addObserver(this);

        //Set up Navigation panel
        BottomNavigationView navigationPanel = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationPanel.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_create:
                                Intent intent1 = new Intent(CookBookActivity.this, CreateRecipeActivity.class);
                                startActivity(intent1);
                                break;

                            case R.id.navigation_cookbook:
                                Intent intent2 = new Intent(CookBookActivity.this, CookBookActivity.class);
                                startActivity(intent2);
                                break;

                            case R.id.navigation_account:
                                Intent intent3 = new Intent(CookBookActivity.this, PrivateUserProfileActivity.class);
                                startActivity(intent3);
                                break;

                        }
                        return false;
                    }
                });
    }



    @Override
    public void goToCreateRecipeScreen() {
        Intent intent = new Intent(this, CreateRecipeActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Taking user to CreateRecipe Screen", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToViewRecipe(String clickedRecipeKey) {
        Toast.makeText(this, "TEST: Recipe key:" + clickedRecipeKey, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ViewRecipeActivity.class);
        intent.putExtra("RECIPE", clickedRecipeKey);
        startActivity(intent);
    }

    @Override
    public void update(ArrayList<String> recipes) {
        this.recipeNames = recipes;
        ArrayList<String> foundRecipes = this.recipeNames;
        if( foundRecipes!= null && !foundRecipes.isEmpty() ) {
            //Populate with List of Recipe names
            final ListView RecipeList = (ListView)findViewById(R.id.recipeList); //Fill in with actual id of List view
            arrayAdapter = new ArrayAdapter<String>(this, R.layout.item_row_recipe, foundRecipes);
            RecipeList.setAdapter(arrayAdapter);
            RecipeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    presenter.handleRecipeClicked(i);
                }
            });
        }

    }
}