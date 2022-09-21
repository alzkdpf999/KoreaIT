package namoo.web.sts.service;

import java.util.List;
import java.util.Map;

import namoo.student.common.web.Params;
import namoo.web.sts.dto.Student;

/**
 * 사용자 관리 서비스
 * 
 * @author 김기정
 *
 */
public interface StudentService {
	public List<Student> listByPage(Params params);

	public int countByPage(Params params);

	// 전체 학생
	public List<Student> findAll();

	// 학번 조회
	public Student findBySsn(int ssn);

	// 이름으로 검색
	public List<Student> findByName(String name);

	// 동적 검색
	public List<Student> search(Map<String, Object> map);

	// 학생 등록
	public void create(Student student);

	// 학생 삭제
	public void delete(Map<String, Object> map);

	// 모든 학생 삭제
	public void deleteAll();

	// 학생 정렬
	public List<Student> sortStudent(String type);
}
