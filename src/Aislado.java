public class Aislado {
    private String dni;

    private Integer temp;

    private String barrio;

    public Aislado(String dni, Integer temp, String barrio) {
        this.dni = dni;
        this.temp = temp;
        this.barrio = barrio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    @Override
    public String toString() {
        return "Aislado{" +
                "dni='" + dni + '\'' +
                ", temp=" + temp +
                ", barrio='" + barrio + '\'' +
                '}';
    }
}
