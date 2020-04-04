package com.lions.cookbook;

import java.util.ArrayList;

public interface PublicProfileObserver {

    void update(String fullname, ArrayList<String> recipes, ArrayList<String> recipeIDs);

}