package org.rnasystems.simpleapps.mousesave.controller.save;

import java.util.ArrayList;

import javax.swing.JTable;

import com.linet.api.swing.filechooser.FileChooserUtil;
import com.linet.api.swing.jtable.DynamicTableModel;
import com.linet.util.file.FileUtil;

public class ExportCSV{

	@SuppressWarnings("unchecked")
	public static void export(JTable table){
		
		//obtain data model from jtable
		
		DynamicTableModel model = (DynamicTableModel) table.getModel();
		
		ArrayList<Object> rows = model.getRows();
		ArrayList<String> csvString = new ArrayList<String>();
		
		for(int a=0;a<rows.size();a++){
			
			ArrayList<Integer> row = (ArrayList<Integer>) rows.get(a);
			String rowString = String.format("%d,%d,%d,%d",row.get(0),row.get(1),row.get(2),row.get(3));
			
			csvString.add(rowString);
			
			}
		
		String path = null;
		try{
			path = FileChooserUtil.getFilePathToSave("Save csv file","coordinates","csv");
		}
		catch(Exception e1){
			e1.printStackTrace();
		}
		
		
		try{
			FileUtil.writeFileFromStringCollection(path,csvString);
		}
		catch(Exception e1){
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
