package me.unmsm.alejandriapp.presentacion.contract;


import me.unmsm.alejandriapp.core.BasePresenter;
import me.unmsm.alejandriapp.core.BaseView;
import me.unmsm.alejandriapp.data.entity.PersonEntity;
import me.unmsm.alejandriapp.data.entity.loginData;

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void errorLogin(String msg);
        void successLoginUser();
    }

    interface Presenter extends BasePresenter {
        void loginUser(String username, String password);
    }
}
