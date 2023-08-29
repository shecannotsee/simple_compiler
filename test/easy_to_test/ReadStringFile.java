package test.easy_to_test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class ReadStringFile {
    public static String readStringFromFile(String filePath) {
        try {
            byte[] encodedBytes = Files.readAllBytes(Paths.get(filePath));
            return new String(encodedBytes);
        } catch (IOException e) {
            System.out.println("read file error:[" + filePath + "].Exception:" + e.getMessage());
            return null;
        }
    }
}
