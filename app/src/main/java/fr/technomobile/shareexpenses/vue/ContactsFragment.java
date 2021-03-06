package fr.technomobile.shareexpenses.vue;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import fr.technomobile.shareexpenses.R;
import fr.technomobile.shareexpenses.adapters.ContactAdapter;
import fr.technomobile.shareexpenses.adapters.ContactTabViewAdapter;
import fr.technomobile.shareexpenses.model.ContactModel;
import fr.technomobile.shareexpenses.model.GroupModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactsFragment extends Fragment {


    ListView fragmentContactListView;
    private ContactTabViewAdapter adapterContact;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "OBJECT_NAME_CONTACT";

    // parameters
    private GroupModel gm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // if (getArguments() != null) {
       //     contactModel = getArguments().getParcelableArrayList(ARG_PARAM1);
       // }

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param GroupModel Parameter 1
     * @return A new instance of fragment ContactsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactsFragment newInstance(GroupModel gm) {
        ContactsFragment fragment = new ContactsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, gm);
        fragment.setArguments(args);
        return fragment;
    }


    public ContactsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);
        gm = getArguments().getParcelable(ARG_PARAM1);
        fragmentContactListView = view.findViewById(R.id.fragmentContactListView);

        adapterContact = new ContactTabViewAdapter(gm.getContacts(), getActivity().getApplication(),this);
        //Toast.makeText(getActivity().getApplication(), "veuillez :" + gm.getContacts().get(1).getName(), Toast.LENGTH_LONG).show();
        fragmentContactListView.setAdapter(adapterContact);
        adapterContact.notifyDataSetChanged();

        FloatingActionButton addFloating = view.findViewById(R.id.contactFragmentAdd);
        addFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addContactActivity = new Intent(getActivity().getApplication(),AddContactActivity.class);
                addContactActivity.putExtra("OBJECT_NAME_GROUP", gm);
                startActivity(addContactActivity);
            }
        });


        return view;
    }
}