import org.example.ServiceClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainServiceTestCase {

    @Test
    public void test1() {
        ServiceClass serviceClass = new ServiceClass("TEST");
        Assertions.assertEquals(serviceClass.serviceClassFieldName, "TEST");
    }
}
