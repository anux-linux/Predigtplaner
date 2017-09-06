package sbb.controler;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import sbb.gui.PlanerPanel;

/**
 * Hier werden alle Daten, die mit der Planung verbunden sind verwaltet. Es
 * enthält das Mapping zwischen Prediger und Aufgabe
 * 
 * @author Antonio
 *
 */
public class PlanerController extends SubController {

    private final MainController mainController;
    private PlanerPanel planerPanel;

    public PlanerController(MainController controller) {
	super(controller);
	this.mainController = controller;
	this.createPlanerPanel();
    }

    public PlanerPanel getPlanerPanel() {
	return this.planerPanel;
    }

    private void createPlanerPanel() {
	this.planerPanel = new PlanerPanel(this);
	this.updatePlanerPanel();

    }

    public void updatePlanerPanel() {
	this.planerPanel.removeAll();
	JTable mainTableCalendar = planerPanel.createCalendar(mainController.getPreachers(),
		mainController.getPreachingTasks());
	JScrollPane calendarScrollPane = new JScrollPane(mainTableCalendar);

	this.planerPanel.add(calendarScrollPane);
	this.planerPanel.updateUI();
    }

}
