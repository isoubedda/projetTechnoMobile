package fr.technomobile.shareexpenses.vue;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fr.technomobile.shareexpenses.R;
import fr.technomobile.shareexpenses.adapters.ParticipantAdapter;
import fr.technomobile.shareexpenses.model.ListeParicipantModel;

public class NewGroupActivity extends AppCompatActivity implements  OnItemClickListener, OnItemSelectedListener {

    AutoCompleteTextView searchTextView;
    private ArrayAdapter<String> adapterContact;

    // Store contacts name in these list
    public static ArrayList<String> nameValue = new ArrayList<String>();

    ListView listeViewParticipant;
    // list of participant
    public static ArrayList<ListeParicipantModel> participantValue = new ArrayList<ListeParicipantModel>();
    private ParticipantAdapter adapterParticipant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);

        //back to before Activity
        ImageButton btnBack = (ImageButton) findViewById(R.id.actNewGroupImgBtnBefore);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // AutoCompleteTextView
        searchTextView = (AutoCompleteTextView) findViewById(R.id.searchViewParticipantNom);
        // Create contact adapter
        adapterContact = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
        // The minimum number of characters the user has to type in the edit box before the drop down list is shown
        searchTextView.setThreshold(1);
        //Set Contact adapter to AutoCompleteTextView
        searchTextView.setAdapter(adapterContact);
        searchTextView.setOnItemSelectedListener(this);
        searchTextView.setOnItemClickListener(this);

        readContactFromPhone();

        listeViewParticipant = (ListView) findViewById(R.id.listViewParticipantNom);
        // setup de liste view
        adapterParticipant = new ParticipantAdapter(this,participantValue);
        //ArrayAdapter<String>(this, android.R.layout.,participantValue);
        listeViewParticipant.setAdapter(adapterParticipant);
    }

    
    // Read phone contact name
    private void readContactFromPhone() {
        try {
            String phoneNumbe = "";
            ContentResolver cr = getBaseContext().getContentResolver();

            //get contact name
            Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            // name found in contacts
            if (cur.getCount() > 0) {

                int j=0;
                String name = "";
                while (cur.moveToNext())
                {
                    name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    // Add contacts names to adapter
                    adapterContact.add(name);
                    // Add ArrayList names to adapter
                    nameValue.add(name.toString());
                    j++;

                }  // End while loop

            } // End Cursor value check
            cur.close();

        } catch (Exception e) {
            Log.i("readContactFromPhone","Error : "+ e);
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
                               long arg3) {
        // TODO Auto-generated method stub
        //Log.d("AutocompleteContacts", "onItemSelected() position " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

        InputMethodManager imm = (InputMethodManager) getSystemService(
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub

        // Get Array index value for selected name
        int i = nameValue.indexOf(""+arg0.getItemAtPosition(arg2));

        // If name exist in name ArrayList
        if (i >= 0) {

            InputMethodManager imm = (InputMethodManager) getSystemService(
                    INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            int k = participantValue.size();
            boolean exist = false;
            while (k>0){
                if(participantValue.get(k-1).getName().equalsIgnoreCase(arg0.getItemAtPosition(arg2).toString())){
                    Toast.makeText(getBaseContext(), "Le participant existe deja !:", Toast.LENGTH_LONG).show();
                    exist = true;
                }
                k--;
            }
            if(exist == false){
                ListeParicipantModel md = new ListeParicipantModel(arg0.getItemAtPosition(arg2).toString());
                participantValue.add(md);
                adapterParticipant.notifyDataSetChanged();
                searchTextView.setText("");
            }

            // Show Alert
            //Toast.makeText(getBaseContext(), "Position:"+arg2+" Name:"+arg0.getItemAtPosition(arg2), Toast.LENGTH_LONG).show();

        }

    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

}