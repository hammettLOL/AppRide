package com.labs.maverick.projectevo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.labs.maverick.projectevo.R;

public class SelectUserActivity extends AppCompatActivity {

    private Button clienteButton;
    private Button choferButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);
        getSupportActionBar().setTitle("Selecciona Tipo Usuario");
        clienteButton = (Button)findViewById(R.id.clienteButton);
        choferButton = (Button)findViewById(R.id.choferbutton);

        clienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectUserActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        choferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectUserActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
