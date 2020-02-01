package checker;

import java.util.ArrayList;
import java.util.List;

import player.BingoDirection;
import player.MadedBingoInformation;

public class BingoChecker {
	//빙고 보드 체크하면서 돌때 좌표를 따서 그걸 모아둔다면? 한줄 길이만큼 되었을때 확인할 수 있다
	//대각선의 경우 패턴이 정해져 있는건 맞는데 어떻게 처리하는게 더 효율적일지 생각을 좀 더 해봐야 할 듯.
	/*testcode
	public static void main(String[] args) {
		int testBoardSize = 3;
		int[][] testBoard = new int[testBoardSize][testBoardSize]  ;
		testBoard[0]= new int[] {1,1,1};
		testBoard[1]= new int[] {0,1,0};
		testBoard[2]= new int[] {1,0,1};
		
		List<MadedBingoInformation> bingoList = bingoChecker(testBoard);
		
		for(MadedBingoInformation bingoInfo : bingoList) {
			System.out.println(bingoInfo);
		}
	}
	*/
	
	public static List<MadedBingoInformation> bingoChecker(int[][] bingoBoardForCheck) {
		List<MadedBingoInformation> madedBingoList = new ArrayList<MadedBingoInformation>();
		madedBingoList.addAll(checkDiagonal(bingoBoardForCheck));
		madedBingoList.addAll(checkVerticalAndHorizontal(bingoBoardForCheck));
		return madedBingoList;
	}
	
	public static List<MadedBingoInformation> checkDiagonal(int[][] bingoBoardForCheck) {
		List<MadedBingoInformation> madedBingoInfomationList = new ArrayList<MadedBingoInformation>();
	
		int leftDiagonal = 0;
		int rightDiagonal = 0;

		for (int i = 0; i < bingoBoardForCheck.length; i++) {
			if (bingoBoardForCheck[i][i] == 1) {
				leftDiagonal++;
			}
			if (bingoBoardForCheck[bingoBoardForCheck.length -1 -i][1] == 1) {
				rightDiagonal++;
			}
		}

		if (leftDiagonal == bingoBoardForCheck.length) {
			madedBingoInfomationList
			.add(new MadedBingoInformation
					.Builder(BingoDirection.Diagonal, 1)
					.build());		
		}
		if (rightDiagonal == bingoBoardForCheck.length) {
			madedBingoInfomationList
			.add(new MadedBingoInformation
					.Builder(BingoDirection.Diagonal, 2)
					.build());			
		}

		return madedBingoInfomationList;
	}
	
	public static List<MadedBingoInformation> checkVerticalAndHorizontal(int[][] bingoBoardForCheck) {
		
		List<MadedBingoInformation> madedBingoInfomationList = new ArrayList<MadedBingoInformation>();

		for (int i = 0; i < bingoBoardForCheck[0].length; i++) {
			
			int horizontalChecked = 0;
			int verticalChecked = 0;
			
			for (int j = 0; j < bingoBoardForCheck[0].length; j++) {
				if (bingoBoardForCheck[i][j] == 1) {
					horizontalChecked++;
				}
				if (bingoBoardForCheck[j][i] == 1) {
					verticalChecked++;
				}
			}

			if (horizontalChecked == bingoBoardForCheck.length) {
				madedBingoInfomationList
				.add(new MadedBingoInformation
						.Builder(BingoDirection.Horizontal, i+1)
						.build());
			}
			
			if (verticalChecked == bingoBoardForCheck.length) {
				madedBingoInfomationList
				.add(new MadedBingoInformation
						.Builder(BingoDirection.Vertical, i+1)
						.build());			
			}
		}

		return madedBingoInfomationList;
	}

}
