package com.lions.cookbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.se.omapi.Session;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PublicUserProfileActivity extends AppCompatActivity implements PublicUserProfileContract.PublicUserProfileView, PublicProfileActivityObserver{
    private PublicUserProfilePresent presenter;
    private PublicUserProfileModel model;
    private DatabaseReference mDatabase;
    private ArrayAdapter<String> arrayAdapter;

    private Button dietaryBtn;
    private Button followingBtn;
    private Button followersBtn;

    private TextView firstName;
    private TextView lastName;
    private TextView username;

    private String userUsername;
    private String[] userFullName;
    private ArrayList<String> recipeNames;
    private ArrayList<String> recipeKeys;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_account_public_activity);

        //Set up MVP
        this.userUsername = getIntent().getStringExtra("USERNAME");

        mDatabase = FirebaseDatabase.getInstance().getReference();
        model = new PublicUserProfileModel(mDatabase, this.userUsername);
        presenter = new PublicUserProfilePresent(this, model);

        presenter.addObserver(this);//add the activity to observer list

        Log.d("TEST", "can you reach here");
        //set up textView
        this.firstName = (TextView) findViewById(R.id.firstName);
        this.lastName = (TextView) findViewById(R.id.lastName);

        this.username = (TextView) findViewById(R.id.username);
        this.username.setText(this.userUsername);


        //set up event handlers for the buttons
        this.dietaryBtn = (Button) this.findViewById(R.id.dietaryBtn);
        this.dietaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        this.followingBtn = (Button) this.findViewById(R.id.followingBtn);
        this.followingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handler
            }
        });

        this.followersBtn = (Button) this.findViewById(R.id.followersBtn);
        this.followersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handler
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
                                Intent intent1 = new Intent(PublicUserProfileActivity.this, CreateRecipeActivity.class);
                                startActivity(intent1);
                                break;

                            case R.id.navigation_cookbook:
                                Intent intent2 = new Intent(PublicUserProfileActivity.this, CookBookActivity.class);
                                startActivity(intent2);
                                break;

                            case R.id.navigation_account:
                                Intent intent3 = new Intent(PublicUserProfileActivity.this, PrivateUserProfileActivity.class);
                                startActivity(intent3);
                                break;

                        }
                        return false;
                    }
                });
    }

    @Override
    public void update(String[] Fullname, ArrayList<String> recipes, ArrayList<String> recipeIDs){
        Log.d("TEST", "I'm in the update function in activity");
        this.userFullName = Fullname;//an array
        this.recipeNames = recipes;
        this.recipeKeys = recipeIDs;

        //Populate other info to the UI
        String[] foundFullname = this.userFullName;
        if ( (foundFullname!= null) && (foundFullname.length > 0)){
            //set values for the textView
            this.firstName.setText(foundFullname[0]);
            this.lastName.setText(foundFullname[1]);
        }


        ArrayList<String> foundRecipes = this.recipeNames;
        if( foundRecipes!= null && !foundRecipes.isEmpty() ) {
            //Populate with List of Recipe names
            final ListView RecipeList = (ListView)findViewById(R.id.steps); //Fill in with actual id of List view
            arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foundRecipes);
            RecipeList.setAdapter(arrayAdapter);
            RecipeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    presenter.handleRecipeClicked(i);
                }
            });
        }

    }


    @Override
    public void goToViewRecipe(String clickedRecipe) {
        Intent intent = new Intent(this, ViewRecipeActivity.class);
        intent.putExtra("RECIPE", clickedRecipe);
        startActivity(intent);
    }

}
