public class Rules {

    public boolean isNoBall(String ball){

        if (ball.equalsIgnoreCase("nb")){
            return true;
        }

        return false;
    }

    public boolean isWideBall(String ball){

        if (ball.equalsIgnoreCase("wd")){
            return true;
        }

        return false;
    }

    public boolean isOut(String ball){

        if (ball.equalsIgnoreCase("w")){
            return true;
        }

        return false;
    }
}
