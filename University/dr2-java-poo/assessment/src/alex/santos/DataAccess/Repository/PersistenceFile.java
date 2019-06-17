package alex.santos.DataAccess.Repository;

import java.io.*;
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
            System.out.println("DONE: abertura de leitura da base: "+file_db+"\n");
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("Erro: abertura de leitura da base: "+file_db+"\n");
            return false;
        }
    }

    public void closeReadConn() {

        if (readerDb != null) {
            readerDb.close();
        }
    }

    public List<String> readAll() {

        List<String> linhas = new ArrayList<>();
        try {

            while (readerDb.hasNext()) {
                linhas.add(readerDb.nextLine());
            }
            return linhas;
        }
        catch (Exception e) {
            System.out.println("Erro: na leitura da base: "+file_db+"\n");
        }
        return new ArrayList<>();
    }

    // WRITE    ---------------------------------
    public boolean openWriteConn() {
        try {
            File db = new File(fullPathFileDb);
            writerDb = new Formatter(db);
            System.out.println("DONE: abertura de gravação da base: "+file_db+"\n");
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("Erro: abertura de gravação da base: "+file_db+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void closeWriteConn()
    {
        if (writerDb != null) {
            writerDb.close();
        }
    }

    public void write(E item)
    {
        try {

            //TODO: metodo 'ToString' precisa estar criado na entidade.

            writerDb.format(item.toString());
            writerDb.format("\n");
        }
        catch (Exception e) {
            System.out.println("Erro: gravacao da base - item: "+item.toString()+"\n");
        }
    }

    // SAVE many
    public void writeMany(List<E> list)
    {
        //TODO: metodo 'ToString' precisa estar criado na entidade.

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fullPathFileDb, true)))
        {
            for (E item : list)
            {
                bw.write(item.toString());
                bw.newLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Erro: gravacao da base - item\n");
        }
    }

    public void cleanFile()
    {
        openWriteConn();
    }

    public enum TypeDb {
        airports_bd,
        cities_db,
        airplanes_db,
        helicopters_db,
        flights_db
    }
}
