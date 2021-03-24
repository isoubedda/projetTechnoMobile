package fr.technomobile.shareexpenses.vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import fr.technomobile.shareexpenses.R;
import fr.technomobile.shareexpenses.adapters.ViewPagerAdapter;
import fr.technomobile.shareexpenses.model.ContactModel;
import fr.technomobile.shareexpenses.model.GroupModel;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // get name of the group from intent
        Intent intent = getIntent();
        GroupModel gm = intent.getParcelableExtra("OBJECT_NAME_GROUP");

        String contact = intent.getStringExtra("STRING_NAME_NEW_GROUP");
        if(contact != null) {
            gm.getContacts().add(new ContactModel(contact));
        }
        TabLayout tabLayout = findViewById(R.id.tabHomeLayoutActivity);
        ViewPager viewPager = findViewById(R.id.viewHomePagerActivity);

        // set toolbar
        Toolbar toolbar = findViewById(R.id.toolbarHomeActivity);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setElevation(0);
        }
        setTitle(gm.getName());

        // create adapter for viewpager and add fragments, group name and title to adapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(ContactsFragment.newInstance(gm),"Contacts");
        adapter.addFragment(DepensesFragment.newInstance(gm),"Depenses");
        adapter.addFragment(BalanceFragment.newInstance(gm),"Balance");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}