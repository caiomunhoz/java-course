package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Instant;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Set<LogEntry> log = new HashSet<>();

		try (BufferedReader br = new BufferedReader(new FileReader("e:\\log.txt"))) {
			String line = br.readLine();

			while (line != null) {
				String fields[] = line.split(" ");
				log.add(new LogEntry(fields[0], Instant.parse(fields[1])));
				line = br.readLine();
			}
			
			System.out.println("Total users: " + log.size());
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}
}

