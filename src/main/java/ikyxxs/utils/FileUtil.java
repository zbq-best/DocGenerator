package ikyxxs.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

    public static void write(String fileName, String content) {

        FileOutputStream out = null;

        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new FileOutputStream(file, false);
            out.write(content.getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
