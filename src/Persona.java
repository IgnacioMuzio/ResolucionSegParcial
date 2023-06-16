import java.util.Objects;

public class Persona {
    private String nombre;

    private String apellido;

    private int edad;

    private String barrio;

    private String dni;

    private String ocupacion;

    private Integer numKit;

    public Persona(String nombre, String apellido, int edad, String barrio, String dni, String ocupacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.barrio = barrio;
        this.dni = dni;
        this.ocupacion = ocupacion;
        numKit = null;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Integer getNumKit() {
        return numKit;
    }

    public void setNumKit(Integer numKit) {
        this.numKit = numKit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", barrio='" + barrio + '\'' +
                ", dni='" + dni + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                ", numKit=" + numKit +
                '}';
    }
}
