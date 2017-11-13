package me.unmsm.alejandriapp.data.repositories.remote.Request;



import java.util.ArrayList;

import me.unmsm.alejandriapp.data.entity.PersonEntity;
import me.unmsm.alejandriapp.data.entity.loginData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserRequest {

    @GET("/api/logins")
    Call<ArrayList<loginData>> getLogin(@Query("filter[where][email]")String username, @Query("filter[where][password]")String password);


    @GET("/api/u_descripcion")
    Call<PersonEntity> getPerson(@Path("person_id") String person_id);
}