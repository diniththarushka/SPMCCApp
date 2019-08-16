package com.spm.app;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.spm.model.CPPSourceCode;
import com.spm.model.ComplexityElement;
import com.spm.model.ComplexityFactor;
import com.spm.model.JavaSourceCode;
import com.spm.model.SourceCode;
import com.spm.util.Highlight;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;



public class MainGUI {
	private String FilePath;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ImageIcon background = new ImageIcon(getClass().getResource("../../../images/background.png"));
		ImageIcon backResized = new ImageIcon(this.getScaledImage(background.getImage(),652,486));
		frame = new JFrame("Java/C++ Complexity Tester");
		frame.setResizable(false);
		ImageIcon icon = new ImageIcon(getClass().getResource("../../../images/icon.jpg"));
		frame.setIconImage(icon.getImage());
		frame.setContentPane(new JLabel(backResized));
		frame.setBounds(100, 100, 650, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("--* Welcome *--");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcome.setBounds(104, 23, 438, 24);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblWelcome);
		
		TitledBorder border = new TitledBorder("File Management");
		border.setBorder(new LineBorder(Color.BLACK));
		border.setTitleJustification(TitledBorder.CENTER);
		
		TitledBorder border2 = new TitledBorder("About");
		border2.setBorder(new LineBorder(Color.BLACK));
		border2.setTitleJustification(TitledBorder.CENTER);
		
		JPanel Description = new JPanel();
		Description.setBackground(SystemColor.activeCaptionBorder);
		Description.setBounds(24, 76, 596, 163);
		Description.setBorder(border2);
		frame.getContentPane().add(Description);
		Description.setLayout(null);
		
		JLabel lblHereYouCan = new JLabel("Here you can measure the complexity of your source code");
		lblHereYouCan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHereYouCan.setBounds(64, 24, 452, 25);
		Description.add(lblHereYouCan);
		
		JLabel lblSupportedFileFormats = new JLabel("Supported file formats (extensions):");
		lblSupportedFileFormats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSupportedFileFormats.setBounds(80, 57, 331, 25);
		Description.add(lblSupportedFileFormats);
		
		JLabel lblJavajava = new JLabel("1. Java (.java)");
		lblJavajava.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJavajava.setBounds(120, 90, 118, 25);
		Description.add(lblJavajava);
		
		JLabel lblCcpp = new JLabel("2. C++ (.cpp)");
		lblCcpp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCcpp.setBounds(120, 121, 118, 14);
		Description.add(lblCcpp);
		
			ImageIcon logojfile = new ImageIcon(getClass().getResource("../../../images/JavaLogo.png"));
			ImageIcon resized = new ImageIcon(this.getScaledImage(logojfile.getImage(), 84, 84));
			JLabel JavaIconLBL = new JLabel(resized);
			JavaIconLBL.setBounds(375, 60, 84, 84);
			JavaIconLBL.setIcon(resized);
			Description.add(JavaIconLBL);
		
			ImageIcon logocfile = new ImageIcon(getClass().getResource("../../../images/CppLogo.png"));
			ImageIcon resizedcpp = new ImageIcon(this.getScaledImage(logocfile.getImage(),84,84));
			JLabel CppIconLBL = new JLabel(resizedcpp);
			CppIconLBL.setBounds(483, 60, 84, 84);
			CppIconLBL.setIcon(resizedcpp);
			Description.add(CppIconLBL);

		
		JPanel FileMgmt = new JPanel();
		FileMgmt.setBackground(SystemColor.activeCaptionBorder);
		FileMgmt.setBorder(border);
		FileMgmt.setBounds(134, 275, 384, 129);
		frame.getContentPane().add(FileMgmt);
		FileMgmt.setLayout(null);
		
		JLabel lblToOpenFile = new JLabel("To open file browser click 'Submit My Code' button");
		lblToOpenFile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblToOpenFile.setBounds(24, 28, 337, 23);
		FileMgmt.add(lblToOpenFile);
		
