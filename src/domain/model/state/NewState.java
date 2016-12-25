package domain.model.state;

import domain.service.BoardGame;

/**
 * @author Thomas Vanzegbroeck & Pieter Huybrechts
 */
public class NewState implements GameState {
	private BoardGame game;
	public NewState(BoardGame game){
		this.game = game;
	}
	@Override
	public void start() {
		game.setState(game.getStartedState());
	}

	@Override
	public void newGame() {
		throw new IllegalStateException("Can't start a new game when game isn't started yet.");
	}
	@Override
	public void endGame() {
		throw new IllegalStateException("A game that isn't started yet can't be ended");
	}

}
