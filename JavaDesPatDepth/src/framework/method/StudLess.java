package framework.method;

public class StudLess implements ILess<Student> {

	@Override
	public boolean less(Student x, Student y) {
		return x.grade < y.grade;
	}

}
