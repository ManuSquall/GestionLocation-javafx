package dao;

import java.sql.*;

public class Db {
    private Connection con;
    private Statement stmt;
    private PreparedStatement pstmt;

    private static Db db;
    public Db(){}

    public static Db getInstance(){

        if (db == null ){
            db = new Db();
        }
        return db;
    }

    public void openConnection() throws Exception
    {
        try
        {
            if(con == null || con.isClosed())
            {
                //Class.forName("com.mysql.cj.jdbc.Driver");
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://127.0.0.1:3306/java_gestionLocation?serverTimezone=UTC";
                String user = "root", pwd = "";
                con = DriverManager.getConnection(url, user, pwd);
                stmt = con.createStatement();
            }
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public void myPrepareStatement(String sql) throws Exception
    {
        try
        {
            openConnection();
            if(sql.trim().toLowerCase().startsWith("insert"))
            {
                pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            }
            else
            {
                pstmt = con.prepareStatement(sql);
            }
        }
        catch (SQLException e)
        {
            throw e;
        }
    }

    public void addParameters(Object [] parameters) throws SQLException
    {
        try {
            for (int i = 0; i < parameters.length; i++)
            {
                pstmt.setObject(i+1, parameters[i]);
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            throw e;
        }
    }

    public ResultSet myExecuteQuery() throws Exception
    {
        try
        {
            return pstmt.executeQuery();
        }
        catch (Exception e)
        {
            throw e;
        }

    }

    public int myExecuteUpdate() throws Exception
    {
        int retour = -1;

        try
        {
            retour = pstmt.executeUpdate();
            //ResultSet rs = pstmt.getGeneratedKeys();

            return retour =  pstmt.RETURN_GENERATED_KEYS;

            //if(rs.next())
            //{
            //  retour = rs.getInt(1);
            //}
        }
        catch (Exception e)
        {
            throw e;
        }

    }

    public void closeConnection() throws Exception
    {
        try
        {
            pstmt.close();
            con.close();
        }
        catch (Exception e)
        {
            throw e;
        }

    }

    public void begingTransaction() throws Exception
    {
        try
        {
            con.setAutoCommit(false);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public void endTransaction() throws Exception
    {
        try
        {
            con.setAutoCommit(true);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public void myCommit() throws Exception
    {
        try
        {
            con.commit();
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public void myRollBack() throws Exception
    {
        try
        {
            con.rollback();
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public PreparedStatement getPstmt() {
        return pstmt;
    }

    public void setPstmt(PreparedStatement pstmt) {
        this.pstmt = pstmt;
    }
}

