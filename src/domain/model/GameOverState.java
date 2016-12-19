package domain.model;

import domain.service.BoardGame;

public class GameOverState implements GameState{

	private BoardGame game;
	
	public GameOverState(BoardGame game) {
		this.game = game;
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newGame() {
		// TODO Auto-generated method stub
		
	}

}
