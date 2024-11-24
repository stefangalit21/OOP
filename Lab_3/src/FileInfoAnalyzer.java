import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import javax.imageio.ImageIO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FileInfoAnalyzer {
    public static void displayGeneralInfo(File file) {
        try {
            BasicFileAttributes attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            String fileName = file.getName();
            System.out.println("File name: " + fileName);
            System.out.println("Extension:" + getFileExtension(fileName));
            System.out.println("Creation time: " + attrs.creationTime());
            System.out.println("Last modified time: " + attrs.lastModifiedTime());

            if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
                displayImageInfo(file);
            } else if (fileName.endsWith(".txt")) {
                displayTextFileInfo(file);
            } else if (fileName.endsWith(".py") || fileName.endsWith(".java")) {
                displayCodeFileInfo(file);
            }
        } catch (IOException e){
            System.out.println("Unable to read file attributes");
        }
    }
    private static String getFileExtension(String fileName) {
        int index = fileName.lastIndexOf('.');
        return (index > 0) ? fileName.substring(index + 1) : "";
    }

    private static void displayImageInfo(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            System.out.println("Image width: " + image.getWidth());
            System.out.println("Image height: " + image.getHeight());
        } catch (IOException e) {
            System.out.println("Unable to read image");
        }
    }
    private static void displayTextFileInfo(File file) {
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            int lineCount = lines.size();
            int wordCount = 0;
            int charCount = 0;

            for (String line : lines) {
            wordCount += line.split("\\s+").length;
            charCount += line.length();
            }

            System.out.println("Text File Info");
            System.out.println("Line count: " + lineCount);
            System.out.println("Word count: " + wordCount);
            System.out.println("Character count: " + charCount);

        } catch (IOException e) {
            System.out.println("Unable to read text file" + e.getMessage());
        }
    }

    private static void displayCodeFileInfo(File file) {
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            int lineCount = lines.size();
            int classCount = 0;
            int methodCount = 0;

            Pattern classPatern = Pattern.compile("\\bclass\\b");
            Pattern methodPattern = Pattern.compile("\\b(public|private|protected|def)\\s+\\w+\\s*\\(");
            for (String line : lines) {
               if (classPatern.matcher(line).find()) {
                   classCount++;
               }
               if (methodPattern.matcher(line).find()) {
                   methodCount++;
               }
        }
            System.out.println("Code File Info");
            System.out.println("Line count: " + lineCount);
            System.out.println("Class count: " + classCount);
            System.out.println("Method count: " + methodCount);

        } catch (IOException e) {
            System.out.println("Unable to read code file" + e.getMessage());
        }
    }
}
