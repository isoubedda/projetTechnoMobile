package fr.technomobile.shareexpenses.vue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import fr.technomobile.shareexpenses.R;
import fr.technomobile.shareexpenses.adapters.ViewPagerAdapter;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // get name of the group from intent
        Intent intent = getIntent();
        String groupeName = intent.getStringExtra("STRING_NAME_GROUP");

        Toast.makeText(getBaseContext(), "le nom du groupe est :"+groupeName, Toast.LENGTH_LONG).show();


        TabLayout tabLayout = findViewById(R.id.tabHomeLayoutActivity);
        ViewPager viewPager = findViewById(R.id.viewHomePagerActivity);

        // set toolbar
        Toolbar toolbar = findViewById(R.id.toolbarHomeActivity);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setElevation(0);
        }
        setTitle(groupeName);

        // create adapter for viewpager and add fragments, group name and title to adapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(ContactsFragment.newInstance(groupeName),"Contacts");
        adapter.addFragment(DepensesFragment.newInstance(groupeName),"Depenses");
        adapter.addFragment(BalanceFragment.newInstance(groupeName),"Balance");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);



    }
}