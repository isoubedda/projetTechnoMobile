package fr.technomobile.shareexpenses;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button addGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.addGroup = findViewById(R.id.btnNewGroup);

        addGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newGroupActivity = new Intent(getApplicationContext(),NewGroupActivity.class);
                startActivity(newGroupActivity);
                finish();
            }
        });
    }

}