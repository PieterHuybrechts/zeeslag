package app;

import domain.DomainException;
import ui.controller.Controller;
import ui.view.View;

public class App {
	
	public static void main(String[] args){
		
		try {
			Controller controller = new Controller();
			View view = new View();
			controller.setView(view);
			view.setController(controller);
			
			controller.start();
		} catch (DomainException e) {
			System.exit(1);
		}
	}
	
}
