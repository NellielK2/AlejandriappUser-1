package me.unmsm.alejandriapp.presentacion.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import me.unmsm.alejandriapp.R;
import me.unmsm.alejandriapp.core.BaseActivity;
import me.unmsm.alejandriapp.core.BaseFragment;
import me.unmsm.alejandriapp.data.entity.PersonEntity;
import me.unmsm.alejandriapp.data.repositories.local.SessionManager;
import me.unmsm.alejandriapp.presentacion.contract.ProfileContract;
import me.unmsm.alejandriapp.presentacion.presenter.ProfilePresenter;
import me.unmsm.alejandriapp.presentacion.util.ProgressDialogCustom;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class ProfileFragment extends BaseFragment implements ProfileContract.View{
    @BindView(R.id.name) TextView text_name;
    @BindView(R.id.last_name) TextView text_lastName;
    @BindView(R.id.text_mail) TextView text_mail;
    @BindView(R.id.text_dof) TextView text_dof;
    @BindView(R.id.eap) TextView text_eap;
    @BindView(R.id.image_profile)
    CircleImageView imageProfile;
    private ProgressDialogCustom mProgressDialogCustom;
    private SessionManager sessionManager;
    private ProfileContract.Presenter presenter;


    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("uwu", "uwu");
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, root);
        sessionManager = new SessionManager(getContext());
        mProgressDialogCustom = new ProgressDialogCustom(getActivity(), "Actualizando...");
        presenter = new ProfilePresenter(this, getContext());
        presenter.start();
        return root;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        this.presenter = checkNotNull(presenter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void loadUser(PersonEntity personEntity, boolean t) {
        /*if (t) {
            Picasso.with(getContext()).load(sessionManager.getProfileData().getFoto()).into(imageProfile);
        } else {
            imageProfile.setImageDrawable(getResources().getDrawable(R.drawable.user));
        }*/
        text_name.setText(personEntity.getUser().getNombre());
        text_lastName.setText(personEntity.getUser().getApellidos());
        text_mail.setText(personEntity.getUser().getEmail());
        text_dof.setText(personEntity.getFechaNac());
        text_eap.setText(personEntity.getEscuela());

    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (mProgressDialogCustom != null) {
            if (active) {
                mProgressDialogCustom.show();
            } else {
                mProgressDialogCustom.dismiss();
            }
        }
    }

    @Override
    public void setMessageError(String error) {
        ((BaseActivity) getActivity()).showMessageError(error);
    }

    @Override
    public void setDialogMessage(String message) {
        ((BaseActivity) getActivity()).showMessage(message);

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }



}
