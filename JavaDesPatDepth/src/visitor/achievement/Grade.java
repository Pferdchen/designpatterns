package visitor.achievement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Grade {
	Map<String, Banji> map = new HashMap<String, Banji>();
	
	public Banji add(String banji) {
		Banji obj = new Banji();
		map.put(banji, obj);
		return obj;
	}
	
	public void readFile(String strFile) {
		String s = "";
		Banji obj = null;
		try{
			FileReader in = new FileReader(strFile);
			BufferedReader in2 = new BufferedReader(in);
			while((s=in2.readLine())!=null) {
				s = s.trim();
				if(s.equals("")) continue;
				if(s.startsWith("class")) {
					obj = add(s);
					continue;
				}
				String t[] = s.split(" ");
				Student stud = new Student(t);
				obj.add(stud);
			}
			in2.close();
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
