package starter;

import java.util.List;

import boardChecker.BoardMarker;
import checker.BingoChecker;
import checker.GameClearJudge;
import numberPicker.NumberPicker;
import player.Player;
import player.PlayerListMaker;

public class Starter {
	static int bingoBoardSize = 9;
	static int maxIntRange = 100;
	static int bingoLinesForClear = 10;
	static int howManyPlayers = 7;
	
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
			int[] markingPosition = BoardMarker.checkNumberExistOnboard(pickNumber, player.getBingoBoard());
			if(markingPosition.length==2) {
			int[][] bingoBoardForCheck = BoardMarker.boardChecker(player.getBingoBoardForCheck(), markingPosition);
			player.setBingoBoardForCheck(bingoBoardForCheck);
			player.setMadedBingoList(BingoChecker.bingoChecker(player.getBingoBoardForCheck()));
			}
		}
		return players;
	}

}
