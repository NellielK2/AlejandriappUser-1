package me.unmsm.alejandriapp.presentacion.Fragments;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import me.unmsm.alejandriapp.R;
import me.unmsm.alejandriapp.core.BaseActivity;
import me.unmsm.alejandriapp.core.BaseFragment;
import me.unmsm.alejandriapp.data.entity.PersonEntity;

import me.unmsm.alejandriapp.data.remote.Request.UserRequest;
import me.unmsm.alejandriapp.data.remote.ServiceGenerator;
import me.unmsm.alejandriapp.presentacion.activity.LoginActivity;
import me.unmsm.alejandriapp.presentacion.constant.Constants;
import me.unmsm.alejandriapp.presentacion.util.Preferences;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {
    /*@BindView(R.id.name)
    TextView text_name;
    @BindView(R.id.last_name)
    TextView text_lastName;
    @BindView(R.id.text_mail)
    TextView text_mail;
    @BindView(R.id.text_dof)
    TextView text_dof;
    @BindView(R.id.eap)
    TextView text_eap;
    @BindView(R.id.image_profile)
    CircleImageView imageProfile;*/
    private TextView text_name;
    private TextView text_lastName;
    private TextView text_mail;
    private TextView text_dof;
    private TextView text_eap;
     Button cerrarSesion;
    PersonEntity personEntity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("uwu", "uwu");
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        text_name = (TextView) root.findViewById(R.id.name);
        text_lastName=(TextView)root.findViewById(R.id.last_name);
        text_mail = (TextView) root.findViewById(R.id.text_mail);
        text_dof = (TextView) root.findViewById(R.id.text_dof);
        text_eap = (TextView) root.findViewById(R.id.eap);
        cerrarSesion = (Button)root.findViewById(R.id.text_logout);
        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                Toast.makeText(getActivity(), "Se cerró sesión", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        getData();
        return root;
    }
    public void getData(){
        String idUser = Preferences.obtener(Constants.idUser, getActivity());
        Log.i("usuario",String.valueOf(idUser));
        UserRequest userRequest = ServiceGenerator.createService(UserRequest.class);
        Call<PersonEntity> call = userRequest.getPerson(idUser);
        Log.i("ewe","ewe");
        call.enqueue(new Callback<PersonEntity>() {
            @Override
            public void onResponse(Call<PersonEntity> call, Response<PersonEntity> response) {
                if(response.isSuccessful()){
                    personEntity = response.body();
                    if(personEntity != null){
                        text_name.setText(personEntity.getNombre());
                        text_lastName.setText(personEntity.getApellidos());
                        text_mail.setText(personEntity.getEmail());
                        text_dof.setText(personEntity.getFechaNac());
                        text_eap.setText(personEntity.getEscuela());
                    }
                    else{
                        Toast.makeText(getActivity(), "No hay conexión", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<PersonEntity> call, Throwable t) {
                Toast.makeText(getActivity(), "No hay conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
