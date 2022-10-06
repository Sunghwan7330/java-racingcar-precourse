package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String carNameList = Console.readLine();
        int rotate = Integer.parseInt(Console.readLine());

        RacingcarModel racingModel = new RacingcarModel();
        for (String name : carNameList.split(",")) {
            racingModel.addCar(name);
        }

        for (int i = 0; i < rotate; i++) {
            racingModel.runCarOnce();
            racingModel.printCarPosition();
        }
        System.out.println("최종 우승자 : " + racingModel.getForefrontCarName());
    }
}
