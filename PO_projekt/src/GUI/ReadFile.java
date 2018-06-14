package GUI;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile  {
	private File file;
	
	public ReadFile(){
	file = new File("menu.txt");
	;}
	
	public void Read() throws FileNotFoundException
	{
		Scanner in = new Scanner(file);
		String line;
		
		while(in.hasNextLine()) {
			line = in.nextLine();
			System.out.println(line);
		}
	}
	
	public void clear() {
		for(int i=0; i<50; i++)
		{
			System.out.println("");
		}
	}
}