		JButton btnSubmitMyCode = new JButton("Submit My Code");
		btnSubmitMyCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSubmitMyCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser jf = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			            "JAVA and C++ source files", "java", "cpp");
			    	jf.setAcceptAllFileFilterUsed(false);
			    	jf.setFileFilter(filter);
			        int returnVal = jf.showOpenDialog(null);
			        if(returnVal == JFileChooser.APPROVE_OPTION) {
			        	String filepath=jf.getSelectedFile().getAbsolutePath();
			        		   setFilePath(filepath);
			        
			        		   ComplexityCalculationProc(filepath,jf.getSelectedFile().getName());
			        		   //JOptionPane.showMessageDialog(null, "Complexity Calculation Completed","Success",JOptionPane.INFORMATION_MESSAGE);
			        }
			}
		});
		btnSubmitMyCode.setBackground(Color.WHITE);
		btnSubmitMyCode.setForeground(SystemColor.controlText);
		btnSubmitMyCode.setBounds(122, 76, 146, 23);
		FileMgmt.add(btnSubmitMyCode);
		
		JLabel lblNewLabel = new JLabel("Java/C++ Complexity Tester - Version 1.0");
		lblNewLabel.setForeground(SystemColor.scrollbar);
		lblNewLabel.setBounds(384, 436, 254, 14);
		frame.getContentPane().add(lblNewLabel);
	}

	public String getFilePath() {
		return FilePath;
	}

	public void setFilePath(String filePath) {
		FilePath = filePath;
	}
	
	public void ComplexityCalculationProc(String FileDir,String filename) {
		
		try {
			File file = new File(FileDir);
			FileReader code = new FileReader(file);
			BufferedReader reader = new BufferedReader(code);
			ImageIcon logo;
			String Ext = getFileExtension(FileDir);
			if("java".equals(Ext)) {
				logo = new ImageIcon(getClass().getResource("../../../images/JavaLogo.png"));
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
					ArrayList<ComplexityElement> summarylist = cf.getElementComplexityArr();
					String summary="Complexity Calculated: \n";
					double total=0;
					if(!summarylist.isEmpty()) {
						for(ComplexityElement CE: summarylist) {
							summary=summary+CE.getName()+CE.getComplexity()+"\n";
							total=total+CE.getComplexity();	
						}
						summary=summary+"\nTotal Complexity: "+total;
					}else {
						summary=summary+"Complexity data unavailable. Maybe your code is Simple ;-)";
					}
					summary=summary+"\n-------------------------------------------------------------------------------"
							+"\nCheck the corresponding Log file for detailed info.";
					JOptionPane.showMessageDialog(null, summary, "Complexity Summary: "+file.getName(),JOptionPane.INFORMATION_MESSAGE,logo);
					
					Highlight window = new Highlight();
					window.setCode(SCBuffer,cf.getComplexlines());
					window.frame.setVisible(true);
//				String[] summarySizeC = cf.getSummaryComplexity();
//				
//				if(summarySizeC.length>0){
//					for(int j=0;j<summarySizeC.length;j++) {
//						System.out.println(summarySizeC[j]);
//					}
//				}
				
				}else
					JOptionPane.showMessageDialog(null,"Blank Java file found. Nothing to measure.");
			}else if("cpp".equals(Ext)) {
				logo = new ImageIcon(getClass().getResource("../../../images/CppLogo.png"));
				SourceCode cps = new CPPSourceCode();
				int linecount = CountLines(file);
				
				if(linecount>0) {
					String line;
					String[] SCBuffer = new String[linecount];
					
					int i=0;
					while((line = reader.readLine())!=null) {
						SCBuffer[i]=line;
						i++;
					}
				ComplexityFactor cf = new ComplexityFactor(SCBuffer,cps.getType(),filename);
					ArrayList<ComplexityElement> summarylist = cf.getElementComplexityArr();
					String summary="Complexity Calculated: \n";
					double total=0;
					if(!summarylist.isEmpty()) {
						for(ComplexityElement CE: summarylist) {
							summary=summary+CE.getName()+CE.getComplexity()+"\n";
							total=total+CE.getComplexity();	
						}
						summary=summary+"\nTotal Complexity: "+total;
					}else {
						summary=summary+"Complexity data unavailable. Maybe your code is Simple ;-)";
					}
					summary=summary+"\n-------------------------------------------------------------------------------"
							+"\nCheck the corresponding Log file for detailed info.";
					JOptionPane.showMessageDialog(null, summary, "Complexity Summary: "+file.getName(),JOptionPane.INFORMATION_MESSAGE,logo);
					
					Highlight window = new Highlight();
					window.setCode(SCBuffer,cf.getComplexlines());
					window.frame.setVisible(true);
					
//				String[] summarySizeC = cf.getSummaryComplexity();
//				
//				if(summarySizeC.length>0){
//					for(int j=0;j<summarySizeC.length;j++) {
//						System.out.println(summarySizeC[j]);
//					}
//				}
				
				}else
					System.out.println("Blank C++ file found. Nothing to measure.");
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
