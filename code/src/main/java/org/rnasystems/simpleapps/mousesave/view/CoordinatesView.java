package org.rnasystems.simpleapps.mousesave.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.linet.api.swing.jtable.JTableUtil;

public class CoordinatesView extends JFrame{

	private static final long serialVersionUID=1L;
	private JButton buttonSave;
	private JButton buttonClear;
	private JButton buttonStop;
	private JButton buttonStart;
	private JTable table;

	
	public CoordinatesView(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		buttonStart = new JButton("");
		buttonStart.setIcon(new ImageIcon(CoordinatesView.class.getResource("/org/rnasystems/simpleapps/mousesave/resources/img/start.png")));
		buttonStart.setToolTipText("clear");
		panel.add(buttonStart);
		
		buttonStop = new JButton("");
		buttonStop.setIcon(new ImageIcon(CoordinatesView.class.getResource("/org/rnasystems/simpleapps/mousesave/resources/img/stop.png")));
		buttonStop.setToolTipText("clear");
		panel.add(buttonStop);
		
		buttonClear = new JButton("");
		buttonClear.setIcon(new ImageIcon(CoordinatesView.class.getResource("/org/rnasystems/simpleapps/mousesave/resources/img/clear.png")));
		buttonClear.setToolTipText("stop");
		panel.add(buttonClear);
		
		buttonSave = new JButton("");
		buttonSave.setIcon(new ImageIcon(CoordinatesView.class.getResource("/org/rnasystems/simpleapps/mousesave/resources/img/save.png")));
		buttonSave.setToolTipText("start");
		panel.add(buttonSave);

		ArrayList<String> columnNames = new ArrayList<String>();
		columnNames.add("x1");
		columnNames.add("y1");
		columnNames.add("x2");
		columnNames.add("y2");
		
		table=new JTable(JTableUtil.getDynamicModel(columnNames));
		
		JScrollPane scrollpaneTable=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollpaneTable);
		
		setSize(300,367);
		setVisible(true);
		setAlwaysOnTop(true);
	}

	public JButton getButtonSave() {
		return buttonSave;
	}
	public JButton getButtonClear() {
		return buttonClear;
	}
	public JButton getButtonStop() {
		return buttonStop;
	}
	public JButton getButtonStart() {
		return buttonStart;
	}
	public JTable getTable() {
		return table;
	}
	
}
