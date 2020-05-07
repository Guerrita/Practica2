public class nodoSimple {
    private Integer dato;
    private nodoSimple liga;

    public nodoSimple(Integer dato) {
        this.dato = dato;
        this.liga = null;
    }


    public Integer getDato() {
        return dato;
    }

    public void setDato(Integer dato) {
        this.dato = dato;
    }

    public nodoSimple getLiga() {
        return liga;
    }

    public void setLiga(nodoSimple liga) {
        this.liga = liga;
    }
}
