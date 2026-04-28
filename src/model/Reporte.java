package model;

public record Reporte(String nombre, String codigo, String descripcion) {
    @Override
    public String toString() {
        return "Detalle del reporte: " + nombre + " " + codigo + " " + descripcion + "";
    }
}
