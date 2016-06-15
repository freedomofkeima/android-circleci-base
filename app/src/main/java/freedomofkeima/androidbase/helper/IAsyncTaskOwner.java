package freedomofkeima.androidbase.helper;

/**
 * Freedomofkeima Application
 *
 * Created on 6/15/16.
 * Maintained by iskandarsetiadi
 * Copyright (c) 2016. All rights reserved.
 */
public interface IAsyncTaskOwner {

    void getResult(AsyncTaskResult<?> result);

    void toggleProgressBar(Boolean show, String message);

}
