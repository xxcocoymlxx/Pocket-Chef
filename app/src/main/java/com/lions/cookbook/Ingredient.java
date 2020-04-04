package com.lions.cookbook;

public class Ingredient {
    private String name;
    private float quantity;
    private String quantityType;

    private Ingredient(){}

    public Ingredient(String name, float quantity, String quantity_type){
        this.name = name;
        this.quantity = quantity;
        this.quantityType = quantity_type;
    }

    public void changeName(String name){
        this.name = name;
    }

    public void changeQuantity(float quantity){
        this.quantity = quantity;
    }

    public void changeQuantityType(String quantity_type){
        this.quantityType = quantity_type;
    }

    public String getName(){
        return this.name;
    }

    public float getQuantity(){
        return this.quantity;
    }

    public String getQuantityType(){
        return this.quantityType;
    }

}

