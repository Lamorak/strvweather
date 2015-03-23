package cz.lamorak.weather.android.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import cz.lamorak.weather.android.R;
import cz.lamorak.weather.android.entity.NavigationDrawerItem;
import cz.lamorak.weather.android.fragment.ForecastFragment;
import cz.lamorak.weather.android.fragment.NavigationDrawerFragment;
import cz.lamorak.weather.android.fragment.TodayFragment;

public class MainActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private NavigationDrawerFragment navigationDrawerFragment;
    private int titleResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setStatusBarBackgroundColor(Color.BLUE);

        FragmentManager fragmentManager = getSupportFragmentManager();
        navigationDrawerFragment = (NavigationDrawerFragment) fragmentManager.findFragmentById(R.id.navigation_drawer);
        navigationDrawerFragment.setUp(R.id.navigation_drawer, toolbar, drawerLayout);
    }

    @Override
    public void onNavigationDrawerItemSelected(NavigationDrawerItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment;
        switch (item.getId()) {
            case NavigationDrawerItem.FORECAST:
                fragment = ForecastFragment.newInstance();
                break;
            case NavigationDrawerItem.TODAY:
            default:
                fragment = TodayFragment.newInstance();
        }

        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

        titleResource = item.getTextResource();
    }


    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setTitle(titleResource);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!navigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
            case R.id.action_about:
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
