package Models;

public class Seccion {

    private long Id;
    private long IdProfesor;
    private String Numero;
    private int CantidadEstudiantes;

    public Seccion(long id, long idprofesor, String numero, int cantidadEstudiantes) {
        Id = id;
        IdProfesor = idprofesor;
        Numero = numero;
        CantidadEstudiantes = cantidadEstudiantes;
    }

    public Seccion() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getIdProfesor() {
        return IdProfesor;
    }

    public void setIdProfesor(long id_Profesor) {
        IdProfesor = id_Profesor;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public int getCantidadEstudiantes() {
        return CantidadEstudiantes;
    }

    public void setCantidadEstudiantes(int cantidadEstudiantes) {
        CantidadEstudiantes = cantidadEstudiantes;
    }
}
