package com.example.recyclerviewproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtNome, edtEmail;
    EditText edtUpdateNome, edtUpdateEmail;
    Button btnAdicionar;
    RecyclerView recyclerView;

    String nome, email;

    List<Usuario> list = new ArrayList<>();

    AlertDialog.Builder builder;

    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // O recyclerView vai ficar na forma linear, neste formato agui
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome = edtNome.getText().toString();
                email = edtEmail.getText().toString();

                Usuario userData = new Usuario();

                userData.setNome(nome);
                userData.setEmail(email);

                list.add(userData);

                // tipo o alertinha do js -> chato
                Toast.makeText(MainActivity.this, "Usuário adicionado! Sucesso...", Toast.LENGTH_SHORT).show();

                edtNome.setText("");
                edtEmail.setText("");
                edtNome.requestFocus();
            }
        });
    }
}