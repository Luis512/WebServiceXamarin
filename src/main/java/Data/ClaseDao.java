package Data;

import Models.Clase;

import java.util.List;

public interface ClaseDao {

    List<Clase> getClases();

    Clase getClase(Long id);

    List<Clase> getClasesBySeccion(Long id);

    int saveClase(Clase clase);

    int deleteClase(Long id);
}
