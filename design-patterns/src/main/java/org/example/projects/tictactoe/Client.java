package org.example.projects.tictactoe;

import org.example.projects.tictactoe.controller.GameController;
import org.example.projects.tictactoe.models.*;
import org.example.projects.tictactoe.service.winningStrategy.OrderNsquareWinningStrategy;
import org.example.projects.tictactoe.service.winningStrategy.OrderOneWinningStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();
        Player siva = new Player(1,"shiva",'O', PlayerType.HUMAN);
        Player vijay = new Player(2,"vijay",'X',PlayerType.HUMAN);
        Player surya = new Player(2,"surya",'@',PlayerType.HUMAN);
        Player sqib = new Player(2,"saqib",'$',PlayerType.HUMAN);
        OrderNsquareWinningStrategy orderNsquareWinningStrategy = new OrderNsquareWinningStrategy(10);
        players.add(siva);
        players.add(vijay);
//        players.add(surya);
//        players.add(sqib);
        Collections.shuffle(players);
        Game game = gameController.createGame(10,players,orderNsquareWinningStrategy);
        int playerIndex = -1;

        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            gameController.showBorad(game);
            playerIndex++;
            playerIndex = playerIndex % players.size();
            System.out.println(players.get(playerIndex).getName()+" has to make a move");
            Move movePlayed = gameController.makeMove(game,players.get(playerIndex));
            game.getMoves().add(movePlayed);
            game.getBoardState().add(game.getBoard());
            Player winner = gameController.checkWinner(game,movePlayed);

            if(winner!=null){
                System.out.println("winner is "+winner.getName());
                break;
            }
            if(game.getMoves().size() == game.getBoard().getDimension()*game.getBoard().getDimension()){
                System.out.println("game is draw");
                break;
            }
        }

    }
}
