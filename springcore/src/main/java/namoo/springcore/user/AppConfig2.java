package namoo.springcore.user;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "namoo.springcore.user" ) 밑에와 똑같이 동작
@ComponentScan 
// namoo.springcore.user; 이므로 자동으로 함
// 나중에 최상단 패키지에 넣으면 나중에 밑에것들 다 스캔함
public class AppConfig2 {

}
