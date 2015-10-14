package chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 	DI 방식 2: 설정 메서드 방식
 	
 	스프링은 생성자뿐만 아니라 set으로 시작하는 프로퍼티 설정 메서드를 통해서 의존 객체를 주입받는 방법을 지원
 	
 	프로퍼티 설정 메서드는 다음과 같은 형식
 	- 메서드 이름이 set으로 시작한다.
 	- set뒤에는 프로퍼티 이름의 첫 글자를 대문자로 치환한 이름을 사용한다.
 	- 한 개의 파라미터를 가지며, 파라미터의 타입은 포러티의 타입이다.
 
 	※ 자바빈즈 규약 : 재사용 가능한 객체를 빈(Bean)으로 명명하고 있으면 이 빈은 프로퍼티와 이벤트, 기타 기능(메서드)으로 구성된다. 
 	                   여기서 프로퍼티는 빈이 관리하는 데이터로서, 이 프로퍼티를 위한 명명 규칙을 다음과 같이 정의하고 있다.
 	                   
 	       - 프로퍼티 값을 구하는 메서드는 get으로 시작
 	       - 프로퍼티 값을 변경하는 메서드는 set으로 시작
 	       - get과 set뒤에는 프로퍼티 이름의 첫 글자를 대문자로 바꾼 이름을 사용
 	       - set 메서드는 1개의 파라미터를 갖는다.
 	       
 	 
 	 생성자 방식과 설정 메서드 방식
 	 
 	 생성자 방식 : 빈 객체를 생성하는 시점에 모든 의존 객체가 주입된다.
 	 설정 메서드 방식 : <property> 태그의 name속성을 통해 어떤 의존 객체가 주입되는지 알 수 있다.
 	 
 */
public class MainForSrping03 {
	
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException {
		
		//GenericXmlApplicationContext를 사용해서 스프링 컨테이너를 생성
		//객체 조립기와 같은 역할로 객체를 생성하고 의존 객체를 주입해준다. 
		//외부의 설정파일로부터 생성할 객체와 의존 주입대상을 정한다는 점.
		ctx = new GenericXmlApplicationContext("classpath:applicationContextChap3.xml");
		
		//컨테이너에서 이름이 memberRegSvc인 빈 객체를 구한다.
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		//컨테이너에서 이름이 changePwdSvc인 빈 객체를 구한다.
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);

		regSvc.regist(new RegisterRequest("mtest@computer.com", "1234", "1234", "테스트"));		
		changePwdSvc.changePassword("mtest@computer.com", "1234", "new!1234");
		
		//명령어 
		//exit : 프로그램 종료
		//new : 새로운 회원 데이터를 추가
		//change : 회원 데이터의 암호를 변경
		
		BufferedReader reader 
			= new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.println("명령어를 입력하세요:");
			String command = reader.readLine();
			
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			if (command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			} else if (command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			} else if (command.startsWith("list")) {
				processListCommand();
				continue;
			} else if (command.startsWith("info ")) {
				processInfoCommand(command.split(" "));
				continue;
			} 
			printHelp();
			
		}
		
	}
	
	private static void processNewCommand(String[] arg) {
		if (arg.length != 5) {
			printHelp();
			return;
		}
		
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다. \n");
			return;
		}
		
		try {
			regSvc.regist(req);
			System.out.println("등록했습니다. \n");
		} catch (AlreadyExistingMemberException e) {
			System.out.println("이미 존재하는 이메일입니다. \n");
		}
		
	}

	private static void processChangeCommand(String[] arg) {
		if (arg.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");
		} catch (MemberNotFoundException e) {
			System.out.println("존재 하지 않는 이메일입니다. \n");
		} catch (IdPasswordNotMatchingException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다. \n");
		}
	}
	
	private static void processListCommand() {
		MemberListPrinter listPrinter = ctx.getBean("listPrinter",MemberListPrinter.class);
		listPrinter.printAll();
	}
	

	private static void processInfoCommand(String[] arg) {
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);

		
	}

	
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println();
	}
}
