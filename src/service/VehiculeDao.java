package service;

import dao.Db;
import model.Vehicule;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VehiculeDao implements IVehicule {
    Db db=new Db();
    ResultSet rs;
    int ok;

    @Override
    public List<Vehicule> listVehicule() throws Exception {
        db.openConnection();
        String sql="SELECT * FROM vehicule";
        List<Vehicule> listvehicules=new ArrayList<>();

        try {
            db.myPrepareStatement(sql);
            rs=db.myExecuteQuery();

            while (rs.next())
            {
                Vehicule e=new Vehicule();
                e.setId(rs.getInt(1));
                e.setMatricule(rs.getString(2));
                e.setCouleur(rs.getString(3));
                e.setNumCarteGrise(rs.getString(4));
                e.setNbrChvx(rs.getInt(5));

                IModele serv=new ModeleDao();
                e.setModele(serv.findModeleById(rs.getInt(6)));


                listvehicules.add(e);
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        db.closeConnection();
        return listvehicules;
    }

    public Vehicule findVehiculeByMat(String mat) throws Exception {


        db.openConnection();
        String sql="SELECT * FROM vehicule WHERE matricule =  '" + mat + "'";

        Db db = Db.getInstance();
        db.myPrepareStatement(sql);

        ResultSet rs = db.myExecuteQuery();

        Vehicule s = new Vehicule();

        while (rs.next()) {
            s.setId(rs.getInt(1));
            s.setMatricule(rs.getString(2));
            s.setCouleur(rs.getString(3));
            s.setNumCarteGrise(rs.getString(4));
            s.setNbrChvx(rs.getInt(5));
            IModele serv=new ModeleDao();
            s.setModele(serv.findModeleById(rs.getInt(6)));



        }

        return s;
    }
}
