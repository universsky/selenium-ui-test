package ui.test.cases;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class TCData {
	private static final String BUNDLE_NAME = "ui.test.cases.tc"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private TCData() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
