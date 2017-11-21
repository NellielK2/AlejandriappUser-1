package me.unmsm.alejandriapp.data.remote.Request;


import me.unmsm.alejandriapp.data.entity.BooksEntity;
import me.unmsm.alejandriapp.data.entity.PrestamoEntity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PrestamoRequest {
    @PATCH("/api/libros/{id}")
    Call<ResponseBody> pathPrestamo(@Path("id") Integer id, @Body BooksEntity booksEntity);
    @FormUrlEncoded
    @POST("/api/prestamos")
    Call<ResponseBody> postPrestamo(@Field("fecha_emision") String fecha_emision,
                                    @Field("fecha_entrega") String fecha_entrega,
                                    @Field("fecha_maxima") String fecha_maxima,
                                    @Field("usuarioId") Integer id, @Field("libroId") Integer libroId);
}
