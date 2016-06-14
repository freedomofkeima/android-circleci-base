package freedomofkeima.androidbase.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import freedomofkeima.androidbase.FreedomofkeimaApplication;
import freedomofkeima.androidbase.R;
import freedomofkeima.androidbase.helper.VersionHelper;
import timber.log.Timber;

/**
 * Freedomofkeima Application
 *
 * Created on 6/14/16.
 * Maintained by iskandarsetiadi
 * Copyright (c) 2016. All rights reserved.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Initialize
        FreedomofkeimaApplication.initializeInstance(this);
        // Check application version
        VersionHelper.checkVersionUpdate();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timber.tag(TAG).d("MainActivity onCreate is called");
    }

}
