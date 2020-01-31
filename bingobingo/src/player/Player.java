package player;

import java.util.List;

public class Player {
	private final String name;
	private final int[][] bingoBoard;
	int[][] bingoBoardForCheck;
	List<MadedBingoInformation> madedBingoList;

	private Player(Builder builder) {
		this.name = builder.name;
		this.bingoBoard = builder.bingoBoard;
		this.bingoBoardForCheck = builder.bingoBoardForCheck;
		this.madedBingoList = builder.madedBingoList;
	}

	public static class Builder {
		private final String name;
		private final int[][] bingoBoard;

		private int[][] bingoBoardForCheck;
		private List<MadedBingoInformation> madedBingoList;

		public Builder(String name, int[][] bingoBoard) {
			this.name = name;
			this.bingoBoard = bingoBoard;
		}

		public Builder bingoBoardForCheck(int[][] bingoBoardForCheck) {
			this.bingoBoardForCheck = bingoBoardForCheck;
			return this;
		}

		public Builder madedBingoList(List<MadedBingoInformation> madedBingoList) {
			this.madedBingoList = madedBingoList;
			return this;
		}

		public Player build() {
			return new Player(this);
		}

	}

	public String getName() {
		return name;
	}

	public int[][] getBingoBoard() {
		return bingoBoard;
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
