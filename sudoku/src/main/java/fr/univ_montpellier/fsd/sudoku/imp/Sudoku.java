package fr.univ_montpellier.fsd.sudoku.imp;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sudoku {

    int n;
    int s;
    int[][] grid;

    /*
     * Create an instance of the problem sudoku (nxn)
     *
     */

    public Sudoku(int n) {
        this.n = n;
        this.s = (int) Math.sqrt(n);
        this.grid = new int[n][n];
    }

	/*
	 * [[x, x, x, x]
	 * 	[x, x, x, x]
	 * 	[x, x, x, x]
	 * 	[x, x, x, x]]
	 */

	/*
	 * check if this.grid is a correct sudoku solution.
	 * 
	 */

	private boolean solutionChecker() {
		// Test de allDifferent sur chaque ligne
		for (int i = 0; i < n; i++) {
			int[] tab = new int[n];

			for (int j = 0; j < n; j++)
				tab[j] = grid[j][i];

			if (!allDifferent(grid[i]) || !allDifferent(tab))
				return false;
		}

		// Test de allDifferent sur les carrés
		int squareSize = (int) Math.sqrt(n);
		
		for(int i = 0; i < n; i += squareSize) {
			int[] tab = new int[n];
			int counter = 0;
			
			for (int j = 0; j < squareSize; j++)
				for (int k = 0; k < squareSize; k++) {
					tab[counter] = grid[j+i][k+i];
					counter++;
				}
			
			if (!allDifferent(tab))
				return false;
		}

		return true;
	}

	private boolean allDifferent(int... elements) {
		for (int i = 0; i < elements.length - 1; i++)
			for (int j = i + 1; j < elements.length; j++)
				if (elements[i] == elements[j])
					return false;
		return true;
	}

    /*
     * Generate a random grid solution
     *
     */

    private void generateSolution() {
        /*for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                this.grid[i][j] = 1 + (int) (Math.random() * (n - 1) + 1);
            }
        }*/

        //Version un peu plus opti
        List<Integer> possible_solution = new ArrayList<>();
        for (int i = 1; i <= this.n; i++) {
            possible_solution.add(i);
        }
        for (int j = 0; j < this.grid.length; j++) {
            Collections.shuffle(possible_solution);
            this.grid[j] = possible_solution.stream().mapToInt(i -> i).toArray();
        }
    }

    /*
     * Find a solution to the sudoku problem
     *
     */
    public void findSolution() {
        do {
            generateSolution();
        } while (!solutionChecker());
        printSudoku();
    }

    private void printSudoku() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print("c_" + i + "_" + j + " = " + grid[i][j]);
                if (j == grid[i].length - 1) {
                    System.out.print("\n");
                } else {
                    System.out.print("\t");
                }
            }
        }
    }

    public static void main(String args[]) {
        new Sudoku(4).findSolution();

    }
}
