package com.spm.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.spm.model.JavaSourceCode;
import com.spm.model.SourceCode;

public class App {

	public static void main(String[] args) {
		
		String FileDir = "resources/deleteSalaryDetails.java";
		
		try {
			File file = new File(FileDir);
			FileReader code = new FileReader(file);
			BufferedReader reader = new BufferedReader(code);
			
			String Ext = getFileExtension(FileDir);
			if("java".equals(Ext)) {
				
				SourceCode jsc = new JavaSourceCode();
				System.out.println(CountLines(file));
				
				int linecount = CountLines(file);
				
				if(linecount>0) {
					String line;
					String[] SCBuffer = new String[linecount];
					
					int i=0;
					while((line = reader.readLine())!=null) {
						SCBuffer[i]=line;
						i++;
					}
					
					for(int k=0;k<SCBuffer.length;k++) {
						String BufferStatement = SCBuffer[k];
						if(BufferStatement.contains("eid")) {
							System.out.println("line: "+(k+1));
						}
					}
					
					
				}else
					System.out.println("Blank Java file found. Nothing to measure.");
					
			}else if("cpp".equals(Ext)) {
				
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

}
