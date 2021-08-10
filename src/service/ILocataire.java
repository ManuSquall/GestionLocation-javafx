package service;

import model.Locataire;

import java.time.LocalDate;

public interface ILocataire {

    public Locataire findLocataireByNum(String num) throws Exception;
    public void addLoc(Locataire loc) throws Exception ;

    }
