package Controllers;

import Data.Impl.SeccionDaoImpl;
import Data.SeccionDao;
import Models.Seccion;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class SeccionController {

    @RequestMapping(method = RequestMethod.GET,
            value = "/seccion/list",
            produces = APPLICATION_JSON_VALUE)
    public List<Seccion> listSecciones()
    {
        SeccionDao seccionDao = new SeccionDaoImpl();
        return seccionDao.getSecciones();
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/seccion/{id}",
            produces = APPLICATION_JSON_VALUE)
    public Seccion findSeccion(@PathVariable("id") Long id)
    {
        SeccionDao seccionDao = new SeccionDaoImpl();
        return seccionDao.getSeccion(id);
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/seccion/profesor/{id}",
            produces = APPLICATION_JSON_VALUE)
    public List<Seccion> listSeccionesByProfesor(@PathVariable("id") Long id)
    {
        SeccionDao seccionDao = new SeccionDaoImpl();
        return seccionDao.getSeccionesByProfesor(id);
    }
}
