package fr.univ_montpellier.fsd.sudoku.imp;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;

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
		// TODO

	}

	/*
	 * Find a solution to the sudoku problem
	 * 
	 */
	public void findSolution() {

		// TODO
	}

	public static void main(String args[]) {
		new Sudoku(4).findSolution();

	}
}
