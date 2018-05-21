package Controllers;

import Config.DatabaseConnection;
import Data.Impl.ProfesorDaoImpl;
import Data.ProfesorDao;
import Models.Profesor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProfesorController {

    @RequestMapping(method = RequestMethod.GET,
            value = "/profesor/list",
            produces = APPLICATION_JSON_VALUE)
    public List<Profesor> listProfesores()
    {
        ProfesorDao profesorDao = new ProfesorDaoImpl();
        return profesorDao.getProfesores();
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/profesor/{id}",
            produces = APPLICATION_JSON_VALUE)
    public Profesor findProfesor(@PathVariable("id") Long id)
    {
        ProfesorDao profesorDao = new ProfesorDaoImpl();
        return profesorDao.getProfesor(id);
    }
}
