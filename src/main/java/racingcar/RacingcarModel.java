package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.entity.CarEntity;

import java.util.ArrayList;

public class RacingcarModel {
    private ArrayList<CarEntity> carList;   //TODO 일급컬렉션으로 변경 필요

    public RacingcarModel() {
        carList = new ArrayList<>();
    }

    public boolean addCar(String carName) {
        carList.add(new CarEntity(carName));
        return true;
    }

    public int getCarLen() {
        return carList.size();
    }

    public boolean runCarOnce() {
        int n;
        for (CarEntity car : carList) {
            n = Randoms.pickNumberInRange(0, 9);
            if (n >= 4) {
                car.setPosition(car.getPosition() + 1);  //TODO 가독성 올릴 수 있을지 검토
            }
        }
        return true;
    }

    public void printCarPosition() {
        for (CarEntity car : carList) {
            String dashStr = "";
            for (int i = 0; i < car.getPosition(); i++)
                dashStr += "-";
            System.out.println(car.getName() + " : " + dashStr);
        }
    }

    public String getForefrontCarName() {
        // TODO 가독성 향상 리팩터링 필요
        String res = "";
        int max = -1;
        for (CarEntity car : carList) {
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
            if (name.length() > 5) { //TODO max length 상수 변경 필요
                return false;
            }
        }
        for (String name : nameArr) {
            addCar(name);
        }
        return true;
    }
}
