package com.example.zelfix;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import actualsolusi.com.samplesqliteb.R;
import models.Dokter;

/**
 * Created by erick on 06/11/2017.
 */

public class DokterAdapter extends RecyclerView.Adapter<DokterAdapter.MyViewHolder> {
    private List<Dokter> listDokter;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNama,tvNia,tvAlamat;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvNama = (TextView)itemView.findViewById(R.id.tvNama);
            tvNia = (TextView)itemView.findViewById(R.id.tvNia);
            tvAlamat = (TextView)itemView.findViewById(R.id.tvAlamat);
        }
    }

    public DokterAdapter(List<Dokter> listDokter){
        this.listDokter = listDokter;
    }

    @Override
    public DokterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_wish,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DokterAdapter.MyViewHolder holder, int position) {
        Dokter currWish = listDokter.get(position);
        holder.tvAlamat.setText(currWish.getAlamat());
        holder.tvNama.setText(currWish.getNama());
        holder.tvNia.setText(currWish.getNia());
    }

    @Override
    public int getItemCount() {
        return listDokter.size();
    }


}
