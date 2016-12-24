package domain.model.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import domain.DomainException;
import domain.model.PlaceShipStrategy;

public class PlaceShipFactory {
	public PlaceShipStrategy getPlaceShipStrategy() throws DomainException {
		Properties p = new Properties();

		InputStream in;

		try {
			in = new FileInputStream(new File("resources\\StrategyProps.properties"));
			p.load(in);
		} catch (IOException e) {
			throw new DomainException("Properties file not found");
		}

		String className = (String) p.get("strat");
		
		
		try {
			Class<?> clazz = Class.forName(className);
			return (PlaceShipStrategy) clazz.newInstance();
		} catch (Exception e){
			throw new DomainException("Strategy could not be initiated.");
		}
	}
}
