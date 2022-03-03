package sample.model;

import javafx.scene.control.Alert;
import sample.controller.Controller;

public class Automata {
    char [] alfabeto =  {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    char [] arregloNumeros = {'0','1','2','3','4','5','6','7','8','9'};
    Controller ventana = new Controller();

    //EVALUAR PRIMER CARACTER
   public void q0(String rfcConstruido, String rfcIngresado)
   {
       int contador=0;
       for (int i = 0; i < 4; i++) {
           if (recorrer(rfcIngresado.charAt(i))){
               System.out.println("correcto");
               contador++;
           }
       }
       if (contador==4)
       {
           q1(rfcConstruido,rfcIngresado);
       }
       else
           ventana.mostrarIvalidacion(rfcIngresado.charAt(contador));
   }


   public void q1(String rfcConstruido, String rfcIngresado)
   {
       //HEAK981125
       int contador=4;
       for (int i = 4; i < 10; i++) {
           if (recorrerNumeros(rfcIngresado.charAt(i))){
               System.out.println("numero correcto");
               contador++;
           }
       }
       if (contador==10)
       {
           System.out.println("todos son numeros");
           q2(rfcConstruido,rfcIngresado);
       }
       else
           ventana.mostrarIvalidacion(rfcIngresado.charAt(contador));
   }

   public void q2(String rfcConstruido, String rfcIngresado)
   {
       String anio = String.valueOf(rfcIngresado.charAt(4))+ String.valueOf(rfcIngresado.charAt(5));
       int digito = Integer.parseInt(anio);
       if ((digito>=50 && digito<=99) ||(digito>=0 && digito<=22) ){
           System.out.println("año correctoBRYAN");
           String mes = String.valueOf(rfcIngresado.charAt(6))+ String.valueOf(rfcIngresado.charAt(7));
           int digitomes = Integer.parseInt(mes);
           if ((digitomes>0 && digitomes<=12))
           {
               System.out.println("mes correcto");
               String dia = String.valueOf(rfcIngresado.charAt(8))+ String.valueOf(rfcIngresado.charAt(9));
               int digitodia = Integer.parseInt(dia);
               if ((digitodia>0 && digitodia<=31))
               {
                   System.out.println("fecha correcta");
                   q3(rfcConstruido,rfcIngresado);
               }else
               {
                   String m = "El dia ["+dia+"] no es válido";
                   ventana.mostrarIvalidacionFecha(m);
               }
           }
           else {
               String m = "El mes ["+mes+"] no es válido";
               ventana.mostrarIvalidacionFecha(m);
           }
       }
       else
       {
           String m = "El año ["+anio+"] no es válido";
           ventana.mostrarIvalidacionFecha(m);
       }
       System.out.println(anio + digito);
   }


   public void q3(String rfcConstruido, String rfcIngresado)
   {
       if (rfcConstruido.equals(rfcIngresado))
       {
           String m = " FELICIDADES ONICHAN HAS APRENDIDO A GENERAR TU RFC <3";
           ventana.mostrarCorrecto(m, Alert.AlertType.INFORMATION);
       }
       else
       {
           String m = "EL RFC QUE INGRESASTE NO ES EL TUYO :(";
           ventana.mostrarCorrecto(m, Alert.AlertType.ERROR);
       }
   }

    public boolean recorrer(char letra)
    {
        for (int i = 0; i <alfabeto.length; i++) {
            if (letra==alfabeto[i])
            {
                return true;
            }
        }
        return false;
    }

    public boolean recorrerNumeros(char letra)
    {
        for (int i = 0; i <arregloNumeros.length; i++) {
            if (letra==arregloNumeros[i])
            {
                return true;
            }
        }
        return false;
    }
}