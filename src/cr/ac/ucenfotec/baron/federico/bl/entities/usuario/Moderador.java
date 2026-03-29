package cr.ac.ucenfotec.baron.federico.bl.entities.usuario;

import java.time.LocalDate;

/***
 * Clase hija de Usuario
 */
public class Moderador extends Usuario{

    public Moderador() {
        super();
    }

    /***
     *
     * @param nombre
     * @param id
     * @param contrasena
     * @param correoElectronico
     * @param fechaNacimiento
     */
    public Moderador(String nombre, int id, String contrasena, String correoElectronico,
                          LocalDate fechaNacimiento) {

        super(nombre, id, contrasena, correoElectronico, fechaNacimiento);

    }
    /***
     * Metodo toString
     * @return
     */
    @Override
    public String toString() {
        return "----- Moderador -----\n" + super.toString();
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
