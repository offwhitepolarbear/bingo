package player;

import java.util.ArrayList;
import java.util.List;

public class PlayerListMaker {
	public static List<Player> playerListMaker(int maxIntRange,int boardSize,int howManyPlayers){
		List<Player> playerList = new ArrayList<Player>();
		for(int i=0;i<howManyPlayers;i++) {
			playerList.add(PlayerMaker.playerMaker(maxIntRange, boardSize, (i+1)+"번 유저"));
		}
		return playerList;
	}
}
