package starter;

import java.util.ArrayList;

import checker.BingoChecker;
import numberPicker.NumberPicker;

public class Starter {
	static int bingoBoardSize = 5;
	static int maxIntRange = 100;
	static boolean clearTrigger = true;
	
	static int[][] playerOne = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
			{ 21, 22, 23, 24, 25 } };
	static int[][] playerOneChecker = new int[bingoBoardSize][bingoBoardSize];
	static int[][] playerTwo = new int[bingoBoardSize][bingoBoardSize];

	static int[][] playerTwoChecker = new int[bingoBoardSize][bingoBoardSize];

	static ArrayList<Integer> alreadyNumberingList = new ArrayList<Integer>();

	public static void main(String[] args) {
		int playerOneIsBingo = 0;
		int playerTwoIsBingo = 0;
		playerTwo[0] = new int[] { 5, 4, 3, 2, 1 };
		playerTwo[1] = new int[] { 99, 98, 97, 96, 94 };
		playerTwo[2] = new int[] { 49, 98, 67, 76, 35 };
		playerTwo[3] = new int[] { 29, 58, 27, 36, 34 };
		playerTwo[4] = new int[] { 39, 48, 37, 77, 33 };
		
		while (playerOneIsBingo==0 && playerTwoIsBingo==0) {
			int pickedNumber = NumberPicker.randomNumberPicker(maxIntRange);
			System.out.println("이번에 나온 숫자는 "+pickedNumber);
			bingoBoardMarker(pickedNumber);
			playerOneIsBingo=BingoChecker.bingoChecker(playerOneChecker);
			if(playerOneIsBingo!=0) {
				System.out.println("1번 빙고임");
				System.out.println(playerOneIsBingo+"번째 줄이 빙고임");
			}
			playerTwoIsBingo=BingoChecker.bingoChecker(playerTwoChecker);
			if(playerTwoIsBingo!=0) {
				System.out.println("2번 빙고임");
				System.out.println(playerTwoIsBingo+"번째 줄이 빙고임");
			}
		}
	}
	
	public static void bingoBoardMarker(int pickNumber) {
		for(int i=0;i<bingoBoardSize;i++) {
			for(int j=0;j<bingoBoardSize;j++) {
				if(pickNumber==playerOne[i][j]) {
					playerOneChecker[i][j]=1;
					System.out.println("1번의 세로 "+(i+1)+"번째 가로 "+(j+1)+"번째 칸의 "+pickNumber+" 번 이 마킹됨");
				}
				if(pickNumber==playerTwo[i][j]) {
					playerTwoChecker[i][j]=1;
					System.out.println("2번의 세로 "+(i+1)+"번째 가로 "+(j+1)+"번째 칸의 "+pickNumber+" 번 이 마킹됨");
				}
			}
		}
	}


}
