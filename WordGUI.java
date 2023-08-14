package Project1.java;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.JFrame; 

public class WordGUI{
	
	static TextFileInput inFile; 
	static String inFileName = "src/input.txt";
	static JFrame myFrame;
	static Container cPane; //declare container which belongs to myFrame JFrame 
	static TextArea aBox, eBox, iBox, oBox, uBox, otherBox; //declare 6 text areas for receiving different words

	public WordGUI() { //create constructor WordGUI to display the code
		initialize(); 
		readNumbersFromFile(inFileName); //read numbers from external input file
	}

	public static void initialize() { //GUI constructed from a JFrame 
		inFile = new TextFileInput(inFileName); 
		aBox=new TextArea(); //create new text areas for the different words first letters
		eBox=new TextArea(); 
		iBox=new TextArea();
		oBox=new TextArea();
		uBox=new TextArea();
		otherBox=new TextArea(); 
		myFrame=new JFrame();
		myFrame.setSize(400, 400); //set frame size so all boxes fit in it
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame will be exited
	}

	public static void readNumbersFromFile(String fileName) { //used to read numbers line by line from external text file
		myFrame.setLayout(new GridLayout(2,3)); //divide myFrame into 2 rows and 3 columns so each word can go into its correct box
		cPane = myFrame.getContentPane(); 
		cPane.add(aBox); //adds the aBox text area to the top left content pane of the JFrame, where words starting with a or A will be placed
		cPane.add(eBox); //adds the eBox text area to the next content pane of the JFrame(top middle box), where words starting with e or E will be placed
		cPane.add(iBox); //adds the iBox text area to the content pane of the JFrame(top right box), where words starting with i or I will be placed
		cPane.add(oBox); //adds the oBox text area to the content pane of the JFrame(bottom left box), where words starting with o or O will be placed
		cPane.add(uBox); //adds the uBox text area to the content pane of the JFrame(bottom middle box), where words starting with u or U will be placed
		cPane.add(otherBox); //adds the otherBox text area to the content pane of the JFrame(bottom right box, where the line starting with anything other than a,e,i,o,u will be placed
		String line; 
		line=inFile.readLine(); //reads lines from text file
		while(line!=null) { //while loop until the line runs out of content so it ends when there are no more lines in the file
			if (line.charAt(0)=='a' || line.charAt(0)=='A') aBox.append(line+"\n"); //if that lines first letter isn't an A or a append it to aBox area
			if (line.charAt(0)=='e' || line.charAt(0)=='E') eBox.append(line+"\n"); //if that lines first letter is an E or e append it to eBox area
			if (line.charAt(0)=='i' || line.charAt(0)=='I') iBox.append(line+"\n"); //if that lines first letter is an I or i append it to iBox area
			if (line.charAt(0)=='o' || line.charAt(0)=='O') oBox.append(line+"\n"); //if that lines first letter is an O or o append it to oBox area
			if (line.charAt(0)=='u' || line.charAt(0)=='U') uBox.append(line+"\n"); //if that lines first letter is an U or u append it to uBox area
			else otherBox.append(line+"\n");  //if that lines first letter isn't an capital or lowercase a,e,i,o, or u append it to otherBox area
			line=inFile.readLine(); //continue to read next line from text file 
		}
		myFrame.setVisible(true); //JFrame made visible since the JFrame was invisible when initialized
	}
}