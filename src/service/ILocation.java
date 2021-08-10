package service;

import model.Locataire;
import model.Location;

public interface ILocation {

    public void addLocation(Location loc, int id_veh, int locat) throws Exception ;
}
