// Generated by data binding compiler. Do not edit!
package com.lions.cookbook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.lions.cookbook.CreateAccountPresent;
import com.lions.cookbook.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class CreateAccountActivityBinding extends ViewDataBinding {
  @NonNull
  public final BottomNavigationView bottomNavigation;

  @NonNull
  public final Button btnCreateAcct;

  @NonNull
  public final TextInputEditText firstName;

  @NonNull
  public final TextInputEditText gmail;

  @NonNull
  public final TextInputEditText lastName;

  @NonNull
  public final FrameLayout navBar;

  @NonNull
  public final TextInputEditText password;

  @NonNull
  public final TextInputEditText phoneNumber;

  @NonNull
  public final TextInputEditText username;

  @Bindable
  protected CreateAccountPresent mPresenter;

  protected CreateAccountActivityBinding(Object _bindingComponent, View _root, int _localFieldCount,
      BottomNavigationView bottomNavigation, Button btnCreateAcct, TextInputEditText firstName,
      TextInputEditText gmail, TextInputEditText lastName, FrameLayout navBar,
      TextInputEditText password, TextInputEditText phoneNumber, TextInputEditText username) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomNavigation = bottomNavigation;
    this.btnCreateAcct = btnCreateAcct;
    this.firstName = firstName;
    this.gmail = gmail;
    this.lastName = lastName;
    this.navBar = navBar;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.username = username;
  }

  public abstract void setPresenter(@Nullable CreateAccountPresent presenter);

  @Nullable
  public CreateAccountPresent getPresenter() {
    return mPresenter;
  }

  @NonNull
  public static CreateAccountActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.create_account_activity, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static CreateAccountActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<CreateAccountActivityBinding>inflateInternal(inflater, R.layout.create_account_activity, root, attachToRoot, component);
  }

  @NonNull
  public static CreateAccountActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.create_account_activity, null, false, component)
   */
  @NonNull
  @Deprecated
  public static CreateAccountActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<CreateAccountActivityBinding>inflateInternal(inflater, R.layout.create_account_activity, null, false, component);
  }

  public static CreateAccountActivityBinding bind(@NonNull View view) {
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
  public static CreateAccountActivityBinding bind(@NonNull View view, @Nullable Object component) {
    return (CreateAccountActivityBinding)bind(component, view, R.layout.create_account_activity);
  }
}