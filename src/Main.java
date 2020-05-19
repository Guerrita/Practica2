import javax.swing.*;

public class Main {

    private static LSLC ldos=new LSLC(), //Datos pares
                        ltres=new LSLC(), //Datos multiplos de 3
                        lcinco=new LSLC(), //Datos multiplos de 5
                        lcero=new LSLC(), //Datos que no correspondan a ninguna caracteristica anterior
                        ldosTres = new LSLC(),
                        ldosCinco = new LSLC(),
                        ltresCinco = new LSLC(),
                        ldosTresCinco = new LSLC(),
                        ldosNoTresNoCinco= new LSLC(),
                        ltresNoDosNoCinco = new LSLC(),
                        lcincoNoDosNoTres = new LSLC(),
                        lzeta = new LSLC(),
                        lzetaOrdenada = new LSLC();


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
        ldosTres=ldos.interseccionLdosLtres();
        ldosCinco= ldos.interseccionLdosLcinco();
        ltresCinco = ltres.interseccionLtresLcinco();
        ldosTresCinco = ldos.interseccionLdosLtresLcinco();

        ldosNoTresNoCinco = ldos.ldosNoLtresNoLcinco();
        ltresNoDosNoCinco = ltres.ltresNoLdosNoLcinco();
        lcincoNoDosNoTres = lcinco.lcincoNoLtresNoLdos();


        lzeta.lz(lcero, ldos, ltres, lcinco);
        lzeta.recorre();
        lzetaOrdenada.ordenarAscendenteYDescendentemente(lzeta);
    }

}
