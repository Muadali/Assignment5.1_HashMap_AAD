package HashMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

class Words {
	
	public String wordName;
	public String meaning;
	
	//parametrized constructor 
	Words (String wordName, String meaning){
		
		this.wordName= wordName;
		this.meaning = meaning;
		
		
	}

}

class Dictionary {
	
	
	public HashMap <String, Words > map =new HashMap <String, Words>();
	
		public void loadRecords() throws Exception {
			
			BufferedReader br= new BufferedReader (new FileReader("C:\\Users\\Abdif\\Desktop\\File.Xlsx"));
		
			for (String line = br.readLine (); line != null; line=br.readLine()) {
				
				String [] parsedLine= line.split(",");
				String wordName = parsedLine[0];
				String meaning = parsedLine [1];
			
				Words words = new Words (wordName, meaning );
				this.map.put(wordName, words);
			
		}
			
				br.close();
		
	}
			public String findWord (String word) {
				
				for (String i : map.keySet()) {
					if (i.equals(word)){
						Words newWord = map.get(i);
						return newWord.meaning;
				
			}
			}
			
				return null;
		}
		
		
		public void saveRecords() throws Exception {
			BufferedWriter bw = new BufferedWriter (new FileWriter("C:\\Users\\Abdif\\Desktop\\File.Xlsx"));
				for (String i : map.keySet()) {
					Words W = map.get(i);
					bw.write(W.wordName);
					bw.write(",");
					bw.write(W.meaning);
					bw.write("\n");
			}
				bw.close();
			
				//for (Map.entry<String, String> entry.words.entrySet()) {
				
					//System.out.println("Key value=" + entry.getKey());
				
			//}
			
		}
}

class Driver{
	
	public static void main (String [] args)throws Exception {
	
		Dictionary obj = new Dictionary();
		obj.loadRecords();
	
		System.out.println(obj.findWord("appetency"));
		obj.saveRecords();
	
	
	}
	
}
	


