package model;

public abstract class Persona {
    private String documentType;
    private String documentNumber;

    public Persona(String documentType, String documentNumber) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
     //public abstract <T extends Persona> int compare(T o1, T o2);

    @Override
    public String toString() {
        return "Persona{" +
                "documentType='" + documentType + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                '}';
    }
}
