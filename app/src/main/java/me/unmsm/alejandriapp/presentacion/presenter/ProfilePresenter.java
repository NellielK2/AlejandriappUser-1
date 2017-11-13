package me.unmsm.alejandriapp.presentacion.presenter;

import android.content.Context;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import me.unmsm.alejandriapp.data.entity.PersonEntity;
import me.unmsm.alejandriapp.data.repositories.remote.ServiceGenerator;
import me.unmsm.alejandriapp.presentacion.Fragments.ProfileFragment;
import me.unmsm.alejandriapp.presentacion.contract.ProfileContract;
import me.unmsm.alejandriapp.data.repositories.local.SessionManager;


/**
 * Created by KERLY on 06/11/2017.
 */

public class ProfilePresenter implements ProfileContract.Presenter {

    private ServiceGenerator serviceGenerator;
    private ProfileFragment view;
    private SessionManager sessionManager;
    private Context context;

    public ProfilePresenter(ProfileFragment view, Context context) {
        this.view = view;
        this.context = context;
        sessionManager = new SessionManager(context);
        serviceGenerator = new ServiceGenerator();
    }
    @Override
    public void start() {
        PersonEntity personEntity = sessionManager.getProfileData();
        view.loadUser(personEntity, true);
    }
   /* @Override
    public void start() {
        mProfileView.setLoadingIndicator(true);
        Integer idUser = sessionManager.getUserId();
        Integer id = Integer.parseInt(String.valueOf(idUser));
        Log.i("usuario", String.valueOf(id));
        final UserRequest profileService = ServiceGenerator.createService(UserRequest.class);
        Call<ArrayList<PersonEntity>> call = profileService.getProfileData();
        call.enqueue(new Callback<ArrayList<PersonEntity>>() {
            @Override
            public void onResponse(Call<ArrayList<PersonEntity>> call, Response<ArrayList<PersonEntity>> response) {
                if(response.isSuccessful()){
                    profileOpen = response.body();
                    Log.i("uwu", "uwu");
                    mProfileView.loadUser(response.body().get(0));
                } else
                {
                    mProfileView.setMessageError(context.getString(R.string.error));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PersonEntity>> call, Throwable t) {
                if(!mProfileView.isActive()){
                    return;
                }
                mProfileView.setLoadingIndicator(false);
                mProfileView.setMessageError(context.getString(R.string.no_server));
            }
        });

    }*/


}
