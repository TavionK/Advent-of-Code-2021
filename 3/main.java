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
		// System.out.println(ga);
		// System.out.println(ep);
		int ans = ga * ep;
		System.out.println("answer to part 1 " + ans);
		System.out.println("---------------------------------------------------------------------");
		
		//Oxygen generator and the other thing
		ArrayList<String> oxy = new ArrayList<String>();
		for(int i =0; i <lines.size(); i++){
			oxy.add(lines.get(i));
		}
		
		for(int i = 0; i < oxy.get(0).length(); i++){
			//index position
			int ones = 0;
			for(String s : oxy){
				if (s.charAt(i) == '1'){
					ones++;
				}
			}
			int zeros = oxy.size() - ones;
			ArrayList<String> newa = new ArrayList<String>();
			for (String s : oxy){
				if (ones >= zeros){
					if (s.charAt(i) == '1'){
						newa.add(s);
					}
				}
				else{
					if (s.charAt(i) == '0'){
						newa.add(s);
					}
				}
			}
			oxy = newa;
			if (oxy.size() ==1){
				System.out.println(oxy.get(0));
				break;
			}
		}
			
		int oxygen = Integer.parseInt(oxy.get(0),2);
		System.out.println("The oxygen number: " + oxygen);

//------------------------------------------------------------------------------------------------------

		// CO2
		ArrayList<String> carbon = new ArrayList<String>();
		// System.out.println(lines.size());
		for(int i =0; i <lines.size(); i++){
			carbon.add(lines.get(i));
		}
		
		for(int i = 0; i < carbon.get(0).length(); i++){
			//index position
			int ones = 0;
			for(String s : carbon){
				if (s.charAt(i) == '1'){
					ones++;
				}
			}
			int zeros = carbon.size() - ones;
			ArrayList<String> newa = new ArrayList<String>();
			for (String s : carbon){
				if (ones >= zeros){
					if (s.charAt(i) == '0'){
						newa.add(s);
					}
				}
				else{
					if (s.charAt(i) == '1'){
						newa.add(s);
					}
				}
			}
			carbon = newa;
			if (carbon.size() ==1){
				System.out.println(carbon.get(0));
				break;
			}
		}
		int co = Integer.parseInt(carbon.get(0),2);
		System.out.println("The carbon number: " +co);
		int ans2 = co * oxygen;
		System.out.println(ans2);
	}
}