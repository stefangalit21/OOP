import java.time.LocalDateTime;
import java.time.Instant;
import java.time.ZoneOffset;
public class Snapshot {
    private LocalDateTime lastSnapshotTime;

    public Snapshot(){
        this.lastSnapshotTime = LocalDateTime.now();
    }
    public void update(){
        this.lastSnapshotTime = LocalDateTime.now();
    }
    public LocalDateTime getLastSnapshotTime() {
        return lastSnapshotTime;
    }
}
