package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import knapsack.KnapSackService;

class KnapSackServiceTest {

	@Test
	void test() {
		int[] weight = new int[] {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		int[] value = new int[] {15, 18, 15, 17, 21, 20, 19, 21, 23, 24, 24, 25};
		
		int[] limW = new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190};
 		int[] maxVal = new int[] {15, 24, 42, 59, 74, 86, 98, 112, 123, 138, 150, 162, 174, 185, 199, 208, 223, 227, 242};
 		String[] chemin = new String[] {"0", "9", "1 - 9", "1 - 4 - 5", "0 - 1 - 4 - 5", "0 - 1 - 2 - 3 - 4", "0 - 1 - 4 - 5 - 9", "0 - 1 - 2 - 4 - 5 - 8", "0 - 1 - 4 - 5 - 9 - 11", "0 - 1 - 3 - 4 - 5 - 8 - 9", "0 - 1 - 2 - 3 - 4 - 5 - 7 - 8", "0 - 1 - 3 - 4 - 5 - 8 - 9 - 10", "0 - 1 - 2 - 3 - 4 - 5 - 7 - 8 - 9", "0 - 1 - 2 - 4 - 5 - 8 - 9 - 10 - 11", "0 - 1 - 2 - 3 - 4 - 5 - 7 - 8 - 9 - 11", "0 - 1 - 3 - 4 - 5 - 7 - 8 - 9 - 10 - 11", "0 - 1 - 2 - 3 - 4 - 5 - 7 - 8 - 9 - 10 - 11", "0 - 1 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 11", "0 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 11"};
		
 		int totalValue = 0;
		
		for(int i = 0; i < value.length; i++) {
			totalValue += value[i];
		}
		
		for(int i = 0; i  < limW.length; i++) {
			KnapSackService knapSackService = new KnapSackService(limW[i], 0);
			knapSackService.KnapSackMethod(0, 0, totalValue, value, weight);
			
			assertEquals(maxVal[i], knapSackService.getMaximumValue());
			assertEquals(chemin[i], knapSackService.toString());
		}
	}

}
