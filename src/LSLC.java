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

    public void recorrre(){
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
                ultimo = x;
            }
        } else {
            x.setLiga(primero);
            if (primero == null) ultimo = x;
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
            if (x==ultimo)ultimo=y;
        }
        else {
            primero=primero.getLiga();
            if (primero==null)ultimo=null;
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

}
