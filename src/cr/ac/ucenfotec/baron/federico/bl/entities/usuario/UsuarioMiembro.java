package cr.ac.ucenfotec.baron.federico.bl.entities.usuario;

import java.time.LocalDate;


/***
 * Clase hoja de Usuario
 *
 */
public class UsuarioMiembro extends Usuario {

    private Double puntuacion;
    private String direccion;



    public UsuarioMiembro() {
        super();
    }

    /***
     *
     * @param nombre
     * @param id
     * @param contrasena
     * @param correoElectronico
     * @param fechaNacimiento
     * @param puntuacion
     * @param direccion
     */
    public UsuarioMiembro(String nombre, int id, String contrasena, String correoElectronico,
                          LocalDate fechaNacimiento, Double puntuacion, String direccion) {

        super(nombre, id, contrasena, correoElectronico, fechaNacimiento);
        this.puntuacion = puntuacion;
        this.direccion = direccion;
    }

    /***
     * Getters y setters de los atributos propios de la clase
     * @return
     */
    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /***
     * Metodo toString
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Puntuación: " + puntuacion + "\n" +
                "Dirección: " + direccion;
    }
    /***
     * Metodo equals
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }
}
