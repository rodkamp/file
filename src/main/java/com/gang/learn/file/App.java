package com.gang.learn.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Set<String> setOld = new HashSet<String>();
		Set<String> setNew = new HashSet<String>();
		String fileOld = "/Users/gangshen/Documents/textfile.txt";
		String fileNew = "/Users/gangshen/Documents/textfileNew.txt";
		readFile(fileOld, setOld);
		readFile(fileNew, setNew);
		System.out.println(setOld.toString());
		System.out.println(setNew.toString());
		removeDuplicates(setOld, setNew);
		System.out.println("setOld:");
		System.out.println(setOld.toString());
		System.out.println("setNew:");
		System.out.println(setNew.toString());
	}
	
	private static void removeDuplicates(Set<String> set1, Set<String> set2) {
		Iterator<String> iterator = set1.iterator();
		while(iterator.hasNext()) {
			String item = iterator.next();
			if(set2.contains(item)) {
				iterator.remove();
				set2.remove(item);
			}
		}
	}

	private static void readFile(String fileName, Set<String> tokenSet) {
		try {
			// Open the file
			FileInputStream fstream = new FileInputStream(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;

			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				StringTokenizer st = new StringTokenizer(strLine);
				while (st.hasMoreTokens()) {
					tokenSet.add(st.nextToken());
				}
			}

			// Close the input stream
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
