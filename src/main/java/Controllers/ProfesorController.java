package Controllers;

import Data.Impl.ProfesorDaoImpl;
import Data.ProfesorDao;
import Models.Profesor;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST,
            value = "/profesor/register",
            produces = APPLICATION_JSON_VALUE)
    public int register(@RequestParam("id") Long id,
                             @RequestParam("nombre") String nombre,
                             @RequestParam("apellido") String apellido,
                             @RequestParam("password") String password,
                             @RequestParam("sexo") boolean sexo)
    {

        Profesor profesor = new Profesor(id, nombre, apellido, password, sexo);
        ProfesorDao profesorDao = new ProfesorDaoImpl();
        return profesorDao.saveProfesor(profesor);
    }



}
