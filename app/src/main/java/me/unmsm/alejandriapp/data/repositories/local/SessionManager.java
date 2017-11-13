package me.unmsm.alejandriapp.data.repositories.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import me.unmsm.alejandriapp.data.entity.PersonEntity;

/**
 * Created by KERLY on 06/11/2017.
 */

public class SessionManager {
    private static final String PREFERENCE_NAME = "alejandriapp";
    private static int PRIVATE_MODE = 0;

    public static final String USER_JSON = "user_json";
    public static final String IS_LOGIN = "user_login";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;
    public SessionManager(Context context) {
        this.context = context;
        preferences = this.context.getSharedPreferences(PREFERENCE_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }
    public boolean isLogin()  {
        return preferences.getBoolean(IS_LOGIN, false);
    }


    //save user
    public void saveUser(PersonEntity personEntity){
        editor.putString(USER_JSON, null);
        editor.commit();
        if(personEntity!=null){
            Gson gson = new Gson();
            String user= gson.toJson(personEntity);
            editor.putString(USER_JSON, user);
        }
        editor.commit();
    }
    public PersonEntity getProfileData(){
        //obtener datos del usuario guardados en  memoria interna
        String userData = preferences.getString(USER_JSON, null);
        return new Gson().fromJson(userData, PersonEntity.class);
    }


}
