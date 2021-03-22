package fr.technomobile.shareexpenses.vue;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fr.technomobile.shareexpenses.R;
import fr.technomobile.shareexpenses.adapters.GroupAdapter;
import fr.technomobile.shareexpenses.model.GroupModel;

public class SelectGroupActivity extends AppCompatActivity {

    ListView groupListView;
    // list of groups
    public static ArrayList<GroupModel> groupValue = new ArrayList<GroupModel>();
    private GroupAdapter adapterGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_group);

        //back to before Activity
        ImageButton btnBack = (ImageButton) findViewById(R.id.actSelectImgBtnBefore);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        groupListView = (ListView) findViewById(R.id.actSelectGroupListViewGroup);
        GroupModel gm = new GroupModel("samoha");
        GroupModel am = new GroupModel("jamila");

        // setup de liste view
        adapterGroup = new GroupAdapter(this,groupValue);
        //ArrayAdapter<String>(this, android.R.layout.,participantValue);
        groupListView.setAdapter(adapterGroup);
        groupValue.add(am);
        groupValue.add(gm);
        adapterGroup.notifyDataSetChanged();


    }
}