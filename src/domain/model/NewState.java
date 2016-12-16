package domain.model;

import domain.service.BoardGame;

public class NewState implements GameState {
	private BoardGame game;
	public NewState(BoardGame game){
		this.game = game;
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		game.setState(game.getStartedState());
	}

	/*@Override
	public boolean isready() {
		// TODO Auto-generated method stub
		return false;
	}*/

	@Override
	public void newGame() {
		// TODO Auto-generated method stub
		throw new IllegalStateException("Can't start a new game when game isn't started yet.");
	}

}
