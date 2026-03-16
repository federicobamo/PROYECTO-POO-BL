package cr.ac.ucenfotec.baron.federico.bl.logic;

import cr.ac.ucenfotec.baron.federico.bl.dl.Data;
import cr.ac.ucenfotec.baron.federico.bl.entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * El tipo Service.
 */
public class Service {

    private Data data = new Data();

    /**
     * Instantiates a new Service.
     */

    public Service() {

    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param nombre            Nombre completo del usuario
     * @param id                Identificación del usuario
     * @param contrasena        Contraseña del usuario
     * @param correoElectronico Correo electrónico del usuario
     * @param puntuacion        Puntuación del usuario
     * @param direccion         Dirección del usuario
     * @param tipo              Tipo de usuario (MODERADOR, VENDEDOR, COLECCIONISTA)
     * @param fechaNacimiento   Fecha de nacimiento del usuario
     * @return Usuario creado y registrado en el sistema
     */

    public Usuario registrarUsuarios(String nombre, int id, String contrasena, String correoElectronico, double puntuacion, String direccion, TipoUsuario tipo, LocalDate fechaNacimiento) {

        Usuario tmpUsuario = new Usuario(nombre, id, contrasena, correoElectronico, puntuacion, direccion, tipo, fechaNacimiento);

        data.agregarUsuario(tmpUsuario);

        return tmpUsuario; // lo retorno para poder usarlo y agregar sus lista de intereses y objetos

    }

    /**
     * Hay usuarios boolean.
     *
     * @return si hay usuarios
     */
    public boolean hayUsuarios() { // comprueba si hay usuarios registrados

        return !data.listarUsuarios().isEmpty();

    }

    /**
     * Registro subastas subasta.
     *
     * @param fechaVencimiento the fecha vencimiento
     * @param creador          the creador
     * @param precioMinimo     the precio minimo
     * @return la subasta
     */
    public Subasta registroSubastas(LocalDateTime fechaVencimiento, Usuario creador, double precioMinimo) {

        Subasta tmpSubasta = new Subasta(fechaVencimiento, creador, precioMinimo);

        data.agregarSubastas(tmpSubasta);

        return tmpSubasta;

    }

    /**
     * Hay subastas boolean.
     *
     * @return si hay subastas
     */
    public boolean haySubastas() { // comprueba si hay subastas registradas

        return !data.listarSubastas().isEmpty();

    }

    /**
     * Registra una nueva oferta en una subasta.
     *
     * @param subasta        Subasta a la que se realiza la oferta
     * @param coleccionista  Usuario coleccionista que realiza la oferta
     * @param precioOfertado Precio ofertado por el coleccionista
     */
    public void registrarOfertas(Subasta subasta, Usuario coleccionista, double precioOfertado) {

        Oferta tmpOferta = new Oferta(coleccionista, precioOfertado);

        data.agregarOfertas(tmpOferta);

        subasta.getListaOfertas().add(tmpOferta);

    }

    /**
     * Hay ofertas boolean.
     *
     * @return si hay ofertas
     */
    public boolean hayOfertas() {

        return !data.listarOfertas().isEmpty();

    }

            /**
             * Puede crear subasta boolean.
             *
             * @param creador the creador
             * @return the boolean
             */

    public boolean puedeCrearSubasta(Usuario creador) { // El usuario puede crear la subasta?

        if (creador.getTipo() == TipoUsuario.MODERADOR) { // Moderador no puede crear subastas

            return false;

        } else {   // coleccionista y vendedor pueden crear subastas

            return true;

        }
    }

    /**
     * Verifica si un usuario puede realizar ofertas en una subasta.
     *
     * @param usuario Usuario que desea realizar la oferta
     * @return true si es coleccionista, false si es moderador o vendedor
     */
    public boolean puedeOfertar(Usuario usuario) { // El usuario puede ofertar en la subasta?

        if (usuario.getTipo() == TipoUsuario.COLECCIONISTA) { // coleccionista  puede ofertar en la subasta

            return true;

        } else {   // moderador y vendedor no pueden ofertar en la subasta

            return false;

        }
    }

    /**
     * Registra un objeto en la colección personal de un coleccionista.
     *
     * @param usuario      Coleccionista dueño del objeto
     * @param nombreObjeto Nombre del objeto
     * @param descripcion  Descripción del objeto
     * @param estado       Estado del objeto (NUEVO, USADO, ANTIGUO_SIN_ABRIR)
     * @param fechaCompra  Fecha de compra del objeto
     */
    public void registrarObjetosColeccionista(Usuario usuario, String nombreObjeto, String descripcion, EstadoObjeto estado, LocalDate fechaCompra ){

        Objeto tmpObjeto = new Objeto(nombreObjeto, descripcion, estado, fechaCompra);

        usuario.getListaObjetos().add(tmpObjeto);
    }

    /**
     * Registra un objeto en la lista de objetos de una subasta.
     *
     * @param subasta      Subasta a la que se agrega el objeto
     * @param nombreObjeto Nombre del objeto
     * @param descripcion  Descripción del objeto
     * @param estado       Estado del objeto (NUEVO, USADO, ANTIGUO_SIN_ABRIR)
     * @param fechaCompra  Fecha de compra del objeto
     */
    public void registrarObjeto(Subasta subasta, String nombreObjeto, String descripcion, EstadoObjeto estado, LocalDate fechaCompra) {

        Objeto tmpObjeto = new Objeto(nombreObjeto, descripcion, estado, fechaCompra);

        subasta.getListaObjetos().add(tmpObjeto);


    }

    /**
     * Verifica si un usuario puede participar como oferente en una subasta.
     *
     * @param subasta Subasta en la que se desea participar
     * @param usuario Usuario que desea realizar la oferta
     * @return true si el usuario no es el creador, false si es el creador de la subasta
     */
    public boolean puedeParcipar(Subasta subasta, Usuario usuario) {

        if (subasta.getCreador().getId()== usuario.getId()){ // si el creador de la subasta tiene el mismo id del comprador no puede participar

            return true;

        }else{

            return false;
        }

    }

    /**
     * Verifica si el precio ofertado es válido para una subasta.
     *
     * @param precioOferta Precio ofertado por el coleccionista
     * @param precioMinimo Precio mínimo aceptado por la subasta
     * @return true si el precio ofertado es mayor o igual al mínimo, false si es menor
     */
    public boolean ofertaValida(double precioOferta, double precioMinimo) {

        if (precioOferta >= precioMinimo) { // ciclo que valida es igual o mayor al precio puesto por el vendedor

            return true;

        } else {

            return false;

        }
    }

    /**
     * Verifica si una subasta ha vencido y actualiza su estado a VENCIDA.
     *
     * @param subasta Subasta a verificar
     */

    public void subastaVencio(Subasta subasta) { // este metodo comprueba si la fecha de vencimiento esta antes de la hora actual, lo que indica que se vencio la subasta

        if (subasta.getFechaVencimiento().isBefore(LocalDateTime.now())){

            subasta.setEstado(EstadoSubasta.VENCIDA);
        }
    }

    /**
     * Retorna la lista de usuarios registrados en el sistema.
     *
     * @return Lista de usuarios registrados
     */
    public ArrayList<Usuario> listarUsuarios () {
        return data.listarUsuarios();

    }

    /**
     * Retorna la lista de ofertas registradas en el sistema.
     *
     * @return Lista de ofertas registradas
     */
    public ArrayList<Oferta> listarOfertas() {
        return data.listarOfertas();
    }

    /**
     * Retorna la lista de subastas registradas en el sistema.
     *
     * @return Lista de subastas registradas
     */
    public ArrayList<Subasta> listarSubastas() {
        return data.listarSubastas();
    }




}
