package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingcarModel racingModel = new RacingcarModel();
        while (!racingModel.inputCarFromString(Console.readLine())) {
            System.out.println("[ERROR] 입력이 잘못되었습니다.");  //TODO 입력 세분화 필요
        }

        int rotate = Integer.parseInt(Console.readLine());
        for (int i = 0; i < rotate; i++) {
            racingModel.runCarOnce();
            racingModel.printCarPosition();
        }
        System.out.println("최종 우승자 : " + racingModel.getForefrontCarName());
    }
}
