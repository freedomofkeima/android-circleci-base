package freedomofkeima.androidbase.helper;

import android.content.Context;
import android.content.SharedPreferences;

import freedomofkeima.androidbase.Constants;

/**
 * Freedomofkeima Application
 *
 * Created on 6/14/16.
 * Maintained by iskandarsetiadi
 * Copyright (c) 2016. All rights reserved.
 */
public class PreferencesManager {

    private static final String TAG = PreferencesManager.class.getSimpleName();

    private static PreferencesManager sInstance;
    private final SharedPreferences mPref;

    private PreferencesManager(Context context) {
        mPref = context.getSharedPreferences(Constants.PREF_PREFERENCES_KEY,
                Context.MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesManager(context);
        }
    }

    public static synchronized void destroyInstance() {
        sInstance = null;
    }

    public static synchronized PreferencesManager getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException("Preferences Manager is not initialized.");
        }
        return sInstance;
    }

    public void storeValue(String key, String value) {
        mPref.edit().putString(key, value).apply();
    }

    public String readValue(String key) {
        return mPref.getString(key, null);
    }

    public void removeValue(String key) {
        mPref.edit().remove(key).apply();
    }

}
