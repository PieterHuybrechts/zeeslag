package domain.model.state;

import domain.service.BoardGame;

/**
 * @author Thomas Vanzegbroeck
 */
public class EndedState implements GameState {
	private BoardGame game;
	public EndedState(BoardGame game){
		this.game = game;
	}
	@Override
	public void start() {
		throw new IllegalStateException("Ended game can't be started");
		
	}

	@Override
	public void newGame() {
		game.setState(game.getNewSate());
	}

	@Override
	public void endGame() {
		throw new IllegalStateException("A game that is ended can't be ended again");
	}

}
