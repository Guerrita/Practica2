public class nodoSimple {
    private int dato;
    private nodoSimple liga;

    public nodoSimple(int dato) {
        this.dato = dato;
        this.liga = null;
    }


    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public nodoSimple getLiga() {
        return liga;
    }

    public void setLiga(nodoSimple liga) {
        this.liga = liga;
    }
}
