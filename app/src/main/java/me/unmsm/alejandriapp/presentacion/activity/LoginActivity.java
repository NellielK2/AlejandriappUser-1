package me.unmsm.alejandriapp.presentacion.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.widget.RelativeLayout;


import me.unmsm.alejandriapp.R;
import me.unmsm.alejandriapp.core.BaseActivity;
import me.unmsm.alejandriapp.presentacion.Fragments.LoginFragment;
import me.unmsm.alejandriapp.presentacion.presenter.LoginPresenter;
import me.unmsm.alejandriapp.presentacion.util.ActivityUtils;


public class LoginActivity extends BaseActivity {
    

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        LoginFragment loginFragment = (LoginFragment)getSupportFragmentManager().findFragmentById(R.id.body);
        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), loginFragment, R.id.body);
        }
        //Creacion de LoginPresenter
        new LoginPresenter(loginFragment,this);
    }

    public void showMessageError(String message) {
        RelativeLayout container = (RelativeLayout) findViewById(R.id.relative_container);
        super.showMessage(message);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



}
