package me.unmsm.alejandriapp.data.entity;

import com.google.gson.annotations.SerializedName;

public class PersonEntity {
    @SerializedName("cod_usuario")
    public Long codUsuario;
    @SerializedName("nombre")
    public String nombre;
    @SerializedName("apellidos")
    public String apellidos;
    @SerializedName("email")
    public String email;
    @SerializedName("fechaNac")
    public String fechaNac;
    @SerializedName("foto")
    public String foto;
    @SerializedName("escuela")
    public String escuela;
    @SerializedName("id")
    public Integer id;
    @SerializedName("tipoUsuarioId")
    public Integer tipoUsuarioId;

    public PersonEntity(Long codUsuario, String nombre, String apellidos, String email, String fechaNac, String foto, String escuela, int id, int tipoUsuarioId) {
        this.codUsuario = codUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaNac = fechaNac;
        this.foto = foto;
        this.escuela = escuela;
        this.id = id;
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public Long getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Long codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Integer tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }
}
