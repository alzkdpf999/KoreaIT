package namoo.yorizori.common.factory;

import namoo.yorizori.service.cookbook.CookbookService;
import namoo.yorizori.service.external.CrawlingService;
import namoo.yorizori.service.user.UserService;

/**
 * ServiceFactory에 대한 규약을 선언하는 인터페이스
 * @author 김기정
 *
 */
public interface ServiceFactory {
	
	public UserService getUserService();
	public CookbookService getCookbookService();
	public CrawlingService getCrawlingService();
}
