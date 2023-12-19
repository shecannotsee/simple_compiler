package src.main.java.com.shecannotsee.common;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
public class ReadFromFile {
    public static String pathName(String filePath) {
        try {
            byte[] encodedBytes = Files.readAllBytes(Paths.get(filePath));
            return new String(encodedBytes);
        } catch (IOException e) {
            System.out.println("read file error:[" + filePath + "].Exception:" + e.getMessage());
            return null;
        }
    }
}
