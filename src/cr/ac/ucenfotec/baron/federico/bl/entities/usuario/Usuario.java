package cr.ac.ucenfotec.baron.federico.bl.entities.usuario;

import cr.ac.ucenfotec.baron.federico.bl.entities.Objeto;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;

public class Usuario {

    /** Nombre completo del usuario */
    protected String nombre;
    /** id  del usuario */
    protected int id;
    /** contraseña del usuario */
    protected String contrasena;
    /** correo electronico del usuario */
    protected String correoElectronico;

    /** fecha de nacimiento del usuario */
    protected LocalDate fechaNacimiento;

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
     * @param fechaNacimiento   fecha de nacimiento del usuario
     */
    public Usuario(String nombre, int id, String contrasena, String correoElectronico, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.id = id;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * El metodo hace un calculo entre la fecha de nacimiento del usuario y la fecha actual
     * y hace el calculo de sus edad.
     *
     * @return retorna la edad del usuario, unicamente en el formato de años.
     */
    public int calcularEdad() {

        Period p = Period.between(fechaNacimiento, LocalDate.now());
        return p.getYears(); // Metodo para obtner unicamente los añoa

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

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "ID: " + id + "\n" +
                "Correo: " + correoElectronico + "\n" +
                "Fecha Nacimiento: " + fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
