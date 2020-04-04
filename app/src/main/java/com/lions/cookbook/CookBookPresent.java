package com.lions.cookbook;

import android.util.Log;

import java.util.ArrayList;

public class CookBookPresent implements CookBookContract.CookBookMVPPresenter, CookBookObserver{
    private CookBookContract.CookBookMVPView nView;
    private CookBookContract.CookBookMVPModel nModel;
    private ArrayList<String> RecipeList;
    private ArrayList<String> RecipeKeyList;
    private ArrayList<CookBookActivityObserver> observers = new ArrayList<CookBookActivityObserver>();

    CookBookPresent(CookBookContract.CookBookMVPView view, CookBookContract.CookBookMVPModel model){
        this.nView = view;
        this.nModel = model;
        this.nModel.addObserver(this);

    }

    @Override
    public void addObserver(CookBookActivityObserver observer){
        this.observers.add(observer);
    }

    @Override
    public void notifyAllObservers(){
        for (CookBookActivityObserver observer : this.observers) {
            observer.update(this.RecipeList);
        }
    }
    @Override
    public ArrayList getRecipeNames() {
        return nModel.getRecipeNamesDB();
    }

    @Override
    public void handleCreateRecipeClicked() {
        nView.goToCreateRecipeScreen();
    }

    @Override
    public void handleRecipeClicked(int indexClicked) {
        Log.d("TEST", "Finish getting recipe");
        nView.goToViewRecipe(this.RecipeKeyList.get(indexClicked));
        Log.d("TEST", "able to go to view recipe");
    }

    @Override
    public void update(ArrayList<String> recipes, ArrayList<String> recipeKeys) {
        this.RecipeList = recipes;
        this.RecipeKeyList = recipeKeys;
        notifyAllObservers();
    }
}
