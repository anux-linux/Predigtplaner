/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbb.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sbb.controler.MainController;
import sbb.controler.SettingsController;
import sbb.helper.I18NHelper;
import sbb.helper.date.DateHelper;

/**
 *
 * @author Antonio
 */
public class SettingsPanel extends JPanel implements ActionListener, ChangeListener {

    private final DateHelper dateHelper;
    private final I18NHelper i18n;

    private final MainController mainController;
    private final SettingsController settingsController;

    /**
     * Creates new form SettingsPanel
     * 
     * @throws java.lang.InstantiationException
     */
    public SettingsPanel(SettingsController controller) {
	this.settingsController = controller;
	this.mainController = this.settingsController.getMainController();
	this.dateHelper = mainController.getDateHelper();
	this.i18n = mainController.geti18n();
	initComponents();
    }

    private SpinnerModel getSpinnerModel() {
	int currentYear = dateHelper.getCurrentYear();
	SpinnerModel model = new SpinnerNumberModel(currentYear, // initial
								 // value
		currentYear - 10, // min
		currentYear + 100, // max
		1); // step

	return model;
    }

    private ComboBoxModel<String> getMonthComboBoxModel() {

	String[] months = i18n.getStringResourceArray("SettingsPanel.months");

	ComboBoxModel<String> monthModel = new DefaultComboBoxModel<>(months);
	return monthModel;
    }

    private void initComponents() {

	JLabel yearLabel = new JLabel();
	JLabel monthLabel = new JLabel();

	JSeparator jSeparator1 = new JSeparator();
	JSeparator jSeparator2 = new JSeparator();

	FlowLayout flowLayout1 = new FlowLayout(FlowLayout.LEADING);
	flowLayout1.setAlignOnBaseline(true);
	setLayout(flowLayout1);

	yearLabel.setText(i18n.getStringResource("SettingsPanel.yaerLabel"));
	add(yearLabel);

	JSpinner yearSpinner = new JSpinner();
	yearSpinner.setModel(getSpinnerModel());
	JSpinner.NumberEditor editor = new JSpinner.NumberEditor(yearSpinner, "#");
	yearSpinner.setEditor(editor);
	yearSpinner.addChangeListener(this);
	add(yearSpinner);

	monthLabel.setText(i18n.getStringResource("SettingsPanel.monthLabel"));
	add(monthLabel);

	JComboBox monthSelector = new JComboBox<>();
	monthSelector.setModel(getMonthComboBoxModel());
	monthSelector.setSelectedIndex(dateHelper.getCurrentMonth());
	monthSelector.addActionListener(this);
	add(monthSelector);
	add(jSeparator1);
	add(jSeparator2);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
	Object sourceObject = actionEvent.getSource();
	if (sourceObject instanceof JComboBox<?>) {
	    JComboBox<String> months = (JComboBox<String>) sourceObject;
	    int selectedMonth = months.getSelectedIndex();
	    dateHelper.setMonth(selectedMonth);
	}
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
	Object sourceObject = ce.getSource();
	if (sourceObject instanceof JSpinner) {
	    JSpinner year = (JSpinner) sourceObject;
	    int selectedYear = (int) year.getValue();
	    dateHelper.setYear(selectedYear);
	}

    }
}
