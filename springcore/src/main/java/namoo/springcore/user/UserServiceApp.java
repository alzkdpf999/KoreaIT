package namoo.springcore.user;

public class UserServiceApp {
	public static void main(String[] args) {
//		UserService userService = new UserServiceImpl(); DI적용전
		AppConfig appConfig = new AppConfig();
		UserService userService = appConfig.userService();
		User user =new User("bangry","1111","jack","bangry@naver.com");
		
		userService.registUser(user);
		System.out.println("ok.....");
		
		
		System.out.println(userService.findUser("bangry"));
		System.out.println(userService.findUsers());
	}
}
