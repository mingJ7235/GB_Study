package obj;

import java.util.HashSet;
import java.util.Set;

public class School {
	public static void main(String[] args) {
		Student �ѵ��� = new Student(1, "�ѵ���");
		Set<Student> stdSet = new HashSet<>();
		stdSet.add(�ѵ���);
		stdSet.add(new Student(1, "�ѵ���"));
		
		System.out.println(stdSet.size());
		
//		System.out.println(�ѵ���.equals(new Student(1, "�ѵ���")));
		
	}
}
