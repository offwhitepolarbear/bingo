package checker;

public class BingoChecker {
	
	public static int bingoChecker(int[][] bingoBoard) {
		int isBingo=0;
		
		isBingo=checkDiagonal(bingoBoard);
		//System.out.print("대각체크"+isBingo);
		if(isBingo==0) {
			isBingo=checkHorizontal(bingoBoard);
			//System.out.print("수평체크"+isBingo);

		}
		if(isBingo==0) {
			isBingo=checkVertical(bingoBoard);
			//System.out.print("수직체크"+isBingo);

		}
		
		return isBingo;
		
	}
	
	public static int checkDiagonal(int[][] bingoBoard) {
		int isBingo = 0;
		int leftDiagonal = 0;
		int rightDiagonal = 0;

		for (int i = 0; i < bingoBoard.length; i++) {
			if (bingoBoard[i][i] == 1) {
				leftDiagonal++;
			}
			if (bingoBoard[bingoBoard.length - 1 - i][1] == 1) {
				rightDiagonal++;
			}
		}

		if (leftDiagonal == bingoBoard.length) {
			isBingo = 1;
		}
		if (rightDiagonal == bingoBoard.length) {
			isBingo = 2;
		}

		return isBingo;
	}
	
	public static int checkHorizontal(int[][] bingoBoard) {
		
		int isBingo = 0;

		for (int i = 0; i < bingoBoard[0].length; i++) {
			int isChecked = 0;

			for (int j = 0; j < bingoBoard[0].length; j++) {
				if (bingoBoard[i][j] == 1) {
					isChecked++;
				}
			}

			if (isChecked == bingoBoard.length) {
				isBingo = i + 1;
				break;
			}
		}

		return isBingo;
	}

	public static int checkVertical(int[][] bingoBoard) {
		
		int isBingo = 0;

		for (int i = 0; i < bingoBoard[0].length; i++) {
			int isChecked = 0;

			for (int j = 0; j < bingoBoard[0].length; j++) {
				if (bingoBoard[j][i] == 1) {
					isChecked++;
				}
			}

			if (isChecked == bingoBoard.length) {
				isBingo = i + 1;
				break;
			}
		}

		return isBingo;
	}


}
