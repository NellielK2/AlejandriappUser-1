package me.unmsm.alejandriapp.presentacion.contract;

import me.unmsm.alejandriapp.core.BasePresenter;
import me.unmsm.alejandriapp.core.BaseView;
import me.unmsm.alejandriapp.data.entity.BooksEntity;

/**
 * Created by KERLY on 13/11/2017.
 */

public interface BookDetailContract {
    //interfaces para el modelo Vista-Presentador
    interface View extends BaseView<Presenter> {
        void getBookDetail(BooksEntity booksEntity);
    }
    interface Presenter extends BasePresenter {
        void loadBookDetail(BooksEntity booksEntity);
    }
}
