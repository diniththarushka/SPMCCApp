package com.spm.app;

import javax.swing.JFrame;
import com.spm.gui.ComplexityCalcGUI;

public class App {

	public static void main(String[] args) {
		//JFrame frame = new JFrame ("Complexity Calculator");
		ComplexityCalcGUI cgui = new ComplexityCalcGUI("Complexity Calculator");
		cgui.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		cgui.pack();
		cgui.setVisible (true);
	}
}
