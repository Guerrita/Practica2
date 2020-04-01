import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String menu = "Bienvenido. Seleccione una opcion;\n"+
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
        String opcion = "";
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
