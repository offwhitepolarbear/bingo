package player;

import java.util.ArrayList;
import java.util.List;

import boardMaker.BoardMaker;

public class PlayerMaker {
	public static Player playerMaker(int maximumNumberRange, int boardSize, String userName) {
		
		List<Integer> numberListForBingoBoard = BoardMaker.chooseNumbersForMakingBingoBoard(maximumNumberRange, boardSize);
		int[][] bingoBoard = BoardMaker.bingoBoardMaker(numberListForBingoBoard, boardSize);
		Player player = new Player
				.Builder()
				.name(userName)
				.bingoBoard(bingoBoard)
				.horizontalCheckCounter(new int[boardSize])
				.verticalCheckCounter(new int[boardSize])
				.diagnalCheckCounter(new int[2])
				.madedBingoList(new ArrayList<MadedBingoInformation>())
				.build();
		return player;
	}
}
