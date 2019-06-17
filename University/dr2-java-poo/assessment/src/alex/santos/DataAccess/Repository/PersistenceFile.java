package alex.santos.DataAccess.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class PersistenceFile<E> {

    private String file_db;
    private String fullPathFileDb;
    Scanner readerDb;
    Formatter writerDb;

    private final String FILE_EXT = ".txt";
    private final String REPO_PATH = "\\src\\alex\\santos\\DataAccess\\Repository\\";
    private String workingDir = System.getProperty("user.dir");

    public PersistenceFile(TypeDb nameDb) {
        file_db = nameDb.toString();
        fullPathFileDb = workingDir+REPO_PATH+file_db+FILE_EXT;
        //openReadConn();
        //openWriteConn();
    }

    // READ  ----------------------------------------
    public boolean openReadConn() {
        try {
            readerDb = new Scanner(new File(fullPathFileDb));
            System.out.println("DONE: abertura de leitura da base: "+file_db);
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("Erro: abertura de leitura da base: "+file_db);
            return false;
        }
    }

    public void closeReadConn() {

        if (readerDb != null) {
            readerDb.close();
        }
    }

        // GetAll
    public List<String> readAll() {

        List<String> linhas = new ArrayList<>();
        try {

            while (readerDb.hasNext()) {
                linhas.add(readerDb.nextLine());
            }
            return linhas;
        }
        catch (Exception e) {
            System.out.println("Erro: na leitura da base: "+file_db);
        }
        return new ArrayList<>();
    }

    // WRITE    ---------------------------------
    public boolean openWriteConn() {
        try {
            writerDb = new Formatter(new File(fullPathFileDb));
            System.out.println("DONE: abertura de gravação da base: "+file_db);
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("Erro: abertura de gravação da base: "+file_db);
            return false;
        }
    }

    public void closeWriteConn() {

        if (writerDb != null) {
            writerDb.close();
        }
    }

    // Save
    public void write(E item)
    {
        try {

            //TODO: metodo 'ToString' precisa estar criado na entidade.

            writerDb.format(item.toString());
            writerDb.format("\n");
        }
        catch (Exception e) {
            System.out.println("Erro: gravacao da arquivo. Obj: "+item.toString());
        }

    }
        // SAVE many
    public void write(ArrayList<E> list) {   //public void write(ArrayList<? extends 'Interface'> objList) {

        for (E item : list) {
            try {

                //TODO: metodo 'ToString' precisa estar criado na entidade.

                writerDb.format(item.toString());
                writerDb.format("\n");
            }
            catch (Exception e) {
                System.out.println("Erro: gravacao do arquivo");
            }
        }
    }

    public enum TypeDb {
        airports_bd,
        cities_db,
        airplanes_db,
        helicopters_db,
        flights_db
    }
}
