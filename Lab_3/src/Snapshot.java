import java.time.LocalDateTime;

public class Snapshot {
    private LocalDateTime lastSnapshotTime;

    public Snapshot() {
        this.lastSnapshotTime = LocalDateTime.now();
    }

    public void update() {
        this.lastSnapshotTime = LocalDateTime.now();
    }

    public LocalDateTime getLastSnapshotTime() {
        return lastSnapshotTime;
    }
}
