package fr.univ_montpellier.fsd.sudoku;

import fr.univ_montpellier.fsd.sudoku.ppc.Sudoku;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Sudoku sudokuppc = new Sudoku();
        System.out.println("Solution Sudoku proposé par PPC");
        sudokuppc.solve();
        System.out.println("-------------------------------------------------------");
        System.out.println("Solution proposée par l'équipe");
        fr.univ_montpellier.fsd.sudoku.imp.Sudoku sudokuimp = new fr.univ_montpellier.fsd.sudoku.imp.Sudoku(4);
        sudokuimp.findSolution();
    }
}
