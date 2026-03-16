package cr.ac.ucenfotec.baron.federico.bl.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Usuario {

    /** Nombre completo del usuario */
    private String nombre;
    /** id  del usuario */
    private int id;
    /** contraseña del usuario */
    private String contrasena;
    /** correo electronico del usuario */
    private String correoElectronico;
    /** puntuacion del usuario */
    private double puntuacion;
    /** dirección del usuario */
    private String direccion;
    /** lista de intereses del usuario */
    private ArrayList<String> listaIntereses;
    /** lista de objetos usuario */
    private ArrayList<Objeto> listaObjetos;
    /** tipo del usuario */
    private TipoUsuario tipo;
    /** fecha de nacimiento del usuario */
    private LocalDate fechaNacimiento;


    /**
     * constructor vacio
     */
    public Usuario() {
    }


    /**
     * constructor con parametros para crear un usuario
     *
     * @param nombre            nombre completo del usuario
     * @param id                id idetidicación del usuario
     * @param contrasena        contrasena contraseña del usuario
     * @param correoElectronico correo electronico del usuario
     * @param puntuacion        puntuacion del usaurio
     * @param direccion         direccion del usaurio
     * @param tipo              tipo de usuario
     * @param fechaNacimiento   fecha de nacimiento del usuario
     */
    public Usuario(String nombre, int id, String contrasena, String correoElectronico, double puntuacion, String direccion, TipoUsuario tipo, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.id = id;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.puntuacion = puntuacion;
        this.direccion = direccion;
        this.tipo = tipo;
        this.fechaNacimiento = fechaNacimiento;
        this.listaIntereses = new ArrayList<>();
        this.listaObjetos = new ArrayList<>();
    }

    /**
     * El metodo hace un calculo entre la fecha de nacimiento del usuario y la fecha actual
     * y hace el calculo de sus edad.
     *
     * @return retorna la edad del usuario, unicamente en el formato de años.
     */
    public int calcularEdad() {

        Period p = Period.between(fechaNacimiento, LocalDate.now());
        return p.getYears();

    }
    /**
     * Retorna el nombre del usuario
     * @return nombre del usuario
     */
        public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del usuario
     * @param nombre nombre del usuario
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
    * Retorna el id del usuario
    * @return id del usuario
    */
    public int getId() {
        return id;
    }

    /**
     * Asigna el id del usuario
     * @param id nombre del usuario
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna la contraseña del usuario
     * @return contraseña del usuario
     */

    public String getContrasena() {
        return contrasena;
    }

    /**
     * Asigna el contrasena del usuario
     * @param contrasena nombre del usuario
     */

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Retorna la correoElectronico del usuario
     * @return contraseña del usuario
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    /**
     * Asigna el correo electronico del usuario
     * @param correoElectronico nombre del usuario
     */

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    /**
     * Retorna la puntuacion del usuario
     * @return puntuacion del usuario
     */

    public double getPuntuacion() {
        return puntuacion;
    }

    /**
     * Asigna la puntuacion del usuario
     * @param puntuacion nombre del usuario
     */

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * Retorna la dirección del usuario
     * @return dirección del usuario
     */

    public String getDireccion() {
        return direccion;
    }

    /**
     * Asigna el id del usuario
     * @param direccion nombre del usuario
     */

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Retorna el lista de intereses del usuario
     * @return lista de intereses del usuario
     */
    public ArrayList<String> getListaIntereses() {
        return listaIntereses;
    }

    /**
     * Asigna la lista de interes del usuario del usuario
     * @param listaIntereses  del usuario
     */

    public void setListaIntereses(ArrayList<String> listaIntereses) {
        this.listaIntereses = listaIntereses;
    }

    /**
     * Retorna el lista de objetos del usuario
     * @return lista de objetos del usuario
     */

    public ArrayList<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    /**
     * Asigna la lista de objetos del usuario
     * @param listaObjetos  del usuario
     */

    public void setListaObjetos(ArrayList<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }
    /**
     * Retorna el tipo del usuario
     * @return el tipo del usuario
     */
    public TipoUsuario getTipo() {
        return tipo;
    }

    /**
     * Asigna el tipo del usuario
     * @param tipo nombre del usuario
     */

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
    /**
     * Retorna la fecha de nacimiento del usuario
     * @return la fecha de nacimiento del usuario
     */

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    /**
     * Asigna la fecha de nacimiento del usuario
     * @param fechaNacimiento nombre del usuario
     */

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    /**
     * Retorna una representación en texto del objeto Usuario
     * @return String con los datos del usuario
     */

    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", contrasena='" + contrasena + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", puntuacion=" + puntuacion +
                ", direccion='" + direccion + '\'' +
                ", listaIntereses=" + listaIntereses +
                ", listaObjetos=" + listaObjetos +
                ", tipo=" + tipo +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
