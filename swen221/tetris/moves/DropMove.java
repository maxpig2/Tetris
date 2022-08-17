// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.moves;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Rectangle;
import swen221.tetris.tetromino.ActiveTetromino;
import swen221.tetris.tetromino.Tetromino;

/**
 * Implements a "hard drop". That is, when the tetromino is immediately dropped
 * all the way down as far as it can go.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public class DropMove implements Move {
	@Override
	public boolean isValid(Board board) {

		ActiveTetromino tetromino = board.getActiveTetromino();
		return board.canPlaceTetromino(tetromino);

	}

	@Override
	public Board apply(Board board) {

		// Create copy of the board to prevent modifying its previous state.
		board = new Board(board);
		// Create a copy of this board which will be updated.
		ActiveTetromino tetromino = board.getActiveTetromino();
		// Apply the move to the new board, rather than to this board.
		board.setActiveTetromino(tetromino);
		// Return updated version of this board.
		//while (tetromino.isWithin(board.getWidth(),board.getHeight())) {
			board.setPlacedTetrominoAt(board.getWidth(),board.getWidth(),tetromino);
	//	}
		return board;

	}

	@Override
	public String toString() {
		return "drop";
	}
}
