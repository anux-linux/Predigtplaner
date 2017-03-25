/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbb.gui;

import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antonio
 */
public class PlanerPanel extends JPanel {

    /**
     * Creates new form PlanerPanel
     */
    public PlanerPanel() {
        initComponents();
        createSorter();
    }

    private void createSorter() {
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(mainCalendar.getModel()) {
            @Override
            public boolean isSortable(int column) {
                if (column < 1) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        mainCalendar.setRowSorter(sorter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainCalendar = new javax.swing.JTable();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        mainCalendar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Test1", "2", "3", null},
                {"Test2", "1", "4", null},
                {"Test3", "3", "2", null},
                {"Test4", "4", "1", null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mainCalendar.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(mainCalendar);
        mainCalendar.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mainCalendar;
    // End of variables declaration//GEN-END:variables
}
