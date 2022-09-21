package namoo.web.sts.dto;

public class Student {
	private int ssn;
	private String name;
	private int korean;
	private int math;
	private int english;
	
	

	public Student() {
	}

	public Student(int ssn, String name, int korean, int math, int english) {
		this.ssn = ssn;
		this.name = name;
		this.korean = korean;
		this.math = math;
		this.english = english;
	}
	
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	@Override
	public String toString() {
		return "Student [ssn=" + ssn + ", name=" + name + ", korean=" + korean + ", math=" + math + ", english="
				+ english + "]";
	}
	public int avg() {
		return (this.english+ this.math+this.korean)/3; 
	}
	
	
	
}
