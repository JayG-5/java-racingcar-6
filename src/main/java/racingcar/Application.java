package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static List<Car> transformStringToCarList(String cars) {
        List<Car> carList = new ArrayList<>();
        for (String carName : Arrays.stream(cars.split(",")).toList()) {
            if (carName.length() > 5 || carName.isEmpty()) {
                throw new IllegalArgumentException("이름은 1~5자로 입력해주세요.");
            }

            final Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final List<Car> cars = transformStringToCarList(Console.readLine());
        System.out.println("시도할 회수는 몇회인가요?");

        int turn = Integer.parseInt(Console.readLine());
        int maxScore = 0;

        System.out.println("실행 결과");
        for (int i = 0; i < turn; i++) {
            maxScore = cars.stream().mapToInt(Car::run).max().orElse(0);
            System.out.println();
        }

        List<String> winner = new ArrayList<>();

        for (Car car : cars) {
            final String carName = car.ifMaxScore(maxScore);
            if (!carName.isEmpty()) {
                winner.add(carName);
            }
        }
        String winnerFormat = String.format("최종 우승자 : %s", String.join(", ", winner));
        System.out.println(winnerFormat);
    }
}
