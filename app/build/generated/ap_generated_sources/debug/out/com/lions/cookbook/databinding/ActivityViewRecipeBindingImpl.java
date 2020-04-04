package com.lions.cookbook.databinding;
import com.lions.cookbook.R;
import com.lions.cookbook.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityViewRecipeBindingImpl extends ActivityViewRecipeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.scrollView, 1);
        sViewsWithIds.put(R.id.RecipeTitle, 2);
        sViewsWithIds.put(R.id.authorIndication, 3);
        sViewsWithIds.put(R.id.by, 4);
        sViewsWithIds.put(R.id.RecipeAuthor, 5);
        sViewsWithIds.put(R.id.publishNotes, 6);
        sViewsWithIds.put(R.id.publishSwitch, 7);
        sViewsWithIds.put(R.id.ServingSizeLayout, 8);
        sViewsWithIds.put(R.id.Recommended, 9);
        sViewsWithIds.put(R.id.ServingSize, 10);
        sViewsWithIds.put(R.id.alterRecipeLayout, 11);
        sViewsWithIds.put(R.id.newServingSize, 12);
        sViewsWithIds.put(R.id.newMeasurementTypes, 13);
        sViewsWithIds.put(R.id.btnAlterRecipe, 14);
        sViewsWithIds.put(R.id.ingredientLayout, 15);
        sViewsWithIds.put(R.id.IngredientText, 16);
        sViewsWithIds.put(R.id.AmtText, 17);
        sViewsWithIds.put(R.id.ingredients, 18);
        sViewsWithIds.put(R.id.StepsText, 19);
        sViewsWithIds.put(R.id.steps, 20);
        sViewsWithIds.put(R.id.btnDeleteRecipe, 21);
        sViewsWithIds.put(R.id.navBar, 22);
        sViewsWithIds.put(R.id.bottom_navigation, 23);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityViewRecipeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private ActivityViewRecipeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[16]
            , (android.widget.Button) bindings[5]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (android.widget.RelativeLayout) bindings[8]
            , (android.widget.TextView) bindings[19]
            , (android.widget.RelativeLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[3]
            , (com.google.android.material.bottomnavigation.BottomNavigationView) bindings[23]
            , (android.widget.Button) bindings[14]
            , (android.widget.Button) bindings[21]
            , (android.widget.TextView) bindings[4]
            , (android.widget.RelativeLayout) bindings[15]
            , (android.widget.ListView) bindings[18]
            , (android.widget.FrameLayout) bindings[22]
            , (android.widget.Spinner) bindings[13]
            , (android.widget.EditText) bindings[12]
            , (android.widget.TextView) bindings[6]
            , (android.widget.Switch) bindings[7]
            , (android.widget.ScrollView) bindings[1]
            , (android.widget.ListView) bindings[20]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}