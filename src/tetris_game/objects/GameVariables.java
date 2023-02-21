package tetris_game.objects;

public class GameVariables {

    private int time;
    private int score;
    private int lines;
    private int topScore;
    private boolean backToBack;

    public GameVariables(){
        time = 0;
        score = 0;
        lines = 0;
        backToBack = false;
    }

    public int getTime(){
        return time;
    }
    public void setTime(int time){
        this.time = time;
    }

    public int getLines() {
        return lines;
    }
    public void setLines(int lines) {
        this.lines = lines;
    }


    public void countLines(int lines){
        this.lines += lines;
    }

    public int getScore() {
        return score;
    }


    public void setScore(int lines) {

        if (lines != 0){
            this.score += lines * 100;
            if (lines == 4){
                this.score += 400;
            }
            if (backToBack){
                this.score += 1200;
            }
            else {
                backToBack = true;
            }
        }
        else {
            backToBack = false;
        }


    }

    public int getTopScore() {
        return topScore;
    }
    public void setTopScore(int topLevel) {
        this.topScore = topLevel;
    }



}
