package me.unmsm.alejandriapp.presentacion.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import me.unmsm.alejandriapp.R;
import me.unmsm.alejandriapp.data.entity.HistoryEntity;
import me.unmsm.alejandriapp.data.entity.PrestamoEntity;


public class PrestamoAdapter extends BaseAdapter{
    private List<PrestamoEntity> prestamo;
    private LayoutInflater inflater;
    private FragmentActivity activity;

    public PrestamoAdapter(List<PrestamoEntity> prestamo, FragmentActivity activity) {
        this.prestamo = prestamo;
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return prestamo.size();
    }

    @Override
    public PrestamoEntity getItem(int position) {
        return prestamo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return prestamo.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_history, parent, false);
        if(view != null){
            TextView titulo=(TextView)view.findViewById(R.id.history_title);
            titulo.setText(prestamo.get(position).getBooksEntity().getTitulo());
            TextView autor=(TextView)view.findViewById(R.id.history_autor);
            autor.setText(prestamo.get(position).getBooksEntity().getAutor());
            TextView estado=(TextView)view.findViewById(R.id.history_estado);
            if(prestamo.get(position).getBooksEntity().getEstado()==true){
                estado.setText("Disponible");}
            else{
                estado.setText("Prestado");
            }
            TextView fechaPrestamo=(TextView)view.findViewById(R.id.history_fecha);
            fechaPrestamo.setText(prestamo.get(position).getFecha_emision());
        }




        return view;
    }

}
