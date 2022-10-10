package racingcar.entity;

public class CarEntity {
    //TODO 원시값 포장
    //private String name;
    private CarName carName;
    private int position;

    public CarEntity(String name) {
        carName = new CarName(name);
        position = 0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return carName.getName();
    }
}