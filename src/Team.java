import java.util.LinkedList;
import java.util.List;

public class Team {

    private int team;

    private int numberOfOversToPlay;
    private int numberOfPlayers;

    private List<Player> listOfPlayers;


    private int currentTotalScore;
    private int totalWickets;
    private double oversDone;

    private BowlingTeam bowlingTeam;
    public Game game;


    public Team(int team, int numberOfOversToPlay, int numberOfPlayers){

        this.team = team;

        this.oversDone = 0.0;
        this.totalWickets = 0;
        this.currentTotalScore = 0;
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfOversToPlay = numberOfOversToPlay;

        listOfPlayers = new LinkedList<>();

        game = new Game();
    }

    public void battingOrder(Player player){
        listOfPlayers.add(player);
    }

    public void printScoreCard(){
        System.out.println("-------");
        System.out.println("ScoreCard for "+this.team);
        System.out.println();

        for(Player player : listOfPlayers){
            player.printPlayerStatus();
        }

        System.out.println();
        System.out.println("Total Score: "+ currentTotalScore);
        System.out.println("Total Wickets: "+ totalWickets);
        System.out.println("Overs: "+ oversDone);
        System.out.println("-------");
    }

    public void handleBowlingTeam(Team team2){
        bowlingTeam = new BowlingTeam(team2);
        bowlingTeam.setTotalRunsConceded(currentTotalScore);
        bowlingTeam.setWicketsTaken(totalWickets);
        bowlingTeam.setTotalOversBowled((int) oversDone);
    }

    public void setCurrentPlayers(){
        game.setCurrentPlayers(this);
    }

    public void play(List<String> overList) throws Exception {
        game.play(overList, this);
    }


    public Player getNewPlayer(){
        Player newPlayer = listOfPlayers.get(totalWickets + 1);
        return newPlayer;
    }

    public BowlingTeam getBowlingTeam() {
        return bowlingTeam;
    }

    public void checkWhoWon(Team team2){

        if (this.currentTotalScore > team2.currentTotalScore){
            System.out.println("Team "+ this.team +" won the match");
        }
        else if (this.currentTotalScore < team2.currentTotalScore){
            System.out.println("Team "+ team2.team + " won the match");
        }
        else{
            System.out.println("The match is drawn");
        }
    }

    public int getTeam() {
        return team;
    }


    public void setOversDone(double oversDone) {
        this.oversDone = oversDone;
    }

    public int getCurrentTotalScore() {
        return currentTotalScore;
    }

    public void setCurrentTotalScore(int currentTotalScore) {
        this.currentTotalScore = currentTotalScore;
    }

    public int getNumberOfOversToPlay() {
        return numberOfOversToPlay;
    }

    public double getOversDone() {
        return oversDone;
    }

    public List<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public int getTotalWickets() {
        return totalWickets;
    }
}
