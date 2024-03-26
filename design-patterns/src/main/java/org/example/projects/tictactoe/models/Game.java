package org.example.projects.tictactoe.models;

import org.example.projects.tictactoe.exception.InavlidPlayerSizeException;
import org.example.projects.tictactoe.exception.InvalidBotCountException;
import org.example.projects.tictactoe.exception.InvalidSymbolSetupException;
import org.example.projects.tictactoe.service.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player player;
    private GameStatus gameStatus;
    private List<Move> moves;
    private List<Board>boardState;
    private WinningStrategy winningStrategy;
    private int numberOfSymbols;


    private Game(Board board, List<Player> players, WinningStrategy winningStrategy) {
        this.board = board;
        this.players = players;
        this.player = null;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.boardState = new ArrayList<>();
        this.winningStrategy = winningStrategy;
        this.numberOfSymbols = players.size();
    }

    public static Builder builder(){
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Board> getBoardState() {
        return boardState;
    }

    public void setBoardState(List<Board> boardState) {
        this.boardState = boardState;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    public static class Builder{
        private int dimension;
        private Board board;
        private List<Player> players;
        private Player player;

        private WinningStrategy winningStrategy;


        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setPlayer(Player player) {
            this.player = player;
            return this;
        }


        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }


//        private void validateNumberOfPlayers(){
//            if (players.size() < dimension-2|| players.size() >= dimension){
//                throw new InavlidPlayerSizeException("you have entered invalid number of player");
//            }
//
//
//        }
        private void validateSymbols(){
            //TODO : convert the below code into lambda expression using streams
            HashSet<Character> symbols = new HashSet<>();
            for (Player player : players){
                symbols.add((player.getSymbol()));
            }

            if(symbols.size() != players.size()){
                throw new InvalidSymbolSetupException("there should be unique symbols for each player");
            }
        }

        private void validateBotCount(){
            //TODO : convert this code into labmda expressin using sreams
            int count = 0;
            for(Player player: players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    count++;
                }
            }
            if(count > 1 || count < 0){
                throw new InvalidBotCountException("we can have max one bot per game");
            }
        }

        public void vlidate(){
//            validateNumberOfPlayers();
            validateSymbols();
            validateBotCount();

        }

        public Game build(){
            vlidate();
            return new Game(new Board(dimension),players,winningStrategy);
        }
    }
}
