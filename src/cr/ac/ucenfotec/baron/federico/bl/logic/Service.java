package cr.ac.ucenfotec.baron.federico.bl.logic;
import com.google.protobuf.Message;
import com.mysql.cj.Session;
import cr.ac.ucenfotec.baron.federico.bl.dl.Data;
import cr.ac.ucenfotec.baron.federico.bl.entities.*;
import cr.ac.ucenfotec.baron.federico.bl.entities.usuario.*;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Properties;


/**
 * El tipo Service.
 */
public class Service {

    private Data data = new Data(); // crea una instancia de data, para usarse y poder acceder a los arrays que tiene data

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


    public boolean existeModerador() {

        for (Usuario u : data.listarUsuarios()) {

            if (u instanceof Moderador) {

                return true;

            }
        }

        return false;
    }

    public Moderador registrarModerador(String nombre, int id, String contrasena, String correoElectronico, LocalDate fechaNacimiento) {


        Moderador tmpModerador = new Moderador(nombre, id, contrasena, correoElectronico, fechaNacimiento);
        if (tmpModerador.calcularEdad() < 18) {
            return null;
        }
        data.agregarUsuario(tmpModerador);
        return tmpModerador;

    }


    public Vendedor registrarVendedor(String nombre, int id, String contrasena, String correoElectronico, LocalDate fechaNacimiento, Double puntuacion, String direccion) {

        Vendedor tmpVendedor = new Vendedor(nombre, id, contrasena, correoElectronico, fechaNacimiento, puntuacion, direccion);
        if (tmpVendedor.calcularEdad() < 18) {
            return null;
        }
        data.agregarUsuario(tmpVendedor);
        return tmpVendedor;
    }

    public Coleccionista registrarColeccionista(String nombre, int id, String contrasena, String correoElectronico, LocalDate fechaNacimiento, Double puntuacion, String direccion) {
        Coleccionista tmpColeccionista = new Coleccionista(nombre, id, contrasena, correoElectronico,
                fechaNacimiento, puntuacion, direccion);
        if (tmpColeccionista.calcularEdad() < 18) {
            return null;
        }

        data.agregarUsuario(tmpColeccionista);
        return tmpColeccionista;

    }

