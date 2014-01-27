package org.rnasystems.simpleapps.mousesave.controller.save;

import java.util.ArrayList;

import javax.swing.JTable;

import com.linet.api.swing.filechooser.FileChooserUtil;
import com.linet.api.swing.jtable.DynamicTableModel;
import com.linet.util.file.FileUtil;

public class ExportAutoitArray{

	@SuppressWarnings("unchecked")
	public static void export(JTable table){
		
		//goal to save : Local  $arr[3][4] = [[1, 2, 3,4], [2, 3, 4,5], [3, 4, 5,6]]
		
		DynamicTableModel model = (DynamicTableModel) table.getModel();
		
		ArrayList<Object> rows = model.getRows();
		
		String readyRow = "";
		
		for(int a=0;a<rows.size();a++){
			
			ArrayList<Integer> row = (ArrayList<Integer>) rows.get(a);
			
			String rowFormat = "[%d, %d, %d,%d]";
			String rowValue = String.format(rowFormat,row.get(0),row.get(1),row.get(2),row.get(3));
			
			if(a!=rows.size()-1){// is not last row, add ","
				rowValue += ", ";
			}
			
			//[1, 2, 3,4], [2, 3, 4,5], [3, 4, 5,6] , .... , ......,
			readyRow += rowValue;
			
		}
		
		// order values = rows, cols, content rows
		String readyFormat = "Local  $arr[%d][%d] = [%s]";
		String finalValue = String.format(readyFormat,rows.size(),4,readyRow);
		
		String path = null;
		try{
			path = FileChooserUtil.getFilePathToSave("Save array autoit in file","coordinates","au3");
		}
		catch(Exception e1){
			e1.printStackTrace();
		}
		
		
		try{
			FileUtil.writeFileFromSimpleString(path,finalValue);
		}
		catch(Exception e1){
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
