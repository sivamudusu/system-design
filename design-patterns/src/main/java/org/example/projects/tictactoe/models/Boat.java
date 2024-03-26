package org.example.projects.tictactoe.models;

public class Boat extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Boat(int id, char Symbol, BotDifficultyLevel botDifficultyLevel){
        super(id,"CHITTI",Symbol,PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;

    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        return null;
    }
}
