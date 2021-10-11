package fr.univ_montpellier.fsd.sudoku.imp;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
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
     * check if this.grid is a correct sudoku solution.
     *
     */

    private boolean solutionChecker() {
        // TODO
        return false;

    }

    /*
     * Generate a random grid solution
     *
     */

    private void generateSolution() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                this.grid[i][j] = 1 + (int) (Math.random() * (n - 1) + 1);
            }
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
    }

    public static void main(String args[]) {
        new Sudoku(4).findSolution();

    }
}
