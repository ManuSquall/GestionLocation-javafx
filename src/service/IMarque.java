package service;
import model.Marque;
import model.Modele;

import java.util.List;

public interface IMarque {
    public List<Marque> listMarque() throws Exception;
    public Marque findMarqueById(int id) throws Exception;
    public Marque findMarqueByLib(String lib) throws Exception;

}
