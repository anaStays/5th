import java.lang.String;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Injector injector = new Injector();
        ExperimentalClass exp = new ExperimentalClass();
        injector.inject(exp);
        exp.test();
    }
}
