package namoo.tutorial.io;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.Properties;
//	https://lifeinprogram.tistory.com/19 getProperty 사용법을 위한 사이트
//파일(디렉토리) 정보 조회 및 조작
public class FileExample {

	public static void main(String[] args) throws IOException {
		//파일 조회
		String path = System.getProperty("user.dir"); // 현재 디렉토리 가져오기 동적으로
		System.out.println(path);
		Properties pro=System.getProperties(); //hash table 확장 맵 계열 파일저장할때 String 구조로만 
		Enumeration<Object> e = pro.elements(); //Enumration 열거된 데이터를 저장 value 가져오기
		Enumeration<Object> keys = pro.keys(); // 키값 가져오기
		while(e.hasMoreElements()) { //열거된 데이터를 가져올 때 가져올게 있는지 없는지 검사
			String element =(String) e.nextElement(); //가져올게 있으면 가져와라  (value)
			System.out.println(element);
		}
		System.out.println("======================================================================");
		while(keys.hasMoreElements()) { 
			String key=(String) keys.nextElement();
			String value= pro.getProperty(key); System.out.println(key + " = " + value);
		}
		System.out.println("======================================================================");
		//File.separator \을 줌
		String download = System.getProperty("user.home")+ File.separator+"Downloads";
		System.out.println(download);
		System.out.println("======================================================================");
		File file= new File("./sample.txt");
		boolean ex = file.exists(); //파일이 존재하는지(t) 존재안하는지(f)   
		System.out.println(ex);
		System.out.println("getName():" +file.getName()); //경로명에 있는 마지막 이름
		System.out.println("getParent():" +file.getParent());//경로명에서 마지막 이름 제외한 나머지들
		System.out.println("getPath():" +file.getPath()); //경로명 얻기
		System.out.println("getAbsolutePath():" +file.getAbsolutePath()); // 절대경로명
		System.out.println("getCanonicalPath():" +file.getCanonicalPath()); // 위에꺼와 비슷함 차이는 있으나 큰 차이는 모르겠
		System.out.println("length():" +file.length()+"bytes"); // 파일 크기
		System.out.println("isFile():" +file.isFile()); // 파일인지(t) 아닌지(f)
		System.out.println("isDirectory():" +file.isDirectory()); //디렉토리인지(t) 아닌지(f)
		System.out.println("lastModified():"+file.lastModified()); //마지막으로 변경된 시간을 얻는다.
		//1970년도 기준으로 밀리초를 반환 그래서 고칠 필요 있음
		Calendar calendar= Calendar.getInstance(); //칼렌더 객체 가져오기 현재 날짜 static method
		calendar.setTimeInMillis(file.lastModified()); // 수정된 날짜가 밀리초이기 때문에 우리가 알고 있는 시각으로 가져오기
//		int year = calendar.get(Calendar.YEAR);
//		int month = calendar.get(Calendar.MONTH)+1 ;
//		int DATE = calendar.get(Calendar.DATE);
//		int hour = calendar.get(Calendar.HOUR_OF_DAY);
//		int minute = calendar.get(Calendar.MINUTE);
//		System.out.println(calendar);
//		System.out.println(year+"-"+month+"-"+DATE+"-"+ hour+"-"+minute);
		System.out.println(String.format("%1$tF %1$tR",calendar));
		System.out.println("======================================================================");
		//파일 목록 조회
		File directory = new File("./");
		File[] directoryList = directory.listFiles(); // ./에 있는 모든 파일 가져오기
		for(File List: directoryList) {
			String tf = List.isDirectory() ? "[D]" : "[F]"; //디렉토리이면 D 파일이면 F를 출력 
			if(tf.equals("[F]")) {
				System.out.println(tf+ List.length() +":"+ List);
			}
			System.out.println(tf + " : " + List);
		}
		
//		빈 디렉토리 생성
		File dir = new File("my-dir");
		boolean ok = dir.mkdir(); // mkdirs는 없는 부모이면 부모까지 생성
		if(ok) {
			System.out.println("디렉토리 생성 완료");
		}
		else {
			System.out.println("디렉토리 생성 실패");
		}
		File dirs = new File("some/my-dir");
		boolean OK = dirs.mkdirs(); // mkdirs 여러개를 만들어줌 
		if(OK) {
			System.out.println("디렉토리 생성 완료");
		}
		else {
			System.out.println("디렉토리 생성 실패");
		}
		
	}
}
