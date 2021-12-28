package pl.edu.agh.mwo.java1.f1.logic;

import pl.edu.agh.mwo.java1.f1.data.Race;
import pl.edu.agh.mwo.java1.f1.data.Result;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class F1Statistics {

    List<Race> races;

    public F1Statistics(List<Race> races) {
        this.races = races;
    }

    public void printStats() {

        System.out.println("1. Drivers who won at least once:");
        System.out.println(getWinners() + "\n");

        System.out.println("2. Score of Lewis Hamilton:");
        System.out.println(getDriverScore("Lewis Hamilton") + "\n");

        System.out.println("3. Score of Ferrari team:");
        System.out.println(getTeamScore("Ferrari") + "\n");

        System.out.println("4. Score board:");

        for (String result : getScoreBoard()) {
            System.out.println(result);
        }


    }

    //1. Napisz kod, który wypisze kierowców, którzy co najmniej raz zwyciężyli wyścig GP.

    private List<String> getWinners() {

        return races.stream()
                .map(Race::getWinner)
                .distinct()
                .toList();

    }

    //2. Napisz kod, który wypisze ile punktów zdobył Lewis Hamilton.

    private Map<String, Integer> getDriverScore(String driver) {

        return getStreamOfResults()
                .filter(n -> n.getdriverName().contains(driver))
                .collect(Collectors.groupingBy(Result::getdriverName, Collectors.summingInt(Result::getscore)));

    }

    //3. Napisz kod, który wypisze ile punktów zdobył zespół Ferrari.

    private Map<String, Integer> getTeamScore(String team) {

        return getStreamOfResults()
                .filter(n -> n.getTeam().contains(team))
                .collect(Collectors.groupingBy(Result::getTeam, Collectors.summingInt(Result::getscore)));

    }

    //4. Napisz kod, który wypiszę tabelę wyników na koniec sezonu.
    // W pojedynczym wierszu na konsoli wypisz miejsce, imię i nazwisko kierowcy, sumaryczna liczba punktów.

    private List<String> getScoreBoard() {

        AtomicInteger index = new AtomicInteger(1);

        return getStreamOfResults()
                .collect(Collectors.groupingBy(Result::getdriverName, Collectors.summingInt(Result::getscore)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(n -> index.getAndIncrement() + ". " + n.getKey() + " score: " + n.getValue())
                .toList();

    }


    private Stream<Result> getStreamOfResults() {

        return races.stream()
                .flatMap(n -> n.getResults().stream());
    }



}
