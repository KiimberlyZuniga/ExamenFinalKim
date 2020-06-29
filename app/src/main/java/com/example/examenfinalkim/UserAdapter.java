package com.example.examenfinalkim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinalkim.Entidades.Lote;

import java.util.ArrayList;
import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    List<Lote> lotes;

    public UserAdapter(List<Lote> lotes) {

        this.lotes = lotes;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lote, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombreLote.setText(lotes.get(position).getNombrelote());
        holder.medida.setText(lotes.get(position).getMedidalote());
    }

    @Override
    public int getItemCount() {
        return lotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreLote;
        public  TextView medida;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreLote = itemView.findViewById(R.id.txtItemLote);
            medida = itemView.findViewById(R.id.txtItemLoteMedida);
        }
    }
}
