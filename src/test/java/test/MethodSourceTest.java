package test;

import com.github.javafaker.Faker;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class MethodSourceTest {
    static Faker faker = new Faker();

    static Stream<Arguments> methodProvide() {
        return Stream.of(
                Arguments.of("Первый массив данных", List.of(faker.number().randomNumber(), faker.number().randomNumber()
                        , faker.number().randomNumber(),faker.number().randomNumber(), faker.number().randomNumber())),
                Arguments.of("Второй массив данных", List.of(faker.number().randomNumber(), faker.number().randomNumber()
                        , faker.number().randomNumber(), faker.number().randomNumber(), faker.number().randomNumber()))
        );
    }

    @MethodSource("methodProvide")
    @ParameterizedTest
    void methodSourceExampleTest(String first, List<Integer> second) {
        System.out.println(first + " содержит следующие числа: " + second);
    }

}
