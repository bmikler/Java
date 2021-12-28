package pl.edu.agh.mwo.java1.f1.data;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private String name;
    private List<Result> results;

    public Race(String name, List<Result> results) {
        this.name = name;
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    public String getWinner(){
        return results.get(0).getdriverName();
    }

    public int getScoreForDriver (String driverName) {

        List<Integer> score = results.stream()
                .filter(n -> n.getdriverName().equals(driverName))
                .map(n -> n.getscore())
                .collect(Collectors.toList());

        return score.size() == 1 ? score.get(0) : 0;


    }

    @Override
    public String toString() {
        return name + " - " + results;
    }

}
