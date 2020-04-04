package com.lions.cookbook;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.lions.cookbook.databinding.ActivityViewRecipeBindingImpl;
import com.lions.cookbook.databinding.CookBookActivityBindingImpl;
import com.lions.cookbook.databinding.CreateAccountActivityBindingImpl;
import com.lions.cookbook.databinding.CreateRecipeActivityBindingImpl;
import com.lions.cookbook.databinding.LoginActivityBindingImpl;
import com.lions.cookbook.databinding.ViewAccountPrivateActivityBindingImpl;
import com.lions.cookbook.databinding.ViewAccountPublicActivityBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYVIEWRECIPE = 1;

  private static final int LAYOUT_COOKBOOKACTIVITY = 2;

  private static final int LAYOUT_CREATEACCOUNTACTIVITY = 3;

  private static final int LAYOUT_CREATERECIPEACTIVITY = 4;

  private static final int LAYOUT_LOGINACTIVITY = 5;

  private static final int LAYOUT_VIEWACCOUNTPRIVATEACTIVITY = 6;

  private static final int LAYOUT_VIEWACCOUNTPUBLICACTIVITY = 7;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(7);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.lions.cookbook.R.layout.activity_view_recipe, LAYOUT_ACTIVITYVIEWRECIPE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.lions.cookbook.R.layout.cook_book_activity, LAYOUT_COOKBOOKACTIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.lions.cookbook.R.layout.create_account_activity, LAYOUT_CREATEACCOUNTACTIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.lions.cookbook.R.layout.create_recipe_activity, LAYOUT_CREATERECIPEACTIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.lions.cookbook.R.layout.login_activity, LAYOUT_LOGINACTIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.lions.cookbook.R.layout.view_account_private_activity, LAYOUT_VIEWACCOUNTPRIVATEACTIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.lions.cookbook.R.layout.view_account_public_activity, LAYOUT_VIEWACCOUNTPUBLICACTIVITY);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYVIEWRECIPE: {
          if ("layout/activity_view_recipe_0".equals(tag)) {
            return new ActivityViewRecipeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_view_recipe is invalid. Received: " + tag);
        }
        case  LAYOUT_COOKBOOKACTIVITY: {
          if ("layout/cook_book_activity_0".equals(tag)) {
            return new CookBookActivityBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for cook_book_activity is invalid. Received: " + tag);
        }
        case  LAYOUT_CREATEACCOUNTACTIVITY: {
          if ("layout/create_account_activity_0".equals(tag)) {
            return new CreateAccountActivityBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for create_account_activity is invalid. Received: " + tag);
        }
        case  LAYOUT_CREATERECIPEACTIVITY: {
          if ("layout/create_recipe_activity_0".equals(tag)) {
            return new CreateRecipeActivityBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for create_recipe_activity is invalid. Received: " + tag);
        }
        case  LAYOUT_LOGINACTIVITY: {
          if ("layout/login_activity_0".equals(tag)) {
            return new LoginActivityBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for login_activity is invalid. Received: " + tag);
        }
        case  LAYOUT_VIEWACCOUNTPRIVATEACTIVITY: {
          if ("layout/view_account_private_activity_0".equals(tag)) {
            return new ViewAccountPrivateActivityBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for view_account_private_activity is invalid. Received: " + tag);
        }
        case  LAYOUT_VIEWACCOUNTPUBLICACTIVITY: {
          if ("layout/view_account_public_activity_0".equals(tag)) {
            return new ViewAccountPublicActivityBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for view_account_public_activity is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "presenter");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(7);

    static {
      sKeys.put("layout/activity_view_recipe_0", com.lions.cookbook.R.layout.activity_view_recipe);
      sKeys.put("layout/cook_book_activity_0", com.lions.cookbook.R.layout.cook_book_activity);
      sKeys.put("layout/create_account_activity_0", com.lions.cookbook.R.layout.create_account_activity);
      sKeys.put("layout/create_recipe_activity_0", com.lions.cookbook.R.layout.create_recipe_activity);
      sKeys.put("layout/login_activity_0", com.lions.cookbook.R.layout.login_activity);
      sKeys.put("layout/view_account_private_activity_0", com.lions.cookbook.R.layout.view_account_private_activity);
      sKeys.put("layout/view_account_public_activity_0", com.lions.cookbook.R.layout.view_account_public_activity);
    }
  }
}
