package pe.edu.upc.materialsample.viewcontrollers.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import pe.edu.upc.materialsample.R;
import pe.edu.upc.materialsample.viewcontrollers.fragments.DashboardFragment;
import pe.edu.upc.materialsample.viewcontrollers.fragments.HomeFragment;
import pe.edu.upc.materialsample.viewcontrollers.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return navigateTo(item);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigateTo(navigation.getMenu()
                .findItem(R.id.navigation_home));
    }

    private Fragment getFragmentFor(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home: return new HomeFragment();
            case R.id.navigation_dashboard: return new DashboardFragment();
            case R.id.navigation_settings: return new SettingsFragment();
            default: return new HomeFragment();
        }
    }

    private boolean navigateTo(MenuItem item) {
        item.setChecked(true);
        return getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, getFragmentFor(item))
                .commit() > 0;
    }
}
