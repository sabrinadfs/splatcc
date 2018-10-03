import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	static String ifdefs = "/Users/sabrinasouto/workspace/BusyboxMetrics/ifdefs.txt";
	static String defines = "/Users/sabrinasouto/workspace/BusyboxMetrics/ifdefs.txt";
	public static void main(String[] args) throws IOException {
//		Set<String> varsIfdefs = getVars(ifdefs);
//		String varsDefines = readLines(defines);
//		for (String current_var : varsIfdefs) {
//			if(varsDefines.contains(current_var)){
//				System.out.println(current_var);
//			}
//		}
		
		Map<String,Integer> nvars = getNVars(ifdefs);
//		for (Entry<String, Integer> nvar : nvars.entrySet()) {
////			if(nvar.getValue() >= 5)
//				System.out.println(nvar.getKey() + ": " + nvar.getValue());
//		}
	}
	
	public static Map<String,Integer> getNVars(String path) throws FileNotFoundException, IOException {
		Map<String,Integer> nvars = new HashMap<String,Integer>();
		String[] tokens;
		String var;
		FileInputStream stream = new FileInputStream(path);
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String line = br.readLine();
		
		while(line != null) {
			if(line.contains("ifdef") && line.contains(" __linux__")){
				System.out.println(line);
				tokens = line.split(" ");
				var = tokens[tokens.length-1];
//				vars.add(var);
				if(!nvars.keySet().contains(var)){
					nvars.put(var, new Integer(1));
				} else {
					Integer value = nvars.get(var);
					int counter = value.intValue();
					nvars.put(var,  new Integer(++counter));
				}
			}
		   line = br.readLine();
		}
		return nvars;
	}
	
	public static Set<String> getVars(String path) throws FileNotFoundException, IOException {
		String[] tokens;
		String var;
		FileInputStream stream = new FileInputStream(path);
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String line = br.readLine();
		Set<String> vars = new TreeSet<String>();
		while(line != null) {
			if(line.contains("ifdef")){
				tokens = line.split(" ");
				var = tokens[tokens.length-1];
				vars.add(var);
			}
		   line = br.readLine();
		}
		return vars;
	}
	
	/**
	 * Read all the lines from a file
	 * 
	 * @return A list of all the lines of the file
	 */
	public static String readLines(String fileName) {
		String lines = "";
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(fileName));
			String line = in.readLine();
			while (line != null) {
				lines += "\n" + line;
				line = in.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	/**
	 * Read all the lines from a file
	 * 
	 * @return A list of all the lines of the file
	 */
	public static List<String> readLinesFrom(String fileName) {
		List<String> lines = new LinkedList<String>();
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(fileName));
			String line = in.readLine();
			while (line != null) {
				lines.add(line);
				line = in.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lines;
	}

}



//
//static String path = "/Users/sabrinasouto/workspace/BusyboxMetrics/ifdefs.txt";
//public static void main(String[] args) throws IOException {
//	Map<String,Set<String>> fileVarMap = new TreeMap<String,Set<String>>();
//	Set<String> allVars = new TreeSet<String>();
//	FileInputStream stream = new FileInputStream(path);
//	InputStreamReader reader = new InputStreamReader(stream);
//	BufferedReader br = new BufferedReader(reader);
//	String linha = br.readLine();
//	while(linha != null) {
////	   System.out.println(linha);
//	   String[] tokens = linha.split(" ");
//	   String file = tokens[0];
//	   String var = tokens[1];
//	  
//	   Set<String> currentVars = new TreeSet<String>();
//	   if(fileVarMap.containsKey(file))
//		   currentVars = fileVarMap.get(file);
//	   if(!var.contains("ifdef")){
//		   allVars.add(var);
//		   currentVars.add(var);
//		   fileVarMap.put(file, currentVars);
//	   }
//	   linha = br.readLine();
//	}
//	
////	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>AllVars<<<<<<<<<<<<<<<<<<<<<<<<<<<<<:");
////	int i = 0;
////	for (String var : allVars) {
////		System.out.println(i++ + ": " + var);
////	}
//	
//	System.out.println("#################################################");
//	System.out.println(">>>>>>>>>>>>>>>>>MAP<<<<<<<<<<<<<<<<<<");
//	for (Entry<String, Set<String>> entry : fileVarMap.entrySet()) {
//		System.out.println(entry.getKey());
//		Set<String> vars = entry.getValue();
//		int j = 0;
//		for (String var : vars) {
//			System.out.println(j++ + ": " + var);
//		}
//		
//	}
//
//}