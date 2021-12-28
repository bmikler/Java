package pl.edu.agh.mwo.java1.f1;

public class Result {

    private String driverName;
    private String team;
    private int score;

    public Result(String driverName, String team, int score) {
        this.driverName = driverName;
        this.team = team;
        this.score = score;
    }


    public String getdriverName() {
        return driverName;
    }


    public String getTeam() {
        return team;
    }

    public int getscore() {
        return score;
    }

    @Override
    public String toString() {
        return "Result{" +
                "driverName=" + driverName +
                ", team='" + team + '\'' +
                ", score=" + score +
                '}';
    }

}
