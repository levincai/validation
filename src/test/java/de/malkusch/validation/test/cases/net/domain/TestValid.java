package de.malkusch.validation.test.cases.net.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;

import de.malkusch.validation.constraints.net.Domain;
import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.AbstractBean;

/**
 * @author Markus Malkusch
 */
public class TestValid extends AbstractValidTest {
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@Domain
		public String getProperty() {
			return super.getProperty();
		}
		
	}
	
	public <T>TestValid(Class<AbstractBean<T>> beanType, T property) {
		super(beanType, property);
	}

	@Parameters
	static public List<Object[]> beans() {
		return Arrays.asList(new Object[][] {
				{ Bean.class, null },
				{ Bean.class, "malkusch.de" },
				{ Bean.class, "www.malkusch.de" },
				{ Bean.class, "malkusch.org" },
				{ Bean.class, "malkusch.net" },
				{ Bean.class, "malkusch.arpa" },
				{ Bean.class, "malkusch.aero" },
		});
	}

}
