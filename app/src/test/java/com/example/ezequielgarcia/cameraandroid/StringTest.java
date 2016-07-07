package com.example.ezequielgarcia.cameraandroid;

import android.content.Context;
import android.os.Build;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

/**
 * Created by ezequiel.garcia on 7/7/16.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class StringTest {
    private Context context;
    @Before
    public void setUp() {
        context = RuntimeEnvironment.application;
    }

    @Test
    @Config(qualifiers = "es")
    public void localizedSpanishHelloWorld() {
        TextView tvHelloWorld = new TextView(context);
        tvHelloWorld.setText("Hello world");
        assertEquals(tvHelloWorld.getText().toString(), "Hola Mundo!");
    }

    @Test
    @Config(qualifiers = "es")
    public void two() {
        TextView tvHelloWorld = new TextView(context);
        tvHelloWorld.setText("Hello world");
        assertEquals(tvHelloWorld.getText().toString(), "Hello world");
    }
}
