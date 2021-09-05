public class BattingPlayer {

    private int individualScore;
    private int numberOfBallsFaced;

    private int numberOf4s;
    private int numberOf6s;

    private boolean onStrike;

    private PlayerStatus playerStatus;

    public BattingPlayer(){
        this.individualScore = 0;
        this.numberOf4s = 0;
        this.numberOf6s = 0;
        this.numberOfBallsFaced = 0;
        this.playerStatus = PlayerStatus.YET_TO_BAT;
        this.onStrike = false;
    }

    public boolean isOnStrike() {
        return onStrike;
    }

    public void setOnStrike(boolean onStrike) {
        this.onStrike = onStrike;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public void playingBall(int runs){

        if (runs == 4){
            addNumberOf4s(1);
            addRuns(4);
        }
        else if (runs == 6){
            addNumberOf6s(1);
            addRuns(6);
        }else{
            addRuns(runs);
        }

        addBallFaced(1);
    }

    public void addRuns(int runs){
        this.individualScore += runs;
    }

    public void addBallFaced(int ball){
        this.numberOfBallsFaced += ball;
    }

    public void addNumberOf4s(int fours){
        this.numberOf4s += fours;
    }

    public void addNumberOf6s(int sixes){
        this.numberOf6s += sixes;
    }

    public int getIndividualScore() {
        return individualScore;
    }

    public int getNumberOf4s() {
        return numberOf4s;
    }

    public int getNumberOf6s() {
        return numberOf6s;
    }

    public int getNumberOfBallsFaced() {
        return numberOfBallsFaced;
    }
}
