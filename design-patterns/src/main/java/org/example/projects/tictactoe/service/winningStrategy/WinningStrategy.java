package org.example.projects.tictactoe.service.winningStrategy;

import org.example.projects.tictactoe.models.Board;
import org.example.projects.tictactoe.models.Move;
import org.example.projects.tictactoe.models.Player;

public interface WinningStrategy {
    Player checkWinner(Board board, Move lastMove);
}
