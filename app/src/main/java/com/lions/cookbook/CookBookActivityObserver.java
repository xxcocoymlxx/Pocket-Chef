package com.lions.cookbook;

import java.util.ArrayList;

public interface CookBookActivityObserver {
    void update(ArrayList<String> recipes);
}