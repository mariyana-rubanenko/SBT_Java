/**
 * Created by user on 10.11.2017.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader("C:/Users/Дмитрий/Music/ClassLoader2/out/production/ClassLoader2");
        simpleClassLoader.findClass("ru.sbt.Person");
        simpleClassLoader.findClass("Lesson");
    }
}
