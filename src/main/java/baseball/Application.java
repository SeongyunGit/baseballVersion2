package baseball;

public class Application {
    public static void main(String[] args) {
        baseballGameModel model = new baseballGameModel();
        baseballGameView view = new baseballGameView();
        baseBallGameController controller = new baseBallGameController(model, view);
        System.out.println("숫자 야구 게임을 시작합니다.");
        controller.gameStart();
    }
}
