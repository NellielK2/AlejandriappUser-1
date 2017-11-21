package me.unmsm.alejandriapp.presentacion.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import me.unmsm.alejandriapp.R;
import me.unmsm.alejandriapp.data.entity.BooksEntity;


public class BookAdapter extends BaseAdapter {

    private FragmentActivity activity;
    private LayoutInflater inflater;
    private ArrayList<BooksEntity> booksEntities;

    public BookAdapter(FragmentActivity activity, ArrayList<BooksEntity> booksEntities) {
        this.activity = activity;
        this.booksEntities = booksEntities;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return booksEntities.size();
    }

    @Override
    public long getItemId(int position) {
        return booksEntities.get(position).getId();
    }
    @Override
    public BooksEntity getItem(int position) {
        return booksEntities.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_books, parent, false);
        if (view!=null){
            TextView titulo=(TextView)view.findViewById(R.id.text_title);
            titulo.setText(booksEntities.get(position).getTitulo());
            TextView isbn=(TextView)view.findViewById(R.id.text_isbn);
            isbn.setText(booksEntities.get(position).getIsbn());
            TextView estado=(TextView)view.findViewById(R.id.text_estado);
            if(booksEntities.get(position).getEstado()==true){
                estado.setText("Disponible");}
            else{
                estado.setText("No disponible");
            }
            TextView edicion=(TextView)view.findViewById(R.id.text_edicion);
            edicion.setText(booksEntities.get(position).getEdicion());

        }
        return view;
    }
}

