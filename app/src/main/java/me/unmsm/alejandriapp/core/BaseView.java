package me.unmsm.alejandriapp.core;

public interface BaseView<T> {

    void setLoadingIndicator(boolean active);
    void setMessageError(String error);
    void setDialogMessage(String message);
    boolean isActive();
    void setPresenter(T presenter);

}