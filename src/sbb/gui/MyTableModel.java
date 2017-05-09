/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbb.gui;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import sbb.helper.date.DateHelper;

/**
 *
 * @author Antonio
 */
public class MyTableModel extends AbstractTableModel implements TableModel {

    DateHelper dateHelper = DateHelper.getDateHelperInstance();
    private final int maxDaysInMonth;

    public MyTableModel() {

	this.maxDaysInMonth = this.dateHelper.getNumOfDaysInMonth();
    }

    @Override
    public int getRowCount() {
	return 3;
	// throw new UnsupportedOperationException("Not supported yet."); //To
	// change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
	// System.out.println("sbb.gui.MyTableModel.getColumnCount()");
	// System.out.println(maxDaysInMonth);
	return maxDaysInMonth + 1;
    }

    @Override
    public String getColumnName(int col) {
	if (col < 1) {
	    return "Name";
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

}
