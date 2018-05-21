package Data;

import Models.Seccion;

import java.util.List;

public interface SeccionDao {

    List<Seccion> getSecciones();

    Seccion getSeccion(Long id);

    List<Seccion> getSeccionesByProfesor(Long id);
}
