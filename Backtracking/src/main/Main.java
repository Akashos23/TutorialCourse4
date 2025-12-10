package main;

import knapsack.KnapSackService;
import sudoku.Sudoku;

public class Main {

	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku();
		sudoku.InitSudokuGrid();
		
		System.out.println(sudoku.toString());
		
		sudoku.SolveSoduku();
		System.out.println(sudoku.toString());
		
		int[] weight = new int[] {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		int[] value = new int[] {15, 18, 15, 17, 21, 20, 19, 21, 23, 24, 24, 25};

		int totalValue = 0;
		
		for(int i = 0; i < value.length; i++) {
			totalValue += value[i];
		}
		
		KnapSackService knapSackService = new KnapSackService(90, 0);
		knapSackService.KnapSackMethod(0, 0, totalValue, value, weight);
		
		System.out.println(knapSackService.getMaximumValue());
		System.out.println(knapSackService.toString());
	}

}
