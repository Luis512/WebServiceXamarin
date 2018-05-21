package Models;

public class Seccion {

    private long Id;
    private long Id_Profesor;
    private String Numero;
    private int CantidadEstudiantes;

    public Seccion(long id, long id_profesor, String numero, int cantidadEstudiantes) {
        Id = id;
        Id_Profesor = id_profesor;
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

    public long getId_Profesor() {
        return Id_Profesor;
    }

    public void setId_Profesor(long id_Profesor) {
        Id_Profesor = id_Profesor;
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
