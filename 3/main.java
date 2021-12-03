import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class main{
	public static void main(String[] args){
		ArrayList<Integer> gamma = new ArrayList<Integer>();
		ArrayList<Integer> epsilon = new ArrayList<Integer>();
		ArrayList<Integer> lines = new ArrayList<Integer>();

		try{
			File f = new File(args[0]);
			Scanner scan = new Scanner(f);
			while(scan.hasNextInt()){
				int test = scan.nextInt();
				System.out.println(test);
			}
			while(scan.hasNextInt()){
				int t = scan.nextInt();
				System.out.println(t);
				lines.add(t);
			}
			System.out.println(lines);
		}catch(FileNotFoundException e){
			System.out.println("File not found");
			System.exit(0);
		}
		//get length of a line
		int len = 12;
		for(int x =0;x<len;x++){
			int ones = 0;
			int zeros = 0;
			for(int y = 0; y < lines.size(); y++){
				int temp = Integer.parseInt(String.valueOf(String.valueOf(lines.get(y)).charAt(x)));
				if(temp == 0){
					ones++;
				}
				else{
					zeros++;
				}
			}
			if(ones>zeros){
				System.out.println("more ones");
			}
			else{
				System.out.println("more zeros");
			}
		}
	}
}