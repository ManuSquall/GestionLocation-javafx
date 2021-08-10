package service;

import dao.Db;
import model.Locataire;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;

public class LocataireDao implements ILocataire {
    Db db=new Db();
    ResultSet rs;
    int ok;

    public Locataire findLocataireByNum(String num) throws Exception {


        db.openConnection();
        String sql="SELECT * FROM locataire WHERE numpiece =  '" + num + "'";

        Db db = Db.getInstance();
        db.myPrepareStatement(sql);

        ResultSet rs = db.myExecuteQuery();

        Locataire s = new Locataire();

        while (rs.next()) {
            s.setId(rs.getInt(1));
            s.setNumpiece(rs.getString(2));
            s.setNom(rs.getString(3));
            s.setPrenom(rs.getString(4));
            s.setNumtel(rs.getInt(5));
            s.setDatenaiss(rs.getString(6));




        }

        return s;
    }

    @Override
    public void addLoc(Locataire loc) throws Exception {

        db.openConnection();
        //Object emp[]={mat,prenom,nom,date,salaire};
        try
        {

            String sql="INSERT INTO locataire VALUES(null,?,?,?,?,?)";
            db.myPrepareStatement(sql);
            db.getPstmt().setString(1,loc.getNumpiece());
            db.getPstmt().setString(2,loc.getNom());
            db.getPstmt().setString(3,loc.getPrenom());
            db.getPstmt().setInt(4, loc.getNumtel());
            db.getPstmt().setString(5,loc.getDatenaiss());
            //db.addParameters(emp);
            ok=db.myExecuteUpdate();

            if(ok!=-1)
            {
                System.out.println("SUCCES");

            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        db.closeConnection();

    }

}
