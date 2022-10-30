package game.spaceinvaders.utils;

import java.net.URL;

public class FileUtils {

    public static String getImagePath(String fileName, Class clazz) {
        // get the fileName url, not working in JAR fileName.
        URL resource = clazz.getClassLoader().getResource("images/" + fileName);
        if (resource == null) {
            throw new IllegalArgumentException(String.format("file not found : %s", fileName));
        } else {
            return resource.getPath();
        }
    }
}