    /**
     * Hay usuarios boolean.
     *
     * @return si hay usuarios
     */
    public boolean hayUsuarios() { // comprueba si hay usuarios registrados

        return !data.listarUsuarios().isEmpty(); // esta vacia?, si no esta vacia return true
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
        Coleccionista moderador = asignarModeradorAleatorio();
        if (moderador != null) {
            System.out.println("Moderador asignado: " + moderador.getNombre());
        }
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

        if (creador instanceof Moderador) { // Moderador no puede crear subastas
            return false; // la unica persona que no puede crear subastas, moderador
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

        if (usuario instanceof Coleccionista) { // coleccionista  puede ofertar en la subasta
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
    public void registrarObjetosColeccionista(Coleccionista coleccionista, String nombreObjeto, String descripcion, EstadoObjeto estado, LocalDate fechaCompra) {

        Objeto tmpObjeto = new Objeto(nombreObjeto, descripcion, estado, fechaCompra);
        coleccionista.getListaObjetos().add(tmpObjeto);
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
        if (subasta.getCreador().getId() == usuario.getId()) { // si el creador de la subasta tiene el mismo id del comprador no puede participar
            return true;
        } else {
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
     * El metodo compara las oferta para saber cual fue la más alta
     *
     * @param subasta
     * @return retonar la oferta más alta por la subasta
     */
    public Oferta ofertaGanadora(Subasta subasta) {

        Oferta ganadora = subasta.getListaOfertas().get(0);
        for (int i = 0; i < subasta.getListaOfertas().size(); i++) {
            if (subasta.getListaOfertas().get(i).getprecioOferta() > ganadora.getprecioOferta()) {
                ganadora = subasta.getListaOfertas().get(i);
            }
        }
        return ganadora;
    }

    /**
     * Verifica si una subasta ha vencido y si tiene ofertas se ADJUDICA y sino se vence..
     *
     * @param subasta Subasta a verificar
     */
    public void subastaVencio(Subasta subasta) { // este metodo comprueba si la fecha de vencimiento esta antes de la hora actual, lo que indica que se vencio la subasta


        if (subasta.getEstado() == EstadoSubasta.CANCELADA) {
            return; // no hacer nada si está cancelada
        }

        if (subasta.getFechaVencimiento().isBefore(LocalDateTime.now())) {
            if (!subasta.getListaOfertas().isEmpty()) { // si lista ofertas no esta vacia / tiene ofertas

                String nombreGanador = ofertaGanadora(subasta).getColeccionista().getNombre();
                LocalDate fechaOrden = LocalDate.now();
                ArrayList<Objeto> listaObjetos = subasta.getListaObjetos();
                double precioTotal = ofertaGanadora(subasta).getprecioOferta();

                OrdenAdjudicacion orden = new OrdenAdjudicacion(nombreGanador, fechaOrden, listaObjetos, precioTotal);
                data.agregarOrdenes(orden);

                subasta.setEstado(EstadoSubasta.ADJUDICADA);// su estado cambia a adjundicada

            } else {
                subasta.setEstado(EstadoSubasta.VENCIDA); // si esta vacia, esta vencida
            }
        }
    }

    /**
     *
     * @param Verifica si una subasta ha vencido o cancela o adjudicada y la bloquea para que no se pueda ofertar
     *                 Params:
     *                 subasta – Subasta a verificar
     * @return
     */
    public boolean subastaActiva(Subasta subasta) {

        if ((subasta.getFechaVencimiento().isBefore(LocalDateTime.now())) || subasta.getEstado() == EstadoSubasta.ADJUDICADA ||
                subasta.getEstado() == EstadoSubasta.CANCELADA) {
            return false;
        } else {
            return true;
        }
    }

    /***
     * Metodo para verificar si el usuario puede cancelar una subasta
     * @param Boolean
     */
    public Boolean puedeCancelarSubasta(Usuario moderador) { // Quién puede cancelar la subasta?

        if (moderador instanceof Moderador) { // Moderador no puede crear subastas
            return true; // es moderador puede cancelar la subasta
        } else {
            return false; // no es moderador, no puede cancelar la subasta
        }
    }

    /***
     * Metodo para cancelar una subasta
     * @param subasta
     */
    public void CancelarSubasta(Subasta subasta) {

        subasta.setEstado(EstadoSubasta.CANCELADA);
    }

    /***
     * Metodo que compara los datos que ingreso el usuario al iniciar sesión
     * con los de algun usuario registrado
     * @param correoElectronico
     * @param contrasena
     * @return
     */
    public Usuario inicarSesion(String correoElectronico, String contrasena) {

        for (Usuario u : data.listarUsuarios()) {
            if (u.getCorreoElectronico().equals(correoElectronico) && u.getContrasena().equals(contrasena)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Retorna la lista de usuarios registrados en el sistema.
     *
     * @return Lista de usuarios registrados
     */
    public ArrayList<Usuario> listarUsuarios() {
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
    /***
     * Metodo para listar las subastas
     * @return
     */
    public ArrayList<Subasta> listarSubastas() {
        return data.listarSubastas();
    }

    /***
     * Metodo para listar las ordenes
     * @return
     */

    public ArrayList<OrdenAdjudicacion> listarOrdenes() {
        return data.listarOrdenes();
    }

    public boolean probarConexion() {
        return data.probarConexion();
    }

    public void agregarCategoria(String nombre) {
        data.agregarCategoria(nombre);
    }

    public boolean esMayorDeEdad(Usuario usuario) {
        return usuario.calcularEdad() >= 18;
    }

    public void seleccionarComoModerador(int index) {
        Usuario u = data.listarUsuarios().get(index);
        if (u instanceof Coleccionista) {
            ((Coleccionista) u).setEsModerador(true);
        }
    }

    public ArrayList<Coleccionista> listarColeccionistasModeradores() {
        ArrayList<Coleccionista> moderadores = new ArrayList<>();
        for (Usuario u : data.listarUsuarios()) {
            if (u instanceof Coleccionista && ((Coleccionista) u).isEsModerador()) {
                moderadores.add((Coleccionista) u);
            }
        }
        return moderadores;
    }

    public Coleccionista asignarModeradorAleatorio() {
        ArrayList<Coleccionista> moderadores = new ArrayList<>();
        for (Usuario u : data.listarUsuarios()) {
            if (u instanceof Coleccionista && ((Coleccionista) u).isEsModerador()) {
                moderadores.add((Coleccionista) u);
            }
        }
        if (moderadores.isEmpty()) return null;
        int index = (int) (Math.random() * moderadores.size());
        return moderadores.get(index);
    }

    public void calificarUsuario(Usuario usuario, double calificacion) {
        if (usuario instanceof UsuarioMiembro) {
            ((UsuarioMiembro)usuario).setPuntuacion(calificacion);
        }
    }
}

