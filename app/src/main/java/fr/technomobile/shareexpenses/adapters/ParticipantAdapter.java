package fr.technomobile.shareexpenses.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

import fr.technomobile.shareexpenses.R;
import fr.technomobile.shareexpenses.model.ListeParicipantModel;

public class ParticipantAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ListeParicipantModel> participantValue;
    LayoutInflater inflater;

    public ParticipantAdapter (Context context, ArrayList<ListeParicipantModel> participantValue){
        this.context = context;
        this.participantValue = participantValue;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return participantValue.size();
    }

    @Override
    public ListeParicipantModel getItem(int i) {
        return participantValue.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_participant,null);

        ListeParicipantModel currentValue = getItem(i);

        TextView adapterTxtView = view.findViewById(R.id.adapterTxtView);
        ImageView imgRemove = view.findViewById(R.id.adapterImgDelete);
        ImageView imgUpdate  = view.findViewById(R.id.adapterImgUpdate);

        imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                participantValue.remove(i);
                notifyDataSetChanged();
            }
        });
        final String[] m_Text = {""};
        imgUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder[] builder = {new AlertDialog.Builder(context)};
                builder[0].setTitle("Changer le nom");

// Set up the input
                final EditText input = new EditText(context);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                input.setText(participantValue.get(i).getName());
                builder[0].setView(input);

// Set up the buttons
                builder[0].setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        participantValue.get(i).setName(input.getText().toString());
                        notifyDataSetChanged();
                    }
                });
                builder[0].setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder[0].show();

                //participantValue.remove(i);
                //notifyDataSetChanged();
            }
        });


        adapterTxtView.setText(currentValue.getName());

        return view;
    }
}
