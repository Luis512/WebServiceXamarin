package Data;

import Models.Profesor;

import java.util.List;

public interface ProfesorDao {

    List<Profesor> getProfesores();

    Profesor getProfesor(Long id);

    void saveProfesor(Long id, String nombre, String apellido, boolean sexo);
}
