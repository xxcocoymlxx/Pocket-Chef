package com.lions.cookbook;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import android.view.View;

public interface LoginContract {

    interface LoginPresenter{

        void handleLoginClicked(View view);
        void update(boolean signedIn);

    }

    interface LoginModel {
        FirebaseUser getCurrentUser();
        void signOut();
        void signIn(String email, String password);
        boolean getSignedIn();
        void addObserver(LoginObserver observer);
        public void notifyObservers();
}


    interface LoginView{
        void goToCreateAccountScreen();
        void goToCookBookScreen();
        String getEmail();
        String getPassword();
        void goToCreateRecipeScreen();
        void showUnfilledError();
        void showLoginFailure();
        void showLoginSuccess();


       // void onLoginResult(Boolean result, int code);

     //   void showLogin();

     //   void hideLogin();

    }


}