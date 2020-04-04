// Generated by data binding compiler. Do not edit!
package com.lions.cookbook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.lions.cookbook.CreateRecipeContract;
import com.lions.cookbook.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class CreateRecipeActivityBinding extends ViewDataBinding {
  @NonNull
  public final TextView AmtText;

  @NonNull
  public final TextView IngredientText;

  @NonNull
  public final TextView StepsText;

  @NonNull
  public final EditText amountField;

  @NonNull
  public final BottomNavigationView bottomNavigation;

  @NonNull
  public final Button btnAddIngredient;

  @NonNull
  public final Button btnAddStep;

  @NonNull
  public final Button btnCreate;

  @NonNull
  public final RelativeLayout ingredientEntry;

  @NonNull
  public final EditText ingredientField;

  @NonNull
  public final RelativeLayout ingredientLayout;

  @NonNull
  public final ListView ingredients;

  @NonNull
  public final Spinner measurements;

  @NonNull
  public final FrameLayout navBar;

  @NonNull
  public final TextView publishNotes;

  @NonNull
  public final Switch publishSwitch;

  @NonNull
  public final TextInputEditText recipeTitle;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final TextInputEditText servingSize;

  @NonNull
  public final RelativeLayout stepEntry;

  @NonNull
  public final EditText stepField;

  @NonNull
  public final ListView steps;

  @Bindable
  protected CreateRecipeContract.CreateRecipeMVPPresenter mPresenter;

  protected CreateRecipeActivityBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView AmtText, TextView IngredientText, TextView StepsText, EditText amountField,
      BottomNavigationView bottomNavigation, Button btnAddIngredient, Button btnAddStep,
      Button btnCreate, RelativeLayout ingredientEntry, EditText ingredientField,
      RelativeLayout ingredientLayout, ListView ingredients, Spinner measurements,
      FrameLayout navBar, TextView publishNotes, Switch publishSwitch,
      TextInputEditText recipeTitle, ScrollView scrollView, TextInputEditText servingSize,
      RelativeLayout stepEntry, EditText stepField, ListView steps) {
    super(_bindingComponent, _root, _localFieldCount);
    this.AmtText = AmtText;
    this.IngredientText = IngredientText;
    this.StepsText = StepsText;
    this.amountField = amountField;
    this.bottomNavigation = bottomNavigation;
    this.btnAddIngredient = btnAddIngredient;
    this.btnAddStep = btnAddStep;
    this.btnCreate = btnCreate;
    this.ingredientEntry = ingredientEntry;
    this.ingredientField = ingredientField;
    this.ingredientLayout = ingredientLayout;
    this.ingredients = ingredients;
    this.measurements = measurements;
    this.navBar = navBar;
    this.publishNotes = publishNotes;
    this.publishSwitch = publishSwitch;
    this.recipeTitle = recipeTitle;
    this.scrollView = scrollView;
    this.servingSize = servingSize;
    this.stepEntry = stepEntry;
    this.stepField = stepField;
    this.steps = steps;
  }

  public abstract void setPresenter(@Nullable CreateRecipeContract.CreateRecipeMVPPresenter presenter);

  @Nullable
  public CreateRecipeContract.CreateRecipeMVPPresenter getPresenter() {
    return mPresenter;
  }

  @NonNull
  public static CreateRecipeActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.create_recipe_activity, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static CreateRecipeActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<CreateRecipeActivityBinding>inflateInternal(inflater, R.layout.create_recipe_activity, root, attachToRoot, component);
  }

  @NonNull
  public static CreateRecipeActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.create_recipe_activity, null, false, component)
   */
  @NonNull
  @Deprecated
  public static CreateRecipeActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<CreateRecipeActivityBinding>inflateInternal(inflater, R.layout.create_recipe_activity, null, false, component);
  }

  public static CreateRecipeActivityBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static CreateRecipeActivityBinding bind(@NonNull View view, @Nullable Object component) {
    return (CreateRecipeActivityBinding)bind(component, view, R.layout.create_recipe_activity);
  }
}