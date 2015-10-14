package chap02;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 
 * main() 메서드를 통해 스프링과 Greeter를 실행하는 자바 클래스
 * @author 
 */
public class MainSpring2 {
	
	public static void main(String args[]) {
		
		
		// 1. 설정 정보를 이용해서 빈 객체를 생성한다.
		GenericXmlApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 2. 빈 객체를 제공한다.
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		
		System.out.println("(g1 == g2) = " + (g1 == g2)); //(g1 == g2) = true
		
		
		/*
		 	출력결과를 확인해보면 다음과 같다. 
			
			(g1 == g2) = true
			
			즉 g1과 g2는 같은 객체라는 것을 의미한다. 
			스프링은 별도 설정을 하지 않을 경우  한개의 <bean> 태그에 대해 한 개의 빈 객체만을 생성하며, 
			이들 빈(Bean) 객체들이 '싱글톤(singleton)' 범위를 갖는다고 표현
			싱글톤 => 단일 객체(single objet) 의미
		 */
		
		// 두개의 빈 객체 생성
		/*
		<bean id="greeterTarget1" class="chap02.Greeter">
			<property name="format" value="%s, 안녕하세요!"/> <!-- setFormat("%s, 안녕하세요!") -->
		</bean>
		<bean id="greeterTarget2" class="chap02.Greeter">
			<property name="format" value="%s, 안녕하세요!"/> <!-- setFormat("%s, 안녕하세요!") -->
		</bean>
		*/
		Greeter gTarget1 = ctx.getBean("greeterTarget1", Greeter.class);
		Greeter gTarget2 = ctx.getBean("greeterTarget2", Greeter.class);
		
		System.out.println("(gTarget1 == gTarget2) = " + (gTarget1 == gTarget2)); //(gTarget1 == gTarget2) = false
		
		ctx.close();
		
	}
}
