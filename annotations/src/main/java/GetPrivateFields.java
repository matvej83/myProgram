import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.lang.reflect.Field;


public class GetPrivateFields {

    public static void main(String[] args) throws URISyntaxException {
        //getting array of fields values from a file
        Properties props = new Properties();
        Path proppath = Paths.get(GetPrivateFields.class.getResource("app.properties.txt").toURI());
        try (FileInputStream fs = new FileInputStream(new File(proppath.toString()))) {
            props.load(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //getting information about class fields
        try {
            Class<?> ReflectClass = Class.forName("AppProperties");
            Field[] declaredFields = ReflectClass.getDeclaredFields();
            Constructor constructor = ReflectClass.getConstructor();
            Object instance = constructor.newInstance();
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(PropertyKeys.PropertyKey.class) && field.trySetAccessible()) {
                    if (props.containsKey(field.getName())) {
                        setField(field, instance, props.getProperty(field.getName()));
                        System.out.println(field.getName() + " - " + getField(field, instance));
                    }
                }
            }
        } catch (ClassNotFoundException |
                IllegalAccessException |
                NoSuchMethodException |
                InstantiationException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static Object getField(Field field, Object someClass) throws IllegalAccessException, NullPointerException {
        Object result = null;
        if (field.getType().equals(Double.class) || field.getType().equals(double.class)) {
            result = field.getDouble(someClass);
        } else if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {
            result = field.getInt(someClass);
        } else if (field.getType().equals(Long.class) || field.getType().equals(long.class)) {
            result = field.getLong(someClass);
        } else if (field.getType().equals(String.class)) {
            result = field.get(someClass);
        }
        return result;
    }

    public static void setField(Field field, Object someClass, Object value) throws IllegalAccessException {
        if (field.getType().equals(Double.class) || field.getType().equals(double.class)) {
            field.setDouble(someClass, Double.parseDouble(value.toString()));
        } else if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {
            field.setInt(someClass, (Integer) value);
        } else if (field.getType().equals(Long.class) || field.getType().equals(long.class)) {
            field.setLong(someClass, (Long) value);
        } else if (field.getType().equals(String.class)) {
            field.set(someClass, value.toString());
        }
    }
}
