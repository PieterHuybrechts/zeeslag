package domain.model.observer;

/**
 * @author Pieter Huybrechts
 */
public interface Subject {

	public void addObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
	
}
