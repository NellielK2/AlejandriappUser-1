package me.unmsm.alejandriapp.presentacion.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.unmsm.alejandriapp.R;
import me.unmsm.alejandriapp.core.BaseFragment;
import me.unmsm.alejandriapp.presentacion.activity.LoginActivity;
import me.unmsm.alejandriapp.presentacion.activity.MainActivity;

import me.unmsm.alejandriapp.presentacion.contract.LoginContract;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class LoginFragment extends BaseFragment implements LoginContract.View,Validator.ValidationListener {

    @NotEmpty(message = "Este campo no puede estar vacío",sequence = 1)
    @BindView(R.id.text_username)
    EditText textEmail;

    @NotEmpty(message = "Este campo no puede estar vacío",sequence = 2)
    @Password(min = 8, message = "Contraseña muy corta",sequence = 3)
    @BindView(R.id.text_password)
    EditText textPassword;

    @BindView(R.id.button_signin)
    Button btnsignin;

    @BindView(R.id.tv_error)
    TextView tvError;
    private ProgressDialog dialog;
    private LoginContract.Presenter mPresenter;
    private Validator validator;
    private boolean isLoading = false;


    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("uwu", "uwu");
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dialog = new ProgressDialog(getContext());
        dialog.setIndeterminate(true);
        dialog.setMessage("Ingresando, espere un momento...");
        dialog.setCancelable(false);
        dialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.circle_progress));

        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }


    public void onValidationSucceeded() {
        mPresenter.loginUser(textEmail.getText().toString(), textPassword.getText().toString());
        isLoading = true;
    }


    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getContext());
            //Display error messages
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                tvError.setText(message);
            }
        }
    }

    @Override
    public void successLoginUser(){
        next(getActivity(),null, MainActivity.class,true);
    }

    @Override
    public void errorLogin(String message) {
        ((LoginActivity) getActivity()).showMessageError(message);}

    @Override
    public void setLoadingIndicator(boolean active) {
        if(active == false){
            dialog.dismiss();
            isLoading = false;
        }else if(active==true){
            isLoading = true;
            dialog.show();
        }
    }

    @Override
    public void setMessageError(String error) {
        tvError.setVisibility(View.VISIBLE);
        tvError.setText(error);
    }

    @Override
    public void setDialogMessage(String message) {
        tvError.setVisibility(View.VISIBLE);
        tvError.setText("Bienvenido");

    }

    @Override
    public boolean isActive() {
        return true;
    }

    @OnClick(R.id.button_signin)
    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.button_signin:
                validator.validate();
                break;


        }
    }
}