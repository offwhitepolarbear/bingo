package starter;

import java.util.ArrayList;

import boardChecker.BoardMarker;
import checker.BingoChecker;
import checker.GameClearJudge;
import numberPicker.NumberPicker;
import player.BingoDirection;
import player.Player;
import player.PlayerMaker;

public class Starter {
	static int bingoBoardSize = 5;
	static int maxIntRange = 100;
	static int bingoLinesForClear = 1;
	
	public static void main(String[] args) {
		ArrayList<Integer> numberIndexing = NumberPicker.numberSequenceMaker(maxIntRange, maxIntRange);
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(PlayerMaker.playerMaker(maxIntRange, bingoBoardSize, "1�� ����"));
		playerList.add(PlayerMaker.playerMaker(maxIntRange, bingoBoardSize, "2�� ����"));
		playerList.add(PlayerMaker.playerMaker(maxIntRange, bingoBoardSize, "4�� ����"));
		
		while(!GameClearJudge.gameCleareJudge(playerList, bingoLinesForClear)) {
			int pickNumberNow = numberIndexing.get(0);
			System.out.println("�̹��� ���� ���ڴ�  "+pickNumberNow);
			numberIndexing.remove(0);
			playerList = mainProcessForCheckBingo(pickNumberNow, playerList);
		}
		
	}
	
	public static ArrayList<Player> mainProcessForCheckBingo(int pickNumber, ArrayList<Player> players) {
		for(Player player : players) {
			int[] markingPostion = BoardMarker.bingoBoardMarker(pickNumber, player.getBingoBoard());
			int[][] bingoBoardForCheck = BoardMarker.boardChecker(player.getBingoBoardForCheck(), markingPostion);
			player.setBingoBoardForCheck(bingoBoardForCheck);
			player.setMadedBingoList(BingoChecker.bingoChecker(player.getBingoBoardForCheck()));
		}
		return players;
	}


}
