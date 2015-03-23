package cz.lamorak.weather.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/*
* The purpose of this activity is to display app logo before any view gets inflated within
* the onCreate method.
*/

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
