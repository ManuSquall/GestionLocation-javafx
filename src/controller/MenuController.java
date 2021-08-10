package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import utils.LoadView;

import javax.swing.*;

public class MenuController {

    @FXML
    private Button addLocationBtn;

    public void initialize(){

    }

    @FXML
    void handleButtonAction(ActionEvent event) {
        //JOptionPane.showMessageDialog(null,"vous venez de cliquer");
        LoadView.getStage().hide();
        LoadView.showView("Location","locationForm.fxml", 1);
    }

    public void listButtonAction(ActionEvent actionEvent) {
        LoadView.getStage().hide();
        LoadView.showView("Location","locationForm.fxml", 1);
    }


}
