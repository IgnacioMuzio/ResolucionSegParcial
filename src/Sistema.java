import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;

public class Sistema {

    private LinkedHashSet<Persona> personas;

    private Integer cantKits;

    private HashMap<Integer,Registro> testeos;

    private ArrayList<Persona> sanos;//hacer generico

    private ArrayList<Aislado> aislados;

    public Sistema(Integer cantKits) {
        personas = new LinkedHashSet<>();
        this.cantKits = cantKits;
        testeos = new HashMap<>();
        sanos = new ArrayList<>();
        aislados = new ArrayList<>();
    }

    //region get set
    public LinkedHashSet<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(LinkedHashSet<Persona> personas) {
        this.personas = personas;
    }

    public Integer getCantKits() {
        return cantKits;
    }

    public void setCantKits(Integer cantKits) {
        this.cantKits += cantKits;
    }

    public HashMap<Integer, Registro> getTesteos() {
        return testeos;
    }

    public void setTesteos(HashMap<Integer, Registro> testeos) {
        this.testeos = testeos;
    }

    public ArrayList<Persona> getSanos() {
        return sanos;
    }

    public void setSanos(ArrayList<Persona> sanos) {
        this.sanos = sanos;
    }

    public ArrayList<Aislado> getAislados() {
        return aislados;
    }

    public void setAislados(ArrayList<Aislado> aislados) {
        this.aislados = aislados;
    }
    //endregion

    public void agregarPersona(Persona p) throws NoHayKit,Exception{
        if(personas.contains(p)) {
            throw new Exception("El numero de dni ya fue registrado");
        }
        if(cantKits-1<0){
            throw new NoHayKit("No hay mas kits");
        }else{
            (cantKits)--;
            p.setNumKit(getKitNum());
            personas.add(p);
        }
    }

    public Integer getKitNum(){
        int num = -1;
        Random ran = new Random();
        do{
            num = ran.nextInt(100);
        }while(searchKitNum(num));
        return num;
    }

    public boolean searchKitNum(int num){
        for(Persona p : personas){
            if(p.getNumKit()==num) return true;
        }
        return false;
    }

    public void testear(){
        Integer temp;
        Random ran = new Random();
        for(Persona p: personas){
            temp = ran.nextInt(3)+36;
            testeos.put(p.getNumKit(),new Registro(p.getDni(),temp));
        }
    }

    public String getBarrioByKit(Integer kit){
        String barrio = "";
        for(Persona p : personas){
            if(p.getNumKit()==kit){
                barrio = p.getBarrio();
                break;
            }
        }
        return barrio;
    }

    public void aislar(Integer numKit) throws Exception {
        Registro aux = testeos.get(numKit);
        if(aux.getTemp()>=38){
            throw new Exception("El paciente con el numero de kit: "+ numKit + ". Procedente del barrio: "+ getBarrioByKit(numKit) + "debe ser aislado.");
        }
    }

    public void getEstado(){
        Registro reg;
        for(Persona p : personas){
            reg=testeos.get(p.getNumKit());
            if(reg.getTemp()>=38)
                aislados.add(new Aislado(p.getDni(),reg.getTemp(),p.getBarrio()));
            else
                sanos.add(p);
        }
    }

}
