package namoo.yorizori.common.factory;

import namoo.yorizori.service.cookbook.CookbookService;
import namoo.yorizori.service.cookbook.CookbookServiceImpl;
import namoo.yorizori.service.external.CrawlingService;
import namoo.yorizori.service.external.CrawlingServiceImpl;
import namoo.yorizori.service.user.UserService;
import namoo.yorizori.service.user.UserServiceImpl;

/**
 * 서비스(비즈내스) 객체 생성 팩토리
 * @author 김기정
 */
public class ServiceFactoryImpl implements ServiceFactory {
	
	private static ServiceFactoryImpl instance = new ServiceFactoryImpl();
	
	private UserService userService;
	private CookbookService cookbookService;
	private CrawlingService apiService;

	private ServiceFactoryImpl() {}

	public static ServiceFactoryImpl getInstance() {
		return instance;
	}

	@Override
	public UserService getUserService() {
		if(userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}

	@Override
	public CookbookService getCookbookService() {
		if(cookbookService == null) {
			cookbookService = new CookbookServiceImpl();
		}
		return cookbookService;
	}

	@Override
	public CrawlingService getCrawlingService() {
		if(apiService == null) {
			apiService = new CrawlingServiceImpl();
		}
		return apiService;
	}
}
