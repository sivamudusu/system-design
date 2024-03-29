package org.example.projects.tictactoe.models;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;

    private char symbol;
    private PlayerType playerType;

    public Player(int id,String name,char symbol,PlayerType playerType){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;

    }
    public Move makeMove(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the coordinates");
        int row = sc.nextInt();
        System.out.println("print the col for the target cell ");
        int col = sc.nextInt();


        Cell playedCell = board.getMatrix().get(row).get(col);
        playedCell.setCellState(CellState.FILL);
        playedCell.setPlayer(this);

        return new Move(this,playedCell);

    }
    public String getName(){
        return this.name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
