package me.unmsm.alejandriapp.presentacion.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.unmsm.alejandriapp.R;
import me.unmsm.alejandriapp.data.entity.PrestamoEntity;
import me.unmsm.alejandriapp.data.remote.Request.UserRequest;
import me.unmsm.alejandriapp.data.remote.ServiceGenerator;
import me.unmsm.alejandriapp.presentacion.adapter.PrestamoAdapter;
import me.unmsm.alejandriapp.presentacion.constant.Constants;
import me.unmsm.alejandriapp.presentacion.util.Preferences;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryFragment extends Fragment {

    ListView list;
    List<PrestamoEntity> prestamo;
    PrestamoAdapter adapter;
    private TextView text;
    public HistoryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_history, container, false);
        setRetainInstance(true);
        list = (ListView) view.findViewById(R.id.list_prestamos);
        text = (TextView) view.findViewById(R.id.empty_view);

        getprestamos();
        return view;
    }

    public void getprestamos(){
        Log.i("entro", "fragments");
        String idUser = Preferences.obtener(Constants.idUser, getActivity());
        Integer id = Integer.parseInt(idUser);
        UserRequest userRequest= ServiceGenerator.createService(UserRequest.class);
        Call<List<PrestamoEntity>> call = userRequest.getHistory(id);
        final ArrayList<PrestamoEntity> finalPrestamoFilter = new ArrayList<>();
        call.enqueue(new Callback<List<PrestamoEntity>>() {

            @Override
            public void onResponse(Call<List<PrestamoEntity>> call, Response<List<PrestamoEntity>> response) {
                if(response.isSuccessful()){
                    prestamo = response.body();
                    if(!prestamo.isEmpty()){
                        for(int i=0;i<prestamo.size();i++){
                            finalPrestamoFilter.add(prestamo.get(i));
                        }
                        Log.i("entro","fragments get Prestmaos");
                        PrestamoAdapter adapt = new PrestamoAdapter(finalPrestamoFilter,getActivity());
                        if (getActivity() != null){
                            list.setAdapter(adapt);
                        }
                    }else{
                        list.setEmptyView(getView().findViewById(R.id.empty_view));
                    }
                }else {
                    Toast.makeText(getActivity(), "No hay conexion", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PrestamoEntity>> call, Throwable t) {
                Log.i("entro", t.getMessage());
                Toast.makeText(getActivity(), "No hay conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
