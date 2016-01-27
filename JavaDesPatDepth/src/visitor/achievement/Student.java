package visitor.achievement;

public class Student {
	String studNO;
	String name;
	int chinese;
	int math;
	int english;

	public Student(String t[]) {
		this.studNO = t[0];
		this.name = t[1];
		this.chinese = Integer.parseInt(t[2]);
		this.math = Integer.parseInt(t[3]);
		this.english = Integer.parseInt(t[4]);
	}
}
