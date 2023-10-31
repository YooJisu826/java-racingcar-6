package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int numberOfAttempts;
    private List<Car> cars;
    private List<String> winners;

    public Game() {
        this.numberOfAttempts = 0;
        this.cars = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    private void addCar(String nameOfCar) {
        cars.add(new Car(nameOfCar));
    }

    /**
     * userInput 을 받아 name을 분리하고 cars 리스트에 car 를 추가하는 함수
     */
    public void addCars(String userInput) {
        String[] nameList = userInput.split(",");
        for (String name : nameList) {
            addCar(name);
        }
    }

    /**
     * cars 리스트에 저장된 car 객체들이 한 라운드를 수행하도록 하는 함수
     */
    public void startRound() {
        for (Car car : cars) {
            car.playRound();
        }
    }

    /**
     * 각 라운드의 자동차들 전진 결과를 출력하는 함수
     */
    public void printResultOfRound() {
        for (Car car : this.cars) {
            System.out.println(car.getNameAndStateOfCar());
        }
    }

    /**
     * 가장 많이 전진한 자동차의 전진 횟수를 리턴하는 함수
     */
    private int findMaxForwardMovement() {
        int max = 0;
        for (Car car : cars) {
            if (max < car.getForwardMovementStateOfLength()) {
                max = car.getForwardMovementStateOfLength();
            }
        }
        return max;
    }

    /**
     * 자동차들의 전진 상황을 비교하여 우승자를 저장하는 함수
     */
    public void findWinners() {
        int max = findMaxForwardMovement();
        for (Car car : cars) {
            if (car.getForwardMovementStateOfLength() == max) {
                this.winners.add(car.getName());
            }
        }
    }
}
