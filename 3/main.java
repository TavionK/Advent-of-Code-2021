import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class main{
	public static void main(String[] args){
		ArrayList<String> gamma = new ArrayList<String>();
		ArrayList<String> epsilon = new ArrayList<String>();
		ArrayList<String> lines = new ArrayList<String>();

		try{
			File f = new File(args[0]);
			Scanner scan = new Scanner(f);
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				lines.add(line);
			}
		}catch(FileNotFoundException e){
			System.out.println("File not found");
			System.exit(0);
		}
		//get length of a line
		int len = lines.get(0).length();
		for(int x =0;x<len;x++){
			int ones = 0;
			int zeros = 0;
			//System.out.println("position " + x);
			for(int y = 0; y < lines.size()-1; y++){
				//get first char
				char c = lines.get(y).charAt(x);
				//turn char into int
				int temp = Character.getNumericValue(c);
				if(temp > 0){
					ones++;
				}
				else{
					zeros++;
				}
				// System.out.println(ones);
				// System.out.println(zeros);
			}
			if(ones>zeros){
				gamma.add("1");
				epsilon.add("0");
			}
			else{
				gamma.add("0");
				epsilon.add("1");
			}
		}
		String g = "";
		String e = "";
		for(String s : gamma){
			
			g+= s;
		}
		for(String s : epsilon){
			e+= s;
		}
		System.out.println(g);
		System.out.println(e);
		int ga = Integer.parseInt(g,2);
		int ep = Integer.parseInt(e,2);
		System.out.println(ga);
		System.out.println(ep);
		int ans = ga * ep;
		System.out.println(ans);

		//Oxygen generator and the other thing
	}
}