package com.spm.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.spm.model.ComplexityFactor;
import com.spm.model.JavaSourceCode;
import com.spm.model.SourceCode;

@SuppressWarnings("serial")
public class ComplexityCalcGUI extends JFrame implements ActionListener{
	  	 JButton jcomp1;
	    private JCheckBox jcomp2;
	    private JCheckBox jcomp3;
	    private JLabel jcomp4;
	    private JLabel jcomp5;
	    private JLabel jcomp6;
	    private JLabel jcomp7;
	    private String filePath;

	    public ComplexityCalcGUI(String name) {
	    	super(name);
	        //construct components
	        jcomp1 = new JButton ("Submit My Code");
	        jcomp2 = new JCheckBox ("Check for Inheritence");
	        jcomp3 = new JCheckBox ("Check for Recursion");
	        jcomp4 = new JLabel ("Welcome, here you can measure the complexity of your Source code");
	        jcomp5 = new JLabel ("Possible code formats are:");
	        jcomp6 = new JLabel ("1. Java (.java)");
	        jcomp7 = new JLabel ("2. C++ (.cpp)");
	        jcomp1.addActionListener(this);
	        jcomp2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("Clicked");
				}
			});
	        //adjust size and set layout
	        setPreferredSize (new Dimension (592, 398));
	        setLayout (null);

	        //add components
	        add (jcomp1);
	        add (jcomp2);
	        add (jcomp3);
	        add (jcomp4);
	        add (jcomp5);
	        add (jcomp6);
	        add (jcomp7);
	        
	        //set component bounds (only needed by Absolute Positioning)
	        jcomp1.setBounds (325, 240, 155, 35);
	        jcomp2.setBounds (110, 220, 210, 30);
	        jcomp3.setBounds (110, 270, 145, 25);
	        jcomp4.setBounds (90, 40, 420, 25);
	        jcomp5.setBounds (120, 80, 240, 20);
	        jcomp6.setBounds (195, 105, 100, 25);
	        jcomp7.setBounds (195, 130, 100, 25);
	    }
	    
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser jf = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		            "JAVA and C++ source files", "java", "cpp");
		    	jf.setAcceptAllFileFilterUsed(false);
		    	jf.setFileFilter(filter);
		        int returnVal = jf.showOpenDialog(this);
		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		        	String filepath=jf.getSelectedFile().getAbsolutePath();
		        		   this.setFilePath(filepath);
		        
		        		   this.ComplexityCalculationProc(filepath,jf.getSelectedFile().getName());
		        		   JOptionPane.showMessageDialog(this, "Complexity Calculation Completed");
		        }
		}

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}
		
		public void ComplexityCalculationProc(String FileDir,String filename) {
			
			try {
				File file = new File(FileDir);
				FileReader code = new FileReader(file);
				BufferedReader reader = new BufferedReader(code);
				
				String Ext = getFileExtension(FileDir);
				if("java".equals(Ext)) {
					
					SourceCode jsc = new JavaSourceCode();
					int linecount = CountLines(file);
					
					if(linecount>0) {
						String line;
						String[] SCBuffer = new String[linecount];
						
						int i=0;
						while((line = reader.readLine())!=null) {
							SCBuffer[i]=line;
							i++;
						}
						
					ComplexityFactor cf = new ComplexityFactor(SCBuffer,jsc.getType(),filename);
						
					String[] summarySizeC = cf.getSummaryComplexity();
					
					if(summarySizeC.length>0){
						for(int j=0;j<summarySizeC.length;j++) {
							System.out.println(summarySizeC[j]);
						}
					}
					
					}else
						System.out.println("Blank Java file found. Nothing to measure.");
				}else if("cpp".equals(Ext)) {
					//c++ calculation should be implemented here
				}else {
					System.out.println("Unsupported file type. Supported are Java(.java) and C++(.cpp)");
				}
				reader.close();
			} catch (FileNotFoundException e) {
				System.out.println("File read error: "+e);
			} catch (IOException e) {
				System.out.println("Line read error: "+e);
			}
		}
		public static String getFileExtension(String FileName) {
			String extension="";
			int i = FileName.lastIndexOf('.');
			int p = Math.max(FileName.lastIndexOf('/'), FileName.lastIndexOf('\\'));

			if (i > p) {
			    return extension = FileName.substring(i+1);
			}else {
				System.out.println("Please check the directory and file name.");
				return extension;
			}
		}
		public static int CountLines(File f) {
			int count=0;
			FileReader code;
			try {
				code = new FileReader(f);
				BufferedReader reader = new BufferedReader(code);
				while(reader.readLine()!=null)
				count++;
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return count;
		}
}
