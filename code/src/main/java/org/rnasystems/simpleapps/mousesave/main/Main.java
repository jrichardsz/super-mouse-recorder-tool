package org.rnasystems.simpleapps.mousesave.main;

import javax.swing.SwingUtilities;

import org.rnasystems.simpleapps.mousesave.controller.Controllers;
import org.rnasystems.simpleapps.mousesave.view.CoordinatesView;

public class Main{

	/**
	 * @param args
	 */
	public static void main(String[] args){

		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        		CoordinatesView coordinatesView = new CoordinatesView();
        		Controllers controllers = new Controllers(coordinatesView);
        		controllers.start();
            }
    });
		
		
	}

}
