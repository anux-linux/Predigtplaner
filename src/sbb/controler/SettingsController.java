package sbb.controler;

import sbb.gui.SettingsPanel;

/**
 * Hier werden alle Daten, die mit der Planung verbunden sind verwaltet. Es
 * enthält das Mapping zwischen Prediger und Aufgabe
 * 
 * @author Antonio
 *
 */
public class SettingsController extends SubController {

    private SettingsPanel settingsPanel;

    public SettingsController(MainController controller) {
	super(controller);
	this.createSettingsPanel();
    }

    public SettingsPanel getSettingsPanel() {
	return this.settingsPanel;
    }

    private void createSettingsPanel() {
	this.settingsPanel = new SettingsPanel(this);

    }
}
