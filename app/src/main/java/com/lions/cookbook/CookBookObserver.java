package com.lions.cookbook;

import java.util.ArrayList;

public interface CookBookObserver {
    void update(ArrayList<String> recipes, ArrayList<String> recipeKeys);
}
