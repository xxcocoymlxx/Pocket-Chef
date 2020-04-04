package com.lions.cookbook.databinding;
import com.lions.cookbook.R;
import com.lions.cookbook.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ViewAccountPrivateActivityBindingImpl extends ViewAccountPrivateActivityBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.NameLayout, 1);
        sViewsWithIds.put(R.id.firstName, 2);
        sViewsWithIds.put(R.id.lastName, 3);
        sViewsWithIds.put(R.id.username, 4);
        sViewsWithIds.put(R.id.phoneNumber, 5);
        sViewsWithIds.put(R.id.email, 6);
        sViewsWithIds.put(R.id.ButtonLayout, 7);
        sViewsWithIds.put(R.id.settingsBtn, 8);
        sViewsWithIds.put(R.id.dietaryBtn, 9);
        sViewsWithIds.put(R.id.followingBtn, 10);
        sViewsWithIds.put(R.id.followersBtn, 11);
        sViewsWithIds.put(R.id.logoutBtn, 12);
        sViewsWithIds.put(R.id.steps, 13);
        sViewsWithIds.put(R.id.navBar, 14);
        sViewsWithIds.put(R.id.bottom_navigation, 15);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ViewAccountPrivateActivityBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ViewAccountPrivateActivityBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.RelativeLayout) bindings[1]
            , (com.google.android.material.bottomnavigation.BottomNavigationView) bindings[15]
            , (android.widget.Button) bindings[9]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[2]
            , (android.widget.Button) bindings[11]
            , (android.widget.Button) bindings[10]
            , (android.widget.TextView) bindings[3]
            , (android.widget.Button) bindings[12]
            , (android.widget.FrameLayout) bindings[14]
            , (android.widget.TextView) bindings[5]
            , (android.widget.Button) bindings[8]
            , (android.widget.ListView) bindings[13]
            , (android.widget.TextView) bindings[4]
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
            setPresenter((com.lions.cookbook.CreateRecipePresent) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPresenter(@Nullable com.lions.cookbook.CreateRecipePresent Presenter) {
        this.mPresenter = Presenter;
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
        flag 0 (0x1L): presenter
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}