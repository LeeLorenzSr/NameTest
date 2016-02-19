

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class MyApp {

	public static void main(String[] args) {
		
		ArrayList<String> rawNames = new ArrayList<String>();
		Scanner scan;
		try {
			scan = new Scanner(new File("names.txt"));

			while(scan.hasNextLine()){
				
				String line = scan.nextLine();
				
				String [] nameParts = line.split(" ");
				
				String newLine = nameParts[nameParts.length-1]+",";
				
				
				for(int i = 0; i < nameParts.length-1; i++)
				{
					
					newLine +=  " " +nameParts[i];
				}
				
				
				
				rawNames.add(newLine);
				
				

			}
			scan.close();
			
			Collections.sort(rawNames);
			
			FileWriter fw;
			try {
				
				
				File file = new File("newNames.txt");
				
				//if (!file.exists()) {
					file.createNewFile();
				//}
				fw = new FileWriter(file);

				BufferedWriter bw = new BufferedWriter(fw);
				
				for(String name: rawNames){
					bw.write(name);	
					bw.newLine();
				}
				
				bw.write("There  are ");
				
				int count = rawNames.size();
				
				String outp = Integer.toString(count);
				
				bw.write(outp);
				
				
				bw.write(" Names in this list");
				bw.newLine();
				
				bw.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

			



	}

}
