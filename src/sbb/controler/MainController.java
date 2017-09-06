package sbb.controler;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.WindowConstants;

import sbb.gui.MainFrame;
import sbb.gui.MainPanel;
import sbb.helper.I18NHelper;
import sbb.helper.date.DateHelper;
import sbb.io.IOHandler;
import sbb.model.Preacher;
import sbb.model.PreachingTask;

/**
 * Hauptcontroler. Hier werden alle anderen Controller instantiert und
 * abgerufen.
 * 
 * Hier werden die Daten eingelesen und geschrieben
 * 
 * @author Antonio
 *
 */

public class MainController {

    private I18NHelper i18n;
    private DateHelper dataHelper;
    private PlanerController planerController;
    private SettingsController settingsController;
    private List<Preacher> preachers;
    private Map<String, PreachingTask> preachingTasks;

    private MainFrame mainFrame;

    public MainController() {
	this.createI18N();
	this.createDateHelper();
	this.loadMocData();
	this.createSubController();
	this.createGUI();
    }

    private void createI18N() {
	Locale locale = new Locale("de");
	this.i18n = new I18NHelper(locale);
    }

    private void createDateHelper() {
	this.dataHelper = new DateHelper();
    }

    @Deprecated
    private void loadMocData() {
	this.loadPreachers();
	this.loadPreacherTasks();
    }

    private void createSubController() {
	this.planerController = new PlanerController(this);
	this.settingsController = new SettingsController(this);
    }

    private void createGUI() {
	this.mainFrame = new MainFrame(this);
	MainPanel mainPanel = createMainPanel();
	this.mainFrame.addMainPanel(mainPanel);

	mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private MainPanel createMainPanel() {
	MainPanel mainPanel = new MainPanel();

	JPanel planerPanel = this.planerController.getPlanerPanel();
	mainPanel.add(planerPanel, BorderLayout.CENTER);

	JPanel settingsPanel = this.settingsController.getSettingsPanel();
	mainPanel.add(settingsPanel, BorderLayout.SOUTH);

	return mainPanel;

    }

    private void loadFile(File file) {
	IOHandler ioHandler = new IOHandler(file);

    }

    private void loadPreachers() {
	this.preachers = new ArrayList<Preacher>();
	for (int i = 0; i < 10; i++) {
	    Preacher pr = new Preacher("Name " + i, "Family " + i);
	    preachers.add(pr);
	}

    }

    private void loadPreacherTasks() {
	this.preachingTasks = new HashMap<String, PreachingTask>();
	for (int x = 0; x < 5; x++) {
	    PreachingTask prt = new PreachingTask("T" + x, "Task " + x, "TASK for " + x);
	    this.preachingTasks.put(prt.getKey(), prt);
	}

    }

    /* PUBLIC Methodes */

    public void start() {
	this.mainFrame.setVisible(true);

    }

    public I18NHelper geti18n() {
	return this.i18n;
    }

    public DateHelper getDateHelper() {
	return this.dataHelper;
    }

    /**
     * @return the preachers
     */
    public List<Preacher> getPreachers() {
	return preachers;
    }

    /**
     * @return the preachingTasks
     */
    public Map<String, PreachingTask> getPreachingTasks() {
	return preachingTasks;
    }

}