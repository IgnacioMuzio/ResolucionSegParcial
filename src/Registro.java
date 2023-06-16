public class Registro {

    private String dni;

    private Integer temp;

    public Registro(String dni, Integer temp) {
        this.dni = dni;
        this.temp = temp;
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

    @Override
    public String toString() {
        return "Registro{" +
                "dni='" + dni + '\'' +
                ", temp=" + temp +
                '}';
    }
}
