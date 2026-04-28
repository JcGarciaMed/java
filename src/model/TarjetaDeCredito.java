package model;

import java.time.LocalDate;

public class TarjetaDeCredito extends ProductoBancario implements Operacion{
    private double saldo;
    private String emisor;
    private String numeroTarjeta;

    public TarjetaDeCredito(String codigo, String descripcion, LocalDate fechaCreacion, String estado) {
        super(codigo, descripcion, fechaCreacion, estado);
    }

    public TarjetaDeCredito(String codigo, String descripcion, LocalDate fechaCreacion, String estado, double saldo,
                            String emisor, String numeroTarjeta) {
        super(codigo, descripcion, fechaCreacion, estado);
        this.saldo = saldo;
        this.emisor = emisor;
        this.numeroTarjeta = numeroTarjeta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public void retiro() {
    }

    @Override
    public void abono() {

    }

    @Override
    public void consulta() {

    }
}
