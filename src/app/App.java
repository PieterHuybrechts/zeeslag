package app;

import domain.DomainException;
import ui.controller.Controller;

public class App {
	
	public static void main(String[] args){
		
		try {
			Controller controller = new Controller();
			
			controller.start();
		} catch (DomainException e) {
			System.exit(1);
		}
	}
	
}
