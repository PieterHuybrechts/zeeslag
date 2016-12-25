package domain.model.state;

import domain.service.BoardGame;

/**
 * @author Thomas Vanzegbroeck & Pieter Huybrechts
 */
public class StartedState implements GameState{
	private BoardGame game;
	public StartedState(BoardGame game){
		this.game = game;
	}
	@Override
	public void start() {
		throw new IllegalStateException("Can't start a gaùe that is already started.");
	}

	@Override
	public void newGame() {
		game.setState(game.getNewSate());
	}
	@Override
	public void endGame() {
		game.setState(game.getEndedState());
	}

}
