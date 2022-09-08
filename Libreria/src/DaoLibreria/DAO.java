package DaoLibreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    protected Connection conexion = null;  // SE HEREDA A OTRAS CLASES
    protected ResultSet resultado = null; // SE HEREDA A OTRAS CLASES
    protected Statement sentencia = null; //  HEREDA A OTRAS CLASES

    private final String USER = "root";  // SE HEREDA A OTRAS CLASES
    private final String PASSWORD = "root";  // SE HEREDA A OTRAS CLASES
    private final String DATABASE = "LibreriaPU"; // SE HEREDA A OTRAS CLASES
    private final String DRIVER = "com.mysql.jdbc.Driver"; //SE HEREDA A OTRAS CLASES

    // METODO CONECTAR BASE DE DATOS
    protected void conectarBase() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    // DESCONECTAR Y/O MATAR TODAS LAS CONEXIONES , SENTENCIAS Y RESULTADOS
    protected void desconectarBase() throws Exception {

        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    // ME CONECTARIA A LA BASE DE DATOS Y EJECUTA LA SENTENCIA 
    //QUE IMPACTA EN LA BASE DE DATOS Y SE DESCONECTA  
    

    // SE CONECTA, EJECUTA LA SENTENCIA Y GUARDA LOS RESULTADOS 
    //EN LA VAR "RESULTADO" 
    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();  // me conecto a la base de datos
            sentencia = conexion.createStatement(); // preparo una sentencia
            resultado = sentencia.executeQuery(sql); // albergo  el producto 
            //de la consulta(ejem todas las mascotas)

        } catch (Exception ex) {
            throw ex;
        }
    }
}
