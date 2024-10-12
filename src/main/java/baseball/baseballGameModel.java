package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class baseballGameModel {

    public List<Integer> strikeAndBall(List<Integer> userList, List<Integer> randomList) {
        List<Integer> strikeBall = new ArrayList<>();
        int strike = 0;
        int ball = 0;
        for (int i =0; i<userList.size(); i++) {
            if (userList.get(i) == randomList.get(i)) {
                strike += 1;
                if (userList.get((i+2)%3) == randomList.get((i+1)%3) && userList.get((i+1)%3) == randomList.get((i+2)%3)) {
                    ball += 2;
                } else if (userList.get((i+2)%3) == randomList.get((i+1)%3) || userList.get((i+1)%3) == randomList.get((i+2)%3)) {
                    ball += 1;
                }
            }
        }
        strikeBall.add(strike);
        strikeBall.add(ball);
        return strikeBall;
    }
    public int findBall(List<Integer> userList, List<Integer> randomList, int ball) {
        for (int i=0;i<userList.size();i++) {
            for (int j=0;j<randomList.size();j++) {
                if (i!=j && userList.get(i) == randomList.get(j)) {
                    ball+=1;
                }
            }
        }
        return ball;
    }
    public List<Integer> randomNumberList(List<Integer> randomList) {
        while (randomList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }
        return randomList;
    }
}
