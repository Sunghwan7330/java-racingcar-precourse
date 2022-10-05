package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarEitityTest {

    @Test
    public void newCarEntityTest() {
        String name = "test_car";
        CarEntity car = new CarEntity(name);
        assertThat(car.getName()).contains(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void setCarPosition() {
        String name = "test_car";
        int pos = 10;
        CarEntity car = new CarEntity(name);
        car.setPosition(pos);
        assertThat(car.getPosition()).isEqualTo(pos);
    }
}
