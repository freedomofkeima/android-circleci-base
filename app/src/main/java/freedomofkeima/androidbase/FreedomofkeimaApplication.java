package freedomofkeima.androidbase;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import freedomofkeima.androidbase.helper.PreferencesManager;
import timber.log.Timber;

/**
 * Freedomofkeima Application
 *
 * Created on 6/14/16.
 * Maintained by iskandarsetiadi
 * Copyright (c) 2016. All rights reserved.
 */
public class FreedomofkeimaApplication extends Application {

    private static final String TAG = FreedomofkeimaApplication.class.getSimpleName();
    private static FreedomofkeimaApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        // Add Timber logging library
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected String createStackElementTag(StackTraceElement element) {
                    return super.createStackElementTag(element) + ":" + element.getLineNumber();
                }
            });
        } else {
            Timber.plant(new CrashReportingTree());
        }

        sInstance = this;

        PreferencesManager.initializeInstance(getBaseContext());

        Timber.tag(TAG).d("Freedomofkeima Application created.");
    }

    public static synchronized void initializeInstance(Context context) {
        // Initialization here
    }

    public static FreedomofkeimaApplication getInstance() {
        return sInstance;
    }

    // Timber library
    public static class CrashReportingTree extends Timber.Tree {
        @Override protected void log(int priority, String tag, String message, Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
                return; // pass
            }

            if (t != null) {
                if (priority == Log.ERROR || priority == Log.WARN) {
                    t.printStackTrace();
                }
            } else {
                if (priority == Log.ERROR) {
                    Log.e(tag, message);
                } else if (priority == Log.WARN) {
                    Log.w(tag, message);
                }
            }
        }
    }

}
