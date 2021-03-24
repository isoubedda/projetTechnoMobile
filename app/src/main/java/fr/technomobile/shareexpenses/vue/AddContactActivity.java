package fr.technomobile.shareexpenses.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import fr.technomobile.shareexpenses.R;
import fr.technomobile.shareexpenses.model.ContactModel;
import fr.technomobile.shareexpenses.model.GroupModel;

public class AddContactActivity extends AppCompatActivity implements  OnItemClickListener, OnItemSelectedListener {

    AutoCompleteTextView searchTextView;
    private ArrayAdapter<String> adapterContact;

    // Store contacts name in these list
    public static ArrayList<String> nameValue = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        //back to before Activity
        ImageButton btnBack = (ImageButton) findViewById(R.id.actAddContactImgBtnBefore);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        // AutoCompleteTextView
        searchTextView = (AutoCompleteTextView) findViewById(R.id.actAddContactSearch);
        // Create contact adapter
        adapterContact = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
        // The minimum number of characters the user has to type in the edit box before the drop down list is shown
        searchTextView.setThreshold(1);
        //Set Contact adapter to AutoCompleteTextView
        searchTextView.setAdapter(adapterContact);
        searchTextView.setOnItemSelectedListener(this);
        searchTextView.setOnItemClickListener(this);

        // get name of the group from intent
        Intent intent = getIntent();
        GroupModel gm = intent.getParcelableExtra("OBJECT_NAME_GROUP");

         Button btnAdd = (Button) findViewById(R.id.actAddContactButton);
         btnAdd.setOnClickListener(new View.OnClickListener() {
         @Override
             public void onClick(View view) {
             if (searchTextView.getText().toString().isEmpty()) {
                 Toast.makeText(getBaseContext(), "veuillez ajouter un contact !", Toast.LENGTH_LONG).show();

             } else {
                 Intent intent = new Intent(AddContactActivity.this, HomeActivity.class);
                 intent.putExtra("OBJECT_NAME_GROUP", gm);
                 intent.putExtra("STRING_NAME_NEW_GROUP", searchTextView.getText().toString());

                 startActivity(intent);
                 finish();
             }

         }

          });
         readContactFromPhone();
    }

    // Read phone contact name
    private void readContactFromPhone() {
        try {
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

                }

            }
            cur.close();

        } catch (Exception e) {
            Log.i("readContactFromPhone","Error : "+ e);
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
                               long arg3) {
        // TODO Auto-generated method stub
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
        InputMethodManager imm = (InputMethodManager) getSystemService(
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            ContactModel md = new ContactModel(arg0.getItemAtPosition(arg2).toString());

    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

}