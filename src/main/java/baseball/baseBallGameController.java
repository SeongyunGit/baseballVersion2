package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class baseBallGameController {
    private final baseballGameModel model;
    private final baseballGameView view;

    public baseBallGameController(baseballGameModel model, baseballGameView view) {
        this.model = model;
        this.view = view;
    }

    public void gameStart() {
        while (true) {
            List<Integer> randomList = new ArrayList<>();
            while (randomList.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!randomList.contains(randomNumber)) {
                    randomList.add(randomNumber);
                }
            }

            while (true) {

                int userNumber = view.userNumberScan();

                List<Integer> userList = new ArrayList<>();
                int hundred = userNumber / 100;
                int ten = (userNumber/10)%10;
                int one = userNumber%10;
                userList.add(hundred);
                userList.add(ten);
                userList.add(one);

                List<Integer> strikeBall = model.strikeAndBall(userList, randomList);
                int strike = strikeBall.get(0);
                int ball = strikeBall.get(1);

                if (strike == 0) {
                    ball = model.findBall(userList, randomList, ball);
                }
                view.judgeStrikeAndBall(strike, ball);

                if (strike == 3) {
                    break;
                }
            }
            boolean resetGame = view.questionGameOver();
            if (!resetGame) {
                break;
            }
        }
    }
}
