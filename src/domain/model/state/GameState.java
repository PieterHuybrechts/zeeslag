package domain.model.state;

/**
 * @author Thomas Vanzegbroeck & Pieter Huybrechts
 */
public interface GameState {
	public void start();
	public void newGame();
	public void endGame();
}
