package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.RacingcarModel;

public class RacingCarGameController {
    private static final String STR_INPUT_CAR_NAME_MSG = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static final String STR_INPUT_TRY_CNT_MSG = "시도할 회수";

    public static RacingcarModel racingModel;

    public static void run() {
        racingModel = new RacingcarModel();
        inputCarName();
        inputTryCount();
        printVictoryCar();
    }

    private static void inputCarName() {
        while (true) {
            System.out.println(STR_INPUT_CAR_NAME_MSG);
            String inputCarStr = Console.readLine();
            if (racingModel.inputCarFromString(inputCarStr)) break;
            System.out.println("[ERROR] 입력이 잘못되었습니다.");  //TODO 입력 세분화 필요
        }
    }

    private static void inputTryCount() {
        System.out.println(STR_INPUT_TRY_CNT_MSG);
        int rotate = Integer.parseInt(Console.readLine());
        for (int i = 0; i < rotate; i++) {
            racingModel.runCarOnce();
            racingModel.printCarPosition();
        }
    }

    private static void printVictoryCar() {
        System.out.println("최종 우승자 : " + racingModel.getForefrontCarName());
    }
}
