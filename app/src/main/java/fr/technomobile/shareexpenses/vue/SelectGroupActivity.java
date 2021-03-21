package fr.technomobile.shareexpenses.vue;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import fr.technomobile.shareexpenses.R;

public class SelectGroupActivity extends AppCompatActivity {

    // TODO : backend recuperer les données de groupes de la base et avec le model il faut creer un adapter pour remplire la liste
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
    }
}