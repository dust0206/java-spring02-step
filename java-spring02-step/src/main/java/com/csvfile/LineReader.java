package com.csvfile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LineReader {
	
	List<String> readLines(String filename) throws IOException {
		List<String> result = new ArrayList<>();
//		BufferedReader br = new BufferedReader(new FileReader(filename));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "utf-8"));
		String str;
		while( (str = br.readLine()) != null) {
			result.add(str);
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		String filename = "xxx/ttt.csv";
		LineReader lr = new LineReader();
		List<String> lines = lr.readLines(filename);
		System.out.println(lines.size());
	}
}
