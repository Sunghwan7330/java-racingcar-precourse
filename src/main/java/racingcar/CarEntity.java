package racingcar;

public class CarEntity {
    private String name;
    private int position;

    public CarEntity(String name) {
        this.name = name;
        position = 0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return this.name;
    }
}
