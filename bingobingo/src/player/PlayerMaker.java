package player;

import java.util.ArrayList;
import java.util.List;

import boardMaker.BoardMaker;

public class PlayerMaker {
	public static Player playerMaker(int maximumNumberRange,int boardSize, String userName) {
		
		List<Integer> numberListForBingoBoard = BoardMaker.chooseNumbersForMakingBingoBoard(maximumNumberRange, boardSize);
		
		Player player = new Player
				.Builder(userName, BoardMaker.bingoBoardMaker(numberListForBingoBoard, boardSize))
				.bingoBoardForCheck(new int[boardSize][boardSize])
				.madedBingoList(new ArrayList<MadedBingoInformation>())
				.build();
		
		return player;
	}
}
