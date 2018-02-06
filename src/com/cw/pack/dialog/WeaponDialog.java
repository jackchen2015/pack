/*
 * Copyright 2015 Hongxin Telecommunication Technologies Co, Ltd.,
 * Wuhan, Hubei, China. All rights reserved.
 */

/*
 * WeaponDialog.java
 *
 * Created on 2017-12-19, 15:38:57
 */

package com.cw.pack.dialog;

import com.cw.pack.util.Utils;
import com.cw.pack.util.db.DBHelper;
import com.cw.pack.Model;
import com.cw.pack.Weapon;
import com.cw.pack.util.Constants;
import com.cw.pack.util.NumberKeyAdapter;
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
public class WeaponDialog extends javax.swing.JDialog
{

    /** Creates new form CarDialog */
    public WeaponDialog(java.awt.Frame parent, boolean modal)
	{
        super(parent, modal);
        initComponents();
		((DefaultTableCellRenderer)weaponTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		DBHelper helper =new DBHelper();
		List<Model> allModels = helper.getAllModel();
		for(Model model:allModels)
		{
			typeComb.addItem(model);
		}
		List<Weapon> allWeapons = helper.getAllWeapon();
		for(Weapon weapon:allWeapons)
		{
			((DefaultTableModel)weaponTable.getModel()).addRow(new Object[]{weapon.getId(), weapon.getName(), weapon.getLength(), weapon.getWidth(), weapon.getHigh(), weapon.getWeight(), weapon.getModel()});
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
        weaponName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        weaponWeight = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        weaponLength = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        weaponWidth = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        weaponHeight = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        weaponTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        importWeapon = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        modify = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        typeComb = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        numberTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("武器信息维护");
        setName("weaponDialog"); // NOI18N

        jLabel1.setText("名称");

        jLabel2.setText("重量");

        weaponWeight.addKeyListener(new NumberKeyAdapter());

        jLabel3.setText("长");

        weaponLength.addKeyListener(new NumberKeyAdapter());

        jLabel4.setText("宽");

        weaponWidth.addKeyListener(new NumberKeyAdapter());

        jLabel5.setText("高");

        weaponHeight.addKeyListener(new NumberKeyAdapter());

        weaponTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "序号", "名称", "长", "宽", "高", "重量", "类别"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, false
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
        weaponTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        weaponTable.getTableHeader().setReorderingAllowed(false);
        weaponTable.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                weaponTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(weaponTable);

        jLabel6.setText("武器信息");

        importWeapon.setText("导入武器信息");
        importWeapon.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                importWeaponActionPerformed(evt);
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

        jLabel7.setText("类别");

        jLabel8.setText("序号");

        numberTxt.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(importWeapon)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(weaponName)
                            .addComponent(weaponLength)
                            .addComponent(weaponHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(weaponWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(weaponWidth, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(typeComb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modify, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(10, 10, 10)
                                .addComponent(numberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(insert))
                            .addComponent(delete, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {typeComb, weaponHeight, weaponLength, weaponName, weaponWeight, weaponWidth});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importWeapon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(weaponName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insert))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(weaponLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modify)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(numberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(weaponWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(weaponWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(weaponHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete)
                    .addComponent(jLabel7)
                    .addComponent(typeComb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void importWeaponActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_importWeaponActionPerformed
    {//GEN-HEADEREND:event_importWeaponActionPerformed
 	JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("EXECL Files", "xls");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal != JFileChooser.APPROVE_OPTION) {
            return;
        }

		ArrayList<ArrayList<Object>> result = Utils.readExcel2003(chooser.getSelectedFile());
		int rows = weaponTable.getRowCount();
//		if(rows>0)
//		{
//			for(int i=0;i<rows;i++)
//				((DefaultTableModel)weaponTable.getModel()).removeRow(0);
//		}
		DBHelper helper =new DBHelper();
		for(int i=1;i<result.size();i++)
		{
			ArrayList<Object> rowObj = result.get(i);
			String weaponName = (String)rowObj.get(1);
			Integer length = (Integer)rowObj.get(2);
			Integer width = (Integer)rowObj.get(3);
			Integer height = (Integer)rowObj.get(4);
			Integer weight = (Integer)rowObj.get(6);
			Weapon newWeapon = Constants.getInstance().getAllNameMapping().get(weaponName);
			if(newWeapon!=null)
			{
				JOptionPane.showMessageDialog(this, "武器'"+weaponName+"'已存在，无需导入该武器!");
				continue;
			}
			Model md = Constants.getInstance().getAllMapModels().get(rowObj.get(7)+"");
			if(md==null)
			{
				JOptionPane.showMessageDialog(this, "武器类别'"+rowObj.get(7)+"'不存在!请在武器类别中增加该武器类别!");
				continue;
			}
			newWeapon = helper.addWeapon(weaponName, length, width, height, weight, md);

			Constants.getInstance().getAllWeapons().add(newWeapon);
			Constants.getInstance().getAllNameMapping().put(weaponName, newWeapon);
			Constants.getInstance().getWeapMapping().get(md).add(newWeapon);
			((DefaultTableModel)weaponTable.getModel()).addRow(new Object[]{newWeapon.getId(), rowObj.get(1), rowObj.get(2),rowObj.get(3),rowObj.get(4),rowObj.get(6),md});
		}
    }//GEN-LAST:event_importWeaponActionPerformed

    private void weaponTableMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_weaponTableMouseClicked
    {//GEN-HEADEREND:event_weaponTableMouseClicked
        int selectRow = weaponTable.getSelectedRow();
		if(evt.getClickCount()==2&&selectRow>-1)
		{
			numberTxt.setText(""+weaponTable.getValueAt(selectRow, 0));
			weaponName.setText((String)weaponTable.getValueAt(selectRow, 1));
			weaponLength.setText(""+weaponTable.getValueAt(selectRow, 2));
			weaponWidth.setText(""+weaponTable.getValueAt(selectRow, 3));
			weaponHeight.setText(""+weaponTable.getValueAt(selectRow, 4));
			weaponWeight.setText(""+weaponTable.getValueAt(selectRow, 5));
			typeComb.setSelectedItem(weaponTable.getValueAt(selectRow, 6));
		}
    }//GEN-LAST:event_weaponTableMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteActionPerformed
    {//GEN-HEADEREND:event_deleteActionPerformed
         int selectRow = weaponTable.getSelectedRow();
		 DBHelper helper =new DBHelper();
                 int wId = Integer.parseInt(""+weaponTable.getValueAt(selectRow, 0));

 		 String carName = "";
		 List<Weapon> allWeapons = Constants.getInstance().getAllWeapons();
		 for(Weapon w:allWeapons)
		 {
			 if(w.getId() == wId)
			 {
				 carName = w.getName();
				 allWeapons.remove(w);
				 break;
			 }
		 }
		 Constants.getInstance().getAllNameMapping().remove(carName);               
                 
                 helper.delWeapon(wId);
		((DefaultTableModel)weaponTable.getModel()).removeRow(selectRow);
    }//GEN-LAST:event_deleteActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_insertActionPerformed
    {//GEN-HEADEREND:event_insertActionPerformed
  		DBHelper helper =new DBHelper();
		String name = this.weaponName.getText();
		Weapon w = Constants.getInstance().getAllNameMapping().get(name);
		if(w!=null)
		{
			JOptionPane.showMessageDialog(this, "武器已存在!");
			return;
		}                
		Integer length = Integer.parseInt(weaponLength.getText());
		Integer width = Integer.parseInt(weaponWidth.getText());
		Integer high = Integer.parseInt(weaponHeight.getText());
		Integer weight = Integer.parseInt(weaponWeight.getText());
		Model selModel = (Model)typeComb.getSelectedItem();
		Weapon weapon = helper.addWeapon(name, length, width, weight, weight, selModel);
                if(weapon!=null)
                {
                    Constants.getInstance().getAllWeapons().add(weapon);
                    Constants.getInstance().getAllNameMapping().put(name, weapon);
                }
		((DefaultTableModel)weaponTable.getModel()).addRow(new Object[]{weapon.getId(), name, length, width, high, weight, selModel});

    }//GEN-LAST:event_insertActionPerformed

    private void modifyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_modifyActionPerformed
    {//GEN-HEADEREND:event_modifyActionPerformed
 		int selectRow = weaponTable.getSelectedRow();
		DBHelper helper =new DBHelper();
		Integer number = Integer.parseInt(numberTxt.getText());
 		String weaponNameTxt = weaponName.getText();
                Weapon w0 = Constants.getInstance().getAllNameMapping().get(weaponNameTxt);
                if(w0!=null&&w0.getId()!=number)
                {
			JOptionPane.showMessageDialog(this, "名称重复, 请重新修改!");
			return;                    
                }
		Integer length = Integer.parseInt(weaponLength.getText());
		Integer width = Integer.parseInt(weaponWidth.getText());
		Integer height = Integer.parseInt(weaponHeight.getText());
		Integer weight = Integer.parseInt(weaponWeight.getText());
		Model model = (Model)typeComb.getSelectedItem();
		Weapon w = helper.updateWeapon(number, weaponNameTxt, length, width, height, weight, model.getId());
                
		List<Weapon> allWeapons = Constants.getInstance().getAllWeapons();
		String oldNameTxt = "";
		for(Weapon cc:allWeapons)
		 {
			 if(cc.getId() == number)
			 {
				 oldNameTxt = cc.getName();
				 allWeapons.remove(cc);
				 allWeapons.add(w);
				 break;
			 }
		 }
		 Constants.getInstance().getAllWeapons().remove(oldNameTxt);
		 Constants.getInstance().getAllNameMapping().put(weaponNameTxt, w);                
                
		((DefaultTableModel)weaponTable.getModel()).setValueAt(weaponNameTxt, selectRow, 1);
		((DefaultTableModel)weaponTable.getModel()).setValueAt(length, selectRow, 2);
		((DefaultTableModel)weaponTable.getModel()).setValueAt(width, selectRow, 3);
		((DefaultTableModel)weaponTable.getModel()).setValueAt(height, selectRow, 4);
		((DefaultTableModel)weaponTable.getModel()).setValueAt(weight, selectRow, 5);
		((DefaultTableModel)weaponTable.getModel()).setValueAt(model, selectRow, 6);
    }//GEN-LAST:event_modifyActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[])
	{
        java.awt.EventQueue.invokeLater(new Runnable()
		{
            public void run()
			{
                WeaponDialog dialog = new WeaponDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton delete;
    private javax.swing.JButton importWeapon;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton modify;
    private javax.swing.JTextField numberTxt;
    private javax.swing.JComboBox typeComb;
    private javax.swing.JTextField weaponHeight;
    private javax.swing.JTextField weaponLength;
    private javax.swing.JTextField weaponName;
    private javax.swing.JTable weaponTable;
    private javax.swing.JTextField weaponWeight;
    private javax.swing.JTextField weaponWidth;
    // End of variables declaration//GEN-END:variables

}
