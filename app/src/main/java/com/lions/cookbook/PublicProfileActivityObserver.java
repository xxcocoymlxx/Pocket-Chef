package com.lions.cookbook;

import java.util.ArrayList;

public interface PublicProfileActivityObserver {

    void update(String[] fullname, ArrayList<String> recipes, ArrayList<String> recipeIDs);
}
