package generics;

import model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola mundo");
        PersonaNatural jorge = new PersonaNatural("CC", "123456789", "Jorge",
                LocalDate.now(), "masculino");

        CuentaAhorros cuentaAhorrosSimple = new CuentaAhorros("123456789", "Cuenta de ahorros simple",
                LocalDate.now(), "activo");

        CuentaAhorros cuentaAhorrosGanadora = new CuentaAhorros("123456789", "Cuenta de ahorros ganadora",
                LocalDate.now(), "inactivo");

        ProductoBancario cuentaCorriente = new CuentaAhorros("1234567888", "Cuenta de Corriente",
                LocalDate.now(), "activo");

        ProductoBancario tarjetaDeCreditoVisa = new TarjetaDeCredito("12341111", "TARJETA DE CREDSITO VISA",
                LocalDate.now(), "inactivo");

        TarjetaDeCredito tarjetaDeCreditoMC = new TarjetaDeCredito("12341111", "TARJETA DE CREDSITO MC",
                LocalDate.now(), "activo");

        var listProductosBancarios = Arrays.asList(cuentaAhorrosSimple, cuentaAhorrosGanadora,cuentaCorriente, tarjetaDeCreditoVisa, tarjetaDeCreditoMC);

        jorge.addCuentaAhorros(cuentaAhorrosSimple);
        jorge.addCuentaAhorros(cuentaCorriente);
        jorge.addCuentaAhorros(tarjetaDeCreditoVisa);

        jorge.listarProductos();

        ServicioReporte<CuentaAhorros, Reporte> reporteDeCuentas = new ServicioReporte<>();
        reporteDeCuentas.addProducto(cuentaAhorrosSimple);
        reporteDeCuentas.addProducto(cuentaAhorrosGanadora);

        reporteDeCuentas.emitirReporte();


        ServicioReporte<ProductoBancario, Reporte> servicioReporte = new ServicioReporte<>();
        servicioReporte.addProducto(cuentaCorriente);
        servicioReporte.addProducto(tarjetaDeCreditoVisa);
        servicioReporte.addProducto(tarjetaDeCreditoMC);

        servicioReporte.emitirReporte();


        List<ProductoBancario> productoBancarios = Arrays.asList(cuentaAhorrosSimple, cuentaAhorrosGanadora,
                cuentaCorriente, tarjetaDeCreditoVisa, tarjetaDeCreditoMC);

        servicioReporte.emitirNuevoReporte(productoBancarios);

        ServicioReporte.emitirNuevoReporte2(productoBancarios);

        //USO DE CONSUMERR


        Consumer<ProductoBancario> bancarioConsumer = productoBancario -> {
            System.out.println("Esto es un Consumer para reportes de Productos Bancarios");
            System.out.println("Producto Bancario: " + productoBancario.getClass().getSimpleName());
            System.out.println("Producto Bancario: " + productoBancario.getCodigo());
        };

        ServicioReporte.emitirNuevoReporte3(bancarioConsumer, cuentaCorriente,
                productoBancario -> productoBancario.getEstado().equalsIgnoreCase("activo"));

        Predicate<ProductoBancario> predicate = productoBancario -> productoBancario.getEstado().equalsIgnoreCase("activo");

        listProductosBancarios.forEach(productoBancario -> ServicioReporte.emitirNuevoReporte3(bancarioConsumer, productoBancario, predicate));

    }
}
