import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CricketScoreMain {

    private  Team team1;
    private  Team team2;


    public Team team1Playing() throws Exception {

        Player p1 = new Player(1, "sachin");
        Player p2 = new Player(2, "dhoni");
        Player p3 = new Player(3, "rahul");
        Player p4 = new Player(4, "yuvraj");
        Player p5 = new Player(5, "sehwag");

        team1.battingOrder(new ArrayList<>( Arrays.asList(p1, p2, p3, p4, p5)));

        team1.setCurrentPlayers();

        List<String> over = new ArrayList<>(Arrays.asList("1","1","1","1","1","2"));
        team1.play(over);
        team1.handleBowlingTeam(team2);

        over = new ArrayList<>(Arrays.asList("W","4","4","Wd","W","1", "6"));
        team1.play(over);
        team1.handleBowlingTeam(team2);

        team1.getBowlingTeam().printStatus();

        return team1;
    }

    public Team team2Playing() throws Exception {

        Player p1 = new Player(1, "Rohit");
        Player p2 = new Player(2, "Virat");
        Player p3 = new Player(3, "Pujara");
        Player p4 = new Player(4, "Rahane");
        Player p5 = new Player(5, "Pant");

        team2.battingOrder(new ArrayList<>( Arrays.asList(p1, p2, p3, p4, p5)));

        team2.setCurrentPlayers();

        List<String> over = new ArrayList<>(Arrays.asList("4","6","W","W","1","1"));
        team2.play(over);
        team2.handleBowlingTeam(team1);

        over = new ArrayList<>(Arrays.asList("6", "1", "W","W"));
        team2.play(over);
        team2.handleBowlingTeam(team1);

        team2.getBowlingTeam().printStatus();

        return team2;
    }

    public static void main(String[] args) throws Exception {
        CricketScoreMain cricket = new CricketScoreMain();

        cricket.team1 = new Team(1, 2, 5);
        cricket.team2 = new Team(2, 2, 5);

        cricket.team1Playing();
        cricket.team2Playing();

        cricket.team1.checkWhoWon(cricket.team2);
    }
}
