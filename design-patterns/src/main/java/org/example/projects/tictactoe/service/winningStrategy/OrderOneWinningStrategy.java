package org.example.projects.tictactoe.service.winningStrategy;

import org.example.projects.tictactoe.models.Board;
import org.example.projects.tictactoe.models.Cell;
import org.example.projects.tictactoe.models.Move;
import org.example.projects.tictactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy{
    private int dimension;
    private List<HashMap<Character,Integer>> rowHashMap;
    private List<HashMap<Character,Integer>>colHashMap;
    private HashMap<Character,Integer>leftDiagonal;
    private HashMap<Character,Integer>rightDiagonal;
    private HashMap<Character,Integer>corner;


    public OrderOneWinningStrategy(int dimension){
        this.dimension = dimension;
        this.colHashMap = new ArrayList<>();
        this.rowHashMap = new ArrayList<>();
        this.leftDiagonal = new HashMap<>();
        this.rightDiagonal = new HashMap<>();
        this.corner = new HashMap<>();
        for(int i=0;i<dimension;i++){
            colHashMap.add(new HashMap<>());
            rowHashMap.add(new HashMap<>());
        }

    }


    @Override
    public Player checkWinner(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        boolean isWinner = (checkCorner(row,col) && checkWinnerForCorners(board.getMatrix(),symbol))
                || checkAndUpdateColHashMap(col,symbol)
                || checkAndUpdateRowHashMap(row,symbol)
                || (checkLeftDiagonal(row,col) && checkAndUpdateleftDiagonalHashMap(symbol))
                || (checkRightDiagonal(row,col) && checkAndUpdateRightDiagonalHashMap(symbol));

        if (isWinner){
            return player;
        }else{
            return null;
        }
    }

    private boolean checkCorner(int row ,int col){
        return (
                (row ==0 && col ==0)
                || (row ==dimension-1 && col == dimension -1)
                || (row == 0 && col == dimension-1)
                || (row == dimension -1 && col == 0)
                );
    }

    private boolean checkLeftDiagonal(int row,int col){
        return row == col;
    }

    private boolean checkRightDiagonal(int row,int col){
        return ((row+col) == dimension -1);
    }

    private boolean checkWinnerForCorners(List<List<Cell>>board , char symbol){
        if(corner.containsKey(symbol)){
            corner.put(symbol,corner.get(symbol)+1);
            return corner.get(symbol)==4;
        }else{
            corner.put(symbol,1);
        }
        return false;
    }

    private boolean checkAndUpdateRowHashMap(int row , char symbol){
        HashMap<Character,Integer> tempRowHashMap = rowHashMap.get(row);
        if(tempRowHashMap.containsKey(symbol)){
            tempRowHashMap.put(symbol,tempRowHashMap.get(symbol)+1);
            return tempRowHashMap.get(symbol)==dimension;
        }else{
            tempRowHashMap.put(symbol,1);
        }
        return false;

    }
    private boolean checkAndUpdateColHashMap(int col , char symbol){
        HashMap<Character,Integer> tempColHashMap = colHashMap.get(col);
        if(tempColHashMap.containsKey(symbol)){
            tempColHashMap.put(symbol,tempColHashMap.get(symbol)+1);
            return tempColHashMap.get(symbol)==dimension;
        }else{
            tempColHashMap.put(symbol,1);
        }
        return false;

    }
    private boolean checkAndUpdateleftDiagonalHashMap(char symbol){
        if(leftDiagonal.containsKey(symbol)){
            leftDiagonal.put(symbol,leftDiagonal.get(symbol)+1);
            return leftDiagonal.get(symbol)==dimension;
        }else{
            leftDiagonal.put(symbol,1);
        }
        return false;

    }
    private boolean checkAndUpdateRightDiagonalHashMap(char symbol){
        if(rightDiagonal.containsKey(symbol)){
            rightDiagonal.put(symbol,rightDiagonal.get(symbol)+1);
            return rightDiagonal.get(symbol)==dimension;
        }else{
            rightDiagonal.put(symbol,1);
        }
        return false;

    }



}
