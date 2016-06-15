package freedomofkeima.androidbase.helper;

/**
 * Freedomofkeima Application
 *
 * Created on 6/15/16.
 * Maintained by iskandarsetiadi
 * Copyright (c) 2016. All rights reserved.
 */
public class AsyncTaskResult<T> {
    private T mResult;
    private String mType;
    private Exception mError;


    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public T getResult() {
        return mResult;
    }

    public Exception getError() {
        return mError;
    }

    public AsyncTaskResult(T result) {
        super();
        mResult = result;
    }

    public AsyncTaskResult(Exception error) {
        super();
        mError = error;
    }
}

