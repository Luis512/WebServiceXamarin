package Controllers;

import Data.ClaseDao;
import Data.Impl.ClaseDaoImpl;
import Models.Clase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ClaseController {

    @RequestMapping(method = RequestMethod.GET,
            value = "/clase/list",
            produces = APPLICATION_JSON_VALUE)
    public List<Clase> listClases()
    {
        ClaseDao claseDao = new ClaseDaoImpl();
        return claseDao.getClases();
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/clase/{id}",
            produces = APPLICATION_JSON_VALUE)
    public Clase findClase(@PathVariable("id") Long id)
    {
        ClaseDao claseDao = new ClaseDaoImpl();
        return claseDao.getClase(id);
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/clase/new",
            produces = APPLICATION_JSON_VALUE)
    public int newClase(@RequestParam("idseccion") Long id_seccion,
                        @RequestParam("numero") String numero,
                        @RequestParam("notas") String notas)
    {

        Clase clase = new Clase(id_seccion, numero, notas);
        ClaseDao claseDao = new ClaseDaoImpl();
        return claseDao.saveClase(clase);
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/clase/seccion/{id}",
            produces = APPLICATION_JSON_VALUE)
    public List<Clase> findClaseBySeccion(@PathVariable("id") Long id)
    {
        ClaseDao claseDao = new ClaseDaoImpl();
        return claseDao.getClasesBySeccion(id);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            value = "/clase/{id}",
            produces = APPLICATION_JSON_VALUE)
    public int deleteClase(@PathVariable("id") Long id)
    {
        ClaseDao claseDao = new ClaseDaoImpl();
        return claseDao.deleteClase(id);
    }
}
