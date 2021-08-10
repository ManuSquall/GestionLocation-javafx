package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Db;
import model.Marque;
import model.Modele;

public class MarqueDao implements IMarque {

    Db db=new Db();
    ResultSet rs;
    int ok;

    @Override
    public List<Marque> listMarque() throws Exception {
        db.openConnection();
        String sql="SELECT * FROM marque";
        List<Marque> listmarques=new ArrayList<>();

        try {
            db.myPrepareStatement(sql);
            rs=db.myExecuteQuery();

            while (rs.next())
            {
                Marque e=new Marque();
                e.setId(rs.getInt(1));
                e.setLibelle(rs.getString(2));


                listmarques.add(e);
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        db.closeConnection();
        return listmarques;
    }


    public Marque findMarqueById(int id) throws Exception {


        db.openConnection();
        String sql="SELECT * FROM marque WHERE id =  " + id;

        Db db = Db.getInstance();
        db.myPrepareStatement(sql);

        ResultSet rs = db.myExecuteQuery();

        Marque s = new Marque();

        while (rs.next()) {
            s.setId(rs.getInt(1));
            s.setLibelle(rs.getString(2));


        }

        return s;
    }

    public Marque findMarqueByLib(String lib) throws Exception {


        db.openConnection();
        String sql="SELECT * FROM marque WHERE libelle =  '" + lib + "'";

        Db db = Db.getInstance();
        db.myPrepareStatement(sql);

        ResultSet rs = db.myExecuteQuery();

        Marque s = new Marque();

        while (rs.next()) {
            s.setId(rs.getInt(1));
            s.setLibelle(rs.getString(2));


        }

        return s;
    }
}
