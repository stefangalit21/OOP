import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Logger {
    private static final List<String> logs = new ArrayList<>();

    public static void log(String message) {
        logs.add(message);
        System.out.println("LOG: " + message);
    }

    public static List<String> getLogs() {
        return logs;
    }
}