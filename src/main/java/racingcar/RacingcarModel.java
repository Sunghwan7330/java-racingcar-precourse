package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.entity.CarEntity;

import java.util.ArrayList;

public class RacingcarModel {
    private RacingCarList carList;

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

    public boolean runCarOnce() {
        int n;
        for (int i = 0; i < getCarLen(); i++) {
            n = Randoms.pickNumberInRange(0, 9);
            if (n >= 4) {
                CarEntity car = carList.getCarEntity(i);
                car.setPosition(car.getPosition() + 1);  //TODO 가독성 올릴 수 있을지 검토
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
                return false;
            }

        }
        return true;
    }
}
