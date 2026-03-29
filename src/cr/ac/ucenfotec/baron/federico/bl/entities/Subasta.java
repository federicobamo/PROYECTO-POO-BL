package cr.ac.ucenfotec.baron.federico.bl.entities;

import cr.ac.ucenfotec.baron.federico.bl.entities.usuario.Usuario;

import java.time.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 *atributos de la clase Subasta
 */
public class Subasta {

    private LocalDateTime fechaVencimiento;
    private Usuario creador;
    private double precioMinimo;
    private ArrayList<Objeto> listaObjetos;
    private ArrayList<Oferta> listaOfertas;
    private EstadoSubasta estado;

    /**
     * constructor vacio
     */
    public Subasta() {

    }

    /**
     *  Constructor con parámetros para crear un Subasta.
     *
     * @param fechaVencimiento la fecha vencimiento
     * @param creador          el creador
     * @param precioMinimo     el precio minimo
     */
    public Subasta(LocalDateTime fechaVencimiento, Usuario creador, double precioMinimo) {

        this.fechaVencimiento = fechaVencimiento;
        this.creador = creador;
        this.precioMinimo = precioMinimo;
        this.listaOfertas = new ArrayList<>();
        this.listaObjetos = new ArrayList<>();
        this.estado = EstadoSubasta.ACTIVA;

    }

    /**
     * Calcular tiempo restante de lo que le queda a la subasta activa
     *
     * @return el tiempo restante que le queda a la subasta
     */
    public String calcularTiempoRestante() { // metodo para calcular el tiempo que le queda a la subasta

        LocalDateTime horaActual = LocalDateTime.now();
        LocalDateTime vencimiento = fechaVencimiento;
        Duration duracion = Duration.between(horaActual, vencimiento);

        long dias = duracion.toDays();
        long horas = duracion.toHours() % 24;
        long minutos = duracion.toMinutes() % 60;
        long segundos = duracion.getSeconds() % 60;

        return dias + " días, " + horas + " horas, " + minutos + " minutos, " + segundos + " segundos";

    }

    /**
     * Gets fecha vencimiento.
     *
     * @return la fecha vencimiento
     */
    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Sets fecha vencimiento.
     *
     * @param fechaVencimiento la fecha vencimiento
     */
    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Gets creador.
     *
     * @return el creador
     */
    public Usuario getCreador() {
        return creador;
    }

    /**
     * Sets creador.
     *
     * @param creador el creador
     */
    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    /**
     * Gets precio minimo.
     *
     * @return el precio minimo
     */
    public double getPrecioMinimo() {
        return precioMinimo;
    }

    /**
     * Sets precio minimo.
     *
     * @param precioMinimo el precio minimo
     */
    public void setPrecioMinimo(double precioMinimo) {
        this.precioMinimo = precioMinimo;
    }

    /**
     * Gets lista objetos.
     *
     * @return la lista objetos
     */
    public ArrayList<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    /**
     * Sets lista objetos.
     *
     * @param listaObjetos la lista objetos
     */
    public void setListaObjetos(ArrayList<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    /**
     * Gets lista ofertas.
     *
     * @return la lista ofertas
     */
    public ArrayList<Oferta> getListaOfertas() {
        return listaOfertas;
    }

    /**
     * Sets lista ofertas.
     *
     * @param listaOfertas la lista ofertas
     */
    public void setListaOfertas(ArrayList<Oferta> listaOfertas) {
        this.listaOfertas = listaOfertas;
    }

    /**
     * Gets estado.
     *
     * @return el estado
     */
    public EstadoSubasta getEstado() {
        return estado;
    }

    /**
     * Sets estado.
     *
     * @param estado el estado
     */
    public void setEstado(EstadoSubasta estado) {
        this.estado = estado;
    }

    /**
     * Retorna una representación en texto del objeto Subasta
     * @return String con los datos de la Subasta
     */
    @Override
    public String toString() {
        return "Subasta{" +
                "fechaVencimiento=" + fechaVencimiento +
                ", creador=" + creador +
                ", precioMinimo=" + precioMinimo +
                ", listaObjetos=" + listaObjetos +
                ", listaOfertas=" + listaOfertas +
                ", estado=" + estado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Subasta subasta = (Subasta) o;
        return Objects.equals(fechaVencimiento, subasta.fechaVencimiento) && Objects.equals(creador, subasta.creador) && Objects.equals(listaObjetos, subasta.listaObjetos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaVencimiento, creador, listaObjetos);
    }
}
