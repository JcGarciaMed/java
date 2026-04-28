package model;

import java.time.LocalDate;

public abstract class ProductoBancario {
    private String codigo;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String estado;

    public ProductoBancario(String codigo, String descripcion, LocalDate fechaCreacion, String estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName()+ " {" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estado='" + estado + '\'' +
                '}';
    }
}
