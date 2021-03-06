import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * class for injecting
 */
public class Injector {

    public Injector(){
        try{
            fileReader = new FileReader("src/main/resources/injection.properties");
            properties.load(fileReader);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * initialize field for class
     * @param object - instance of provided class
     */
    public <T> void inject(T object) throws IllegalAccessException, InstantiationException {
        Class objectClass = object.getClass();

        Field[] fields = objectClass.getDeclaredFields();

        for(Field field: fields){
            Annotation fAnnotation = field.getAnnotation(RefInjectable.class);

            if(fAnnotation!=null){
                field.setAccessible(true);
                Class aClass=null;

                try{
                    String t = (String) properties.get(field.getType().getTypeName());
                    aClass = Class.forName(t);
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }

                field.set(object,aClass.newInstance());
            }
        }
    }

    FileReader fileReader = null;
    Properties properties = new Properties();
}
