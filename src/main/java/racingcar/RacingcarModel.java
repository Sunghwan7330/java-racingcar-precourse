package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.entity.CarEntity;

public class RacingcarModel {
    private RacingCarList carList;

    private final int MOVE_LEN = 1;
    private final int MAX_STOP_NUM = 3;

    public RacingcarModel() {
        carList = new RacingCarList();
    }

    public boolean addCar(String carName) {
        carList.addCar(new CarEntity(carName));
        return true;
    }

    public int getCarLen() {
        return carList.getCarCount();
    }

    private boolean isMove() {
        int  n = Randoms.pickNumberInRange(0, 9);
        if (n <= MAX_STOP_NUM) {
            return false;
        }
        return true;
    }

    public boolean runCarOnce() {
        for (int i = 0; i < getCarLen(); i++) {
            if (isMove()) {
                carList.getCarEntity(i).moveCar(MOVE_LEN);
            }
        }
        return true;
    }

    public void printCarPosition() {
        for (int i = 0; i < getCarLen(); i++) {
            CarEntity car = carList.getCarEntity(i);
            String dashStr = "";
            for (int j = 0; j < car.getPosition(); j++)
                dashStr += "-";
            System.out.println(car.getName() + " : " + dashStr);
        }
    }

    public String getForefrontCarName() {
        // TODO 가독성 향상 리팩터링 필요
        String res = "";
        int max = -1;
        for (int i = 0; i < getCarLen(); i++) {
            CarEntity car = carList.getCarEntity(i);
            if (max < car.getPosition()) {
                max = car.getPosition();
                res = car.getName();
            } else if (max == car.getPosition()) {
                res += ", " + car.getName();
            }
        }
        return res;
    }

    public boolean inputCarFromString(String carNameList) {
        String nameArr[] = carNameList.split(",");

        for (String name : nameArr) {
            try {
                addCar(name);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                carList.clearCarList();
                return false;
            }

        }
        return true;
    }
}
