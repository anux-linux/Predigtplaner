/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbb.helper;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Antonio
 */
public class I18NHelper {

    private static I18NHelper i18nHelper = null;

    private final String path = "sbb/resources/";
    private final String stringproperties = "I18NStrings";
    private final ResourceBundle stringResources;

    private final String defaultSeperator;

    public I18NHelper(Locale locale) {
	stringResources = ResourceBundle.getBundle(path + stringproperties, locale);
	this.defaultSeperator = stringResources.getString("default.separator");
    }

    public static void init(Locale locale) {
	if (i18nHelper == null) {
	    i18nHelper = new I18NHelper(locale);
	}
    }

    public static I18NHelper getInstance() throws InstantiationException {
	if (i18nHelper == null) {
	    throw new InstantiationException("You need to call init(Locale) first.");
	}
	return i18nHelper;
    }

    public String getStringResource(String key) {
	return stringResources.getString(key);
    }

    public String[] getStringResourceArray(String key) {
	return stringResources.getString(key).split(this.defaultSeperator);
    }

}
