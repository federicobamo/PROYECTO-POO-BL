package cr.ac.ucenfotec.baron.federico.bl.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class OrdenAdjudicacion {

private String nombreGanador;
private LocalDate fechaOrden;
private ArrayList<Objeto> listaObjetosAdjudicados;
private Double precioFinal;


public OrdenAdjudicacion () {
}

    /***
     *
     * @param nombreGanador
     * @param fechaOrden
     * @param listaObjetosAdjudicados
     * @param precioFinal
     */
    public OrdenAdjudicacion(String nombreGanador, LocalDate fechaOrden, ArrayList<Objeto> listaObjetosAdjudicados, Double precioFinal) {
        this.nombreGanador = nombreGanador;
        this.fechaOrden = fechaOrden;
        this.listaObjetosAdjudicados = listaObjetosAdjudicados;
        this.precioFinal = precioFinal;
    }

    /***
     * Getters y setters de los atributos de la clase
     * @return
     */
    public String getNombreGanador() {
        return nombreGanador;
    }

    public void setNombreGanador(String nombreGanador) {
        this.nombreGanador = nombreGanador;
    }

    public LocalDate getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(LocalDate fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public ArrayList<Objeto> getListaObjetosAdjudicados() {
        return listaObjetosAdjudicados;
    }

    public void setListaObjetosAdjudicados(ArrayList<Objeto> listaObjetosAdjudicados) {
        this.listaObjetosAdjudicados = listaObjetosAdjudicados;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }
    /***
     * Metodo toString
     * @return
     */
    @Override
    public String toString() {
       return  "----- Orden de Adjudicación -----\n" +
                "Ganador: " + nombreGanador+ "\n" +
                "Fecha: " + fechaOrden + "\n" +
                "Objetos: " + listaObjetosAdjudicados + "\n" +
                "Precio Total: $" + precioFinal;
    }
    /***
     * Metodo equals
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrdenAdjudicacion that = (OrdenAdjudicacion) o;
        return Objects.equals(nombreGanador, that.nombreGanador) && Objects.equals(listaObjetosAdjudicados, that.listaObjetosAdjudicados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreGanador, listaObjetosAdjudicados);
    }
}
