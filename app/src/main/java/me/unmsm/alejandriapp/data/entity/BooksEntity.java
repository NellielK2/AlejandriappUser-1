package me.unmsm.alejandriapp.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class BooksEntity implements Serializable {
    @SerializedName("titulo")
    public String titulo;
    @SerializedName("autor")
    public String autor;
    @SerializedName("edicion")
    public String edicion;
    @SerializedName("isbn")
    public String isbn;
    @SerializedName("idioma")
    public String idioma;
    @SerializedName("portadaPhoto")
    public String portadaPhoto;
    @SerializedName("codigoQR")
    public String codigoQR;
    @SerializedName("anio")
    public Integer anio;
    @SerializedName("num_imgreso")
    public Integer num_ingreso;
    @SerializedName("num_hoja")
    public Integer num_hoja;
    @SerializedName("fecha_imgreso")
    public String fecha_ingreso;
    @SerializedName("estado")
    public Boolean estado;
    @SerializedName("id")
    public Integer id;

    public BooksEntity(Boolean estado) {
        this.estado = estado;
    }

    public BooksEntity(String titulo, String autor, String edicion, String isbn, String idioma, String portadaPhoto, String codigoQR, Integer anio, Integer num_ingreso, Integer num_hoja, String fecha_ingreso, Boolean estado, Integer id) {
        this.titulo = titulo;
        this.autor = autor;
        this.edicion = edicion;
        this.isbn = isbn;
        this.idioma = idioma;
        this.portadaPhoto = portadaPhoto;
        this.codigoQR = codigoQR;
        this.anio = anio;
        this.num_ingreso = num_ingreso;
        this.num_hoja = num_hoja;
        this.fecha_ingreso = fecha_ingreso;
        this.estado = estado;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getPortadaPhoto() {
        return portadaPhoto;
    }

    public void setPortadaPhoto(String portadaPhoto) {
        this.portadaPhoto = portadaPhoto;
    }

    public String getCodigoQR() {
        return codigoQR;
    }

    public void setCodigoQR(String codigoQR) {
        this.codigoQR = codigoQR;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getNum_ingreso() {
        return num_ingreso;
    }

    public void setNum_ingreso(Integer num_ingreso) {
        this.num_ingreso = num_ingreso;
    }

    public Integer getNum_hoja() {
        return num_hoja;
    }

    public void setNum_hoja(Integer num_hoja) {
        this.num_hoja = num_hoja;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
