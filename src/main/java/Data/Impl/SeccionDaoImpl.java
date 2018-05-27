package Data.Impl;

import Config.DatabaseConnection;
import Data.SeccionDao;
import Models.Seccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeccionDaoImpl implements SeccionDao {

    private Connection conn;

    public SeccionDaoImpl(){
        DatabaseConnection db = new DatabaseConnection();
        conn = db.GetConnection();
    }

    @Override
    public List<Seccion> getSecciones() {
        List<Seccion> secciones = new ArrayList<Seccion>();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select * from aulavirtual.Secciones");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Seccion seccion = new Seccion();
                seccion.setId(rs.getLong("Id"));
                seccion.setNumero(rs.getString("Numero"));
                seccion.setCantidadEstudiantes(rs.getInt("CantidadEstudiantes"));
                seccion.setIdProfesor(rs.getInt("IdProfesor"));
                secciones.add(seccion);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return secciones;
    }

    @Override
    public Seccion getSeccion(Long id) {
        Seccion seccion = new Seccion();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from aulavirtual.Secciones where Id="+id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                seccion.setId(rs.getLong("Id"));
                seccion.setNumero(rs.getString("Numero"));
                seccion.setCantidadEstudiantes(rs.getInt("CantidadEstudiantes"));
                seccion.setIdProfesor(rs.getInt("IdProfesor"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return seccion;
    }

    @Override
    public List<Seccion> getSeccionesByProfesor(Long id) {
        List<Seccion> secciones = new ArrayList<Seccion>();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT s.* FROM aulavirtual.Profesor p join aulavirtual.Secciones s on p.Id = s.IdProfesor where p.Id ="+id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Seccion seccion = new Seccion();
                seccion.setId(rs.getLong("Id"));
                seccion.setNumero(rs.getString("Numero"));
                seccion.setCantidadEstudiantes(rs.getInt("CantidadEstudiantes"));
                secciones.add(seccion);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return secciones;
    }
}
