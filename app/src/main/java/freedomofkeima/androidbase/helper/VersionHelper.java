package freedomofkeima.androidbase.helper;

import freedomofkeima.androidbase.BuildConfig;
import freedomofkeima.androidbase.Constants;

/**
 * Freedomofkeima Application
 *
 * Created on 6/14/16.
 * Maintained by iskandarsetiadi
 * Copyright (c) 2016. All rights reserved.
 */
public class VersionHelper {

    private static final String TAG = VersionHelper.class.getSimpleName();

    public static void checkVersionUpdate() {
        String s = PreferencesManager.getInstance().readValue(Constants.LATEST_ANDROID_VERSION_KEY);
        String versionCode = String.valueOf(BuildConfig.VERSION_CODE);
        int currentVersionCode = 0;

        if (s != null) {
            currentVersionCode = Integer.valueOf(s);
        }

        // Do update per version change
        if (currentVersionCode < 1) {

            currentVersionCode = 1;
        }

        // Update preference
        PreferencesManager.getInstance().storeValue(Constants.LATEST_ANDROID_VERSION_KEY, versionCode);
    }

}
