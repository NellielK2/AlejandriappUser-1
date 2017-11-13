package me.unmsm.alejandriapp.data.repositories.remote.Request;

import java.util.ArrayList;

import me.unmsm.alejandriapp.data.entity.BooksEntity;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by KERLY on 07/11/2017.
 */

public interface BooksRequest {
    @GET("/api/libros")
    Call<ArrayList<BooksEntity>> getBooksData();
}
