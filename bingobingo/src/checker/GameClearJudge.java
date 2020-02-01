package checker;

import java.util.List;

import player.MadedBingoInformation;
import player.Player;

public class GameClearJudge {
	public static boolean gameCleareJudge(List<Player> playerList, int clearGoal) {
		
		boolean isCleared = false;
		
		for(Player player : playerList) {
			if(player.getMadedBingoList().size()==clearGoal){
				System.out.println(player.getName()+"님이  " +clearGoal+"줄 빙고를 완성했습니다." );
				System.out.println("완성한 빙고 목록 : ");
				for(MadedBingoInformation bingoInformation : player.getMadedBingoList()) {
					System.out.println(bingoInformation);
				}
				isCleared = true;
			}
		}
		
		return isCleared;
	}
}
