package example.danny.com.sql;

/**
 * Created by DArica on 21/10/2015.
 */
public class SqlConstants {
    public static final String DB_NAME = "articulos.db";
    public static final int DB_VERSION = 1;

    public static final String SQLCommandCreateTableArticulos = "CREATE TABLE tblItem(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,titulo TEXT, descripcion TEXT, rango TEXT)";
    public static final String SQLCommandCreateTableImagenes = "CREATE TABLE tblImage(titulo TEXT, url TEXT)";
    public static final String SQLCommandDropTableArticulos = "DROP TABLE tblItem";
    public static final String SQLCommandDropTableImagenes = "DROP TABLE tblImage";
}
