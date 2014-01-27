package org.rnasystems.simpleapps.mousesave.controller.clear;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;

import org.rnasystems.simpleapps.mousesave.view.CoordinatesView;

import com.linet.api.swing.jtable.JTableUtil;

public class ControllerClearTable implements ActionListener{

	private JTable jTable;
	private JButton jButtonClear;
	
	public ControllerClearTable(CoordinatesView coordinatesView){
		jTable=coordinatesView.getTable();
		jButtonClear = coordinatesView.getButtonClear();
		jButtonClear.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		 if(e.getSource()==jButtonClear){
			 JTableUtil.clearJTable(jTable);
		 }
	}
	
	

}
