package net.strive.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Test {
	public static void main(String[] args) throws IOException {
		/*
		 1.试题一答案
		 ArrayList list=new ArrayList();
		 list.add(1);
		 list.add(2);
		 for(Object  o:list)
		 {
			System.out.println(o);
		 }
		 */
		
		 /**
		  * 2.试题四答案
		  */
		 FileWriter fw = new FileWriter("D:/Java.txt",true);
			String s = " World!";  
			fw.write(s,0,s.length());  
			fw.flush();  
			fw.close();  
			/*true为追加写入,不加此参数则重写.可做如下测试 
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:/Test1.txt"));  
			osw.write(s,0,s.length());  
			osw.flush();  
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("D:/Test2.txt")),true);  
			pw.println(s);  
			osw.close();  
			pw.close();  
			 */
			
			/*将Java.txt中文件中的内容写入到1.txt*/
			{
				File file = new File("D:/Java.txt");
	    		File dest = new File("D:/1.txt");
	    		try {
	    			BufferedReader reader = new BufferedReader(new FileReader(file));
	    			BufferedWriter writer  = new BufferedWriter(new FileWriter(dest));
	    			String line = reader.readLine();
	    			while(line!=null){
	    				writer.write(line);
	    				line = reader.readLine();
	    			}
	    			writer.flush();
	    			reader.close();
	    			writer.close();
	    		} catch (FileNotFoundException e) {
	    			e.printStackTrace();
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
			}
		
			/* Read 方式一*/
			{
			   FileReader fr = new FileReader("D:/Java.txt");
				int ch = 0;  
				while((ch = fr.read())!=-1 ){  
					System.out.print( (char)ch );  
				}  
			}
			
			/* Read 方式二*/
			File file=new File("d:\\Java.txt");
			if(file.exists())
			{
				InputStream in=new FileInputStream(file);
				InputStreamReader is=new InputStreamReader(in);
				int ch=0;
				while((ch=is.read())!=-1)
				{
					System.out.print((char)ch);	
				}
			}
			
			/* Read 方式三*/
			BufferedReader br = new BufferedReader(new FileReader("d:\\Java.txt"));
			String data = br.readLine();//一次读入一行，直到读入null为文件结束
			while( data!=null){
			      System.out.println(data);
			      data = br.readLine(); //接着读下一行
			}

		
		
	}
}
