package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.model.Automata;
import sample.model.Persona;

public class Controller {
    //COMPONENTES PARA PRIMER VISTA
    @FXML TextField txtnombre;
    @FXML TextField txtapellidoP;
    @FXML TextField txtapellidM;
    @FXML TextField txtfecha;
    @FXML AnchorPane ventana1;

    //COMPONENTES PARA SEGUNDA VISTA
    @FXML TextField txtRFC;
    @FXML AnchorPane ventana2;
    @FXML Label lblNombre;
    @FXML Label lblaPaterno;
    @FXML Label lblaMaterno;
    @FXML Label lblfecha;

    //metodo para boton SALIR
    public void salir()
    {
        System.exit(0);
    }

    String rfcGlobal="";



    public void continuar()
    {
        //INSTANCIAMOS OBJETOS A UTILIZAR
        Persona llamar = new Persona();

        //VALIDAMOS QUE NO EXISTAN CAMPOS VACIOS
        if (!txtnombre.getText().isEmpty() && !txtapellidoP.getText().isEmpty() && !txtapellidM.getText().isEmpty() && !txtfecha.getText().isEmpty())
        {
            System.out.println(">>sin campos vacios");
            if(txtnombre.getText().length()>=3 && txtapellidoP.getText().length()>=3 && txtapellidM.getText().length()>=3 && txtfecha.getText().length()==8) //validamos longitud
            {
                System.out.println(">>campos llenos de forma correcta");
                //VAMOS A VALIDAR QUE LAS CADENAS ESTÉN EN MAYÚSCULAS
                String n,ap,am,f;
                n= txtnombre.getText();
                ap= txtapellidM.getText();
                am= txtapellidM.getText();
                f= txtfecha.getText();
                char linea = '/';
                //SE EVALUAN LOS DOS SLASH
                if (f.charAt(2)==linea && f.charAt(5)==linea)
                {
                    String[] fechaSeparada = f.split("/");
                    System.out.println("dos slash correctos");
                    //EVALUAMOS LA FECHA COMPLETA
                    System.out.println(fechaSeparada[0]);
                    //EVALUAMOS DIA
                     if (Integer.parseInt(fechaSeparada[0])>0 && Integer.parseInt(fechaSeparada[0])<=31)
                     {
                         //EVALUAMOS MES
                         if (Integer.parseInt(fechaSeparada[1])>0 && Integer.parseInt(fechaSeparada[1])<=12)
                         {
                             //EVALUAMOS AÑO
                             if ((Integer.parseInt(fechaSeparada[2])>=50 && Integer.parseInt(fechaSeparada[2])<=99) || (Integer.parseInt(fechaSeparada[2])>=0 && Integer.parseInt(fechaSeparada[2])<=22))
                             {
                                 System.out.println("si");
                                 if (n.equals(n.toUpperCase()) && ap.equals(ap.toUpperCase()) && am.equals(am.toUpperCase()))
                                 {
                                     System.out.println(">>todos los campos estan en mayuscula");
                                     llamar.setNombre(txtnombre.getText());
                                     lblNombre.setText(llamar.getNombre());
                                     llamar.setApellidoP(txtapellidoP.getText());
                                     lblaPaterno.setText(llamar.getApellidoP());
                                     llamar.setApellidoM(txtapellidM.getText());
                                     lblaMaterno.setText(llamar.getApellidoM());
                                     llamar.setfNacimiento(txtfecha.getText());
                                     lblfecha.setText(llamar.getfNacimiento());
                                     Alert advertencia = new Alert(Alert.AlertType.INFORMATION);
                                     advertencia.setHeaderText("Formulario correcto, ahora aprenderás a generar tu RFC :)");
                                     advertencia.show();
                                     ventana2.setVisible(true);

                                     //CONSTRUIR RFC
                                     //CUCB
                                     char parte1 = llamar.getApellidoP().charAt(0);
                                     char parte2 = llamar.getApellidoP().charAt(1);
                                     char parte3 = llamar.getApellidoP().charAt(2);
                                     char apeM = llamar.getApellidoM().charAt(0);
                                     char nom = llamar.getNombre().charAt(0);
                                     String letras = String.valueOf(parte1);
                                     if (recorrer(parte1)==false)
                                     {

                                         if (recorrer(parte2)==true)
                                         {
                                             System.out.println("CONSONANTE+VOCAL");
                                             letras=letras+String.valueOf(parte2);

                                         }
                                         else if (recorrer(parte3)==true)
                                         {
                                             System.out.println("CONSONANTE+tercer caracter");
                                             letras=letras+String.valueOf(parte3);

                                         }
                                     }else if (recorrer(parte2)==false)
                                     {
                                         System.out.println("vocal+consonante");
                                         letras=letras+String.valueOf(parte2);

                                     }
                                     letras = letras +String.valueOf(apeM)+String.valueOf(nom)+fechaSeparada[2]+fechaSeparada[1]+fechaSeparada[0];
                                     System.out.println(letras);
                                     rfcGlobal = letras;
                                 }
                                 else
                                 {
                                     Alert advertencia = new Alert(Alert.AlertType.WARNING);
                                     advertencia.setHeaderText("Solo se admiten letras MAYÚSCULAS");
                                     advertencia.show();
                                 }
                             }
                             else {
                                 fechaInvalida();
                             }
                         }
                         else
                         {
                             fechaInvalida();
                         }
                     }
                    else {
                         System.out.println("no");
                        fechaInvalida();
                     }
                }
                else
                {
                    fechaInvalida();
                }
            }
            else
            {
                Alert advertencia = new Alert(Alert.AlertType.WARNING);
                advertencia.setHeaderText("Uno o más campos no fueron llenados de forma corecta");
                advertencia.show();
            }
        }
        else
        {
            Alert advertencia = new Alert(Alert.AlertType.WARNING);
            advertencia.setHeaderText("Debes llenar todos los campos");
            advertencia.show();
        }
    }


