package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Program {
	public static void main(String[] args) {
		
		Map<String, Integer> votes = new LinkedHashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("e:\\result.txt"))){
			
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				
				if(votes.containsKey(fields[0])) {
					votes.put(fields[0], votes.get(fields[0]) + Integer.parseInt(fields[1]));
				} else {
					votes.put(fields[0], Integer.parseInt(fields[1]));
				}
				line = br.readLine();
			}
			
			for (String candidate : votes.keySet()) {
				System.out.println(candidate + ": " + votes.get(candidate));
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}

