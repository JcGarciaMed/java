package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonaJuridica extends Persona{
    private String razonSocial;
    private String fechaConstitucion;
    private LocalDate fechaBaja;
    private String actividadPrincipal;
    private List<CuentaAhorros> cuentasAhorros = new ArrayList<>();
    private List<TarjetaDeCredito> tarjetasCredito = new ArrayList<>();

    public static class ComparadorPersonas<T extends Persona> implements Comparator<Persona>{

        public ComparadorPersonas() {
        }

        @Override
        public int compare(Persona o1, Persona o2) {
            return o1.getDocumentNumber().compareTo(o2.getDocumentNumber());
        }
    }


    public PersonaJuridica(String documentType, String documentNumber) {
        super(documentType, documentNumber);
    }

    public PersonaJuridica(String documentType, String documentNumber, String razonSocial, String fechaConstitucion,
                           LocalDate fechaBaja, String actividadPrincipal) {
        super(documentType, documentNumber);
        this.razonSocial = razonSocial;
        this.fechaConstitucion = fechaConstitucion;
        this.fechaBaja = fechaBaja;
        this.actividadPrincipal = actividadPrincipal;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getFechaConstitucion() {
        return fechaConstitucion;
    }

    public void setFechaConstitucion(String fechaConstitucion) {
        this.fechaConstitucion = fechaConstitucion;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getActividadPrincipal() {
        return actividadPrincipal;
    }

    public void setActividadPrincipal(String actividadPrincipal) {
        this.actividadPrincipal = actividadPrincipal;
    }

    public List<CuentaAhorros> getCuentasAhorros() {
        return cuentasAhorros;
    }

    public void setCuentasAhorros(List<CuentaAhorros> cuentasAhorros) {
        this.cuentasAhorros = cuentasAhorros;
    }

    public List<TarjetaDeCredito> getTarjetasCredito() {
        return tarjetasCredito;
    }

    public void setTarjetasCredito(List<TarjetaDeCredito> tarjetasCredito) {
        this.tarjetasCredito = tarjetasCredito;
    }
}
