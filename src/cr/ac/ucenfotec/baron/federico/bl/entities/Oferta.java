package cr.ac.ucenfotec.baron.federico.bl.entities;

/**
 * atributos de la case Oferta
 */
public class Oferta {

    private Usuario coleccionista;
    private double precioOferta;


    /**
     * creacion contrcutor vacio de Ofera
     */
    public Oferta() {
    }

    /**
     * Constructor con parametros
     *
     * @param coleccionista el coleccionista de Oferta
     * @param precioOferta  el precio de la Oferta
     */
    public Oferta(Usuario coleccionista, double precioOferta) {
        this.coleccionista = coleccionista;
        this.precioOferta = precioOferta;
    }

    /**
     * Gets coleccionista.
     *
     * @return el coleccionista
     */
    public Usuario getColeccionista() {
        return coleccionista;
    }

    /**
     * Sets coleccionista.
     *
     * @param coleccionista el coleccionista
     */
    public void setColeccionista(Usuario coleccionista) {
        this.coleccionista = coleccionista;
    }

    /**
     * Gets oferta.
     *
     * @return la oferta
     */
    public double getprecioOferta() {
        return precioOferta;
    }

    /**
     * Sets oferta.
     *
     * @param precioOferta el precio oferta
     */
    public void setprecioOferta(double precioOferta) {
        precioOferta = precioOferta;
    }




    /**
     * Retorna una representación en texto del objeto Oferta
     * @return String con los datos de la oferta
     */
    @Override
    public String toString() {
        return "Oferta{" +
                "coleccionista=" + coleccionista +
                ", PrecioOferta=" + precioOferta +
                '}';
    }
}




