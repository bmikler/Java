package pl.edu.agh.mwo.java1.f1;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    @Override
    public String toString() {
        return name + " - " + results;
    }

}
