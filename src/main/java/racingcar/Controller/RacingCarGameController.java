package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.RacingcarModel;

public class RacingCarGameController {
    private static final String STR_INPUT_CAR_NAME_MSG = "경주 할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String STR_INPUT_TRY_CNT_MSG = "시도할 회수는 몇회인가요?";
    private static final String STR_RESULT_MSG = "실행 결과";

    public static RacingcarModel racingModel;
    private static int mGameTryCnt = 0;

    public static void run() {
        racingModel = new RacingcarModel();
        inputCarName();
        inputTryCount();
        processRacingCarGame();
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
        mGameTryCnt = Integer.parseInt(Console.readLine()); // TODO 입력값 예외처리 필요
    }

    private static void processRacingCarGame() {
        System.out.println(STR_RESULT_MSG);
        for (int i = 0; i < mGameTryCnt; i++) {
            racingModel.runCarOnce();
            racingModel.printCarPosition();
            System.out.println();
        }
    }

    private static void printVictoryCar() {
        System.out.println("최종 우승자 : " + racingModel.getForefrontCarName());
    }
}
