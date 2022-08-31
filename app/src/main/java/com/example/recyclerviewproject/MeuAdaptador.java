package com.example.recyclerviewproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class MeuAdaptador extends RecyclerView.Adapter<MeuAdaptador.MyHolder> {

    List<Usuario> listaUsuario = new ArrayList<>();

    ItemClickListener itemClickListener;

    public MeuAdaptador(List<Usuario> list) { this.listaUsuario = list; }

    @NonNull
    @Override
    public MeuAdaptador.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeuAdaptador.MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView tvNomeItem, tvEmailItem, tvDeleteItem;

        public MyHolder (View itemView){
            super(itemView);

            tvNomeItem = itemView.findViewById(R.id.tvNomeItem);
            tvEmailItem = itemView.findViewById(R.id.tvEmailItem);
            tvDeleteItem = itemView.findViewById(R.id.tvDeleteItem);
        }
    }
}
