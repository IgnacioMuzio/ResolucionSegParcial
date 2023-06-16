import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Sistema sistema = new Sistema(6);

        //region hardcodeo
        Persona p1 = new Persona("Juan1","Perez1",20,"Barrio1","32424","Oc1");
        Persona p2 = new Persona("Juan2","Perez1",20,"Barrio2","32425","Oc1");
        Persona p3 = new Persona("Juan3","Perez1",20,"Barrio3","32426","Oc1");
        Persona p4 = new Persona("Juan4","Perez1",20,"Barrio4","32427","Oc1");
        Persona p5 = new Persona("Juan5","Perez1",20,"Barrio5","32428","Oc1");
        Persona p6 = new Persona("Juan6","Perez1",20,"Barrio6","32428","Oc1");
        try {
            sistema.agregarPersona(p1);
            sistema.agregarPersona(p2);
            sistema.agregarPersona(p3);
            sistema.agregarPersona(p4);
            sistema.agregarPersona(p5);
            sistema.agregarPersona(p6);
            System.out.println(sistema.getPersonas());
        }catch (NoHayKit e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //endregion

        Consola.escribir("Wenas");

        menuGral(sistema);
    }

    public static void menuGral(Sistema sistema){
        int option;

        do{
            Consola.escribir("-------------");
            Consola.escribir("1.Agregar una persona");
            Consola.escribir("2.Testear personas");
            Consola.escribir("3.Aislar personas");
            Consola.escribir("4.Mostrar listado de sanos y sospechosos");
            Consola.escribir("0.Salir");
            option=Consola.leerInt("Ingrese una opcion...");
            Consola.limpiar();
        }while (option>4 || option<0);

        switch (option){
            case 1: agregar(sistema);
                break;
            case 2: testear(sistema);
                break;
            case 3: aislar(sistema);
                break;
            case 4: mostrarEstado(sistema);
                break;
            case 0: Consola.escribir("Cerrando");
                break;}
    }

    //region case 1
    public static void agregar (Sistema sistema){
        Persona p = new Persona("Juan6","Perez6",20,"Barrio9","453534","Oc6");
        try{
            sistema.agregarPersona(p);
        }catch (NoHayKit e){
            System.out.println(e.getMessage());
            if(masKits(sistema)){
                System.out.println("persona agregada con exito");
            }else{
                System.out.println("persona no agregada por falta de kits...");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        menuGral(sistema);
    }

    public static boolean masKits(Sistema sistema){
        int option = -1;
        int cant=-1;
        do{
            try {
                Consola.escribir("Desea agregar mas kits?");
                Consola.escribir("1.Si");
                Consola.escribir("2.No");
                option=Consola.leerInt("Ingrese una opcion: ");
                Consola.limpiar();
            }catch(InputMismatchException e){
                Consola.escribir("Ingrese un numero por favor...");
            }
        }while(option>2 || option<0);
        if(option==1){
            do{
                try {
                    cant=Consola.leerInt("Cuantos desea agregar? ");
                    Consola.limpiar();
                }catch(InputMismatchException e){
                    Consola.escribir("Ingrese un numero por favor...");
                }
            }while(cant<0);
            sistema.setCantKits(cant);
            return true;
        }
        return false;
    }
    //endregion

    //region case 2
    public static void testear (Sistema sistema){
        sistema.testear();
        System.out.println(sistema.getTesteos());
        menuGral(sistema);
    }

    //endregion

    //region case 3
    public static void aislar(Sistema sistema){
       if(sistema.getTesteos().size()==0){
           System.out.println("Debe testear primero");
       }
       else{
           for(Persona p : sistema.getPersonas()){
               try{
                   sistema.aislar(p.getNumKit());
                   System.out.println("Ta sano");
               }catch(Exception e){
                   System.out.println(e.getMessage());
               }
           }
       }
       menuGral(sistema);
    }

    //endregion

    //region case 4
    public static void mostrarEstado(Sistema sistema){
        sistema.getEstado();
        System.out.println(sistema.getSanos());
        System.out.println(sistema.getAislados());
        menuGral(sistema);
    }

    //endregion
}