package Models;

public class Profesor {

    private long Id;
    private String Nombre;
    private String Apellido;
    private String Password;
    private boolean Sexo;

    public  Profesor(){}

    public Profesor(long id, String nombre, String apellido, String password, boolean sexo) {
        Id = id;
        Nombre = nombre;
        Apellido = apellido;
        Password = password;
        Sexo = sexo;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isSexo() {
        return Sexo;
    }

    public void setSexo(boolean sexo) {
        Sexo = sexo;
    }
}
