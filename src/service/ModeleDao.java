package service;

import dao.Db;
import model.Modele;
import model.Vehicule;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModeleDao implements IModele {

    Db db=new Db();
    ResultSet rs;
    int ok;

    public Modele findModeleById(int id) throws Exception {


        db.openConnection();
        String sql="SELECT * FROM modele WHERE id =  " + id;

        Db db = Db.getInstance();
        db.myPrepareStatement(sql);

        ResultSet rs = db.myExecuteQuery();

        Modele s = new Modele();

        while (rs.next()) {
            s.setId(rs.getInt(1));
            s.setLibelle(rs.getString(2));

            IMarque  serv = new MarqueDao();
            s.setMarque(serv.findMarqueById(rs.getInt(3)));
        }

        return s;
    }

    public Modele findModeleByLib(String lib) throws Exception {


        db.openConnection();
        String sql="SELECT * FROM modele WHERE libelle =  '" + lib + "'";

        Db db = Db.getInstance();
        db.myPrepareStatement(sql);

        ResultSet rs = db.myExecuteQuery();

        Modele s = new Modele();

        while (rs.next()) {
            s.setId(rs.getInt(1));
            s.setLibelle(rs.getString(2));

            IMarque  serv = new MarqueDao();
            s.setMarque(serv.findMarqueById(rs.getInt(3)));
        }

        return s;
    }
}
