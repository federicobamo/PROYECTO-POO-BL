package cr.ac.ucenfotec.baron.federico.bl.entities.usuario;

import java.time.LocalDate;

/***
 * Clase hija de UsuarioMiembro
 */
public class Vendedor extends UsuarioMiembro{

    public Vendedor() {
        super ();

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
    public Vendedor(String nombre, int id, String contrasena, String correoElectronico, LocalDate fechaNacimiento, Double puntuacion, String direccion) {
        super(nombre, id, contrasena, correoElectronico, fechaNacimiento, puntuacion, direccion);
    }
    /***
     * Metodo tostring
     * @return
     */
    @Override
    public String toString() {
        return "----- Vendedor -----\n" + super.toString();
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
