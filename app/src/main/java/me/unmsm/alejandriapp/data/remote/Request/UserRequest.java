package me.unmsm.alejandriapp.data.remote.Request;

import java.util.ArrayList;
import java.util.List;

import me.unmsm.alejandriapp.data.entity.HistoryEntity;
import me.unmsm.alejandriapp.data.entity.PersonEntity;
import me.unmsm.alejandriapp.data.entity.PrestamoEntity;
import me.unmsm.alejandriapp.data.entity.loginData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserRequest {

    @GET("/api/logins")
    Call<ArrayList<loginData>> getLogin(@Query("filter[where][email]")String username, @Query("filter[where][password]")String password);


    @GET("/api/usuarios/{id}")
    Call<PersonEntity> getPerson(@Path("id") String id_user);

    @GET("/api/prestamos")
    Call<List<PrestamoEntity>> getHistory(@Query("filter[where][usuarioId]") Integer id);

}