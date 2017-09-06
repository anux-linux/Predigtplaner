/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbb.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import sbb.controler.MainController;
import sbb.controler.PlanerController;
import sbb.helper.date.DateChangeListener;
import sbb.helper.date.DateHelper;
import sbb.model.Preacher;
import sbb.model.PreachingTask;

/**
 *
 * @author Antonio
 */
public class PlanerPanel extends JPanel implements DateChangeListener {

    private final DateHelper dateHelper;
    private final MainController mainController;
    private final PlanerController planerController;

    /**
     * Creates new form PlanerPanel
     */
    public PlanerPanel(PlanerController controller) {
	this.planerController = controller;
	this.mainController = planerController.getMainController();
	this.dateHelper = mainController.getDateHelper();
	this.dateHelper.addDateChangeListener(this);
	this.initPanel();

    }

    private void initPanel() {
	this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
	this.setOpaque(true);
    }

    public JTable createCalendar(List<Preacher> preachers, Map<String, PreachingTask> preachingTasks) {
	JTable mainTableCalendar = new JTable();

	TableModel mainModel = new MyTableModel(planerController, preachers, preachingTasks);
	mainTableCalendar.setModel(mainModel);

	mainTableCalendar.setColumnSelectionAllowed(true);
	mainTableCalendar.getColumnModel().getSelectionModel()
		.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

	int maxColumns = mainTableCalendar.getColumnCount();
	for (int i = 1; i < maxColumns; i++) {
	    TableColumn column = mainTableCalendar.getColumnModel().getColumn(i);
	    this.setUpCombobox(preachingTasks.keySet(), column);
	}

	this.updateColumnWidth(mainTableCalendar);
	this.createSorter(mainTableCalendar);

	return mainTableCalendar;

    }

    private void createSorter(JTable table) {

	RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel()) {
	    @Override
	    public boolean isSortable(int column) {
		return column < 1;
	    }
	};
	List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
	sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
	sorter.setSortKeys(sortKeys);
	table.setRowSorter(sorter);
    }

    private void updateColumnWidth(JTable table) {
	TableColumnModel tcm = table.getColumnModel();
	int colCount = tcm.getColumnCount();

	for (int i = 0; i < colCount; i++) {
	    if (i > 0) {
		// Setting the width of days Columns
		tcm.getColumn(i).setMaxWidth(30);
	    }
	    // Setting the width of the name Column
	    tcm.getColumn(i).setMinWidth(100);

	}
    }

    private void setUpCombobox(Set<String> tasks, TableColumn column) {
	Vector<String> preachingTasks = new Vector<>(tasks);
	JComboBox<String> comboBox = new JComboBox<String>(preachingTasks);

	// comboBox.addItem("1");
	// comboBox.addItem("2");
	// comboBox.addItem("3");
	// comboBox.addItem("4");
	// comboBox.addItem("1v");
	// comboBox.addItem(" ");
	column.setCellEditor(new DefaultCellEditor(comboBox));

	// Set up tool tips for the sport cells.
	DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	renderer.setToolTipText("Mein Tooltip");
	column.setCellRenderer(renderer);
    }

    @Override
    public void dateChanged(ChangeEvent ce) {
	this.planerController.updatePlanerPanel();

    }

}
