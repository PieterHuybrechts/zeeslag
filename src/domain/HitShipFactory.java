package domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import domain.model.HitShipStrategy;

public class HitShipFactory {
	public HitShipStrategy getHitShipStrategy() throws DomainException {
		Properties p = new Properties();

		InputStream in;

		try {
			in = new FileInputStream(new File("resources\\StrategyProps.properties"));
			p.load(in);
		} catch (IOException e) {
			throw new DomainException("Properties file not found");
		}

		String className = (String) p.get("strathit");
		
		
		try {
			Class<?> clazz = Class.forName(className);
			return (HitShipStrategy) clazz.newInstance();
		} catch (Exception e){
			throw new DomainException("Strategy could not be initiated.");
		}
	}
}
