package com.spm.util;


import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Highlight {

	public JFrame frame;
	private JTextPane code;
	/**
	 * Create the application.
	 */
	public Highlight() {
		initialize();
	}

	public void setCode(String[] codest,boolean[] codedecision) {
		Highlighter.HighlightPainter highlighter = new DefaultHighlighter.DefaultHighlightPainter(Color.ORANGE);
		String codestr="";
		for(int i=0;i<codest.length;i++) {
			if(codedecision[i]) {
				codestr=codestr+(i+1)+":\t"+codest[i]+"\n";
			}
		}
		try {
			code.getHighlighter().addHighlight(0, 1, highlighter);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.code.setText(codestr);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 589, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHereIs = new JLabel("--* Here is your detailed code *--");
		lblHereIs.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHereIs.setBounds(175, 11, 239, 14);
		frame.getContentPane().add(lblHereIs);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnDone.setBounds(478, 369, 89, 23);
		frame.getContentPane().add(btnDone);
		
		 code = new JTextPane();
		 code.setEditable(false);
		 code.setBounds(26, 59, 406, 196);
		frame.getContentPane().add(code);
	
		
		JScrollPane scrollPane = new JScrollPane(code);
		scrollPane.setBounds(26, 59, 541, 299);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblYouCanView = new JLabel("Only the complexity detected lines are displayed here : ");
		lblYouCanView.setBounds(27, 36, 298, 14);
		frame.getContentPane().add(lblYouCanView);
		
		JLabel lblYouCanFind = new JLabel("You can find the detailed Log file in 'COMPLEXITY-LOG-FILES' folder");
		lblYouCanFind.setBounds(26, 362, 441, 14);
		frame.getContentPane().add(lblYouCanFind);
	}
}
