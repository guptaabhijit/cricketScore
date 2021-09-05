
public class BowlingTeam {

    private Team team;

    private int totalOversBowled;
    private int totalRunsConceded;
    private int wicketsTaken;
    private int maidenOvers;
    private int dotBalls;
    private int economy;


    public BowlingTeam(Team team){
        this.team = team;
    }

    public void setTotalRunsConceded(int totalRunsConceded) {
        this.totalRunsConceded = totalRunsConceded;
    }

    public int getTotalOversBowled() {
        return totalOversBowled;
    }

    public void setTotalOversBowled(int totalOversBowled) {
        this.totalOversBowled = totalOversBowled;
    }


    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public int getMaidenOvers() {
        return maidenOvers;
    }

    public void setMaidenOvers(int maidenOvers) {
        this.maidenOvers = maidenOvers;
    }

    public int getDotBalls() {
        return dotBalls;
    }

    public void setDotBalls(int dotBalls) {
        this.dotBalls = dotBalls;
    }

    public int getEconomy() {
        return economy;
    }

    public void setEconomy(int economy) {
        this.economy = economy;
    }

    public int getTotalRunsConceded() {
        return totalRunsConceded;
    }

    public void printStatus(){
        System.out.println("Bowling team: "+ team.getTeam() + " ## Total Overs Bowled: "+ getTotalOversBowled() + " ## Total Runs conceded: "+getTotalRunsConceded() +
                " ## Total wickets taken: " +
                getWicketsTaken());
    }
}
