import java.io.File;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.time.Instant;
import java.time.ZoneOffset;

public class FileMonitor {
    private File folder;
    private  Map<String, FileAttributes> snapshot;

    public FileMonitor(String folderPath){
        this.folder = new File(folderPath);
        snapshot = new HashMap<>();
        commit();
    }
    public void commit(){
        snapshot.clear();
        for(File file : folder.listFiles()){
            snapshot.put(file.getName(), new FileAttributes(file));
        }
        System.out.println("Snapshot updated, folder state is clean.");
    }

    public void info(String fileName){
        File file = new File(folder, fileName);
        if(file.exists()){
            FileInfoAnalyzer.displayGeneralInfo(file);
        } else
            System.out.println("File does not exist" + fileName);
    }

    public void status() {
        // Verificăm dacă folderul există și conține fișiere
        if (folder == null || !folder.exists()) {
            System.out.println("Folder not found.");
            return;
        }

        Map<String, FileAttributes> currentFiles = new HashMap<>();

        // Construim lista actuală de fișiere din folder
        for (File file : folder.listFiles()) {
            currentFiles.put(file.getName(), new FileAttributes(file));
        }


        for (String filename : currentFiles.keySet()) {
            if (!snapshot.containsKey(filename)) {
                System.out.println(filename + " is a new file.");
            } else if (!currentFiles.get(filename).isSameAs(snapshot.get(filename))) {
                System.out.println(filename + " has been modified.");
            } else {
                System.out.println(filename + " has not been modified.");
            }
        }

        for (String filename : snapshot.keySet()) {
            if (!currentFiles.containsKey(filename)) {
                System.out.println(filename + " has been deleted.");
            }
        }
    }

}
