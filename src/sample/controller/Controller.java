package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Controller {
    //COMPONENTES PARA PRIMER VISTA
    @FXML TextField txtnombre;
    @FXML TextField txtapellidoP;
    @FXML TextField txtapellidM;
    @FXML TextField txtfecha;
    @FXML ImageView img;

    //COMPONENTES PARA SEGUNDA VISTA
    @FXML TextField txtRFC;

    //metodo para boton SALIR
    public void salir()
    {
        System.exit(0);
    }

}
