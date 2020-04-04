import javax.swing.*;

public class Main {

    static LSLC ldos=new LSLC(), //Datos pares
         ltres=new LSLC(), //Datos multiplos de 3
         lcinco=new LSLC(), //Datos multiplos de 5
         lcero=new LSLC(); //Datos que no correspondan a ninguna caracteristica anterior

    public static void main(String[] args) {
        String menu ="1. Ingresar dato nuevo\n" +
                "2. No ingresar mas datos";
        String opcion = "";
        Integer dato;
        do {
            opcion = JOptionPane.showInputDialog(menu);
            if ("1".equals(opcion)){
                dato = Integer.valueOf(JOptionPane.showInputDialog("Ingrese el dato:"));
                if (dato%2==0){//Se ingresan los datos al final de la lista
                    if (dato%3==0){
                        if (dato%5==0){//El dato es multiplo de 2, de 3 y de 5
                            ldos.insertarAlFinal(dato);
                            ltres.insertarAlInicio(dato);
                            lcinco.insertarAscendentemente(dato);
                        }
                        else {//El dato es multiplo de 2 y de 3
                            ldos.insertarAlFinal(dato);
                            ltres.insertarAlInicio(dato);
                        }
                    }
                    else if (dato%5==0){//El dato es multiplo de 2 y de 5
                        ldos.insertarAlFinal(dato);
                        lcinco.insertarAscendentemente(dato);
                    }
                    else { //El dato es solo multiplo de 2
                        ldos.insertarAlFinal(dato);
                    }
                }
                else if (dato%3==0){//Se ingresan los datos al principio de la lista
                    if (dato%5==0){//El dato es multiplo de 3 y de 5
                        ltres.insertarAlInicio(dato);
                        lcinco.insertarAscendentemente(dato);
                    }
                    else {//El dato es solo multiplo de 3
                        ltres.insertarAlInicio(dato);
                    }
                }
                else if (dato%5==0){ //Se crea la LSLC de modo que los datos queden ordenados ascendentemente
                    lcinco.insertarAscendentemente(dato);
                }

                else { //Se crea la LSLC de modo que los datos queden ordenados descendentemente
                    lcero.insertarDescendentemente(dato);
                }
            }
        }while (!"2".equals(opcion));

        menu = "Bienvenido. Seleccione una opcion;\n"+
                "1. Construir una nueva lista que sea la intersección de L2 con L3.. \n"+
                "2. Construir una nueva lista que sea la intersección de L2 con L5.. \n"+
                "3. Construir una nueva lista que sea la intersección de L3 con L5. \n" +
                "4. Construir una nueva lista que sea la intersección de L2, L3 y L5.\n" +
                "5. Mostrar por pantalla las listas originales y las que acabó de construir.\n" +
                "6. Mostrar por pantalla los datos de L2 que no está ni en L3 ni en L5.\n" +
                "7. Mostrar por pantalla los datos de L5 que no están ni en L2 ni en L3.\n" +
                "8. Construir una nueva lista (LZ) que sea la unión de los datos de las \nlistas L0, L2, L3 y L5. "+
                "9. Mostrar por pantalla la lista LZ.\n" +
                "10. Ordenar la lista LZ de tal manera que la primera mitad de los datos queden ordenados\n" +
                "ascendentemente y la segunda mitad descendentemente.\n" +
                "11. Mostrar por pantalla la lista LZ después de ordenada.\n" +
                "12. Salir.";
        opcion = "";
        do {
            opcion = JOptionPane.showInputDialog(menu);
            switch (opcion) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":
                    break;
                case "10":
                    break;
                case "11":
                    break;
                case "12":
                    JOptionPane.showMessageDialog(null,"Hasta luego.");
                    break;

            }
        }while(!"12".equals(opcion));
    }
}