    public void  fechaInvalida()
    {
        Alert advertencia = new Alert(Alert.AlertType.ERROR);
        advertencia.setHeaderText("Formato de fecha inválido");
        advertencia.show();
        txtfecha.setText("");
    }


    public boolean recorrer(char letra)
    {
        char vocales [] = {'A','E','I','O','U'};
        for (int i = 0; i <vocales.length; i++) {
            if (letra==vocales[i])
            {
                return true;
            }
        }
        return false;
    }


    //metodo para verificar el RFC ingresado por el usuario
    public void verificar()
    {
        Persona asignar = new Persona();
        asignar.setRfc(txtRFC.getText());
        String rfc = asignar.getRfc();
        System.out.println("llego a " + rfc);
        if (rfc.length()==10)
        {
            Automata llevar = new Automata();
            llevar.q0(rfcGlobal,rfc);
        }
        else
        {
            Alert advertencia = new Alert(Alert.AlertType.WARNING);
            advertencia.setHeaderText("El RFC debe contar con 10 Caracteres");
            advertencia.show();
            txtRFC.setText("");
        }
    }
    public void mostrarIvalidacion(char posicion)
    {
        Alert advertencia = new Alert(Alert.AlertType.ERROR);
        advertencia.setHeaderText("El caracter ["+posicion+"] hace inválido su RFC");
        advertencia.show();
    }

    public void mostrarIvalidacionFecha(String mensaje)
    {
        Alert advertencia = new Alert(Alert.AlertType.ERROR);
        advertencia.setHeaderText(mensaje);
        advertencia.show();
    }
    public void mostrarCorrecto(String mensaje, Alert.AlertType tipo)
    {
        Alert advertencia = new Alert(tipo);
        advertencia.setHeaderText(mensaje);
        advertencia.show();
    }
}