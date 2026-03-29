package cr.ac.ucenfotec.baron.federico.bl.entities.usuario;

import cr.ac.ucenfotec.baron.federico.bl.entities.Objeto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/***
 * Clase hihja de Usuario miembro
 */
public class Coleccionista extends UsuarioMiembro {

    private ArrayList <String> listaIntereses;
    private ArrayList <Objeto> listaObjetos;

    public Coleccionista() {
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
    public Coleccionista(String nombre, int id, String contrasena, String correoElectronico, LocalDate fechaNacimiento, Double puntuacion,
                         String direccion) {
        super(nombre, id, contrasena, correoElectronico, fechaNacimiento, puntuacion, direccion);

        this.listaIntereses = new ArrayList<>();
        this.listaObjetos = new ArrayList<>();
    }

    /***
     * getters y setters de los atributos de la clase coleccionista
     * @return
     */
    public ArrayList<String> getListaIntereses() {
        return listaIntereses;
    }

    public void setListaIntereses(ArrayList<String> listaIntereses) {
        this.listaIntereses = listaIntereses;
    }

    public ArrayList<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(ArrayList<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    /***
     * Metodo toString
     * @return
     */
    @Override
    public String toString() {
        return "----- Coleccionista -----\n" + super.toString() + "\n" +
                "Intereses: " + listaIntereses + "\n" +
                "Objetos: " + listaObjetos;
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
