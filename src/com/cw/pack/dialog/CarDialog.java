/*
 * Copyright 2015 Hongxin Telecommunication Technologies Co, Ltd.,
 * Wuhan, Hubei, China. All rights reserved.
 */

/*
 * CarDialog.java
 *
 * Created on 2017-12-19, 15:38:57
 */

package com.cw.pack.dialog;

import com.cw.pack.Car;
import com.cw.pack.util.Constants;
import com.cw.pack.util.NumberKeyAdapter;
import com.cw.pack.util.Utils;
import com.cw.pack.util.db.DBHelper;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chenwei
 */
public class CarDialog extends javax.swing.JDialog
{

    /** Creates new form CarDialog */
    public CarDialog(java.awt.Frame parent, boolean modal)
	{
        super(parent, modal);
        initComponents();
		((DefaultTableCellRenderer)carTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		DBHelper helper =new DBHelper();
		List<Car> allCars = helper.getAllCar();
		for(Car car:allCars)
		{
			((DefaultTableModel)carTable.getModel()).addRow(new Object[]{car.getId(), car.getName(), car.getLength(), car.getWidth(), car.getHigh(), car.getLoadWeight()});
		}		
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        carName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        loadWeight = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        carLength = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        carWidth = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        carHeight = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        importCar = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        modify = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        numberTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("车辆配置");
        setName("carDialog"); // NOI18N

        jLabel1.setText("车名称");

        jLabel2.setText("载重");

        loadWeight.addKeyListener(new NumberKeyAdapter());

        jLabel3.setText("长");

        carLength.addKeyListener(new NumberKeyAdapter());

        jLabel4.setText("宽");

        carWidth.addKeyListener(new NumberKeyAdapter());

        jLabel5.setText("高");

        carHeight.addKeyListener(new NumberKeyAdapter());

        carTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "序号", "名称", "车长", "车宽", "车高", "载重"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        carTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        carTable.getTableHeader().setReorderingAllowed(false);
        carTable.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                carTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(carTable);

        jLabel6.setText("车辆信息");

        importCar.setText("导入车辆信息");
        importCar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                importCarActionPerformed(evt);
            }
        });

        insert.setText("增加");
        insert.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                insertActionPerformed(evt);
            }
        });

        modify.setText("修改");
        modify.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                modifyActionPerformed(evt);
            }
        });

        delete.setText("删除");
        delete.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteActionPerformed(evt);
            }
        });

        jLabel7.setText("序号");

        numberTxt.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(importCar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(carName)
                                    .addComponent(carLength)
                                    .addComponent(carHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(loadWeight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(carWidth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numberTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(modify, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(delete, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(insert, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {delete, insert, modify});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {carHeight, carLength, carName, carWidth, loadWeight, numberTxt});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importCar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(carName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(loadWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(carLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(carWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modify))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(carHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete)
                    .addComponent(jLabel7)
                    .addComponent(numberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {carWidth, loadWeight, numberTxt});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void importCarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_importCarActionPerformed
    {//GEN-HEADEREND:event_importCarActionPerformed
		JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("EXECL Files", "xls");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal != JFileChooser.APPROVE_OPTION) {
            return;
        }

		ArrayList<ArrayList<Object>> result = Utils.readExcel2003(chooser.getSelectedFile());
		System.out.println(result);
		int rows = carTable.getRowCount();
//		if(rows>0)
//		{
//			for(int i=0;i<rows;i++)
//				((DefaultTableModel)carTable.getModel()).removeRow(0);
//		}
		DBHelper helper =new DBHelper();
		for(int i=1;i<result.size();i++)
		{
			ArrayList<Object> rowObj = result.get(i);
			String carNameTxt = (String)rowObj.get(1);
			Car c = Constants.getInstance().getAllMapCars().get(carNameTxt);
			if(c!=null)
			{
				continue;
			}
			Integer length = (Integer)rowObj.get(2);
			Integer width = (Integer)rowObj.get(3);
			Integer height = (Integer)rowObj.get(4);
			Integer weight = (Integer)rowObj.get(5);
			c = helper.addCar(carNameTxt, length, width, height, weight);
			if(c!=null)
			{				
				Constants.getInstance().getAllCars().add(c);			
				Constants.getInstance().getAllMapCars().put(carNameTxt, c);
			}
			((DefaultTableModel)carTable.getModel()).addRow(new Object[]{c.getId(), carNameTxt, rowObj.get(2),rowObj.get(3),rowObj.get(4),rowObj.get(5)});
		}
        
    }//GEN-LAST:event_importCarActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_insertActionPerformed
    {//GEN-HEADEREND:event_insertActionPerformed
 		DBHelper helper =new DBHelper();
 		String carNameTxt = carName.getText();
		Car c = Constants.getInstance().getAllMapCars().get(carNameTxt);
		if(c!=null)
		{
			JOptionPane.showMessageDialog(this, "车辆已存在!");
			return;
		}
		Integer length = Integer.parseInt(carLength.getText());
		Integer width = Integer.parseInt(carWidth.getText());
		Integer height = Integer.parseInt(carHeight.getText());
		Integer weight = Integer.parseInt(loadWeight.getText());
		c = helper.addCar(carNameTxt, length, width, height, weight);
		if(c!=null)
		{
			Constants.getInstance().getAllCars().add(c);			
			Constants.getInstance().getAllMapCars().put(carNameTxt, c);
		}
		((DefaultTableModel)carTable.getModel()).addRow(new Object[]{c.getId(), carNameTxt, length, width, height, weight});
    }//GEN-LAST:event_insertActionPerformed

    private void modifyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_modifyActionPerformed
    {//GEN-HEADEREND:event_modifyActionPerformed
 		int selectRow = carTable.getSelectedRow();
		DBHelper helper =new DBHelper();
		Integer number = Integer.parseInt(numberTxt.getText());
 		String carNameTxt = carName.getText();
		if(Constants.getInstance().getAllMapCars().get(carNameTxt)!=null)
		{
			JOptionPane.showMessageDialog(this, "名称重复, 请重新修改!");
			return;
		}
		Integer length = Integer.parseInt(carLength.getText());
		Integer width = Integer.parseInt(carWidth.getText());
		Integer height = Integer.parseInt(carHeight.getText());
		Integer weight = Integer.parseInt(loadWeight.getText());
		Car c = helper.updateCar(number, carNameTxt, length, width, height, weight);
		List<Car> allCars = Constants.getInstance().getAllCars();
		String oldNameTxt = "";
		for(Car cc:allCars)
		 {
			 if(cc.getId() == c.getId())
			 {
				 oldNameTxt = cc.getName();
				 allCars.remove(cc);
				 allCars.add(c);
				 break;
			 }
		 }
		 Constants.getInstance().getAllMapCars().remove(oldNameTxt);
		 Constants.getInstance().getAllMapCars().put(carNameTxt, c);
		
		((DefaultTableModel)carTable.getModel()).setValueAt(carNameTxt, selectRow, 1);
		((DefaultTableModel)carTable.getModel()).setValueAt(length, selectRow, 2);
		((DefaultTableModel)carTable.getModel()).setValueAt(width, selectRow, 3);
		((DefaultTableModel)carTable.getModel()).setValueAt(height, selectRow, 4);
		((DefaultTableModel)carTable.getModel()).setValueAt(weight, selectRow, 5);
    }//GEN-LAST:event_modifyActionPerformed

    private void carTableMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_carTableMouseClicked
    {//GEN-HEADEREND:event_carTableMouseClicked
        int selectRow = carTable.getSelectedRow();
		if(evt.getClickCount()==2&&selectRow>-1)
		{
			numberTxt.setText(""+carTable.getValueAt(selectRow, 0));
			carName.setText((String)carTable.getValueAt(selectRow, 1));
			carLength.setText(""+carTable.getValueAt(selectRow, 2));
			carWidth.setText(""+carTable.getValueAt(selectRow, 3));
			carHeight.setText(""+carTable.getValueAt(selectRow, 4));
			loadWeight.setText(""+carTable.getValueAt(selectRow, 5));
		}
    }//GEN-LAST:event_carTableMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteActionPerformed
    {//GEN-HEADEREND:event_deleteActionPerformed
         int selectRow = carTable.getSelectedRow();
		 DBHelper helper =new DBHelper();
		 int carId = Integer.parseInt(""+carTable.getValueAt(selectRow, 0));
		 String carName = "";
		 List<Car> allCars = Constants.getInstance().getAllCars();
		 for(Car c:allCars)
		 {
			 if(c.getId() == carId)
			 {
				 carName = c.getName();
				 allCars.remove(c);
				 break;
			 }
		 }
		 Constants.getInstance().getAllMapCars().remove(carName);
		 helper.delCar(carId);
		 ((DefaultTableModel)carTable.getModel()).removeRow(selectRow);
    }//GEN-LAST:event_deleteActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[])
	{
        java.awt.EventQueue.invokeLater(new Runnable()
		{
            public void run()
			{
                CarDialog dialog = new CarDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
				{
                    public void windowClosing(java.awt.event.WindowEvent e)
					{
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField carHeight;
    private javax.swing.JTextField carLength;
    private javax.swing.JTextField carName;
    private javax.swing.JTable carTable;
    private javax.swing.JTextField carWidth;
    private javax.swing.JButton delete;
    private javax.swing.JButton importCar;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField loadWeight;
    private javax.swing.JButton modify;
    private javax.swing.JTextField numberTxt;
    // End of variables declaration//GEN-END:variables

}
