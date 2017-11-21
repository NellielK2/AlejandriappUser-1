package me.unmsm.alejandriapp.data.remote.Request;

import java.util.ArrayList;
import java.util.List;

import me.unmsm.alejandriapp.data.entity.BooksEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface BooksRequest {
    @GET("/api/libros")
    Call<List<BooksEntity>> getBooksData(@Header("Accept") String json);
    @GET("/api/libros/{id}")
    Call<BooksEntity> getBooksDetail(@Path("id") String id_libro);
}
