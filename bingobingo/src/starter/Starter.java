package starter;

import java.util.List;
import java.util.Map;

import boardChecker.BoardMarker;
import checker.BingoChecker;
import checker.GameClearJudge;
import numberPicker.NumberPicker;
import player.Player;
import player.PlayerListMaker;

public class Starter {
	static int bingoBoardSize = 5;
	static int maxIntRange = 25;
	static int bingoLinesForClear = 2;
	static int howManyPlayers = 3;

	public static void main(String[] args) {
		List<Integer> numberIndexing = NumberPicker.numberSequenceMaker(maxIntRange, maxIntRange);
		List<Player> playerList = PlayerListMaker.playerListMaker(maxIntRange, bingoBoardSize, howManyPlayers);

		while (!GameClearJudge.gameCleareJudge(playerList, bingoLinesForClear)) {
			int pickNumberNow = numberIndexing.get(0);
			System.out.println("이번 숫자는 " + pickNumberNow);
			numberIndexing.remove(0);
			playerList = mainProcessForCheckBingo(pickNumberNow, playerList);
		}

	}

	public static List<Player> mainProcessForCheckBingo(int pickNumber, List<Player> players) {
		for (Player player : players) {
			int[] markingPosition = BoardMarker.checkNumberExistOnboard(pickNumber, player.getBingoBoard());
			if (markingPosition.length == 2) {
				Map<String,int[]> bingoLineCheckCounter = BoardMarker.boardChecker(player.getBingoCounter(), markingPosition);
				player.setBingoCounter(bingoLineCheckCounter);
				player.setMadedBingoList(BingoChecker.bingoChecker(player.getBingoCounter(),bingoBoardSize));
			}
		}
		return players;
	}

}
