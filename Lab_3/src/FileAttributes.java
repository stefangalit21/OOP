import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttributes {
    private long fileSize;
    private long lastModified;

    public FileAttributes(File file) {
        try {
            BasicFileAttributes attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            this.fileSize = attrs.size();
            this.lastModified = attrs.lastModifiedTime().toMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isSameAs(FileAttributes other) {
        return this.fileSize == other.fileSize && this.lastModified == other.lastModified;
    }
}
