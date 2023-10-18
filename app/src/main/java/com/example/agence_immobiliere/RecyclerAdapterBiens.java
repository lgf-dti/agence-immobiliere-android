package com.example.agence_immobiliere;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecyclerAdapterBiens extends RecyclerView.Adapter<RecyclerAdapterBiens.RecyclerViewHolder> {

    private ArrayList<BienImmobilier> biensModelList;

    public RecyclerAdapterBiens(ArrayList<BienImmobilier> biensModelList) {
        this.biensModelList = biensModelList;
    }

    @NonNull
    @Override
    public RecyclerAdapterBiens.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_biens_immobiliers, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterBiens.RecyclerViewHolder holder, int position) {
        holder.textViewVille.setText(biensModelList.get(position).getVille());
        holder.textViewRue.setText(biensModelList.get(position).getRue());
    }

    @Override
    public int getItemCount() {
        return biensModelList.size();
    }

    public long getIdemId(int position){
        return super.getItemId(position);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView textViewVille, textViewRue;


        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewVille = itemView.findViewById(R.id.textViewVille);
            textViewRue = itemView.findViewById(R.id.textViewRue);
        }
    }
}
