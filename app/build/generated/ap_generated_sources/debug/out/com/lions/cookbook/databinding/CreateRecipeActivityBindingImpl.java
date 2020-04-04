package com.lions.cookbook.databinding;
import com.lions.cookbook.R;
import com.lions.cookbook.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CreateRecipeActivityBindingImpl extends CreateRecipeActivityBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.scrollView, 4);
        sViewsWithIds.put(R.id.recipe_title, 5);
        sViewsWithIds.put(R.id.serving_size, 6);
        sViewsWithIds.put(R.id.ingredientLayout, 7);
        sViewsWithIds.put(R.id.IngredientText, 8);
        sViewsWithIds.put(R.id.AmtText, 9);
        sViewsWithIds.put(R.id.ingredients, 10);
        sViewsWithIds.put(R.id.ingredientEntry, 11);
        sViewsWithIds.put(R.id.ingredientField, 12);
        sViewsWithIds.put(R.id.amountField, 13);
        sViewsWithIds.put(R.id.measurements, 14);
        sViewsWithIds.put(R.id.StepsText, 15);
        sViewsWithIds.put(R.id.steps, 16);
        sViewsWithIds.put(R.id.stepEntry, 17);
        sViewsWithIds.put(R.id.stepField, 18);
        sViewsWithIds.put(R.id.publishNotes, 19);
        sViewsWithIds.put(R.id.publishSwitch, 20);
        sViewsWithIds.put(R.id.navBar, 21);
        sViewsWithIds.put(R.id.bottom_navigation, 22);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mPresenterHandleAddIngredientAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mPresenterHandleAddStepsAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mPresenterHandleCreateRecipeClickedAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public CreateRecipeActivityBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }
    private CreateRecipeActivityBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[15]
            , (android.widget.EditText) bindings[13]
            , (com.google.android.material.bottomnavigation.BottomNavigationView) bindings[22]
            , (android.widget.Button) bindings[1]
            , (android.widget.Button) bindings[2]
            , (android.widget.Button) bindings[3]
            , (android.widget.RelativeLayout) bindings[11]
            , (android.widget.EditText) bindings[12]
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.ListView) bindings[10]
            , (android.widget.Spinner) bindings[14]
            , (android.widget.FrameLayout) bindings[21]
            , (android.widget.TextView) bindings[19]
            , (android.widget.Switch) bindings[20]
            , (com.google.android.material.textfield.TextInputEditText) bindings[5]
            , (android.widget.ScrollView) bindings[4]
            , (com.google.android.material.textfield.TextInputEditText) bindings[6]
            , (android.widget.RelativeLayout) bindings[17]
            , (android.widget.EditText) bindings[18]
            , (android.widget.ListView) bindings[16]
            );
        this.btnAddIngredient.setTag(null);
        this.btnAddStep.setTag(null);
        this.btnCreate.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.presenter == variableId) {
            setPresenter((com.lions.cookbook.CreateRecipeContract.CreateRecipeMVPPresenter) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPresenter(@Nullable com.lions.cookbook.CreateRecipeContract.CreateRecipeMVPPresenter Presenter) {
        this.mPresenter = Presenter;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.presenter);
        super.requestRebind();
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
        android.view.View.OnClickListener presenterHandleAddIngredientAndroidViewViewOnClickListener = null;
        com.lions.cookbook.CreateRecipeContract.CreateRecipeMVPPresenter presenter = mPresenter;
        android.view.View.OnClickListener presenterHandleAddStepsAndroidViewViewOnClickListener = null;
        android.view.View.OnClickListener presenterHandleCreateRecipeClickedAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (presenter != null) {
                    // read presenter::handleAddIngredient
                    presenterHandleAddIngredientAndroidViewViewOnClickListener = (((mPresenterHandleAddIngredientAndroidViewViewOnClickListener == null) ? (mPresenterHandleAddIngredientAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mPresenterHandleAddIngredientAndroidViewViewOnClickListener).setValue(presenter));
                    // read presenter::handleAddSteps
                    presenterHandleAddStepsAndroidViewViewOnClickListener = (((mPresenterHandleAddStepsAndroidViewViewOnClickListener == null) ? (mPresenterHandleAddStepsAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mPresenterHandleAddStepsAndroidViewViewOnClickListener).setValue(presenter));
                    // read presenter::handleCreateRecipeClicked
                    presenterHandleCreateRecipeClickedAndroidViewViewOnClickListener = (((mPresenterHandleCreateRecipeClickedAndroidViewViewOnClickListener == null) ? (mPresenterHandleCreateRecipeClickedAndroidViewViewOnClickListener = new OnClickListenerImpl2()) : mPresenterHandleCreateRecipeClickedAndroidViewViewOnClickListener).setValue(presenter));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.btnAddIngredient.setOnClickListener(presenterHandleAddIngredientAndroidViewViewOnClickListener);
            this.btnAddStep.setOnClickListener(presenterHandleAddStepsAndroidViewViewOnClickListener);
            this.btnCreate.setOnClickListener(presenterHandleCreateRecipeClickedAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.lions.cookbook.CreateRecipeContract.CreateRecipeMVPPresenter value;
        public OnClickListenerImpl setValue(com.lions.cookbook.CreateRecipeContract.CreateRecipeMVPPresenter value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.handleAddIngredient(arg0); 
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.lions.cookbook.CreateRecipeContract.CreateRecipeMVPPresenter value;
        public OnClickListenerImpl1 setValue(com.lions.cookbook.CreateRecipeContract.CreateRecipeMVPPresenter value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.handleAddSteps(arg0); 
        }
    }
    public static class OnClickListenerImpl2 implements android.view.View.OnClickListener{
        private com.lions.cookbook.CreateRecipeContract.CreateRecipeMVPPresenter value;
        public OnClickListenerImpl2 setValue(com.lions.cookbook.CreateRecipeContract.CreateRecipeMVPPresenter value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.handleCreateRecipeClicked(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): presenter
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}