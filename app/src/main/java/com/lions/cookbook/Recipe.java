package com.lions.cookbook;
import java.util.*;


public class Recipe {
    private String title;
    private String username;
    private int servingSize;
    private List<Ingredient> ingredients;
    private List<String> tags;
    private List<String> steps;
    private Boolean published;

    private Recipe(){}

    public Recipe(String title, String username, int servingSize, List<Ingredient> ingredients, List<String> tags, List<String> steps){
        this.title = title;
        this.username = username;
        this.servingSize = servingSize;
        this.ingredients = ingredients;
        this.tags = tags;
        this.steps = steps;
        this.published = false;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setServingSize(int size){
        this.servingSize = size;
    }

    public void setIngredients(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    public void setTags(List<String> tags){
        this.tags = tags;
    }

    public void setSteps(List<String> steps){
        this.steps = steps;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getTitle(){
        return this.title;
    }

    public String getUsername() { return this.username; }

    public int getServingSize(){
        return this.servingSize;
    }

    public List<Ingredient> getIngredients(){
        return this.ingredients;
    }

    public List<String> getTags(){
        return this.tags;
    }

    public List<String> getSteps(){
        return this.steps;
    }

    public Boolean getPublished() {
        return published;
    }
}

