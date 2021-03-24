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
import fr.technomobile.shareexpenses.model.DepenseModel;
import fr.technomobile.shareexpenses.vue.ContactsFragment;
import fr.technomobile.shareexpenses.vue.DepensesFragment;

public class DepensesTabViewAdapter extends BaseAdapter {

    private ArrayList<DepenseModel> depensesValue;
    private Application application;
    private DepensesFragment depensesFragment;
    LayoutInflater inflater;

    public DepensesTabViewAdapter(ArrayList<DepenseModel> depensesValue, Application application, DepensesFragment depensesFragment) {
        this.depensesValue = depensesValue;
        this.application = application;
        this.depensesFragment = depensesFragment;
        this.inflater = LayoutInflater.from(application.getApplicationContext());
    }


    @Override
    public int getCount() {
        return depensesValue.size();
    }

    @Override
    public DepenseModel getItem(int i) {
        return depensesValue.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_depenses,null);
        DepenseModel currentValue = getItem(i);

        TextView adapterTxtTitre = view.findViewById(R.id.adapterDepensesTxtTitre);
        TextView adapterTxtDate = view.findViewById(R.id.adapterDepensesTxtDate);
        TextView adapterTxtTotal = view.findViewById(R.id.adapterDepensesTxtTotal);

        adapterTxtTitre.setText(currentValue.getTitre());
        adapterTxtDate.setText(currentValue.getDate().toString());
        adapterTxtTotal.setText(currentValue.calculTotal());

        return view;
    }
}
