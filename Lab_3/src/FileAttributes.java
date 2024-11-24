import java.io.File;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Instant;
import java.time.ZoneOffset;
public class FileAttributes {
    private String fileName;
    private Instant lastModified;
    private long size;

    public FileAttributes(File file) {
        this.fileName = file.getName();
        this.lastModified = Instant.ofEpochMilli(file.lastModified());
        this.size = file.length();
    }

    public String getFileName() {
        return fileName;
    }
    public Instant getLastModified() {
        return lastModified;
    }
    public long getSize() {
        return size;
    }
    public boolean isSameAs(FileAttributes other) {

        if (!this.fileName.equals(other.fileName)) {
            return false;
        }

        return this.size == other.size && this.lastModified.equals(other.lastModified);
    }

}
