package fr.technomobile.shareexpenses.adapters;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import fr.technomobile.shareexpenses.R;
import fr.technomobile.shareexpenses.model.ContactModel;
import fr.technomobile.shareexpenses.model.GroupModel;
import fr.technomobile.shareexpenses.vue.BalanceFragment;
import fr.technomobile.shareexpenses.vue.ContactsFragment;

public class BalanceTabViewAdapter extends BaseAdapter {

    private ArrayList<ContactModel> participantValue;
    private GroupModel groupModel;
    private Application application;
    private BalanceFragment balanceFragment;
    LayoutInflater inflater;

    public BalanceTabViewAdapter(ArrayList<ContactModel> participantValue,GroupModel groupModel, Application application, BalanceFragment balanceFragment) {
        this.participantValue = participantValue;
        this.groupModel = groupModel;
        this.application = application;
        this.balanceFragment = balanceFragment;
        this.inflater = LayoutInflater.from(application.getApplicationContext());
    }


    @Override
    public int getCount() {
        return participantValue.size();
    }

    @Override
    public ContactModel getItem(int i) {
        return participantValue.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_balance,null);
        ContactModel currentValue = getItem(i);

        TextView adapterTxtViewNigative = view.findViewById(R.id.adapterBalanceNigative);
        TextView adapterTxtViewContact = view.findViewById(R.id.adapterBalanceContact);
        TextView adapterTxtViewPositive = view.findViewById(R.id.adapterBalancePositive);

        adapterTxtViewContact.setText(currentValue.getName());
        double total = groupModel.getBalance(currentValue.getName());
        String chaine = total+" Euro";
        if (total<=0){
            adapterTxtViewNigative.setText(chaine);
        } else{
            adapterTxtViewPositive.setText(chaine);
        }
        return view;
    }
}
