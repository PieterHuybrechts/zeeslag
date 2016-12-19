package domain.model;

import domain.service.BoardGame;

public class EndedState implements GameState {
	private BoardGame game;
	public EndedState(BoardGame game){
		this.game = game;
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		throw new IllegalStateException("Ended game can't be started");
		
	}

	@Override
	public void newGame() {
		// TODO Auto-generated method stub
		game.setState(game.getNewSate());
	}

	@Override
	public void endGame() {
		// TODO Auto-generated method stub
		throw new IllegalStateException("A game that is ended can't be ended again");
	}

}
