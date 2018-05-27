package Models;

public class Clase {

    private long Id;
    private long Id_Seccion;
    private String Numero;
    private String Notas;

    public Clase(){}

    public Clase(long id_seccion, String numero, String notas) {
        Id_Seccion = id_seccion;
        Numero = numero;
        Notas = notas;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getId_Seccion() {
        return Id_Seccion;
    }

    public void setId_Seccion(long id_Seccion) {
        Id_Seccion = id_Seccion;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getNotas() {
        return Notas;
    }

    public void setNotas(String notas) {
        Notas = notas;
    }
}
