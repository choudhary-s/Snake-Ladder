package manager;

import entity.Board;
import entity.Ladder;
import entity.Player;
import entity.Snake;
import service.DiceService;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameManager {
    Board board;
    int initialNoOfPlayers;
    Queue<Player> players;
    int boardSize;

    public GameManager(int boardSize) {
        players = new LinkedList<>();
        this.boardSize = boardSize;
        this.board = new Board(boardSize);
    }
    //Initialize board
    public void setSnakes(List<Snake> snakes){
        board.setSnakes(snakes);
    }
    public void setLadder(List<Ladder> ladders){
        board.setLadders(ladders);
    }
    public void setPlayers(List<Player> players){
        this.initialNoOfPlayers = players.size();
        for(Player p: players){
            this.players.add(p);
            board.getPlayerPieces().put(p.getId(), 0);
        }
    }
    public boolean isGameCompleted(){
        return players.size()!=initialNoOfPlayers;
    }
    public int movePlayer(Player curr, int diceValue){
        String currPlayerId = curr.getId();
        int oldPos = board.getPlayerPieces().get(currPlayerId);
        if(oldPos+diceValue>boardSize){
            //Postion is unchanged
            return oldPos;
        }
        else{
            int newPos = oldPos+diceValue;
            while(true){
                boolean flag = false;
                for(Ladder l: board.getLadders()){
                    if(l.getStart()==newPos){
                        System.out.println(curr.getName()+" taking ladder to "+ l.getEnd());
                        newPos = l.getEnd();
                        flag = true;
                    }
                }
                if(!flag){
                    break;
                }
            }
            while(true){
                boolean flag = false;
                for(Snake s: board.getSnakes()){
                    if(s.getStart()==newPos){
                        System.out.println(curr.getName()+" going down to "+ s.getEnd());
                        newPos = s.getEnd();
                        flag = true;
                    }
                }
                if(!flag){
                    break;
                }
            }
            board.getPlayerPieces().put(currPlayerId, newPos);
            System.out.println(curr.getName()+" has finally moved to "+ newPos);
            return newPos;
        }
    }

    public void startGame(){
        while(!isGameCompleted()){
            Player curr = players.poll();
            int diceValue = DiceService.roll();
            int newPos = movePlayer(curr, diceValue);
            if(newPos!=boardSize){
                players.add(curr);
            }
            else{
                System.out.println(curr.getName()+" has won the game.");
                board.getPlayerPieces().remove(curr.getId());
            }
        }
    }
}
