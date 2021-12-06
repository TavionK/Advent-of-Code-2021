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
			int zeros = 0;
			for(int j = 0; j < oxy.size(); j++){
				//index lines
				int temp = Character.getNumericValue(oxy.get(j).charAt(i));
				if(temp > 0){
					ones++;
				}
				else{
					zeros++;
				}
			}
			if (ones>zeros || ones==zeros){
				//get rid of all those that have a 0 in this place
				for(int j = 0; j < oxy.size(); j++){
					int temp = Character.getNumericValue(oxy.get(j).charAt(i));
					if(temp == 0){
						oxy.remove(j);
						j = 0;
					}
				}
			}
			else{
				//get rid of all those that have a 1 in this place
				for(int j = 0; j < oxy.size(); j++){
					int temp = Character.getNumericValue(oxy.get(j).charAt(i));
					if(temp == 1){
						oxy.remove(j);
						j = 0;
					}
				}
			}
		}
		for(int i = 0; i < oxy.size(); i++){
			System.out.println("The oxygen binary: " + oxy.get(i));
		}
		int oxygen = Integer.parseInt(oxy.get(0),2);
		System.out.println("The oxygen number: " + oxygen);
//101010100101
//101011101111

		// CO2
		ArrayList<String> carbon = new ArrayList<String>();
		// System.out.println(lines.size());
		carbon = lines;
		for(int i = 0; i < carbon.get(0).length()-2; i++){
			//index position
			// System.out.println("The number of items " + carbon.size());
			int ones = 0;
			int zeros = 0;
			for(int j = 0; j < carbon.size(); j++){
				//index lines
				int temp = Character.getNumericValue(carbon.get(j).charAt(i));
				if(temp > 0){
					ones++;
				}
				else{
					zeros++;
				}
			}
			if (ones<zeros){
				//get rid of all those that have a 1 in this place
				for(int j = 0; j < carbon.size(); j++){
					int temp = Character.getNumericValue(carbon.get(j).charAt(i));
					if(temp == 0){
						carbon.remove(j);
						j = 0;
					}
				}
			}
			else{
				//get rid of all those that have a 1 in this place
				for(int j = 0; j < carbon.size(); j++){
					int temp = Character.getNumericValue(carbon.get(j).charAt(i));
					if(temp == 1){
						carbon.remove(j);
						j = 0;
					}
				}
			}
		}
		for(int i = 0; i < carbon.size(); i++){
			System.out.println("The carbon binary: " +carbon.get(i));
		}
		int co = Integer.parseInt(carbon.get(0),2);
		System.out.println("The carbon number: " +co);
		int ans2 = co * oxygen;
		System.out.println(ans2);
	}
}