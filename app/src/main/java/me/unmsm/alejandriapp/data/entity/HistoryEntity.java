package me.unmsm.alejandriapp.data.entity;


public class HistoryEntity {
    private String title;
    private String autor;
    private String estado;
    private String fechaPedido;

    public HistoryEntity() {
    }
    public HistoryEntity(String title, String autor, String estado, String fechaPedido) {
        this.title = title;

        this.autor = autor;
        this.estado = estado;
        this.fechaPedido = fechaPedido;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
}
