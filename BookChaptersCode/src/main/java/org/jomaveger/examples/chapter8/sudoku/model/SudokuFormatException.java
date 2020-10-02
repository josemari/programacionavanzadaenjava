package org.jomaveger.examples.chapter8.sudoku.model;

public class SudokuFormatException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public SudokuFormatException(String message) {
		super(message);
	}

	public SudokuFormatException(String message, Throwable cause) {
		super(message, cause);
	}
}