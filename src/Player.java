public class Player {

    private int id;
    private String name;

    private BattingPlayer battingPlayer;
    private BowlingPlayer bowlingPlayer;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
        battingPlayer = new BattingPlayer();
        bowlingPlayer = new BowlingPlayer();
    }

    public String getName() {
        return name;
    }

    public BattingPlayer getBattingPlayer() {
        return battingPlayer;
    }

    public BowlingPlayer getBowlingPlayer() {
        return bowlingPlayer;
    }

    public void printPlayerStatus(){
        System.out.println("Name:" + this.getName()+ " ## Player Status:" + this.battingPlayer.getPlayerStatus() + " ## isOnStike:" + this.battingPlayer.isOnStrike());
        System.out.println("Score: "+this.battingPlayer.getIndividualScore() + " ## 4s: "+ this.battingPlayer.getNumberOf4s() + " ## 6s: "+this.battingPlayer.getNumberOf6s() + " ## Balls: " + this.battingPlayer.getNumberOfBallsFaced());
        System.out.println();
    }
}
