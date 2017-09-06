/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbb.gui;

import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import sbb.controler.MainController;
import sbb.controler.PlanerController;
import sbb.helper.I18NHelper;
import sbb.helper.date.DateHelper;
import sbb.model.Preacher;
import sbb.model.PreachingTask;

/**
 *
 * @author Antonio
 */
public class MyTableModel extends AbstractTableModel implements TableModel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final DateHelper dateHelper;
    private final I18NHelper i18n;
    private final int maxDaysInMonth;
    private final MainController mainController;
    private final PlanerController planerController;

    private final List<Preacher> preachers;
    private final Map<String, PreachingTask> preachingTasks;

    public MyTableModel(PlanerController controller, List<Preacher> preachers,
	    Map<String, PreachingTask> preachingTasks) {

	this.planerController = controller;
	this.mainController = planerController.getMainController();
	this.dateHelper = mainController.getDateHelper();
	this.i18n = mainController.geti18n();
	this.maxDaysInMonth = this.dateHelper.getNumOfDaysInMonth();
	this.preachers = preachers;
	this.preachingTasks = preachingTasks;

    }

    @Override
    public int getRowCount() {
	return preachers.size();
    }

    @Override
    public int getColumnCount() {
	return maxDaysInMonth + 1;
    }

    @Override
    public String getColumnName(int col) {
	if (col < 1) {
	    return i18n.getStringResource("global.name");
	}
	return "" + col;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	Preacher preacher = preachers.get(rowIndex);

	if (columnIndex > 0) {

	    // PreachingTask task = preachingTasks.get(preacher);
	    return "TEAS";
	}

	return preacher.getName() + " " + preacher.getFamily();
    }

    @Override
    public void setValueAt(Object value, int row, int col) {

	System.out.println(value);
    }

    @Override
    public Class<? extends Object> getColumnClass(int c) {
	return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's editable.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
	// Note that the data/cell address is constant,
	// no matter where the cell appears onscreen.

	if (col > 0) {
	    return true;
	} else {
	    return false;
	}
    }

}
