package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonaNatural extends Persona{
    private String name;
    private LocalDate birthDate;
    private String gender;
    private List<ProductoBancario> cuentasAhorros = new ArrayList<>();
    private List<TarjetaDeCredito> tarjetasCredito = new ArrayList<>();

    public PersonaNatural(String documentType, String documentNumber) {
        super(documentType, documentNumber);
    }

    public PersonaNatural(String documentType, String documentNumber, String name, LocalDate birthDate, String gender) {
        super(documentType, documentNumber);
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public List<TarjetaDeCredito> getTarjetasCredito() {
        return tarjetasCredito;
    }

    public void setTarjetasCredito(List<TarjetaDeCredito> tarjetasCredito) {
        this.tarjetasCredito = tarjetasCredito;
    }

    public void addCuentaAhorros(ProductoBancario cuentaAhorros){
        if (!this.cuentasAhorros.contains(cuentaAhorros))
            this.cuentasAhorros.add(cuentaAhorros);
    }

    public void addTarjetaCredito(TarjetaDeCredito tarjetaCredito){
        if (!this.tarjetasCredito.contains(tarjetaCredito))
            this.tarjetasCredito.add(tarjetaCredito);
    }

    public void listarProductos(){
        System.out.println("Cuentas Ahorros: ");
        for (ProductoBancario cuentaAhorros : cuentasAhorros) {
            System.out.println(cuentaAhorros);
        }
    }
}
