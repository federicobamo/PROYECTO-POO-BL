package cr.ac.ucenfotec.baron.federico.bl.dl;


import cr.ac.ucenfotec.baron.federico.bl.entities.Objeto;
import cr.ac.ucenfotec.baron.federico.bl.entities.Oferta;
import cr.ac.ucenfotec.baron.federico.bl.entities.OrdenAdjudicacion;
import cr.ac.ucenfotec.baron.federico.bl.entities.Subasta;
import cr.ac.ucenfotec.baron.federico.bl.entities.usuario.Usuario;

import java.util.ArrayList;
/**
 * Atributos de la clase Data
 */
public class Data {

    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Subasta> listaSubastas;
    private ArrayList<Oferta> listaOfertas;
    private ArrayList<OrdenAdjudicacion> listaOrdenes;

    /**
     * Constructor por defecto, inicializa las listas vacías.
     */
    public Data() {

        this.listaUsuarios = new ArrayList<>();
        this.listaSubastas = new ArrayList<>();
        this.listaOfertas = new ArrayList<>();
        this.listaOrdenes = new ArrayList<>();
    }

    /**
     * Agrega el usuario a la lista de usuarios
     *
     * @param usuario el usuario
     */
    public void agregarUsuario(Usuario usuario) {

        listaUsuarios.add(usuario);

    }


    /**
     * Agrega la subasta a la lista de subastas
     *
     * @param subasta la subasta
     */
    public void agregarSubastas(Subasta subasta) {

        listaSubastas.add(subasta);

    }

    /**
     * Agrega la oferta a la lista  de ofertas
     *
     * @param oferta la oferta
     */
    public void agregarOfertas(Oferta oferta) {

        listaOfertas.add(oferta);
    }
    /***
     * Metodo para agregar las ordenes a la lista
     *
     */
    public void agregarOrdenes(OrdenAdjudicacion orden) {
        listaOrdenes.add(orden);
    }
    /**
     * Retorna la lista de usuarios registrados en el sistema.
     *
     * @return Lista de usuarios
     */
    public ArrayList<Usuario> listarUsuarios() {
        return listaUsuarios;
    }
    /**
     * Retorna la lista de ofertas registradas en el sistema.
     *
     * @return Lista de ofertas
     */
    public ArrayList<Oferta> listarOfertas() {
        return listaOfertas;
    }
    /**
     * Retorna la lista de subastas registradas en el sistema.
     *
     * @return Lista de subastas
     */
    public ArrayList<Subasta> listarSubastas() {
        return listaSubastas;
    }
    /***
     * Metodo para listar las ordenes
     * @return
     */
    public ArrayList<OrdenAdjudicacion> listarOrdenes() {
        return listaOrdenes;
    }

}
