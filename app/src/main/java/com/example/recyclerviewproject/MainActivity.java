package com.example.recyclerviewproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtNome, edtEmail, edtUpdateNome, edtUpdateEmail;
    Button btnAdicionar, btnUpdateUser, btnUpdateCancel;
    RecyclerView recyclerView;

    String nome, email;

    List<Usuario> list = new ArrayList<>();

    MeuAdaptador adaptador;

    // pop up
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

        adaptador = new MeuAdaptador(list);
        recyclerView.setAdapter(adaptador);

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
                adaptador.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Usuário adicionado! Sucesso...", Toast.LENGTH_SHORT).show();

                edtNome.setText("");
                edtEmail.setText("");
                edtNome.requestFocus();
            }
        });

        adaptador.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position, Usuario userData) {
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Usuário alterado");
                builder.setCancelable(false);
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialogedit, null, false);
                initUpdateDialog(position, view);
                builder.setView(view);
                dialog = builder.create();
                dialog.show();
            }
        });

    }

    private void initUpdateDialog(int position, View view) {
        edtUpdateNome = view.findViewById(R.id.edtUpdateNome);
        edtUpdateEmail = view.findViewById(R.id.edtUpdateEmail);
        btnUpdateCancel = view.findViewById(R.id.btnUpdateCancel);
        btnUpdateUser = view.findViewById(R.id.btnUpdateUser);

        edtUpdateNome.setText(nome);
        edtUpdateEmail.setText(email);

        btnUpdateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome = edtUpdateNome.getText().toString();
                email = edtUpdateEmail.getText().toString();

                Usuario userData = new Usuario();

                userData.setNome(nome);
                userData.setEmail(email);

                adaptador.UpdateData(position, userData);
                Toast.makeText(MainActivity.this, "Usuário editado! Sucesso...", Toast.LENGTH_LONG).show();
            }
        });

        btnUpdateCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}