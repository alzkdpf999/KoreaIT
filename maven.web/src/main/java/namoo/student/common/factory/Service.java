package namoo.student.common.factory;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import namoo.student.common.web.Params;
import namoo.web.sts.dto.Student;

/**
 * 사용자 관리 서비스
 * 
 * @author 
 *
 */
public interface Service {
	public SqlSession setUp();
}