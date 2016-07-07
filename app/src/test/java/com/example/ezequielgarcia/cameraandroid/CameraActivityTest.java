package com.example.ezequielgarcia.cameraandroid;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.ezequielgarcia.cameraandroid.BuildConfig;
import com.example.ezequielgarcia.cameraandroid.CameraActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

/**
 * Created by ezequiel.garcia on 7/6/16.
 */

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class CameraActivityTest {
    private ActivityController<CameraActivity> controller;
    private CameraActivity activity;

    @Before
    public void setUp() {
        controller = Robolectric.buildActivity(CameraActivity.class);
    }

    private void createWithIntent(String extra) {
        Intent intent = new Intent(RuntimeEnvironment.application, CameraActivity.class);
        intent.putExtra("activity_extra", extra);
        activity = controller
                .withIntent(intent)
                .create()
                .start()
                .resume()
                .visible()
                .get();
    }

    @Test
    public void createsAndDestroysActivity() {
        createWithIntent("my extra_value");
    }

    @After
    public void tearDown() {
        controller
                .pause()
                .stop()
                .destroy();
    }
}
