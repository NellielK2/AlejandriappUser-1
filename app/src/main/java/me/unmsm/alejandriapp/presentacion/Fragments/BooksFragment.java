package me.unmsm.alejandriapp.presentacion.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import me.unmsm.alejandriapp.R;
import me.unmsm.alejandriapp.data.entity.BooksEntity;
import me.unmsm.alejandriapp.data.entity.PrestamoEntity;
import me.unmsm.alejandriapp.data.remote.Request.BooksRequest;
import me.unmsm.alejandriapp.data.remote.Request.PrestamoRequest;
import me.unmsm.alejandriapp.data.remote.ServiceGenerator;
import me.unmsm.alejandriapp.presentacion.activity.BookDetailActivity;
import me.unmsm.alejandriapp.presentacion.activity.MainActivity;
import me.unmsm.alejandriapp.presentacion.adapter.BookAdapter;
import me.unmsm.alejandriapp.presentacion.constant.Constants;
import me.unmsm.alejandriapp.presentacion.util.Preferences;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BooksFragment extends Fragment {
    ListView list;
    List<BooksEntity> books;
    BookAdapter adapter;
    BooksEntity booksEntity;
    PrestamoEntity prestamoEntity;
    Fragment myFragment;
    private AlertDialog alertDialog;
    private MainActivity.SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private android.support.v7.app.AlertDialog dialog1;
    private SwipeRefreshLayout refresh;
    MainActivity activity = null;
    private android.support.v7.app.AlertDialog dialog;
    AlertDialog dialogoSeguridad;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_books, container, false);

        setRetainInstance(true);

        list = (ListView) view.findViewById(R.id.list_book);
        getbooks();

        return view;
    }

    public void getbooks(){
        Log.i("entro", "fragments");
        BooksRequest booksRequest= ServiceGenerator.createService(BooksRequest.class);
        Call<List<BooksEntity>> call = booksRequest.getBooksData(Constants.APP_JSON);
        final ArrayList<BooksEntity> finalBooksFilter = new ArrayList<>();
        call.enqueue(new Callback<List<BooksEntity>>() {
            @Override
            public void onResponse(Call<List<BooksEntity>> call, Response<List<BooksEntity>> response) {
                if(response.isSuccessful()){
                    books = response.body();
                    if(!books.isEmpty()){
                        for(int i=0;i<books.size();i++){
                            finalBooksFilter.add(books.get(i));
                        }
                        Log.i("entro","fragments");
                        if (getActivity() != null){
                            adapter = new BookAdapter(getActivity(),finalBooksFilter);
                            list.setAdapter(adapter);
                        }
                        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

                            @Override
                            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                                Long idbook = adapter.getItemId(position);
                                Preferences.Guardar("id",String.valueOf(idbook),getActivity());

                                Log.i("libro_id", String.valueOf(idbook));
                                registar();

                                return false;
                            }

                        });
                    }

                }else{
                    Toast.makeText(getActivity(), "No hay conexion", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<BooksEntity>> call, Throwable t) {
                Log.i("entro", t.getMessage());
                Toast.makeText(getActivity(), "No hay conexion", Toast.LENGTH_SHORT).show();
            }
            });

        }
        public void registar(){
            alertDialog = new AlertDialog.Builder(getActivity()).create();
            alertDialog.setTitle("AlejandriApp");
            alertDialog.setMessage("Desea registrar préstamo");
            alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_NEGATIVE, "CANCELAR",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alertDialog.dismiss();
                        }
                    });
            alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_POSITIVE, "PRÉSTAMO",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            pathprestamo(Integer.parseInt(Preferences.obtener("id",getActivity())));
                            postprestamo(Integer.parseInt(Preferences.obtener("id",getActivity())),Integer.parseInt(Preferences.obtener(Constants.idUser,getActivity())));
                        }
                    });
            alertDialog.show();
            alertDialog.setCancelable(false);
        }
    public void pathprestamo(int id){
        PrestamoRequest prestamoRequest = ServiceGenerator.createService(PrestamoRequest.class);
        BooksEntity prestar = new BooksEntity(false);
        Call<ResponseBody> call = prestamoRequest.pathPrestamo(id, prestar);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Log.i("estado","entro");

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }
    public void postprestamo(Integer id, Integer iduser){
        PrestamoRequest prestamoRequest = ServiceGenerator.createService(PrestamoRequest.class);
        Call<ResponseBody> call = prestamoRequest.postPrestamo("hoy","2 dias", "3 dias",iduser,id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Log.i("estado","entro");
                    Toast.makeText(getActivity(), "Su préstamo ha sido registrado", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }

}