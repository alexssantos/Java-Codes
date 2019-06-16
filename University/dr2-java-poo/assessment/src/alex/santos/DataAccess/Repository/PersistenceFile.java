package alex.santos.DataAccess.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class PersistenceFile<E> {
    private String file_db;
    Scanner readerDb;
    Formatter writerDb;

    public PersistenceFile(TypeDb nameDb) {
        file_db = nameDb.toString();
        openReadConn();
        openWriteConn();
    }

    // READ  ----------------------------------------
    public void openReadConn() {
        try {
            readerDb = new Scanner(new File(file_db));
            System.out.println("DONE: abertura de leitura da base: "+file_db);
        }
        catch (FileNotFoundException e) {
            System.out.println("Erro: abertura de leitura da base: "+file_db);
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
    public void openWriteConn() {
        try {
            writerDb = new Formatter(new File(file_db));
            System.out.println("DONE: abertura de gravação da base: "+file_db);
        }
        catch (FileNotFoundException e) {
            System.out.println("Erro: abertura de gravação da base: "+file_db);
        }
    }

    public void closeWriteConn() {

        if (writerDb != null) {
            writerDb.close();
        }
    }

    // Save
    public void write(E obj)
    {
        try {

            //TODO: metodo 'ToString' precisa estar criado na entidade.

            writerDb.format(obj.toString());
            writerDb.format("\n");
        }
        catch (Exception e) {
            System.out.println("Erro: gravacao da arquivo");
        }

    }
        // SAVE many
    public void write(ArrayList<E> objsList) {   //public void write(ArrayList<? extends 'Interface'> objList) {

        for (E obj : objsList) {
            try {

                //TODO: metodo 'ToString' precisa estar criado na entidade.

                writerDb.format(obj.toString());
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
        machines_db,
        flights_db
    }
}
