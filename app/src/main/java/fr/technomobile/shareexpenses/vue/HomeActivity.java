package fr.technomobile.shareexpenses.vue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import fr.technomobile.shareexpenses.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // TODO : load all data

        TabLayout tabLayout = findViewById(R.id.tabHomeLayoutActivity);
        ViewPager viewPager = findViewById(R.id.viewHomePagerActivity);

        // set toolbar
        Toolbar toolbar = findViewById(R.id.toolbarHomeActivity);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setElevation(0);
        }

        // TODO : setTitle() name of groupe

        // TODO : create adapter for viewpager and add all three fragments/tabs to this adapter viewPager.setAdapter(adapter);
        //        tabLayout.setupWithViewPager(viewPager);


    }
}