package org.example.projects.tictactoe.controller;

import org.example.projects.tictactoe.models.*;
import org.example.projects.tictactoe.service.winningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
//    create game will automaically starts the game
    public Game createGame(int dimension, List<Player> players, WinningStrategy winningStrategy){
        return Game.builder().setDimension(dimension).setPlayers(players).setWinningStrategy(winningStrategy).build();
    }



    public void showBorad(Game game){
        game.getBoard().displayBoard();
    }
    public GameStatus gameStatus(Game game){
        return game.getGameStatus();
    }


    public Player getWinner(Game game){
        return null;
    }

    public Move makeMove(Game game, Player player){
        return  player.makeMove(game.getBoard());
    }
    public Player checkWinner(Game game, Move lastMovePayed){
        return game.getWinningStrategy().checkWinner(game.getBoard(),lastMovePayed);
    }

    public Board undoMove(Game game, Move lastplayed){
        return null;
    }

    public void replayTheGame(Game game){

    }
}
