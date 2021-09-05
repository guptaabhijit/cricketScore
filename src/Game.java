import java.util.LinkedList;
import java.util.List;

public class Game {
    public Rules rules;
    private List<Player> currentPlayerPlaying;

    public Game(){
        rules = new Rules();
        currentPlayerPlaying = new LinkedList<>();

    }

    public void setCurrentPlayers(Team team){
        List<Player> listOfPlayers = team.getListOfPlayers();
        Player p1 = listOfPlayers.get(0);
        Player p2 = listOfPlayers.get(1);

        p1.getBattingPlayer().setPlayerStatus(PlayerStatus.PLAYING);
        p2.getBattingPlayer().setPlayerStatus(PlayerStatus.PLAYING);
        p1.getBattingPlayer().setOnStrike(true);

        currentPlayerPlaying.add(p1);
        currentPlayerPlaying.add(p2);
    }


    public void updateScore(Team team, int runs){

        int currentTotalScore = team.getCurrentTotalScore();
        currentTotalScore += runs;
        team.setCurrentTotalScore(currentTotalScore);
    }

    public void play(List<String> overList, Team team) throws Exception {

        int ballsCount = 0;

        if (team.getNumberOfOversToPlay() == (int)team.getOversDone()){
             System.out.println("----------Overs Done for this team: " + team +"-----------");
            return;
        }

        for(String currentBall: overList){

            Player playerOnStrike = getPlayerOnStrike();

            ballsCount += 1;

            if (rules.isNoBall(currentBall)){
                updateScore(team,1);

                ballsCount -= 1;
                continue;
            }

            if (rules.isWideBall(currentBall)){

                updateScore(team,1);

                ballsCount -= 1;
                continue;
            }

            if (rules.isOut(currentBall)){
                if (handleWicket(playerOnStrike, team) == -1)
                    break;
                continue;
            }

            int runs = Integer.parseInt(currentBall);

            playerOnStrike.getBattingPlayer().playingBall(runs);
            updateScore(team,runs);

            if (rotateStrikeIfRequired(runs)){
                rotateStrikes(getPlayerOnStrike(), getPlayerNonStrike());
            }
        }

        handleOversDone(ballsCount, team);

        team.printScoreCard();
    }

    public void handleOversDone(int ballsCount, Team team) throws Exception {
        if (ballsCount == 6){
            double oversDone = team.getOversDone();
            oversDone += 1;
            team.setOversDone(oversDone);

            // rotate strike since over is done;
            rotateStrikes(getPlayerOnStrike(), getPlayerNonStrike());

        }else if (ballsCount < 6){

            double oversDone =  team.getOversDone();
            oversDone = oversDone + (ballsCount % 10) * 0.1;
            team.setOversDone(oversDone);
        }
    }

    public boolean rotateStrikeIfRequired(int currentBall){
        return currentBall == 3 || currentBall == 1;
    }


    public void rotateStrikes(Player OnStrike, Player OnNonStrike){
        OnStrike.getBattingPlayer().setOnStrike(false);
        OnNonStrike.getBattingPlayer().setOnStrike(true);

        currentPlayerPlaying = new LinkedList<>();
        currentPlayerPlaying.add(OnStrike);
        currentPlayerPlaying.add(OnNonStrike);
    }

    public int handleWicket(Player playerOnStrike, Team team) throws Exception {

        System.out.println("------" + playerOnStrike.getName()+" is out------");
        playerOnStrike.getBattingPlayer().setPlayerStatus(PlayerStatus.OUT);
        Player OnNonStrike = getPlayerNonStrike();

        playerOnStrike.getBattingPlayer().setOnStrike(false);
        playerOnStrike.getBattingPlayer().addBallFaced(1);

        int totalWickets = team.getTotalWickets();
        totalWickets += 1;
        team.setTotalWickets(totalWickets);

        if (team.getTotalWickets() == team.getListOfPlayers().size() - 1){
            // all out!
            // System.out.println("-------Team is all out!------");
            team.printScoreCard();
            return -1;
        }

        // bring new player and set is status as playing and set him on strike;
        Player newPlayer = team.getNewPlayer();
        // System.out.println("-------"+newPlayer.getName()+" new player came on strike-------");

        newPlayer.getBattingPlayer().setPlayerStatus(PlayerStatus.PLAYING);
        newPlayer.getBattingPlayer().setOnStrike(true);

        currentPlayerPlaying = new LinkedList<>();

        currentPlayerPlaying.add(newPlayer);
        currentPlayerPlaying.add(OnNonStrike);

        return 0;
    }


    public Player getPlayerOnStrike() throws Exception {

        for(Player player : currentPlayerPlaying){
            if (player.getBattingPlayer().isOnStrike()){
                return player;
            }
        }

        throw new Exception("On Strike player doesnt exist");
    }

    public Player getPlayerNonStrike() throws Exception {

        for(Player player : currentPlayerPlaying){
            if (!player.getBattingPlayer().isOnStrike()){
                return player;
            }
        }

        throw new Exception("Non Strike player doesnt exist");
    }
}
