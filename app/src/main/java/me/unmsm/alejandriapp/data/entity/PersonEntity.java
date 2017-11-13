package me.unmsm.alejandriapp.data.entity;

import android.provider.ContactsContract;

import com.google.gson.annotations.SerializedName;

import me.unmsm.alejandriapp.core.BaseFragment;
import me.unmsm.alejandriapp.presentacion.contract.ProfileContract;

/**
 * Created by KERLY on 06/11/2017.
 */

public class PersonEntity {
    @SerializedName("cod_usuario")
    public Long codUsuario;
    public UserEntity user;
    public String fechaNac;
    public String foto;
    public String escuela;
    public int id;
    public int tipoUsuarioId;

    public Long getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Long codUsuario) {
        this.codUsuario = codUsuario;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(int tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public PersonEntity(Long codUsuario, UserEntity user, String fechaNac, String foto, String escuela, int id, int tipoUsuarioId) {
        this.codUsuario = codUsuario;
        this.user = user;
        this.fechaNac = fechaNac;
        this.foto = foto;
        this.escuela = escuela;
        this.id = id;
        this.tipoUsuarioId = tipoUsuarioId;

    }







}
