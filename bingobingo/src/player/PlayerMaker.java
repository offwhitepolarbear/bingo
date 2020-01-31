package player;

import java.util.ArrayList;

import boardMaker.BoardMaker;

public class PlayerMaker {
	public static Player playerMaker(int maximumNumberRange,int boardSize, String userName) {
		Player player = new Player
				.Builder(userName, BoardMaker.bingoBoardMaker(maximumNumberRange, boardSize))
				.bingoBoardForCheck(new int[boardSize][boardSize])
				.madedBingoList(new ArrayList<MadedBingoInformation>())
				.build();
		return player;
	}
}
