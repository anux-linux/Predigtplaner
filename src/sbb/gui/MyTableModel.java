/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbb.gui;

import java.util.Map;
import java.util.Set;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

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
    private final DateHelper dateHelper = DateHelper.getDateHelperInstance();
    private final I18NHelper i18n;
    private final int maxDaysInMonth;

    private final Set<Preacher> preachers;
    private final Map<String, PreachingTask> preachingTasks;

    public MyTableModel(Set<Preacher> preachers, Map<String, PreachingTask> preachingTasks)
	    throws InstantiationException {

	this.maxDaysInMonth = this.dateHelper.getNumOfDaysInMonth();
	this.i18n = I18NHelper.getInstance();
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

	if (columnIndex > 0) {
	    return rowIndex + "/" + columnIndex;
	}

	return "Test" + rowIndex + "/" + columnIndex;
	// throw new UnsupportedOperationException("Not supported yet."); //To
	// change body of generated methods, choose Tools | Templates.
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
