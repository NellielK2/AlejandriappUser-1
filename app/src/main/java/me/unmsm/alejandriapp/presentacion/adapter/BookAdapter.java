package me.unmsm.alejandriapp.presentacion.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.unmsm.alejandriapp.R;
import me.unmsm.alejandriapp.data.entity.BooksEntity;

/**
 * Created by KERLY on 24/10/2017.
 */

public class BookAdapter extends RecyclerView.Adapter <BookAdapter.ViewHolderBook> {
    List<BooksEntity> booksEntityList = new ArrayList<>() ;
    Context context;
    public BookAdapter(Context context) {
        this.context = context;
    }
    @Override
    public ViewHolderBook onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_books,parent,false);
        ViewHolderBook viewHolderBook= new ViewHolderBook(view);
        return viewHolderBook;
    }
    public void setList( List<BooksEntity> booksEntityList) {
        this.booksEntityList = booksEntityList;
    }

    @Override
    public void onBindViewHolder(ViewHolderBook holder, int position) {
        BooksEntity booksEntity = booksEntityList.get(position);
        holder.text_title.setText(booksEntityList.get(position).getTitulo());
        holder.text_isbn.setText(booksEntityList.get(position).getIsbn());
        holder. text_estado.setText(booksEntityList.get(position).getEstado());
        holder.text_edicion.setText(booksEntityList.get(position).getEdicion());
    }
    @Override
    public int getItemCount(){return booksEntityList.size();}

    public static class ViewHolderBook extends RecyclerView.ViewHolder {
        @BindView(R.id.text_title)
         TextView text_title;
        @BindView(R.id.text_isbn)
         TextView text_isbn;
        @BindView(R.id.text_estado)
         TextView text_estado;
        @BindView(R.id.text_edicion)
         TextView text_edicion;
        @BindView(R.id.image_portada)
         ImageView image_portada;

        public ViewHolderBook(View itemview){
            super(itemview);
            ButterKnife.bind(this,itemView);
        }
    }

}

