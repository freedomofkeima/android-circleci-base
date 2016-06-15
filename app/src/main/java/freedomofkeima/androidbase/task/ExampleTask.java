package freedomofkeima.androidbase.task;

import android.os.AsyncTask;

import freedomofkeima.androidbase.helper.AsyncTaskResult;
import freedomofkeima.androidbase.helper.IAsyncTaskOwner;
import timber.log.Timber;

/**
 * Freedomofkeima Application
 *
 * Created on 6/15/16.
 * Maintained by iskandarsetiadi
 * Copyright (c) 2016. All rights reserved.
 */
public class ExampleTask extends AsyncTask<Void, Integer, AsyncTaskResult<String>> {

    private static final String TAG = ExampleTask.class.getSimpleName();

    private volatile IAsyncTaskOwner mOwner;
    private String mText;

    public ExampleTask(IAsyncTaskOwner owner, String text) {
        mOwner = owner;
        mText = text;
    }

    @Override
    protected void onPreExecute() {
        // You can do something progress bar (toggleProgressBar callback)
        super.onPreExecute();
    }

    @Override
    protected AsyncTaskResult<String> doInBackground(Void... params) {
        String result = "Sample Output";
        Timber.tag(TAG).d("ExampleTask input value: " + mText);
        publishProgress(50); // e.g.: call onProgressUpdate with value of "50" (%)
        return new AsyncTaskResult<String>(result);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        // You can update progress bar here
        Timber.tag(TAG).d("ExampleTask onProgressUpdate is called: " + String.valueOf(values[0]));
        mOwner.toggleProgressBar(true, String.valueOf(values[0]));
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(AsyncTaskResult<String> result) {
        // You can make custom datatype and post-processing here
        mOwner.getResult(result);
    }

}
