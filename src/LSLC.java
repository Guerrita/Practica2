import javax.swing.*;

public class LSLC {
    protected nodoSimple primero,ultimo;

    public LSLC() {
        this.primero = null;
        this.ultimo = null;
    }

    public nodoSimple getPrimero() {
        return primero;
    }

    public void setPrimero(nodoSimple primero) {
        this.primero = primero;
    }

    public nodoSimple getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodoSimple ultimo) {
        this.ultimo = ultimo;
        ultimo.setLiga(primero);
    }

    public boolean esVacia(){
        return primero==null;
    }

    public boolean finDeRecorrido(nodoSimple x){
        return x==primero;
    }

    public void recorre(){
        nodoSimple p;
        String mensaje="";
        if (!esVacia()) {//Hay que tener presente que la lista no puede estar vacia
            p = getPrimero();
            do { //Como el fin de recorrido se acabacuando x == primero entonces primero se tiene que realizar una vez el recorrido, por lo menos
                mensaje+= String.valueOf(p.getDato())+", ";
                p = p.getLiga();
            }while (!finDeRecorrido(p));
        }else JOptionPane.showMessageDialog(null, "La lista esta vacia");
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public nodoSimple buscaDondeInsertarAscendentemente(int d){ //////////////////////////PPROBAR //////////////////////////////////////////
        nodoSimple p,ap;
        p=getPrimero();
        ap = anterior(p);
        if (!esVacia()) {
            if (p.getDato() < d) {
                ap = p;
                p = p.getLiga();
            }
            while (!finDeRecorrido(p) && p.getDato() < d) {
                ap = p;
                p = p.getLiga();
            }
        }
        return ap;
    }

    public nodoSimple buscaDondeInsertarDescendentemente(int d){ //////////////////////////PPROBAR //////////////////////////////////////////
        nodoSimple p,ap;
        p=getPrimero();
        ap = anterior(p);
        if (!esVacia()) {
            if (p.getDato() > d) {
                ap = p;
                p = p.getLiga();
            }
            while (!finDeRecorrido(p) && p.getDato() > d) {
                ap = p;
                p = p.getLiga();
            }
        }
        return ap;
    }

    public nodoSimple anterior(nodoSimple x) { //Busca el nodo anterior al nodo que se ingresa
        nodoSimple p,ap;
        p=getPrimero();
        ap=null;
        while (p!=x) {
            ap=p;
            p=p.getLiga();
        }
        return ap;
    }

    public void insertar(int d, nodoSimple y){
        nodoSimple x = new nodoSimple(d);
        conectar(x,y);
    }

    public void conectar(nodoSimple x, nodoSimple y) {////////////////////////////////////////////CAMBIAR////////////////////////////////////////7
        if (y != null) {
            x.setLiga(y.getLiga());
            y.setLiga(x);
            if (y == ultimo) {
                setUltimo(x);
            }
        } else {
            x.setLiga(primero);
            if (primero == null) setUltimo(x);
            primero = x;
            ultimo.setLiga(primero);
        }
    }

    public void borrar(nodoSimple x, nodoSimple y){
        if (x==null){
            JOptionPane.showMessageDialog(null, "El dato no existe");
            return;
        }
        desconectar(x,y);
    }

    public void desconectar(nodoSimple x /*Nodo a desconectar*/, nodoSimple y /*Nodo anterior al que se desconectara*/) { //Desconecta dos nodos simples
        if (x!=primero){
            y.setLiga(x.getLiga());
            if (x==ultimo)setUltimo(y);
        }
        else {
            primero=primero.getLiga();
            if (primero==null)setUltimo(null);
        }
    }

    public nodoSimple buscarDato(int d, nodoSimple y){ //busca cierto dato y devuelve el nodo simple anterior a el
        nodoSimple x;
        x=getPrimero();
        y = anterior(x);
        if(x.getDato() != d){
            y =x;
            x=x.getLiga();
        }
        while (!finDeRecorrido(x) && x.getDato() != d) {
            y =x;
            x=x.getLiga();
        }
        return x;
    }

    public void ordenaAscendentemente(){//metodo de seleccion
        nodoSimple p,ap,menor,amenor,q,aq;
        p=getPrimero();
        ap=anterior(p);
        while (p!=getUltimo()){
            menor=p;
            amenor=ap;
            q=p.getLiga();
            aq = p;
            while (!finDeRecorrido(q)){
                if (q.getDato()<menor.getDato()) {
                    menor = q;
                    amenor = aq;
                }
                aq = q;
                q=q.getLiga();
            }
            if (menor==p){
                ap=p;
                p=p.getLiga();
            }
            else{
                desconectar(menor,amenor);
                conectar(menor,ap);
                ap=menor;
            }
        }
    }

    public int numeroNodos() {
        int cont = 0;
        nodoSimple p;
        if (!esVacia()) {//Hay que tener presente que la lista no puede estar vacia
            p = getPrimero();
            do {
                cont += 1;
                p = p.getLiga();
            } while (!finDeRecorrido(p));
        }
        return cont;
    }

    public void ordenarAscendenteYDescendentemente(){
        nodoSimple p, ap, menor, amenor, q, aq, anm;
        Integer numNodos;
        numNodos = numeroNodos();
        double mit = Math.ceil(numNodos / 2);
        Integer mitad = (int) mit;
        nodoSimple nodoMitad = getPrimero();

        for (int i = 0; i < mitad; i++) {
            nodoMitad = nodoMitad.getLiga();
        }
        //Ordena ascendentemente desde el inicio del vector hasta el final
        p=getPrimero();
        ap=anterior(p);
        anm = anterior(nodoMitad);
        while (p!=nodoMitad){
            menor=p;
            amenor=ap;
            q=p.getLiga();
            aq = p;
            while (q!=nodoMitad){
                if (q.getDato()<menor.getDato()) {
                    menor = q;
                    amenor = aq;
                }
                aq = q;
                q=q.getLiga();
            }
            if (menor==p){
                ap=p;
                p=p.getLiga();
            }
            else{
                desconectar(menor,amenor);
                conectar(menor,ap);
                ap=menor;
            }
        }


        //Ordena descendentemente desde la mitad del vector hasta el final
        anm = anterior(nodoMitad);
        while (nodoMitad != this.getUltimo()) {
            menor = nodoMitad;
            amenor = anm;
            q = nodoMitad.getLiga();
            aq = nodoMitad;
            while (!finDeRecorrido(q)) {
                if (q.getDato() > menor.getDato()) {
                    menor = q;
                    amenor = aq;
                }
                aq = q;
                q = q.getLiga();
            }
            if (menor == nodoMitad) {
                anm = nodoMitad;
                nodoMitad = nodoMitad.getLiga();
            } else {
                desconectar(menor, amenor);
                conectar(menor, anm);
                anm = menor;
            }
        }


        //Ordena descendentemente desde la mitad del vector hasta el final
        anm = anterior(nodoMitad);
        while (nodoMitad != lzeta.getUltimo()) {
            menor = nodoMitad;
            amenor = anm;
            q = nodoMitad.getLiga();
            aq = nodoMitad;
            while (!finDeRecorrido(q)) {
                if (q.getDato() > menor.getDato()) {
                    menor = q;
                    amenor = aq;
                }
                aq = q;
                q = q.getLiga();
            }
            if (menor == nodoMitad) {
                anm = nodoMitad;
                nodoMitad = nodoMitad.getLiga();
            } else {
                desconectar(menor, amenor);
                conectar(menor, anm);
                anm = menor;
            }
        }
    }

        //Estos metodos nos ayudaran a crear las LSLC: L0,L2,L3,L5.
    public void insertarAlInicio(Integer d){
        insertar(d,null);
    }
    public void insertarAlFinal(Integer d){
        nodoSimple y = this.getUltimo();
        insertar(d,y);
    }
    public void insertarAscendentemente(Integer d){
        nodoSimple y = buscaDondeInsertarAscendentemente(d);
        insertar(d,y);
    }

    public void insertarDescendentemente(Integer d){
        nodoSimple y = buscaDondeInsertarDescendentemente(d);
        insertar(d,y);
    }

    //Metodos practica 2

    public LSLC interseccionLdosLtres(){
        LSLC lista = new LSLC();
        nodoSimple p;
        if (!esVacia()) {//Hay que tener presente que la lista no puede estar vacia
            p = getPrimero();
            do { //Como el fin de recorrido se acabacuando x == primero entonces primero se tiene que realizar una vez el recorrido, por lo menos
                if (p.getDato()%3==0){
                    lista.insertarAlInicio(p.getDato());
                }
                p = p.getLiga();
            }while (!finDeRecorrido(p));
        }
        return lista;
    }

    public LSLC interseccionLdosLcinco(){
        LSLC lista = new LSLC();
        nodoSimple p;
        if (!esVacia()) {//Hay que tener presente que la lista no puede estar vacia
            p = getPrimero();
            do {
                if (p.getDato()%5==0){
                    lista.insertarAlInicio(p.getDato());
                }
                p = p.getLiga();
            }while (!finDeRecorrido(p));
        }
        return lista;
    }

    public LSLC interseccionLtresLcinco(){
        LSLC lista = new LSLC();
        nodoSimple p;
        if (!esVacia()) {//Hay que tener presente que la lista no puede estar vacia
            p = getPrimero();
            do {
                if (p.getDato()%5==0){
                    lista.insertarAlInicio(p.getDato());
                }
                p = p.getLiga();
            }while (!finDeRecorrido(p));
        }
        return lista;
    }

    public LSLC interseccionLdosLtresLcinco(){
        LSLC lista = new LSLC();
        nodoSimple p;
        if (!esVacia()) {//Hay que tener presente que la lista no puede estar vacia
            p = getPrimero();
            do {
                if (p.getDato()%5==0 && p.getDato()%3==0){
                    lista.insertarAlInicio(p.getDato());
                }
                p = p.getLiga();
            }while (!finDeRecorrido(p));
        }
        return lista;
    }


    public LSLC ldosNoLtresNoLcinco(){
        LSLC lista = new LSLC();
        nodoSimple p;
        if (!esVacia()) {//Hay que tener presente que la lista no puede estar vacia
            p = getPrimero();
            do {
                if (p.getDato()%5!=0 && p.getDato()%3!=0){
                    lista.insertarAlInicio(p.getDato());
                }
                p = p.getLiga();
            }while (!finDeRecorrido(p));
        }
        return lista;
    }

    public LSLC ltresNoLdosNoLcinco(){
        LSLC lista = new LSLC();
        nodoSimple p;
        if (!esVacia()) {//Hay que tener presente que la lista no puede estar vacia
            p = getPrimero();
            do {
                if (p.getDato()%5!=0 && p.getDato()%2!=0){
                    lista.insertarAlInicio(p.getDato());
                }
                p = p.getLiga();
            }while (!finDeRecorrido(p));
        }
        return lista;
    }

    
    public LSLC lcincoNoLtresNoLdos(){
        LSLC lista = new LSLC();
        nodoSimple p;
        if (!esVacia()) {//Hay que tener presente que la lista no puede estar vacia
            p = getPrimero();
            do {
                if (p.getDato()%2!=0 && p.getDato()%3!=0){
                    lista.insertarAlInicio(p.getDato());
                }
                p = p.getLiga();
            }while (!finDeRecorrido(p));
        }
        return lista;
    }

    public void lz(LSLC lcero, LSLC ldos,LSLC ltres, LSLC lcinco){
        nodoSimple p;
        if (!lcero.esVacia()) {//Hay que tener presente que la lista no puede estar vacia
            p = lcero.getPrimero();
            do {
                insertarAscendentemente(p.getDato());
                p = p.getLiga();
            }while (!lcero.finDeRecorrido(p));
        }
        if (!ldos.esVacia()) {//Hay que tener presente que la lista no puede estar vacia
            p = ldos.getPrimero();
            do {
                insertarAscendentemente(p.getDato());
                p = p.getLiga();
            }while (!ldos.finDeRecorrido(p));
        }
        if (!ltres.esVacia()) {//Hay que tener presente que la lista no puede estar vacia
            p = ltres.getPrimero();
            do {
                if (p.getDato()%2!=0)insertarAscendentemente(p.getDato());
                p = p.getLiga();
            }while (!ltres.finDeRecorrido(p));
        }
        if (!lcinco.esVacia()) {//Hay que tener presente que la lista no puede estar vacia
            p = lcinco.getPrimero();
            do {
                if (p.getDato()%2!=0 && p.getDato()%3!=0)insertarAscendentemente(p.getDato());
                p = p.getLiga();
            }while (!lcinco.finDeRecorrido(p));
        }

    }
}
