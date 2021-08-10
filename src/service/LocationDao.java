package service;

import dao.Db;
import model.Location;

import java.sql.Date;
import java.sql.ResultSet;

public class LocationDao implements ILocation {

    Db db=new Db();
    ResultSet rs;
    int ok;

    public void addLocation(Location loc, int id_veh, int locat) throws Exception{
        db.openConnection();
        //Object emp[]={mat,prenom,nom,date,salaire};
        try
        {

            String sql="INSERT INTO location VALUES(null,?,?,?,?,?)";
            db.myPrepareStatement(sql);
            db.getPstmt().setDate(1, (Date) loc.getDate());
            db.getPstmt().setInt(2,loc.getMontant());
            db.getPstmt().setString(3,loc.getCommentaire());
            db.getPstmt().setInt(4, locat);
            db.getPstmt().setInt(5,id_veh);
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
