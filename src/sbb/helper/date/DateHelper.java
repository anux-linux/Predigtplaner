/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbb.helper.date;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.ChangeEvent;

/**
 *
 * @author Antonio
 */
public class DateHelper {

    private final GregorianCalendar currentTime;

    private final Set<DateChangeListener> dateChangeListener;

    private static DateHelper dataHelperInstance = null;

    private DateHelper() {
	this.currentTime = new GregorianCalendar();
	dateChangeListener = new HashSet<DateChangeListener>();
    }

    public int getCurrentYear() {
	return currentTime.get(Calendar.YEAR);
    }

    public int getNumOfDaysInMonth() {
	return currentTime.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static DateHelper getDateHelperInstance() {
	if (dataHelperInstance == null) {
	    dataHelperInstance = new DateHelper();
	}
	return dataHelperInstance;

    }

    public int getCurrentMonth() {
	return currentTime.get(Calendar.MONTH);
    }

    public void setMonth(int month) {
	currentTime.set(Calendar.MONTH, month);
	fireDateChangeEvent();

    }

    public void setYear(int year) {
	currentTime.set(Calendar.YEAR, year);
	fireDateChangeEvent();
    }

    public void addDateChangeListener(DateChangeListener dcl) {
	this.dateChangeListener.add(dcl);
    }

    private void fireDateChangeEvent() {
	ChangeEvent ce = new ChangeEvent(this);
	for (DateChangeListener dcl : dateChangeListener) {
	    dcl.dateChanged(ce);
	}
    }
}
