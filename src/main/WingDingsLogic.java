package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WingDingsLogic {


	HashMap<Character,Integer> wingDingsMap = new HashMap<Character,Integer>();

	public WingDingsLogic(){

		importWingDingsMap();

	}


	public void importWingDingsMap(){

		Charset charset = Charset.forName("UTF-8");
		Path filepath = Paths.get("data", "WingDingsData.txt");

		try {
			BufferedReader reader = Files.newBufferedReader(filepath, charset);
			String currLine = null;

			while((currLine = reader.readLine()) != null){

				String[] temp = currLine.split(" ");
				String[] finalParse = new String[2];

				//System.out.println(Arrays.toString(temp));

				int parseCnt = 0;

				for(int i = 0; i < temp.length; i++){

					//System.out.println(temp[i]);
					if(temp[i].compareTo("") != 0){
						//System.out.println("NOTHERE");
						finalParse[parseCnt] = temp[i];
						parseCnt++;
					}
				}

				wingDingsMap.put(finalParse[0].charAt(0),Integer.valueOf(finalParse[1]));

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void test() {

		ArrayList<Character> arrChar = new ArrayList<Character>();
		//arrChar.add(Character.toChars(codeChar)[0]);

		char[] temp = new char[arrChar.size()];

		for(int i = 0; i < temp.length; i++){
			temp[i] = arrChar.get(i);
		}

		String str = new String(temp);
		System.out.println(str);
	}

	public String toWingDings(String input){

		ArrayList<Object> arrWingDings = new ArrayList<Object>(); //Easier to do this than work with Character[] tbh

		for(int i = 0; i < input.length(); i++){ //Iterating through string

			if(wingDingsMap.get(input.charAt(i)) != null){ //If that char of string can be found,
				int temp = wingDingsMap.get(input.charAt(i)); //get the number
				arrWingDings.add(Character.toChars(temp)); //and convert to real char, add to ArrayList //adding char[], because whole char[] needed for UTF-16 Unicode
			} else {
				arrWingDings.add(Character.toChars((int)(input.charAt(i)))); //otherwise, just add
			}
		}

		StringBuilder temp = new StringBuilder();

		for (int i = 0; i < arrWingDings.size(); i++){
			temp.append((char[]) arrWingDings.get(i)); //append to String (which will get character conversion we DO NEED)
		}

		String wingDingsOut = new String(temp);
		//System.out.println(Arrays.toString(arrWingDings.toArray()));
		//System.out.println(wingDingsOut);

		return wingDingsOut;


		//NOTE: Unicode larger than 10000 doesn't fit in char, so we keep track of char[] in ArrayList and add them whole to String

//Some leftover pseudocode? Interesting. 5/21/16

//		convert(){
//
//			for(iteratethroughstring)
//
//			int;
//			for(iteratethroughmap)
//			if [i] == key
//
//			   int = value;
//			}
//
//			if(int != 0){
//
//			   Character.toChars(int)
//			   addchartoArraylist
//			} else {
//
//			   addchartoArraylist(str[i])
//			}


	}

}
