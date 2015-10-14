package chap02;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 
 * main() 메서드를 통해 스프링과 Greeter를 실행하는 자바 클래스
 * @author 
 */
public class MainSpring {
	
	public static void main(String args[]) {
		
		/*
		Greeter greeter = new Greeter();
		greeter.setFormat("%s, 안녕하세요!");
		String msg = greeter.greet("스프링"); // msg에는 "스프링, 안녕하세요!"라는 문자열이 저장된다.
		System.out.println("출력결과: "+msg);
		*/
		
		// GenericXmlApplicationContext : 
		//XML 파일로부터 설정 정보를 읽어와 빈 객체를 생성하고 초기화하는 등 빈을 관리하는 클래스

		// 1. 설정 정보를 이용해서 빈 객체를 생성한다.
		GenericXmlApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 2. 빈 객체를 제공한다.
		Greeter g = ctx.getBean("greeter", Greeter.class); 
		String msg = g.greet("스프링");
		System.out.println("출력결과: "+msg);
		ctx.close();
		
		/*
		 
		 BeanFactory 인터페이스는 객체 생성과 검색에 대한 기능을 정의 ( ex. getBean())
		 ApplicationContext 인터페이스는 메시지, 이젠트, 프로필/환경 변수 등을 철리할수 있는 기능을 추가로 정의
		 
		  GenericXmlApplicationContext : XML로부터 객체 설정 정보를 가져온다.
		  AnnotationConfigApplicationContext : 자바 애노테이션을 이용한 클래스로부터 객체 설정 정보를 가져온다.
		  GenericGroovyApplicationContext : 그루비 코드를 이용해 설정 정보를 가져온다.
		  
		  ApplicationContext(또는 BeanFactory)는 빈 객체의 생성, 초기화, 보관, 제거 등을 관리하는데.
		  이런 이유로 ApplicationContext를 컨테이너(Container)라고도 부른다. 
		  또 스프링 컨테이너라고 표현하기도 한다.
		 */
		
	}
}
