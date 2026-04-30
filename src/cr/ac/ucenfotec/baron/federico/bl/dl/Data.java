package cr.ac.ucenfotec.baron.federico.bl.dl;


import cr.ac.ucenfotec.baron.federico.bl.entities.*;
import cr.ac.ucenfotec.baron.federico.bl.entities.usuario.*;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 * Atributos de la clase Data
 */
public class Data {

    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Subasta> listaSubastas;
    private ArrayList<Oferta> listaOfertas;
    private ArrayList<OrdenAdjudicacion> listaOrdenes;
    private ArrayList<String> listaCategorias;


    /**
     * Constructor por defecto, inicializa las listas vacías.
     */
    public Data() {

        this.listaUsuarios = new ArrayList<>();
        this.listaSubastas = new ArrayList<>();
        this.listaOfertas = new ArrayList<>();
        this.listaOrdenes = new ArrayList<>();
        this.listaCategorias = new ArrayList<>();
        cargarUsuarios();
        cargarSubastas();
    }

    /**
     * Agrega el usuario a la lista de usuarios
     *
     * @param usuario el usuario
     */
    public void agregarUsuario(Usuario usuario) {

        try {
            Connection conn = Conexion.getConexion();
            String tipo = "";
            if (usuario instanceof Moderador) tipo = "MODERADOR";
            else if (usuario instanceof Vendedor) tipo = "VENDEDOR";
            else if (usuario instanceof Coleccionista) tipo = "COLECCIONISTA";

            String sql = "INSERT INTO usuarios (id, nombre, contrasena, correoElectronico, " +
                    "fechaNacimiento, tipo, puntuacion, direccion, activo) VALUES (" +
                    usuario.getId() + ",'" +
                    usuario.getNombre() + "','" +
                    usuario.getContrasena() + "','" +
                    usuario.getCorreoElectronico() + "','" +
                    usuario.getFechaNacimiento() + "','" +
                    tipo + "'," +
                    (usuario instanceof UsuarioMiembro ? ((UsuarioMiembro)usuario).getPuntuacion() : 0) + ",'" +
                    (usuario instanceof UsuarioMiembro ? ((UsuarioMiembro)usuario).getDireccion() : "") + "'," +
                    true + ")";

            conn.createStatement().execute(sql);
            listaUsuarios.add(usuario);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    /**
     * Agrega la subasta a la lista de subastas
     *
     * @param subasta la subasta
     */
    public void agregarSubastas(Subasta subasta) {
        try {
            Connection conn = Conexion.getConexion();
            String sql = "INSERT INTO subastas (fechaVencimiento, precioMinimo, estado, idCreador) VALUES ('" +
                    subasta.getFechaVencimiento() + "','" +
                    subasta.getPrecioMinimo() + "','" +
                    subasta.getEstado() + "'," +
                    subasta.getCreador().getId() + ")";
            conn.createStatement().execute(sql);
            listaSubastas.add(subasta);
        } catch (Exception ex) {
            System.out.println("Error guardando subasta: " + ex.getMessage());
        }
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

    public boolean probarConexion() {
        Connection conn = Conexion.getConexion();
        if (conn != null) {
            System.out.println("Conexión exitosa!");
            return true;
        } else {
            System.out.println("Error de conexión");
            return false;
        }
    }

    public void cargarUsuarios() {
        try {
            Connection conn = Conexion.getConexion();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                String tipo = rs.getString("tipo");
                String nombre = rs.getString("nombre");
                int id = rs.getInt("id");
                String contrasena = rs.getString("contrasena");
                String correo = rs.getString("correoElectronico");
                LocalDate fecha = rs.getDate("fechaNacimiento").toLocalDate();
                double puntuacion = rs.getDouble("puntuacion");
                String direccion = rs.getString("direccion");

                if (tipo.equals("MODERADOR")) {
                    listaUsuarios.add(new Moderador(nombre, id, contrasena, correo, fecha));
                } else if (tipo.equals("VENDEDOR")) {
                    listaUsuarios.add(new Vendedor(nombre, id, contrasena, correo, fecha, puntuacion, direccion));
                } else if (tipo.equals("COLECCIONISTA")) {
                    listaUsuarios.add(new Coleccionista(nombre, id, contrasena, correo, fecha, puntuacion, direccion));
                }
            }
        } catch (Exception ex) {
            System.out.println("Error cargando usuarios: " + ex.getMessage());
        }
    }

    public void cargarSubastas() {
        try {
            Connection conn = Conexion.getConexion();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM subastas");
            while (rs.next()) {
                LocalDateTime fecha = rs.getTimestamp("fechaVencimiento").toLocalDateTime();
                double precioMinimo = rs.getDouble("precioMinimo");
                String estado = rs.getString("estado");
                int idCreador = rs.getInt("idCreador");

                Usuario creador = null;
                for (Usuario u : listaUsuarios) {
                    if (u.getId() == idCreador) {
                        creador = u;
                        break;
                    }
                }

                if (creador != null) {
                    Subasta subasta = new Subasta(fecha, creador, precioMinimo);
                    subasta.setEstado(EstadoSubasta.valueOf(estado));
                    listaSubastas.add(subasta);
                }
            }
        } catch (Exception ex) {
            System.out.println("Error cargando subastas: " + ex.getMessage());
        }
    }


    public void agregarCategoria(String nombre) {
        listaCategorias.add(nombre);
    }
}