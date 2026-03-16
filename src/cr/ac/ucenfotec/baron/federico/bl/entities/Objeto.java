package cr.ac.ucenfotec.baron.federico.bl.entities;

import java.time.LocalDate;
import java.time.Period;

/**
 * atributos de la clase objeto
 */
public class Objeto {

   private String nombreObjeto;
   private String descripcion;
   private EstadoObjeto estado;
   private LocalDate fechaCompra;

    /**
     * constructor vacio de objeto
     */
    public Objeto() {
    }

    /**
     * Instantiates a new Objeto.
     *
     * @param nombreObjeto nombre del objeto
     * @param descripcion  descripción del objeto
     * @param estado       estado del objeto
     * @param fechaCompra  fecha de compra del objeto
     */
    public Objeto(String nombreObjeto, String descripcion, EstadoObjeto estado, LocalDate fechaCompra) {
        this.nombreObjeto = nombreObjeto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCompra = fechaCompra;
    }

    /**
     * calcular antiguedad del objeto dependiendo de la fecha de fabricación/compra y la fecha actual
     *
     * @return retonar el valor en años, meses, dias del objeto
     */
    public String calcularAntiguedad() { // Metodo para calcular la antoguedad del objeto, de la fecha de compra y la fecha de hoy

        Period p = Period.between(fechaCompra, LocalDate.now());
        return p.getYears() + "años, " + p.getMonths()  + "meses, " + p.getDays() + "días ";

    }

    /**
     * Gets nombre objeto.
     *
     * @return el nombre objeto
     */
    public String getNombreObjeto() {
        return nombreObjeto;
    }

    /**
     * Sets nombre objeto.
     *
     * @param nombreObjeto el nombre objeto
     */
    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    /**
     * Gets descripcion.
     *
     * @return la descripcion del objeto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets descripcion.
     *
     * @param descripcion del obejeto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Gets estado.
     *
     * @return  estado del objeto
     */
    public EstadoObjeto getEstado() {
        return estado;
    }

    /**
     * Sets estado.
     *
     * @param estado del objeto
     */
    public void setEstado(EstadoObjeto estado) {
        this.estado = estado;
    }

    /**
     * Gets fecha compra.
     *
     * @return la fecha de compra del objeto
     *
     */
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    /**
     * Sets fecha compra.
     *
     * @param fechaCompra la fecha compra
     */
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }


    /**
     * Retorna una representación en texto del objeto objeto
     * @return String con los datos del objeto
     */
    @Override
    public String toString() {
        return "Objeto{" +
                "nombreObejeto='" + nombreObjeto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", fechaCompra=" + fechaCompra +
                '}';
    }
}



