/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cw.pack;

import com.cw.pack.util.Utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author Administrator
 */
public class MainFrame extends javax.swing.JFrame
{

	private DefaultTableModel model=new DefaultTableModel();
	/**
	 * Creates new form MainFrame
	 */
	public MainFrame()
	{
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        importFile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        carModel = new javax.swing.JComboBox<String>();
        calc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        loadDevice = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        devModel = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        selectAll = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        dev_len = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dev_width = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dev_num = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dev_high = new javax.swing.JTextField();
        insert = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        dev_weight = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("装箱主界面");

        importFile.setText("请导入设备文件");
        importFile.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                importFileActionPerformed(evt);
            }
        });

        jLabel1.setText("请选择车型号");

        calc.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        calc.setText("开始计算");
        calc.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                calcActionPerformed(evt);
            }
        });

        loadDevice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "选择", "长", "宽", "高", "数量", "重量"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Boolean.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean []
            {
                true, false, false, false, false, false
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
        loadDevice.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(loadDevice);

        jLabel2.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("设备装箱平台");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("设备型号");

        jLabel4.setText("设备列表");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        selectAll.setText("全选");
        selectAll.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectAllActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("长");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("宽");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("数量");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("高");

        insert.setText("增加");

        update.setText("修改");

        delete.setText("删除");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("重量");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(calc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(carModel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(devModel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dev_high, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(dev_num, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(dev_weight, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(dev_len, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dev_width, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(importFile)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(selectAll)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(importFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)))
                    .addComponent(selectAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(devModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dev_len, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(dev_width, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(dev_high, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete)
                    .addComponent(jLabel7)
                    .addComponent(dev_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(dev_weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(calc, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel4, selectAll});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void calcActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_calcActionPerformed
    {//GEN-HEADEREND:event_calcActionPerformed
		Map<Integer,Device> allDevs = new HashMap<Integer,Device>();
//		Device dev1 = new Device();
//		dev1.setId(1);
//		dev1.setLength(300);
//		dev1.setWidth(200);
//		dev1.setHigh(150);
//		dev1.setNumber(300);
//		dev1.setBottom(true);
//		dev1.setSlanting(true);
//		allDevs.put(1,dev1);
//
//		Device dev2 = new Device();
//		dev2.setId(2);
//		dev2.setLength(400);
//		dev2.setWidth(250);
//		dev2.setHigh(180);
//		dev2.setNumber(400);
//		allDevs.put(2,dev2);
//
//		Device dev3 = new Device();
//		dev3.setId(3);
//		dev3.setLength(500);
//		dev3.setWidth(200);
//		dev3.setHigh(250);
//		dev3.setNumber(500);
//		allDevs.put(3, dev3);
//		Device dev4 = new Device();
//		dev4.setId(4);
//		dev4.setLength(550);
//		dev4.setWidth(520);
//		dev4.setHigh(350);
//		dev4.setNumber(1000);
//		allDevs.put(4, dev4);
//		Device dev5 = new Device();
//		dev5.setId(5);
//		dev5.setLength(800);
//		dev5.setWidth(300);
//		dev5.setHigh(280);
//		dev5.setNumber(1500);
//		allDevs.put(5, dev5);
//		Device dev6 = new Device();
//		dev6.setId(6);
//		dev6.setLength(2400);
//		dev6.setWidth(520);
//		dev6.setHigh(750);
//		dev6.setNumber(120);
//		allDevs.put(6, dev6);
		
		int id = 0;
		for(int i=0;i<loadDevice.getRowCount();i++)
		{
			if((boolean)loadDevice.getValueAt(i, 0))
			{
				Device d = new Device(id++, Long.parseLong(loadDevice.getValueAt(i, 1)+""), Long.parseLong(loadDevice.getValueAt(i, 2)+""), Long.parseLong(loadDevice.getValueAt(i, 3)+""), (int)loadDevice.getValueAt(i, 5), (int)loadDevice.getValueAt(i, 4));
				allDevs.put(id, d);
			}
		}
		if(allDevs.size()==0)
		{
			JOptionPane.showMessageDialog(this, "请选择需要装车的设备");
			return;
		}
		
		
		Car car = new Car();
		car.setId(0);
		car.setLength(5000);
		car.setWidth(2300);
		car.setHigh(2100);
		car.setLoadWeight(30000);
		for(Map.Entry<Integer, Device> devEntry:allDevs.entrySet())
		{
			Device dev = devEntry.getValue();
			if(dev.getLength()>car.getWidth())//斜放
			{
				long l = (long)java.lang.Math.sqrt(dev.getLength()*dev.getLength()-car.getWidth()*car.getWidth())+dev.getWidth();
				dev.setLength(car.getWidth());
				dev.setWidth(l);
				dev.setSlanting(true);
			}
		}
		
		List<Map.Entry<Integer, Device>> sortResult = Utils.sort(allDevs, true);//逆序排列
		List<Car> cars = new ArrayList<Car>();
		Utils.load(cars, sortResult, car);
		for(Car c:cars)
		{
			System.out.println("car id:"+c.getId());
			List<Device> ds = c.getPutDevices();
			for(Device d:ds)
			{
				System.out.println("---->dev id:"+d.getId()+", number is:"+d.getNumber());
			}
		}
		
		
		ResultDialog rd = new ResultDialog(this, cars, true);
		rd.setVisible(true);
		
    }//GEN-LAST:event_calcActionPerformed

    private void importFileActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_importFileActionPerformed
    {//GEN-HEADEREND:event_importFileActionPerformed
		JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("EXECL Files", "xls");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal != JFileChooser.APPROVE_OPTION) {
            return;
        }
		
//		HSSFWorkbook workBook = null;
//		FileInputStream is = null;
//		try
//		{
//			is = new FileInputStream(chooser.getSelectedFile());
//		}
//		catch(IOException ex)
//		{
//			System.err.println("文件路径错误!");
//			return;
//		}
//		try
//		{
//			workBook = new HSSFWorkbook(is);
//		}
//		catch(IOException ex)
//		{
//			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		HSSFSheet sheet = workBook.getSheetAt(0);
//		HSSFRow row;
//		if(sheet == null)
//		{
//			return;
//		}
//		if(sheet.getPhysicalNumberOfRows() < 2)
//		{
//			return;
//		}		
		ArrayList<ArrayList<Object>> result = Utils.readExcel2003(chooser.getSelectedFile());
		System.out.println(result);
		for(int i=1;i<result.size();i++)
		{
			ArrayList<Object> rowObj = result.get(i);
			
			((DefaultTableModel)loadDevice.getModel()).addRow(new Object[]{});
			loadDevice.getModel().setValueAt(false, i-1, 0);
			for(int j = 2;j<rowObj.size();j++)
			{				
				loadDevice.getModel().setValueAt(rowObj.get(j), i-1, j-1);
			}			
		}
		
    }//GEN-LAST:event_importFileActionPerformed

    private void selectAllActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectAllActionPerformed
    {//GEN-HEADEREND:event_selectAllActionPerformed
        // TODO add your handling code here:
		int rows = loadDevice.getModel().getRowCount();
		for(int i=0;i<rows;i++)
		{
			loadDevice.getModel().setValueAt(selectAll.isSelected(), i, 0);
		}
    }//GEN-LAST:event_selectAllActionPerformed

	private String getStringCellValue(HSSFCell cell)
	{
		if(cell == null)
		{
			return "";
		}
		try
		{
			switch(cell.getCellType())
			{
				case Cell.CELL_TYPE_STRING:
					return cell.getRichStringCellValue().getString().trim();
				case Cell.CELL_TYPE_NUMERIC:
					return (String.valueOf(cell.getNumericCellValue())).
							split("\\..")[0];
				case Cell.CELL_TYPE_BOOLEAN:
					return String.valueOf(cell.getBooleanCellValue());
				case Cell.CELL_TYPE_ERROR:
					return String.valueOf(cell.getErrorCellValue());
				case Cell.CELL_TYPE_FORMULA:
					return cell.getCellFormula();
				case Cell.CELL_TYPE_BLANK:
					return "";
				default:
					return cell.getStringCellValue().trim();
			}
		}
		catch(Exception exp)
		{
			return null;
		}
	}	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[])
	{
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try
		{
			for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.
					getInstalledLookAndFeels())
			{
				if("Nimbus".equals(info.getName()))
				{
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch(ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).
					log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch(InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).
					log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch(IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).
					log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch(javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).
					log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new MainFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calc;
    private javax.swing.JComboBox<String> carModel;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> devModel;
    private javax.swing.JTextField dev_high;
    private javax.swing.JTextField dev_len;
    private javax.swing.JTextField dev_num;
    private javax.swing.JTextField dev_weight;
    private javax.swing.JTextField dev_width;
    private javax.swing.JButton importFile;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable loadDevice;
    private javax.swing.JCheckBox selectAll;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
