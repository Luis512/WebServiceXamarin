package Data.Impl;

import Config.DatabaseConnection;
import Data.ProfesorDao;
import Models.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDaoImpl implements ProfesorDao {

    private Connection conn;

    public ProfesorDaoImpl() {
        DatabaseConnection db = new DatabaseConnection();
        conn = db.GetConnection();
    }

    public List<Profesor> getProfesores() {
        List<Profesor> profesores = new ArrayList<Profesor>();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select * from aulavirtual.Profesor");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setId(rs.getLong("Id"));
                profesor.setNombre(rs.getString("Nombre"));
                profesor.setApellido(rs.getString("Apellido"));
                profesor.setSexo(rs.getBoolean("Sexo"));
                profesores.add(profesor);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return profesores;
    }

    @Override
    public Profesor getProfesor(Long id) {
        Profesor profesor = new Profesor();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from aulavirtual.Profesor where Id=" + id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                profesor.setId(rs.getLong("Id"));
                profesor.setNombre(rs.getString("Nombre"));
                profesor.setApellido(rs.getString("Apellido"));
                profesor.setSexo(rs.getBoolean("Sexo"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return profesor;
    }

    @Override
    public int saveProfesor(Profesor profesor) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO aulavirtual.Profesor ("
                    + "Id,"
                    + "Nombre,"
                    + "Apellido,"
                    + "Password,"
                    + "Sexo)"
                    + "VALUES (?,?,?,?,?)");
            ps.setLong(1, profesor.getId());
            ps.setString(2, profesor.getNombre());
            ps.setString(3, profesor.getApellido());
            ps.setString(4, profesor.getPassword());
            ps.setBoolean(5, profesor.isSexo());
            return ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }
}

