import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		BinaryTree binaryTree = new BinaryTree(fileReader("./src/number.txt"));
		
		System.out.println("Seviyelere göre düðümler: ");
		binaryTree.printLevelOrder(binaryTree.root);
		
		System.out.println();
		
		System.out.println("Binary Tree nin Simetriði:");
		binaryTree.printLevelOrder(binaryTree.symmetricRoot);
		
		
	}
	
	
	
	
	public static ArrayList<Integer> fileReader(String path){
		
		ArrayList<Integer> arr =  new ArrayList();  
		File file = new File(path);
		FileReader fr;
		String line = "";
		String numbers[] = null;
		
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			line = br.readLine();
			
			while(line != null) {
				
				numbers = line.split(" ");
				
				for(String num : numbers) {
					arr.add(Integer.parseInt(num));
				}
				
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return arr;
	}
	
	
}
