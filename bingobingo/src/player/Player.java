package player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
	private final String name;
	private final int[][] bingoBoard;
	private Map<String,int[]> bingoCounter;
	private List<MadedBingoInformation> madedBingoList;

	private Player(Builder builder) {
		this.name = builder.name;
		this.bingoBoard = builder.bingoBoard;
		this.bingoCounter = new HashMap<String,int[]>();
		this.bingoCounter.put("verticalCheckCounter", builder.verticalCheckCounter);
		this.bingoCounter.put("horizontalCheckCounter", builder.horizontalCheckCounter);
		this.bingoCounter.put("diagonalCheckCounter", builder.diagonalCheckCounter);
		this.madedBingoList = builder.madedBingoList;
	}

	public static class Builder {
		private String name;
		private int[][] bingoBoard;
		private int[] verticalCheckCounter;
		private int[] horizontalCheckCounter;
		private int[] diagonalCheckCounter;
		private List<MadedBingoInformation> madedBingoList;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder bingoBoard(int[][] bingoBoard) {
			this.bingoBoard = bingoBoard;
			return this;
		}

		public Builder verticalCheckCounter(int[] verticalCheckCounter) {
			this.verticalCheckCounter = verticalCheckCounter;
			return this;
		}

		public Builder horizontalCheckCounter(int[] horizontalCheckCounter) {
			this.horizontalCheckCounter = horizontalCheckCounter;
			return this;
		}

		public Builder diagnalCheckCounter(int[] diagnalCheckCounter) {
			this.diagonalCheckCounter = diagnalCheckCounter;
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


	public Map<String, int[]> getBingoCounter() {
		return bingoCounter;
	}

	public void setBingoCounter(Map<String, int[]> bingoCounter) {
		this.bingoCounter = bingoCounter;
	}

	public String getName() {
		return name;
	}

	public int[][] getBingoBoard() {
		return bingoBoard;
	}

	public List<MadedBingoInformation> getMadedBingoList() {
		return madedBingoList;
	}

	public void setMadedBingoList(List<MadedBingoInformation> madedBingoList) {
		this.madedBingoList = madedBingoList;
	}

}
