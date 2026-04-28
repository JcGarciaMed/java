package model;

import java.time.LocalDate;

public class CuentaAhorros extends ProductoBancario implements Operacion{
    private double saldo;
    private String numeroCuenta;

    public CuentaAhorros(String codigo, String descripcion, LocalDate fechaCreacion, String estado) {
        super(codigo, descripcion, fechaCreacion, estado);
    }

    public CuentaAhorros(String codigo, String descripcion, LocalDate fechaCreacion, String estado, double saldo, String numeroCuenta) {
        super(codigo, descripcion, fechaCreacion, estado);
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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
