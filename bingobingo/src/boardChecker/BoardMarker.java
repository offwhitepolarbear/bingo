package boardChecker;

import java.util.Map;

public class BoardMarker {
	public static Map<String, int[]> boardChecker(Map<String, int[]> bingoLineCounter, int[] markingPosition) {

		if (markingPosition.length == 2) {
			int boardSize = bingoLineCounter.get("verticalCheckCounter").length;
			int x = markingPosition[0];
			int y = markingPosition[1];
			bingoLineCounter.get("verticalCheckCounter")[x]++;
			bingoLineCounter.get("horizontalCheckCounter")[y]++;
			if(x==y) {
				bingoLineCounter.get("diagonalCheckCounter")[0]++;
			}
			if(x+y==boardSize) {
				bingoLineCounter.get("diagonalCheckCounter")[1]++;
			}
			System.out.print("세로 ");
			System.out.print(markingPosition[0] + 1);
			System.out.print(" 번째 가로  ");
			System.out.print(markingPosition[1] + 1);
			System.out.println(" 번째 칸이 체크 되었습니다.");
		} else {
			System.out.println("해당하는 숫자가 빙고판에 없습니다.");
		}

		return bingoLineCounter;
	}

	public static int[] checkNumberExistOnboard(int pickNumber, int[][] bingoBoard) {
		int[] markingPosition = {};
		for (int i = 0; i < bingoBoard[0].length; i++) {
			for (int j = 0; j < bingoBoard[0].length; j++) {
				if (pickNumber == bingoBoard[i][j]) {
					markingPosition = new int[] { i, j };
				}
			}
		}
		return markingPosition;
	}
}
