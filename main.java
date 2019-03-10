import java.util.Scanner;
import java.util.Vector;

public class main {


	static Scanner scan;

	public static void loadDocument(String name) {

		String wordS = scan.nextLine();

		Vector <String> result = new Vector <String>(); 

		while ( ! ( wordS.equalsIgnoreCase("eod") ) ) {

			String [] words = wordS.split("\\s+");

			for ( String w : words) {

				if(correctLink(w))

					result.add(w.substring(5).toLowerCase());
			}
			
			wordS = scan.nextLine();

		}

		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.elementAt(i));
		}
	}

	// accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
	private static boolean correctLink(String linK) {

		return linK.toLowerCase().matches("link=[A-Za-z][A-Za-z_0-9]*$");
	}


	private static void drawLine(int n, char ch) {

		for ( int i = 0 ; i < n ; i ++ )

			System.out.print(ch);

	}

	private static void drawPyramid(int n) {

		int o = 2 * n - 1;

		int q1 = 1; 

		for ( int i = 0 ; i < n ; i ++ ) { 

			int q2 = ( o - q1 ) / 2; 

			drawLine(q2,' ');

			drawLine(q1,'X');

			q1 += 2 ; 

			System.out.print("\n"); 

		}

	}

	private static void drawChristmassTree(int n) {

		int o = 2 * n - 1;

		int b = n - 1; 

		for ( int a = 0 ; a < n ; a ++ ) {

			int q1 = 1 ; 

			for ( int i = 0 ; i < n - b ; i ++ ) {  

				int q2 = ( o - q1 ) / 2 ; 

				drawLine(q2,' ');

				drawLine(q1,'X');

				q1 += 2 ; 

				System.out.print("\n"); 

			}

			b -- ; 
		}

	}

	public static void main(String[] args) {

		System.out.println("START");

		scan = new Scanner(System.in);

		boolean halt=false;

		while(!halt) {

			String line = scan.nextLine();
			// empty line and comment line - read next line
			if(line.length()==0 || line.charAt(0)=='#')

				continue;
			// copy line to output (it is easier to find a place of a mistake)
			System.out.println("!"+line);

			String word[]=line.split(" ");

			if(word[0].equalsIgnoreCase("py") && word.length==2) {

				int value=Integer.parseInt(word[1]);

				drawPyramid(value);

				continue;
			}

			if(word[0].equalsIgnoreCase("ct") && word.length==2) {

				int value=Integer.parseInt(word[1]);

				drawChristmassTree(value);

				continue;
			}
			// ld documentName
			if(word[0].equalsIgnoreCase("ld") && word.length==2) {

				loadDocument(word[1]);

				continue;
			}
			// ha
			if(word[0].equalsIgnoreCase("ha") && word.length==1) {

				halt=true;

				continue;
			}

			System.out.println("Wrong command");      

		}

		System.out.println("END OF EXECUTION");

		scan.close();

	}



}
