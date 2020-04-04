package com.lions.cookbook;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;


public class SessionManager {

    protected SharedPreferences mPreferences;


    //Shared Preferences Keys
    static final String LOGGEDIN_USER_EMAIL = "logged_in_email";
    static final String IS_USER_LOGIN = "isUserLogin";


    public SessionManager() {
        this.mPreferences = PreferencesProvider.providePreferences();
    }



    public boolean isUserLogin() {
        return mPreferences.getBoolean(IS_USER_LOGIN, false);
    }

    public void setUserLogin(boolean status) {
        mPreferences.edit().putBoolean(IS_USER_LOGIN, status).apply();
    }

    public void clearUser() {
        mPreferences.edit()
                .putBoolean(IS_USER_LOGIN, false)
                .putString(LOGGEDIN_USER_EMAIL, "")
                .apply();
    }

    public void setLoggedInUserEmail(String email) {
        mPreferences.edit().putString(LOGGEDIN_USER_EMAIL, email).apply();
    }

    public String getLoggedInUserEmail() {
        return mPreferences.getString(LOGGEDIN_USER_EMAIL, "");
    }

    public void setUserLoggedInStatus(boolean status) {
        mPreferences.edit().putBoolean(IS_USER_LOGIN, status).apply();
    }

}
