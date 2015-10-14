package chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSrping02 {
	
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
	
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println();
	}
}
