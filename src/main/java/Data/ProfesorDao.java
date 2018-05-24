package Data;

import Models.Profesor;

import java.util.List;

public interface ProfesorDao {

    List<Profesor> getProfesores();

    Profesor getProfesor(Long id);

    int saveProfesor(Profesor profesor);
}
