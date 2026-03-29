package cr.ac.ucenfotec.baron.federico.bl.entities;

import cr.ac.ucenfotec.baron.federico.bl.entities.usuario.Usuario;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Oferta oferta = (Oferta) o;
        return Double.compare(precioOferta, oferta.precioOferta) == 0 && Objects.equals(coleccionista, oferta.coleccionista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coleccionista, precioOferta);
    }
}




