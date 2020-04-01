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
    }

    boolean esVacia(){
        return primero==null;
    }

    boolean finDeRecorrido(nodoSimple x){
        return x==primero;
    }

    void recorrre(){
        nodoSimple p;
        if (!esVacia()) {
            p = getPrimero();
            while (!finDeRecorrido(p)) {
                JOptionPane.showMessageDialog(null, String.valueOf(p.getDato()));
                p = p.getLiga();
            }
        }else JOptionPane.showMessageDialog(null, "La lista esta vacia");

    }

    nodoSimple buscaDondeInsertar(int d){
        nodoSimple p,ap;
        p=getPrimero();
        ap = anterior(p);
        while (!finDeRecorrido(p) && p.getDato() < d) {
            ap =p;
            p=p.getLiga();
        }
        return ap;
    }

    nodoSimple anterior(nodoSimple x) { //Busca el nodo anterior al nodo que se ingresa
        nodoSimple p,ap;
        p=getPrimero();
        ap=null;
        while (p!=x) {
            ap=p;
            p=p.getLiga();
        }
        return ap;
    }

    void insertar(int d, nodoSimple y){
        nodoSimple x = new nodoSimple(d);
        conectar(x,y);
    }

    void conectar(nodoSimple x, nodoSimple y) {
        if (y != null) {
            x.setLiga(y.getLiga());
            y.setLiga(x);
            if (y == ultimo) ultimo = x;
        } else {
            x.setLiga(primero);
            if (primero == null) ultimo = x;
            primero = x;
        }
    }

    void borrar(nodoSimple x, nodoSimple y){
        if (x==null){
            JOptionPane.showMessageDialog(null, "El dato no existe");
            return;
        }
        desconectar(x,y);
    }

    void desconectar(nodoSimple x /*Nodo a desconectar*/, nodoSimple y /*Nodo anterior al que se desconectara*/) { //Desconecta dos nodos simples
        if (x!=primero){
            y.setLiga(x.getLiga());
            if (x==ultimo)ultimo=y;
        }
        else {
            primero=primero.getLiga();
            if (primero==null)ultimo=null;
        }
    }

    nodoSimple buscarDato(int d, nodoSimple y){ //busca cierto dato y devuelve el nodo simple anterior a el
        nodoSimple x;
        x=getPrimero();
        y = anterior(x);
        while (!finDeRecorrido(x) && x.getDato() != d) {
            y =x;
            x=x.getLiga();
        }
        return x;
    }

    void ordenaAscendentemente(){//metodo de seleccion
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
}
