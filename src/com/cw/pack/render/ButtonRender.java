/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cw.pack.render;

/**
 *
 * @author Administrator
 */
import com.cw.pack.Car;
import com.cw.pack.CarView;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ButtonRender extends AbstractCellEditor implements TableCellRenderer,ActionListener, TableCellEditor{
	private static final long serialVersionUID = 1L;
	private JButton button =null;
	private List<Car> cars;
	private int selRow;
	public ButtonRender(List<Car> cars){
		this.cars = cars;
		button = new JButton("查看视图");
		button.addActionListener(this);
	}
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		return button;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CarView cv = new CarView(cars.get(selRow));
		cv.showDialog();
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		this.selRow = row;
		return button;
	}
	
}