package service;

import model.Modele;
import model.Vehicule;

import java.util.List;

public interface IModele  {


        public Modele findModeleById(int id) throws Exception;
        public Modele findModeleByLib(String lib) throws Exception;



}
