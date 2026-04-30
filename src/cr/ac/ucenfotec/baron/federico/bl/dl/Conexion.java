package cr.ac.ucenfotec.baron.federico.bl.dl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexion {

    public static Connection getConexion() {
        Connection conn = null;

        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("config.txt");
            props.load(fis);

            String url = props.getProperty("url");
            String usuario = props.getProperty("usuario");
            String contrasena = props.getProperty("contrasena");

            conn = DriverManager.getConnection(url, usuario, contrasena);

        } catch (Exception ex) {
            System.out.println("Error conexión: " + ex.getMessage());
        }
        return conn;
        }
    }
