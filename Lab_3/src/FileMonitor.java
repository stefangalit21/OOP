import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileMonitor {
    private String folderPath;
    private List<Map<String, FileAttributes>> history;

    public FileMonitor(String folderPath) {
        this.folderPath = folderPath;
        this.history = new ArrayList<>();
    }

    public void commit() {
        Map<String, FileAttributes> snapshot = new HashMap<>();

        String commitFolder = folderPath + "commits/commit_" + history.size();
        File commitDir = new File(commitFolder);
        if (!commitDir.exists()) {
            commitDir.mkdirs();
        }

        File folder = new File(folderPath);
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                FileAttributes fileAttributes = new FileAttributes(file);
                snapshot.put(file.getName(), fileAttributes);

                try {
                    Files.copy(file.toPath(), Paths.get(commitFolder + "/" + file.getName()), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        history.add(snapshot);
        System.out.println("Commit successful. Commit number: " + (history.size() - 1));
    }

    public void checkout(int commitNumber) {
        if (commitNumber < 0 || commitNumber >= history.size()) {
            System.out.println("Invalid commit number.");
            return;
        }

        Map<String, FileAttributes> selectedSnapshot = history.get(commitNumber);
        File folder = new File(folderPath);

        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isFile()) {
                file.delete();
            }
        }

        String commitFolder = folderPath + "commits/commit_" + commitNumber;
        for (String fileName : selectedSnapshot.keySet()) {
            File sourceFile = new File(commitFolder + "/" + fileName);
            File targetFile = new File(folderPath + fileName);
            try {
                Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println("Error restoring file: " + fileName);
            }
        }
        System.out.println("Checked out to commit " + commitNumber);
    }

    public void status() {
        File folder = new File(folderPath);
        Map<String, FileAttributes> currentFiles = new HashMap<>();
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                currentFiles.put(file.getName(), new FileAttributes(file));
            }
        }

        if (!history.isEmpty()) {
            Map<String, FileAttributes> lastCommitSnapshot = history.get(history.size() - 1);
            for (String fileName : currentFiles.keySet()) {
                FileAttributes currentAttributes = currentFiles.get(fileName);
                if (lastCommitSnapshot.containsKey(fileName)) {
                    FileAttributes lastAttributes = lastCommitSnapshot.get(fileName);
                    if (currentAttributes.isSameAs(lastAttributes)) {
                        System.out.println(fileName + " has not changed.");
                    } else {
                        System.out.println(fileName + " has been modified.");
                    }
                } else {
                    System.out.println(fileName + " is a new file.");
                }
            }

            for (String fileName : lastCommitSnapshot.keySet()) {
                if (!currentFiles.containsKey(fileName)) {
                    System.out.println(fileName + " was deleted.");
                }
            }
        } else {
            System.out.println("No commits yet.");
        }
    }

    public void info(String fileName) {
        File file = new File(folderPath + fileName);
        if (file.exists()) {
            FileInfoAnalyzer.displayGeneralInfo(file);
        } else {
            System.out.println("File " + fileName + " does not exist.");
        }
    }
}