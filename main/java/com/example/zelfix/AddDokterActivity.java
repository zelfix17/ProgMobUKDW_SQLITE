package com.example.zelfix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import actualsolusi.com.samplesqliteb.R;
import data.DatabaseHandler;
import models.Dokter;

public class AddDokterActivity extends AppCompatActivity {
    private EditText etNama, etAlamat, etNia;
    private Button btnAddWish;
    private DatabaseHandler db;

    public AddDokterActivity(){
        db = new DatabaseHandler(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wish);

        etNama = (EditText)findViewById(R.id.etNama);
        etAlamat = (EditText)findViewById(R.id.etAlamat);
        etNia = (EditText)findViewById(R.id.etNia);
        btnAddWish = (Button)findViewById(R.id.btnAddWish);

        //On Click Listener
        btnAddWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dokter dokter = new Dokter();
                dokter.setNia(etNia.getText().toString());
                dokter.setNama(etNama.getText().toString());
                dokter.setAlamat(etAlamat.getText().toString());
                try{
                    db.AddDokter(dokter);
                    Toast.makeText(AddDokterActivity.this,"Tambah data berhasil !",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }catch (Exception ex){
                    Toast.makeText(AddDokterActivity.this,
                            "Error "+ex.getMessage().toString(),Toast.LENGTH_LONG).show();
                }
                finally {
                    db.close();
                }
            }
        });
    }
}
