package com.example.nodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewNoDoActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "nodoActivity";
    private EditText newNodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_no_do);
        newNodo = findViewById(R.id.edit_nodo);
        final Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(newNodo.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                }
                else {
                    String nodoString = newNodo.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, nodoString);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}