package player;

import java.util.ArrayList;

public class Player {
	int [][] bingoBoard;
	int [][] bingoBoardForCheck;
	ArrayList<MadedBingoInfomation> madedBingoList;
	
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
	public ArrayList<MadedBingoInfomation> getMadedBingoList() {
		return madedBingoList;
	}
	public void setMadedBingoList(ArrayList<MadedBingoInfomation> madedBingoList) {
		this.madedBingoList = madedBingoList;
	}
	
}
