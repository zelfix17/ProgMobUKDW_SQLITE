package com.example.zelfix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import actualsolusi.com.samplesqliteb.R;
import data.DatabaseHandler;
import models.Dokter;

public class ListOfDokterActivity extends AppCompatActivity {
    private RecyclerView rvWish;
    private ArrayList<Dokter> arrListDokter;
    private DatabaseHandler db;

    public ListOfDokterActivity(){
        db = new DatabaseHandler(ListOfDokterActivity.this);
    }

    // Refresh Data Dokter
    private void RefreshDataDokter(){
        arrListDokter = db.GetAllDokter();
        if(arrListDokter.isEmpty()){
            SeedDataDokter();
            arrListDokter = db.GetAllDokter();
        }
        DokterAdapter adapter = new DokterAdapter(arrListDokter);
        rvWish.setAdapter(adapter);
    }

    // Seed Data Dokter
    private void SeedDataDokter(){
        Dokter dataDokter = new Dokter();
        dataDokter.setNia("72140014");
        dataDokter.setNama("Yohanes Galang");
        dataDokter.setAlamat("Jalan Jalan");
        db.AddDokter(dataDokter);

        dataDokter.setNia("72140011");
        dataDokter.setNama("Galang");
        dataDokter.setAlamat("Jalan Keselamatan");
        db.AddDokter(dataDokter);

        dataDokter.setNia("72140022");
        dataDokter.setNama("Yohanes");
        dataDokter.setAlamat("Jalan Lalala");
        db.AddDokter(dataDokter);
    }


    // On Create Function
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_wish);

        rvWish = (RecyclerView)findViewById(R.id.rvWish);
        rvWish.addItemDecoration(new DividerItemDecoration(ContextCompat.getDrawable(
                getApplicationContext(),R.drawable.item_decorator)));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvWish.setLayoutManager(llm);
    }

    // On Resume Function
    @Override
    protected void onResume() {
        super.onResume();
        RefreshDataDokter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_wish,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuAdd:
                Intent intentAdd = new Intent(ListOfDokterActivity.this,AddDokterActivity.class);
                startActivity(intentAdd);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
