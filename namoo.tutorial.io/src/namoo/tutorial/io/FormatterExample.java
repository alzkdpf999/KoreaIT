package namoo.tutorial.io;

import java.io.File;
import java.util.Calendar;
import java.util.Formatter;

/*다양한 출력 형식 사용하기*/
public class FormatterExample {

	public static void main(String[] args) {
		String ms="자바는 객체지향 언어이다.";
		//System.out.println(ms);
		Formatter ft = new Formatter() ;
		//ft.format("%20s", ms).toString(); //1$ 2$ 3$ 는 순서를 표시 없으면 무조건 1번째
		// %[argument_index$][flags][width]conversion []부분은 생략가능  
		//argument_index$ 순서 / width 자릿수  / conversion 반드시 써야하는(출력하고자 하는 데이터 형식)
		//toString 문자열로 반환
		//flag는 연속적으로 사용가능
		System.out.println(ft.format("%-20s", ms).toString());// 자바는 디폴트 우측정렬 -는 좌측정렬
		System.out.printf("%-20s\n",ms);
		int age = -4545454;
		double weight  = 11.11;
		System.out.printf("%-+,(5d\n",age);
		System.out.printf("%-+,(5.2f\n",weight);
		Calendar now=Calendar.getInstance();
		System.out.printf("%1$tF %1$tT %1$tA\n" ,now); // 짝을 맞춰줘야 한다. R이면 분까지만 T이면 초까지
		//2022-06-14 19:54:39 화요일
		System.out.printf("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %1$tA" ,now);
		//2022-06-14 19:54:39 화요일
		
		System.out.println(String.format("\n%1$tF %1$tT %1$tA\n", now)); //제일 많이 쓰임 
	}
}
