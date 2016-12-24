package domain.model.state;

import domain.service.BoardGame;

public class StartedState implements GameState{
	private BoardGame game;
	public StartedState(BoardGame game){
		this.game = game;
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		throw new IllegalStateException("Can't start a gaùe that is already started.");
	}

	/*@Override
	public boolean isready() {
		// TODO Auto-generated method stub
		return false;
	}*/

	@Override
	public void newGame() {
		// TODO Auto-generated method stub
		game.setState(game.getNewSate());
	}
	@Override
	public void endGame() {
		// TODO Auto-generated method stub
		game.setState(game.getEndedState());
	}

}
