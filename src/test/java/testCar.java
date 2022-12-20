import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class testCar {
    Car car;

    @BeforeEach
    public void beforeEach() {
        car = new Car();
    }

    @BeforeAll
    public static void startTest() {
        System.out.println("Car test started");
    }

    @AfterAll
    public static void endTest() {
        System.out.println("Car test completed");
    }

    @ParameterizedTest
    @MethodSource("sourceWithoutExcp")
    public void testCarWithParams(Integer d, Integer f, boolean expected) {
        boolean result = car.moveTo(d, f);
        Assertions.assertEquals(result, expected);
    }

    public static Stream<Arguments> sourceWithoutExcp() {
        return Stream.of(Arguments.of(5, 20, true),
                Arguments.of(10000, 50, false));
    }

    @Test
    public void testCarExcp() {
        Class<ArithmeticException> arithmeticExceptionClass = ArithmeticException.class;
        Executable executable = () -> car.moveTo(10_000, -5);
        Assertions.assertThrows(arithmeticExceptionClass, executable);
    }
}
