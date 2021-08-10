package controller;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Locataire;
import model.Location;
import model.Marque;
import model.Vehicule;
import service.*;
import utils.LoadView;

import javax.swing.*;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class LocationController implements Initializable {

    @FXML
    private TextField couleurTfd;

    @FXML
    private TextField numCatTfd;

    @FXML
    private TextField nbrChxTfd;

    @FXML
    private TextField marqueTfd;

    @FXML
    private TextField modeleTfd;

    @FXML
    private TextField matriculeTfd;

    @FXML
    private TextField numPieceTfd;

    @FXML
    private TextField prenomTfd;

    @FXML
    private TextField nomTfd;

    @FXML
    private TextField telTfd;

    @FXML
    private TextField dateNaissPkr;

    @FXML
    private DatePicker dateDpr;

    @FXML
    private TextField montantTfd;

    @FXML
    private TextArea commentaireTarea;

    @FXML
    private Button saveBtn;

    @FXML
    private Button backBtn;

    @FXML
    private ListView matriculeLview;

    @FXML
    void backButtonAction(ActionEvent event) {
        LoadView.getStage().close();
        LoadView.showView("Menu", "menuUI.fxml",1);

    }

    public void disableAll(){
        couleurTfd.setDisable(true);
        numCatTfd.setDisable(true);
        nbrChxTfd.setDisable(true);
        marqueTfd.setDisable(true);
        modeleTfd.setDisable(true);

        /*
        prenomTfd.setDisable(true);
        nomTfd.setDisable(true);
        telTfd.setDisable(true);
        dateNaissPkr.setDisable(true);
        */



        //saveBtn.setDisable(true);





    }
    public void addTabView() {
        IVehicule marqdao = new VehiculeDao();
        List<Vehicule> listmarque = null;
        try {
            listmarque = marqdao.listVehicule();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*for(int i=0; i<listmarque.size(); i++)
            System.out.println(listmarque.get(i).getLibelle());*/

        ObservableList<Vehicule> data=FXCollections.observableArrayList(listmarque);





        matriculeLview.setItems(data);





    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Faire les initialisations avant affichage ici.
        disableAll();
        addTabView();
    }
    public void effacer()
    {
        couleurTfd.setText("");
        numCatTfd.setText("");
        nbrChxTfd.setText("");
        marqueTfd.setText("");
        modeleTfd.setText("");
        matriculeTfd.setText("");
        numPieceTfd.setText("");
        prenomTfd.setText("");
        nomTfd.setText("");
        telTfd.setText("");
        dateNaissPkr.setText("");
        dateDpr.setValue(null);
        montantTfd.setText("");
        commentaireTarea.setText("");

    }

    public void clickEnreg(ActionEvent actionEvent) throws Exception {
       // /*
        if(!matriculeTfd.getText().equals("") &&  !numPieceTfd.getText().equals("") && !prenomTfd.getText().equals("") && !nomTfd.getText().equals("") && !telTfd.getText().equals("") && !dateNaissPkr.getText().equals("") && !montantTfd.getText().equals("") && !commentaireTarea.getText().equals("") ){

            Vehicule v = new Vehicule();
            Locataire lo = new Locataire();
            Location l = new Location();

            v.setMatricule(matriculeTfd.getText());
            v.setCouleur(couleurTfd.getText());
            v.setNumCarteGrise(numCatTfd.getText());
            v.setNbrChvx(Integer.parseInt(nbrChxTfd.getText()));
            IModele mod = new ModeleDao();
            v.setModele(mod.findModeleByLib(modeleTfd.getText()));

            IVehicule veh = new VehiculeDao();
            v.setId((veh.findVehiculeByMat(v.getMatricule())).getId());

            lo.setNumpiece(numPieceTfd.getText());
            lo.setPrenom(prenomTfd.getText());
            lo.setNom(nomTfd.getText());
            lo.setDatenaiss(dateNaissPkr.getText());
            lo.setNumtel(Integer.parseInt(telTfd.getText()));
            ILocataire loca = new LocataireDao();
            lo.setId((loca.findLocataireByNum(lo.getNumpiece()).getId()));

            l.setDate(Date.valueOf(dateDpr.getValue()));
            l.setCommentaire(commentaireTarea.getText());
            l.setMontant(Integer.parseInt(montantTfd.getText()));
            ILocation squall    = new LocationDao();
            squall.addLocation(l,v.getId(), lo.getId());


            effacer();

        }else{
            JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs");
        }



         //*/
    }

    public void MousseIn(MouseEvent mouseEvent) {
        //JOptionPane.showMessageDialog(null,"La souris est dans le champ");
        matriculeLview.setVisible(true);
    }

    public void MousseOut(MouseEvent mouseEvent) {
        matriculeLview.setVisible(false);
    }

    public void matriculeLviewMousseIn(MouseEvent mouseEvent) {
        matriculeLview.setVisible(true);
    }

    public void matriculeLviewMousseOut(MouseEvent mouseEvent) {
        matriculeLview.setVisible(false);

    }

    public void matriculeLviewMousseClicked(MouseEvent mouseEvent) throws Exception {
        //System.out.println(matriculeLview.getFocusModel().getFocusedItem().toString());

        Vehicule v = new Vehicule();

        IVehicule iv = new VehiculeDao();

        String s = matriculeLview.getFocusModel().getFocusedItem().toString();
        //System.out.println(s);


        v = iv.findVehiculeByMat(s);

        //System.out.println(v.getCouleur());

        couleurTfd.setText(v.getCouleur());
        numCatTfd.setText(v.getNumCarteGrise());
        nbrChxTfd.setText(String.valueOf(v.getNbrChvx()));
        marqueTfd.setText(v.getModele().getMarque().getLibelle());
        modeleTfd.setText(v.getModele().getLibelle());
        matriculeTfd.setText(v.getMatricule());
    }

    public void numPieceMousseIn(MouseEvent mouseEvent) {

    }

    public void numPieceMousseOut(MouseEvent mouseEvent) throws Exception {
        Locataire lo = new Locataire();

        ILocataire test = new LocataireDao();
        lo = test.findLocataireByNum(numPieceTfd.getText());
        if(lo != null){
            prenomTfd.setText(lo.getPrenom());
            nomTfd.setText(lo.getNom());
            telTfd.setText(String.valueOf(lo.getNumtel()));
            dateNaissPkr.setText(lo.getDatenaiss());
        }else{

        }


    }

    public void mousseMoved(MouseEvent mouseEvent) {

    }


}
