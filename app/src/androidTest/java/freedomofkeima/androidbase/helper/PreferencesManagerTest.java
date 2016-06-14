package freedomofkeima.androidbase.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;

import freedomofkeima.androidbase.Constants;

/**
 * Freedomofkeima Application
 *
 * Created on 6/14/16.
 * Maintained by iskandarsetiadi
 * Copyright (c) 2016. All rights reserved.
 */
public class PreferencesManagerTest extends AndroidTestCase {

    private PreferencesManager mPreferencesManager;
    private SharedPreferences mTestPreferences;

    private static final String PREFIX = "test.";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        PreferencesManager.initializeInstance(new TestContext());
        mPreferencesManager = PreferencesManager.getInstance();
        mTestPreferences = getContext().getSharedPreferences(PREFIX + Constants.PREF_PREFERENCES_KEY,
                Context.MODE_PRIVATE);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        SharedPreferences.Editor editor = mTestPreferences.edit();
        editor.clear();
        editor.apply();
        PreferencesManager.destroyInstance();
    }

    public void testStoreValue() {
        String key = "testStoreValueKey";
        String value = "testStoreValueValue";
        mPreferencesManager.storeValue(key, value);
        assertEquals(value, mTestPreferences.getString(key, null));
    }

    public void testReadValue() {
        String key = "testReadValueKey";
        String value = "testReadValueValue";

        SharedPreferences.Editor editor = mTestPreferences.edit();
        editor.putString(key, value);
        editor.apply();

        assertNull(mPreferencesManager.readValue("testReadValueUndefinedKey"));
        assertEquals(value, mPreferencesManager.readValue(key));
    }

    public void testRemoveValue() {
        String key = "testRemoveValueKey";
        String value = "testRemoveValueValue";

        SharedPreferences.Editor editor = mTestPreferences.edit();
        editor.putString(key, value);
        editor.apply();
        assertEquals(value, mTestPreferences.getString(key, null));

        mPreferencesManager.removeValue(key);
        assertNull(mTestPreferences.getString(key, null));
    }

    // Mock class
    class TestContext extends MockContext {
        private static final String PREFIX = "test.";

        @Override
        public SharedPreferences getSharedPreferences(String name, int mode) {
            return getContext().getSharedPreferences(PREFIX + name, mode);
        }
    }

}
