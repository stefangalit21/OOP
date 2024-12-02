import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;

public class FileInfoAnalyzer {
    private static final List<String> photoExtensions = new ArrayList<>() {{
        add(".jpg");
        add(".png");
        add(".jpeg");
    }};
    private static final List<String> textExtensions = new ArrayList<>() {{
        add(".txt");
    }};
    private static final List<String> codeExtensions = new ArrayList<>() {{
        add(".py");
        add(".java");
        add(".c");
        add(".cpp");
        add(".cs");
        add(".js");
        add(".php");
        add(".pas");
        add(".asm");
    }};

    public static void displayGeneralInfo(File file) {
        try {
            BasicFileAttributes attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            String fileName = file.getName();
            System.out.println("File name: " + fileName);
            System.out.println("Extension:" + getFileExtension(fileName));
            System.out.println("Creation time: " + attrs.creationTime());
            System.out.println("Last modified time: " + attrs.lastModifiedTime());

            if (isExtension(photoExtensions, fileName)) {
                displayImageInfo(file);
            } else if (isExtension(textExtensions, fileName)) {
                displayTextFileInfo(file);
            } else if (isExtension(codeExtensions, fileName)) {
                displayCodeFileInfo(file);
            }
        } catch (IOException e) {
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

            System.out.println("Text File Info: ");
            System.out.println("Line count: " + lineCount);
            System.out.println("Word count: " + wordCount);
            System.out.println("Character count: " + charCount);
        } catch (IOException e) {
            System.out.println("Unable to read text file");
        }
    }

    private static void displayCodeFileInfo(File file) {
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            int lineCount = lines.size();
            int commentCount = 0;

            for (String line : lines) {
                if (line.trim().startsWith("//") || line.trim().startsWith("/*") || line.trim().startsWith("*")) {
                    commentCount++;
                }
            }

            System.out.println("Code File Info: ");
            System.out.println("Line count: " + lineCount);
            System.out.println("Comment count: " + commentCount);
        } catch (IOException e) {
            System.out.println("Unable to read code file");
        }
    }

    private static boolean isExtension(List<String> extensions, String fileName) {
        for (String extension : extensions) {
            if (fileName.endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}
