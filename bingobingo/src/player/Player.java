package player;

import java.util.List;

public class Player {
	String name;
	int [][] bingoBoard;
	int [][] bingoBoardForCheck;
	List<MadedBingoInformation> madedBingoList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[][] getBingoBoard() {
		return bingoBoard;
	}
	public void setBingoBoard(int[][] bingoBoard) {
		this.bingoBoard = bingoBoard;
	}
	public int[][] getBingoBoardForCheck() {
		return bingoBoardForCheck;
	}
	public void setBingoBoardForCheck(int[][] bingoBoardForCheck) {
		this.bingoBoardForCheck = bingoBoardForCheck;
	}
	public List<MadedBingoInformation> getMadedBingoList() {
		return madedBingoList;
	}
	public void setMadedBingoList(List<MadedBingoInformation> madedBingoList) {
		this.madedBingoList = madedBingoList;
	}
	
}
