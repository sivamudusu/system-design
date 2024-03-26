package org.example.projects.tictactoe.service.winningStrategy;

import org.example.projects.tictactoe.models.Board;
import org.example.projects.tictactoe.models.Cell;
import org.example.projects.tictactoe.models.Move;
import org.example.projects.tictactoe.models.Player;

import java.util.List;

public class OrderNsquareWinningStrategy implements WinningStrategy{
    private char[][] matrix;
    private int dimension;

    public OrderNsquareWinningStrategy(int dimension){
        this.dimension = dimension;
        matrix = new char[dimension][dimension];
    }

    @Override
    public Player checkWinner(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        boolean isWinner = (checkCol(board,row,col,symbol)
                || checkRow(board,row,col,symbol)
                || leftDiagonal(board,row,col,symbol)
                || rightDiagonal(board,row,col,symbol)
                || corners(board,symbol));

        if(isWinner){
            return player;
        }else{
            return null;
        }

    }
    public boolean checkRow(Board board,int row,int col,char symbol){
        matrix[row][col]=symbol;
        for(int i=0;i<dimension;i++){
            if(matrix[row][i]!=symbol){
                return false;
            }
        }
        return true;
    }
    public boolean checkCol(Board board,int row,int col,char symbol){
        matrix[row][col]=symbol;
        for(int i=0;i<dimension;i++){
            if(matrix[i][col]!=symbol){
                return false;
            }
        }
        return true;
    }
    public boolean leftDiagonal(Board board,int row,int col,char symbol){
        matrix[row][col]=symbol;
        for(int i=0;i<dimension;i++){
            if(matrix[i][i]!=symbol){
                return false;
            }
        }
        return true;
    }
    public boolean rightDiagonal(Board board,int row,int col,char symbol){
        matrix[row][col]=symbol;
        for(int i=0;i<dimension;i++){
            if(matrix[i][dimension-1-i]!=symbol){
                return false;
            }
        }
        return true;
    }
    public boolean corners(Board board,char symbol){
        if(matrix[0][0]==symbol
                && matrix[dimension-1][dimension-1]==symbol
                && matrix[0][dimension-1]==symbol
                && matrix[dimension-1][0]==symbol){
            return true;
        }
        return false;
    }
}
