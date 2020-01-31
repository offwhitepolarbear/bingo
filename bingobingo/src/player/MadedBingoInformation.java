package player;

public class MadedBingoInformation {
	
	private final BingoDirection bingoDirection;
	private final int whichLine;
	
	public MadedBingoInformation(Builder builder) {
		this.bingoDirection = builder.bingoDirection;
		this.whichLine = builder.whichLine;
	}
	
	public static class Builder{
		private final BingoDirection bingoDirection;
		private final int whichLine;
		public Builder(BingoDirection bingoDirection, int whichLine) {
			this.bingoDirection = bingoDirection;
			this.whichLine = whichLine;
		}
		public MadedBingoInformation build() {
			return new MadedBingoInformation(this);
		}
	}
	
	public BingoDirection getBingoDirection() {
		return bingoDirection;
	}

	public int getWhichLine() {
		return whichLine;
	}
	
	@Override
	public String toString() {
		return "완성빙고 정보 : " + bingoDirection + " 방향 " + whichLine + " 번째 줄";
	}
	
}
