package me.unmsm.alejandriapp.data.entity;

import com.google.gson.annotations.SerializedName;

public class PrestamoEntity {
    @SerializedName("fecha_emision") public String fecha_emision;
    @SerializedName("fecha_entrega") public String fecha_entrega;
    @SerializedName("fecha_maxima")public String fecha_maxima;
    @SerializedName("id") public Integer id;
    @SerializedName("usuarioId") public Integer usuarioId;
    @SerializedName("libroId") public Integer libroId;
    @SerializedName("usuario") PersonEntity personEntity;
    @SerializedName("libro") BooksEntity booksEntity;
    @SerializedName("estado") public Boolean estado;

    public PrestamoEntity(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getFecha_maxima() {
        return fecha_maxima;
    }

    public void setFecha_maxima(String fecha_maxima) {
        this.fecha_maxima = fecha_maxima;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getLibroId() {
        return libroId;
    }

    public void setLibroId(Integer libro) {
        this.libroId = libro;
    }

    public me.unmsm.alejandriapp.data.entity.PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }

    public me.unmsm.alejandriapp.data.entity.BooksEntity getBooksEntity() {
        return booksEntity;
    }

    public void setBooksEntity(BooksEntity booksEntity) {
        this.booksEntity = booksEntity;
    }

    public PrestamoEntity(String fecha_emision, String fecha_entrega, String fecha_maxima, Integer id,Integer usuarioId, Integer libroId) {
        this.fecha_emision = fecha_emision;
        this.fecha_entrega = fecha_entrega;
        this.fecha_maxima = fecha_maxima;
        this.id = id;
        this.usuarioId = usuarioId;
        this.libroId = libroId;

    }
}
