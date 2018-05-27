package Data.Impl;

import Config.DatabaseConnection;
import Data.ClaseDao;
import Models.Clase;
import Models.Profesor;
import Models.Seccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClaseDaoImpl implements ClaseDao {

    private Connection conn;

    public ClaseDaoImpl()
    {
        DatabaseConnection db = new DatabaseConnection();
        conn = db.GetConnection();
    }

    @Override
    public List<Clase> getClases() {
        List<Clase> clases = new ArrayList<Clase>();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select * from aulavirtual.Clases");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setId(rs.getLong("Id"));
                clase.setNumero(rs.getString("Numero"));
                clase.setNotas(rs.getString("Notas"));
                clases.add(clase);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return clases;
    }

    @Override
    public Clase getClase(Long id) {
        Clase clase = new Clase();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from aulavirtual.Clases where Id=" + id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                clase.setId(rs.getLong("Id"));
                clase.setNumero(rs.getString("Numero"));
                clase.setNotas(rs.getString("Notas"));
                clase.setId_Seccion(rs.getLong("Id_Seccion"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return clase;
    }

    @Override
    public List<Clase> getClasesBySeccion(Long id) {
        List<Clase> clases = new ArrayList<Clase>();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT c.* FROM aulavirtual.Secciones s join aulavirtual.Clases c on s.Id = c.Id_Seccion where s.Id ="+id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setId(rs.getLong("Id"));
                clase.setNumero(rs.getString("Numero"));
                clase.setNotas(rs.getString("Notas"));
                clases.add(clase);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return clases;
    }

    @Override
    public int saveClase(Clase clase) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO aulavirtual.Clases ("
                    + "Id_Seccion,"
                    + "Numero,"
                    + "Notas)"
                    + "VALUES (?,?,?)");
            ps.setLong(1, clase.getId_Seccion());
            ps.setString(2, clase.getNumero());
            ps.setString(3, clase.getNotas());
            return ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteClase(Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM aulavirtual.Clases WHERE Id="+id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }
}
