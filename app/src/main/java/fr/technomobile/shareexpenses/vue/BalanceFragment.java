package fr.technomobile.shareexpenses.vue;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import fr.technomobile.shareexpenses.R;
import fr.technomobile.shareexpenses.adapters.BalanceTabViewAdapter;
import fr.technomobile.shareexpenses.model.GroupModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BalanceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BalanceFragment extends Fragment {

    ListView fragmentBalanceListView;
    private BalanceTabViewAdapter adapterBalance;


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "OBJECT_NAME_CONTACT";

    // parameters
    private GroupModel gm;

    public BalanceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param GroupModel Parameter 1
     * @return A new instance of fragment ContactsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BalanceFragment newInstance(GroupModel gm) {
        BalanceFragment fragment = new BalanceFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, gm);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_balance, container, false);
        gm = getArguments().getParcelable(ARG_PARAM1);
        fragmentBalanceListView = view.findViewById(R.id.fragmentBalanceListView);

        adapterBalance = new BalanceTabViewAdapter(gm.getContacts(),gm, getActivity().getApplication(),this);
        //Toast.makeText(getActivity().getApplication(), "veuillez :" + gm.getContacts().get(1).getName(), Toast.LENGTH_LONG).show();
        fragmentBalanceListView.setAdapter(adapterBalance);
        adapterBalance.notifyDataSetChanged();


        return view;
    }
}