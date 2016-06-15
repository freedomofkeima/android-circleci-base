package freedomofkeima.androidbase.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import freedomofkeima.androidbase.FreedomofkeimaApplication;
import freedomofkeima.androidbase.R;
import freedomofkeima.androidbase.helper.AsyncTaskResult;
import freedomofkeima.androidbase.helper.IAsyncTaskOwner;
import freedomofkeima.androidbase.helper.VersionHelper;
import freedomofkeima.androidbase.task.ExampleTask;
import timber.log.Timber;

/**
 * Freedomofkeima Application
 *
 * Created on 6/14/16.
 * Maintained by iskandarsetiadi
 * Copyright (c) 2016. All rights reserved.
 */
public class MainActivity extends AppCompatActivity implements IAsyncTaskOwner {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Initialize
        FreedomofkeimaApplication.initializeInstance(this);
        // Check application version
        VersionHelper.checkVersionUpdate();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sample of calling Asynchronous task
        new ExampleTask(this, "Sample Input").execute();

        Timber.tag(TAG).d("MainActivity onCreate is called");
    }

    // IAsyncTaskOwner Area (For Asynchronous task)
    @Override
    public void getResult(AsyncTaskResult<?> result) {
        Exception e = result.getError();
        if ((e == null) && result.getResult() != null) {
            // In this case, ret is result from ExampleTask
            String ret = (String) result.getResult();
            Timber.tag(TAG).d("MainActivity getResult is called: " + ret);
        } else {
            if (e != null) {
                Timber.tag(TAG).e("Unexpected error occurred during asynchronous callback");
            }
        }
    }

    @Override
    public void toggleProgressBar(final Boolean show, final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Do something in UI thread, e.g.: browser's loading percentage
                Timber.tag(TAG).d("MainActivity toggleProgressBar is called: " + message);
            }
        });
    }

}
