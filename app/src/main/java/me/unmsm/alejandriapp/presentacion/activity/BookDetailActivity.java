package me.unmsm.alejandriapp.presentacion.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import me.unmsm.alejandriapp.R;
import me.unmsm.alejandriapp.data.entity.BooksEntity;
import me.unmsm.alejandriapp.data.remote.Request.BooksRequest;
import me.unmsm.alejandriapp.data.remote.ServiceGenerator;
import me.unmsm.alejandriapp.presentacion.constant.Constants;
import me.unmsm.alejandriapp.presentacion.util.Preferences;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KERLY on 21/11/2017.
 */

public class BookDetailActivity extends AppCompatActivity {
    private TextView titulo;
    private TextView autor;
    private TextView edicion;
    private TextView isbn;
    private TextView idioma;
    private TextView anio;
    private TextView num_hoja;
    private TextView fecha_ingreso;
    private TextView estado;
    private Button button_prestamo;

    BooksEntity booksEntity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.alertdialog_book_detail);
            titulo = (TextView) findViewById(R.id.title_detail);
            isbn = (TextView) findViewById(R.id.isbn_detail);
            autor = (TextView) findViewById(R.id.autor_detail);
            edicion = (TextView) findViewById(R.id.edicion_detail);
            idioma = (TextView) findViewById(R.id.idioma_detail);
            anio = (TextView) findViewById(R.id.año_detail);
            num_hoja = (TextView) findViewById(R.id.paginas_detail);
            fecha_ingreso = (TextView) findViewById(R.id.fechaI_detail);
            estado = (TextView) findViewById(R.id.estado_detail);
            button_prestamo = (Button) findViewById(R.id.button_prestamo);
            getBooksDetails();

            button_prestamo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Intent intent = new Intent(BookDetailActivity.this, QrActivity.class);
                    startActivity(intent);*/

                }
            });
    }
    public void getBooksDetails(){
        String idBook = Preferences.obtener(Constants.idBook,getApplicationContext());
        Log.i("libro",String.valueOf(idBook));
        final BooksRequest booksRequest = ServiceGenerator.createService(BooksRequest.class);
        Call<BooksEntity> call = booksRequest.getBooksDetail(idBook);
        call.enqueue(new Callback<BooksEntity>() {
            @Override
            public void onResponse(Call<BooksEntity> call, Response<BooksEntity> response) {
                if(response.isSuccessful()){
                    booksEntity = response.body();
                    if(booksEntity!=null){
                        titulo.setText(booksEntity.getTitulo());
                        isbn.setText(booksEntity.getIsbn());
                        autor.setText(booksEntity.getAutor());
                        edicion.setText(booksEntity.getEdicion());
                        idioma.setText(booksEntity.getIdioma());
                        anio.setText(booksEntity.getAnio());
                        num_hoja.setText(booksEntity.getNum_hoja());
                        fecha_ingreso.setText(booksEntity.getFecha_ingreso());
                        if(booksEntity.getEstado()){
                            estado.setText("Disponible");}
                        else{
                            estado.setText("No disponible");
                        }

                    }else{
                        Toast.makeText(getApplicationContext(), " ", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<BooksEntity> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No hay conexion", Toast.LENGTH_SHORT).show();
            }
        });

    }

    }




