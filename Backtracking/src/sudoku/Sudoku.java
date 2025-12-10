package sudoku;

import java.util.Random;

public class Sudoku {
	private int[][] tabSudoku;
	
	public Sudoku() {
		this.tabSudoku = new int[9][9];
	}
	
	public int[][] InitSudokuGrid(){
		
		int cpt = 0;
		while(cpt < 9) {
			Random rd = new Random();
			
			
			int i = rd.nextInt(9);
			int y = rd.nextInt(9);
			
			while(this.tabSudoku[i][y] > 0) {
				i = rd.nextInt(9);
				y = rd.nextInt(9);
			}
			int val = rd.nextInt(9) + 1;
			
			while(isPresentHorizontale(i, val) || isPresentVerticale(y, val) || isPresentBloc(i, y, val)) {
				val = rd.nextInt(9) + 1;
			}
			
			
			this.tabSudoku[i][y] = val;
			cpt++;
		}
		return tabSudoku;
	}
	
	public Boolean isPresentHorizontale(int i, int val) {		
		for(int horizontale = 0; horizontale < this.tabSudoku[0].length; horizontale++) {
			if(this.tabSudoku[i][horizontale] == val) {
				return true;
			}
		}
		
		return false;
	}
	
    public Boolean isPresentVerticale(int y, int val) {
    	for(int verticale = 0; verticale < this.tabSudoku[0].length; verticale++) {
			if(this.tabSudoku[verticale][y] == val) {
				return true;
			}
		}
		
		return false;
	}

    public Boolean isPresentBloc(int i, int y, int val) {
        int startI = (i / 3) * 3;
        int startY = (y / 3) * 3;

        for(int t = startI; t < startI + 3; t++) {
            for(int s = startY; s < startY + 3; s++) {
                if(this.tabSudoku[t][s] == val) {
                    return true;
                }
            }
        }
        return false;
    }
    	

    
    public boolean SolveSoduku() {
        for (int i = 0; i < this.tabSudoku.length; i++) {
            for (int y = 0; y < this.tabSudoku[0].length; y++) {
                if (this.tabSudoku[i][y] == 0) {
                    int val = 1;
                    while (val <= 9) {
                        if (!isPresentHorizontale(i, val) &&
                            !isPresentVerticale(y, val) &&
                            !isPresentBloc(i, y, val)) {

                            this.tabSudoku[i][y] = val;

                            if (SolveSoduku()) {
                                return true;       
                            }
                            this.tabSudoku[i][y] = 0;
                        }

                        val++;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    
	
	@Override
	public String toString() {
		String tab = "";
		int cpt = 0;
		while(cpt < 9) {
			if(cpt == 0) {
				tab += " ";
			}
			tab += " —— ";
			cpt++;
		}
		tab += "\n";
		for(int i = 0; i < this.tabSudoku.length; i++) {
			for(int y = 0; y < this.tabSudoku[0].length; y++) {
				if(y == 0) {
					tab += " | ";
				}
				if(this.tabSudoku[i][y] != 0) {
					tab += " " + this.tabSudoku[i][y] + " ";
				}
				else {
					tab += " 0 ";
				}
				if((y+1) % 3 == 0) {
					tab += " | ";
				}
			}
			tab += "\n";
			if((i+1) % 3 == 0) {
				int cpt2 = 0;
				while(cpt2 < 9) {
					if(cpt2 == 0) {
						tab += " ";
					}
					tab += " —— ";
					cpt2++;
				}
				tab += "\n";
			}
			
		}
		
		return tab;
	}
}
