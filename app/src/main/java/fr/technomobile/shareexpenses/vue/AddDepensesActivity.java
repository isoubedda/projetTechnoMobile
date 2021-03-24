package fr.technomobile.shareexpenses.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.technomobile.shareexpenses.R;
import fr.technomobile.shareexpenses.model.DepenseModel;

public class AddDepensesActivity extends AppCompatActivity {

    EditText titre;
    EditText date;
    Button ajouter;
    ImageButton before;
    DepenseModel depenseModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_depenses);

        titre = (EditText) findViewById(R.id.actAddDEpensesTextViewTitre);
        date =(EditText) findViewById(R.id.actAddDEpensesTextViewDate);
        ajouter = (Button) findViewById(R.id.actAddDepensesButton);
        before = (ImageButton) findViewById(R.id.actAddDepensesImgBtnBefore);

        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titre.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "veuillez entrer un titre minimum !", Toast.LENGTH_LONG).show();
                }else{
                    Date date1= null;
                    try {
                        date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    depenseModel = new DepenseModel(titre.getText().toString(),date1);
                }

                finish();

            }
        });





    }
}