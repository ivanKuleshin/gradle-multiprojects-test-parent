import org.example.ServiceClass;
import org.example.StringPrinter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTestCase {

    @Test
    public void test1() {
        ServiceClass serviceClass = new ServiceClass("TEST");
        assertThat(serviceClass.serviceClassFieldName).isEqualTo("TEST");
    }

    @Test
    public void test2() {
        StringPrinter.printString("TEST");
    }
}
