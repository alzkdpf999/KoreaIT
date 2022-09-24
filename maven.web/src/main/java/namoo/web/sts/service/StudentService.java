package namoo.web.sts.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import namoo.student.common.web.Params;
import namoo.web.sts.dto.Student;

/**
 * 사용자 관리 서비스
 * 
 * @author 김기정
 *
 */
public interface StudentService {
	public SqlSession setUp();
}
