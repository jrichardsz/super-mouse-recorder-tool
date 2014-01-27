package org.rnasystems.simpleapps.mousesave.controller.drag;

import java.util.ArrayList;

import javax.swing.JTable;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.rnasystems.simpleapps.mousesave.view.CoordinatesView;

import com.linet.api.swing.jtable.JTableUtil;

public class ControllerSaveMouseCoordinates implements NativeMouseInputListener{

	private JTable jTable;
	private int[] firstCoordinate=new int[2];
	private int[] lastCoordinate=new int[2];	
	private boolean firstCoordinateIsCaptured = false;
	private boolean isRunning = false;

	public ControllerSaveMouseCoordinates(CoordinatesView coordinatesView){
		jTable=coordinatesView.getTable();
		setup();
	}

	public void setup(){

		try{
			GlobalScreen.registerNativeHook();
		}
		catch(NativeHookException ex){
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		// Add the appropriate listeners for the example object.
		GlobalScreen.getInstance().addNativeMouseListener(this);
		GlobalScreen.getInstance().addNativeMouseMotionListener(this);

	}

	public void nativeMouseClicked(NativeMouseEvent arg0){
		// TODO Auto-generated method stub

	}

	public void nativeMousePressed(NativeMouseEvent arg0){
		// TODO Auto-generated method stub

	}

	public void nativeMouseReleased(NativeMouseEvent arg0){
		
		if(!isRunning){
			return;
		}
		
		if(!firstCoordinateIsCaptured){
			return;
		}
		
		ArrayList<Integer> dataRow = new ArrayList<Integer>();
		
		dataRow.add(firstCoordinate[0]);
		dataRow.add(firstCoordinate[1]);
		dataRow.add(lastCoordinate[0]);
		dataRow.add(lastCoordinate[1]);
		
		try{
			JTableUtil.addDataRow(jTable,dataRow);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		reset();

	}

	public void nativeMouseDragged(NativeMouseEvent arg0){
		
		if(!isRunning){
			return;
		}
		
		if(!firstCoordinateIsCaptured){
			firstCoordinate = new int[]{Math.abs(arg0.getX()),Math.abs(arg0.getY())};
			firstCoordinateIsCaptured = true;
		}
		
		lastCoordinate = new int[]{Math.abs(arg0.getX()),Math.abs(arg0.getY())};
	
	}

	public void nativeMouseMoved(NativeMouseEvent arg0){
		
	}
	
	public void reset(){
		firstCoordinateIsCaptured=false;
		
		firstCoordinate = null;
		lastCoordinate = null;
	}
	
	public void start(){
		isRunning = true;
	}
	
	public void stop(){
		isRunning = false;
	}	

}
