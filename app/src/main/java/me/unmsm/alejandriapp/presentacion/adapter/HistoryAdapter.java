package me.unmsm.alejandriapp.presentacion.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.unmsm.alejandriapp.R;
import me.unmsm.alejandriapp.data.entity.HistoryEntity;

/**
 * Created by KERLY on 31/10/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter <HistoryAdapter.ViewHolderHistory>{
    private List<HistoryEntity> historyEntityList;
    private LayoutInflater inflater;
    private Context context;

    public HistoryAdapter(List<HistoryEntity> historyEntityList, LayoutInflater inflater, Context context) {
        this.historyEntityList = historyEntityList;
        this.inflater = inflater;
        this.context = context;
    }

    @Override
    public ViewHolderHistory onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_books, parent, false);
        return new ViewHolderHistory(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderHistory holder, int position) {
        HistoryEntity historyEntity = historyEntityList.get(position);
        holder.history_title.setText(historyEntity.getTitle());
        holder.history_autor.setText(historyEntity.getAutor());
        holder.history_estado.setText(historyEntity.getEstado());
        holder.history_date.setText(historyEntity.getFechaPedido());
    }

    @Override
    public int getItemCount() {
        return historyEntityList.size();
    }

    public class ViewHolderHistory extends RecyclerView.ViewHolder {
        public TextView history_title;
        public TextView history_autor;
        public TextView history_estado;
        public TextView history_date;

        public ViewHolderHistory(View itemView) {
            super(itemView);
            this.history_title = (TextView) itemView.findViewById(R.id.history_title);
            this.history_autor = (TextView) itemView.findViewById(R.id.history_autor);
            this.history_estado = (TextView) itemView.findViewById(R.id.history_estado);
            this.history_date = (TextView) itemView.findViewById(R.id.history_fecha);
        }
    }
}
