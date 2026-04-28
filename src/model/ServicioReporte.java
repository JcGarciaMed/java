package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServicioReporte<T extends ProductoBancario, S>{

    private List<T> productos;
    private S reporte;

    public ServicioReporte() {
        this.productos = new ArrayList<>();
    }

    public ServicioReporte(S reporte) {
        this.reporte = reporte;
    }

    public ServicioReporte(List<T> productos) {
        this.productos = productos;
    }

    public void addProducto(T producto){
        if(!productos.contains(producto))
            productos.add(producto);
        else
            System.out.println("El producto ya se encuentra en el reporte");
    }

    public void emitirReporte(){
        System.out.println(":::::::::::::::Reporte de productos a la sbs::::::::::::::::::");
        if (Objects.nonNull(reporte))
            System.out.println("Detalle del reporte: "+ reporte);
        else System.out.println("Sin Tipo de Reporte especifico");

        for (T producto : productos) {
            System.out.println( producto.getDescripcion() + " " + producto.getCodigo() + " " + " reportado a la sbs");
        }
    }

    public <U> void emitirNuevoReporte(List<U> productos){
        System.out.println(":::::::::::::::Nuevo Reporte de productos a la sbs::::::::::::::::::");
        for (U producto: productos){
            System.out.println( producto+ " " + " reportado a la sbs");
        }
    }

    public static <U extends ProductoBancario> void emitirNuevoReporte2(List<U> productos){
        System.out.println(":::::::::::::::Nuevo Reporte de productos a la sbs::::::::::::::::::");
        for (U producto : productos) {
            System.out.println( producto.getClass().getSimpleName() + " "  + producto.getDescripcion() + " "
                    + producto.getCodigo() + " " + " reportado a la sbs");
        }
    }


}
