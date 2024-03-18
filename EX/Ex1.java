package JavaIO.EX;

// import java.nio.Buffer;
import java.nio.file.*;
import java.io.IOException;
// import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex1 {
    public static void CreateFile(String NewFile) {
        try {
            File files = new File(NewFile);
            if (files.createNewFile()) {
                System.out.println("File created:" + files.getName());
            } else {
                System.out.println("File has exists");
            }
        }

        catch (IOException e) {
            System.err.println("Error");
        }
    }

    public static void SaveFile(String sources, String tagets) {
        try {
            Files.copy(Paths.get(sources), Paths.get(tagets), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File save succused");
        } catch (Exception e) {
            System.out.println("File have't been save");
        }
    }

    public static void Writes(String NewFile, String data) {
        try (BufferedWriter writes = new BufferedWriter(new FileWriter(NewFile))) {
            writes.write(data);
            System.out.println("Saved");
        } catch (Exception e) {
            System.err.println("Error");
        }
    }

    public static void Reads(String NewFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(NewFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.err.println(line);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static String Source(String NewFile) {
        return new File(NewFile).getAbsolutePath();
    }

    public static void deletes(String NewFile) {
        try {
            Files.deleteIfExists(Paths.get(NewFile));
            System.out.println("File have been delete");
        } catch (Exception e) {
            System.err.println("File hasn't been delete: " + e.getMessage());
        }
    }

    public static void Folder(String NewDirectory) {
        File files = new File(NewDirectory);
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("Directory has created");
            } else {
                System.err.println("Error!");
            }
        }
    }

    public static void main(String[] args) {
        String NewFile = "Test.txt";
        String NewDirectory = "Test_source_directory";
        String data = "Hello  Java!";
        String tagets = "Tagets.txt";

        CreateFile(NewFile);

        SaveFile(NewFile, tagets);

        Writes(NewFile, data);

        Reads(NewFile);

        System.out.println("Link: " + Source(NewFile));

        deletes(NewFile);

        Folder(NewDirectory);

    }
}
