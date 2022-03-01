package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
                }
                else
                {
                    Alert advertencia = new Alert(Alert.AlertType.WARNING);
                    advertencia.setHeaderText("Solo se admiten letras MAYÚSCuLAS");
                    advertencia.show();
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

    //metodo para verificar el RFC ingresado por el usuario
    public void verificar()
    {

    }
}