package org.jomaveger.examples.chapter7.sudoku.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import org.jomaveger.examples.chapter7.sudoku.controller.ButtonController;
import org.jomaveger.examples.chapter7.sudoku.controller.SudokuController;
import org.jomaveger.examples.chapter7.sudoku.model.Game;

public class Sudoku extends JFrame {

	private static final long serialVersionUID = 1L;

	public Sudoku() {
		super("Sudoku");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());

		Game game = new Game();

		ButtonController buttonController = new ButtonController(game);
		ButtonPanel buttonPanel = new ButtonPanel();
		buttonPanel.setController(buttonController);
		add(buttonPanel, BorderLayout.EAST);

		SudokuPanel sudokuPanel = new SudokuPanel();
		SudokuController sudokuController = new SudokuController(sudokuPanel, game);
		sudokuPanel.setGame(game);
		sudokuPanel.setController(sudokuController);
		add(sudokuPanel, BorderLayout.CENTER);

		game.addObserver(buttonPanel);
		game.addObserver(sudokuPanel);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
