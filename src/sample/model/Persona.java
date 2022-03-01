package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {
    private final StringProperty nombre;
    private final StringProperty apellidoP;
    private final StringProperty apellidoM;
    private final StringProperty fNacimiento;
    private final StringProperty rfc;

    public Persona () {this(null,null,null,null,null);
    }

    public Persona(String nom, String pat, String mat, String fec, String rfc) {
        this.nombre = new SimpleStringProperty(nom);
        this.apellidoP = new SimpleStringProperty(pat);
        this.apellidoM = new SimpleStringProperty(mat);
        this.fNacimiento = new SimpleStringProperty(fec);
        this.rfc = new SimpleStringProperty(rfc);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }


    public String getApellidoP() {
        return apellidoP.get();
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP.set(apellidoP);
    }


    public String getApellidoM() {
        return apellidoM.get();
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM.set(apellidoM);
    }

    public String getfNacimiento() {
        return fNacimiento.get();
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento.set(fNacimiento);
    }


    public String getRfc() {
        return rfc.get();
    }
    public void setRfc(String rfc) {
        this.rfc.set(rfc);
    }

}
