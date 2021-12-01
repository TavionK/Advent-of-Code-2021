import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
public class main{
	public static void main(String[] args){
		ArrayList<Integer> dist = new ArrayList<Integer>();
		int higher = 0;
		int original;
		if (args.length !=1){
			System.out.println("Only add the name of the file.");
			System.exit(0);
		}
		try{
			File f = new File(args[0]);
			Scanner scan = new Scanner(f);//load file into scanner
			original = scan.nextInt();
			System.out.println(original);
			dist.add(original);
			while(scan.hasNextInt()){
				int test = scan.nextInt();
				if (test > original){
					higher++;
				}
				original = test;
			}
			System.out.println(higher);
		}catch(FileNotFoundException e){
			System.out.println("File not found");
			System.exit(0);
		}
		System.out.println("----------------------------------------------------------");	
		try{
			int bigger = 0;
			File file = new File(args[0]);
			Scanner s = new Scanner(file);
			int a = s.nextInt();
			int b = s.nextInt();
			int c = s.nextInt();
			int d = s.nextInt();
			int total_1 = a + b + c;
			int total_2 = b + c + d;
			if(total_2 > total_1){
				bigger++;
			}

			while(s.hasNextInt()){
				total_1 = 0;
				total_2 = 0;
				a = b;
				b = c;
				c = d;
				d = s.nextInt();
				total_1 = a + b + c;
				total_2 = b + c + d;
				if(total_2 > total_1){
					bigger++;
				}
			}
			System.out.println(bigger);

		}catch(FileNotFoundException e){
			System.out.println("File not found.");
			System.exit(0);
		}

	}
}
			

