package me.unmsm.alejandriapp.presentacion.contract;

import me.unmsm.alejandriapp.core.BasePresenter;
import me.unmsm.alejandriapp.core.BaseView;
import me.unmsm.alejandriapp.data.entity.PersonEntity;

/**
 * Created by KERLY on 06/11/2017.
 */

public interface ProfileContract {
    interface View extends BaseView<Presenter>{

        void loadUser(PersonEntity personEntity, boolean t);
        void setLoadingIndicator(boolean active);
        void setMessageError(String error);
    }
    interface Presenter extends BasePresenter {
        void start();
    }



}
