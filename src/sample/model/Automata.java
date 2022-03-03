package sample.model;

import javafx.scene.control.Alert;
import sample.controller.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Automata {

    Controller ventana = new Controller();

    //EVALUAR PRIMER CARACTER
    public void q0(String rfcConstruido, String rfcIngresado) {

        Pattern patron = Pattern.compile("^[A-Z]");

        int contador = 0;
        for (int i = 0; i < 4; i++) {
            if (patron.matcher(String.valueOf(rfcIngresado.charAt(i))).find()) {
                System.out.println("correcto compile");
                contador++;
            } else {
                break;
            }
        }
        if (contador == 4) {
            q1(rfcConstruido, rfcIngresado);
        } else {
            ventana.mostrarIvalidacion(rfcIngresado.charAt(contador));
        }
    }


    public void q1(String rfcConstruido, String rfcIngresado) {
        //HEAK981125
        Pattern patron = Pattern.compile("^[0-9]");

        int contador = 4;
        for (int i = 4; i < 10; i++) {
            if (patron.matcher(String.valueOf(rfcIngresado.charAt(i))).find()) {
                System.out.println("numero correcto compile");
                contador++;
            } else {
                break;
            }
        }
        if (contador == 10) {
            q2(rfcConstruido, rfcIngresado);
        } else
            ventana.mostrarIvalidacion(rfcIngresado.charAt(contador));
    }

    public void q2(String rfcConstruido, String rfcIngresado) {
        String anio = String.valueOf(rfcIngresado.charAt(4)) + String.valueOf(rfcIngresado.charAt(5));

        Pattern patronAge1 = Pattern.compile("[5-9][0-9]");
        Pattern patronAge2 = Pattern.compile("[0-1][0-9]");
        Pattern patronAge3 = Pattern.compile("2[0-2]");

        if (patronAge1.matcher(String.valueOf(anio)).find() || patronAge2.matcher(String.valueOf(anio)).find() || patronAge3.matcher(String.valueOf(anio)).find()) {
            System.out.println("año correcto compiler: " + anio);
            String mes = String.valueOf(rfcIngresado.charAt(6)) + String.valueOf(rfcIngresado.charAt(7));

            Pattern patronMes1 = Pattern.compile("0[1-9]");
            Pattern patronMes2 = Pattern.compile("1[0-2]");
            if (patronMes1.matcher(mes).find() || patronMes2.matcher(mes).find()) {
                System.out.println("mes correcto compiler");
                String dia = String.valueOf(rfcIngresado.charAt(8)) + String.valueOf(rfcIngresado.charAt(9));

                Pattern patronDia1 = Pattern.compile("0[1-9]");
                Pattern patronDia2 = Pattern.compile("1|2[0-9]");
                Pattern patronDia3 = Pattern.compile("3[0-1]");
                if (patronDia1.matcher(dia).find() || patronDia2.matcher(dia).find() || patronDia3.matcher(dia).find()) {
                    System.out.println("fecha correcta compiler");
                    q3(rfcConstruido, rfcIngresado);
                } else {
                    String m = "El dia [" + dia + "] no es válido";
                    ventana.mostrarIvalidacionFecha(m);
                }
            } else {
                String m = "El mes [" + mes + "] no es válido";
                ventana.mostrarIvalidacionFecha(m);
            }
        } else {
            String m = "El año [" + anio + "] no es válido";
            ventana.mostrarIvalidacionFecha(m);
        }
    }


    public void q3(String rfcConstruido, String rfcIngresado) {
        if (rfcConstruido.equals(rfcIngresado)) {
            String m = " FELICIDADES ONICHAN HAS APRENDIDO A GENERAR TU RFC <3";
            ventana.mostrarCorrecto(m, Alert.AlertType.INFORMATION);
        } else {
            String m = "EL RFC QUE INGRESASTE NO ES EL TUYO :(";
            ventana.mostrarCorrecto(m, Alert.AlertType.ERROR);
        }
    }

}