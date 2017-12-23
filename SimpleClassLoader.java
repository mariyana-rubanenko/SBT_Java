import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by user on 10.11.2017.
 */
public class SimpleClassLoader extends ClassLoader {
    private String classDirectoryPath;

    public SimpleClassLoader(String classDirectoryPath) {
        this.classDirectoryPath = classDirectoryPath;
    }

    @Override
    protected Class<?> findClass(final String name) throws ClassNotFoundException {
        String pathString = name.replace('.', '/') + ".class";
        pathString = this.classDirectoryPath + "/" + pathString;

        Path path = Paths.get(pathString);
        Class<?> clazz = null;
        try {
            byte[] bytes = Files.readAllBytes(path);
            if (bytes.length != 0) {
                clazz = defineClass(name, bytes, 0, bytes.length);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return clazz;
    }
}
