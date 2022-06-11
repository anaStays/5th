import Interfaces.Inject_variant1;
import Interfaces.Inject_variant2;
import Realisations.Realization_variant1;
import Realisations.Realization_variant2;

/**
 * Класс с полями помеченными аннотацией AutoInjectable
 */
public class ExperimentalClass {
    @RefInjectable
    private Realization_variant1 field1;
    @RefInjectable
    private Realization_variant2 field2;
    public void test(){
        field1.test1();
        field2.test2();
    }
}
