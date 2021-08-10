package service;

import model.Marque;
import model.Vehicule;

import java.util.List;

public interface IVehicule {
    public List<Vehicule> listVehicule() throws Exception;
    public Vehicule findVehiculeByMat(String mat) throws Exception;
}
