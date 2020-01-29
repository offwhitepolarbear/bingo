package starter;

import java.util.List;

import boardChecker.BoardMarker;
import checker.BingoChecker;
import checker.GameClearJudge;
import numberPicker.NumberPicker;
import player.Player;
import player.PlayerListMaker;

public class Starter {
	static int bingoBoardSize = 5;
	static int maxIntRange = 100;
	static int bingoLinesForClear = 2;
	static int howManyPlayers = 4;
	
	public static void main(String[] args) {
		List<Integer> numberIndexing = NumberPicker.numberSequenceMaker(maxIntRange, maxIntRange);
		List<Player> playerList = PlayerListMaker.playerListMaker(maxIntRange, bingoBoardSize, howManyPlayers);
		
		while(!GameClearJudge.gameCleareJudge(playerList, bingoLinesForClear)) {
			int pickNumberNow = numberIndexing.get(0);
			System.out.println("이번 숫자는 "+pickNumberNow);
			numberIndexing.remove(0);
			playerList = mainProcessForCheckBingo(pickNumberNow, playerList);
		}
		
	}
	
	public static List<Player> mainProcessForCheckBingo(int pickNumber, List<Player> players) {
		for(Player player : players) {
			int[] markingPostion = BoardMarker.bingoBoardMarker(pickNumber, player.getBingoBoard());
			int[][] bingoBoardForCheck = BoardMarker.boardChecker(player.getBingoBoardForCheck(), markingPostion);
			player.setBingoBoardForCheck(bingoBoardForCheck);
			player.setMadedBingoList(BingoChecker.bingoChecker(player.getBingoBoardForCheck()));
		}
		return players;
	}


}
