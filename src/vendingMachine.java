/*
 프로그램명 : VendingMachine
 프로그램의 구성 : ListStackNode(스택 노드 클래스)
 			ListStack(연결리스트 스택 클래스) - isEmpty(스택 공백상태 검출 메소드), init(스택초기화 메소드), 
 			push(스택 삽입 메소드), pop(스택삭제메소드), count(스택개수 반환 메소드)
			water, coffee, sport, highCoffee, sparkling(음료 클래스) - rename(이름 재설정 메소드), resetting(가격 재설정 메소드)
			coin10, coin50, coin100, coin500, bill1000(화폐 클래스
			password(비밀번호 클래스) - change(비밀번호 변경 메소드)
			vendingMachine(자판기 클래스)-initialize(전체 자판기 알고리즘 메소드)
 구성환경 : Windows 10, Eclipse IDE 2020dnp-06, intel core i5 8th Gen
 개발환경 : JDK version 1.8
 작성자 : JihoKim0
 프로그램 개요 : 자판기 관리 프로그램
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.*;

//스택 노드 클래스
class ListStackNode{
	private int data;	//데이터 노드
	public ListStackNode link;	//링크 노드
	
	//데이터 및 링크 노드 초기화
	public ListStackNode() {
		this.data = 1;
		this.link = null;
	}
}

//연결리스트 스택 클래스
class ListStack{
	private ListStackNode head;	//헤드노드
	private ListStackNode top;	//스택의 top노드
	private int count;	//스택 크기
	
	//스택 생성자
	public ListStack() {
		head = null;
		top = null;
	}
	
	//스택 공백상태 검출
	public boolean isEmpty() {
		return (top == null);
	}
	//스택에 삽입
	public void push() {
		ListStackNode newNode = new ListStackNode();	//새 노드 생성
		if(isEmpty()) {	//스택 공백상태라면
			head = newNode;	//head가 새 노드를 참조하도록 함
			top = head;
		}
		else {	//top노드가 null이 아니라면
			ListStackNode temp = top;	//temp노드가 top 참조
			while(temp.link != null) {
				temp = temp.link;	//다음 노드 참조
			}
			temp.link = newNode;	//temp의 link가 다음 노드 (새 노드)참조
		}
		count++;	//재고 하나 증가
	}
	//스택의 top노드 삭제
	public void pop() {
		ListStackNode pre;
		ListStackNode temp;
		
		if(isEmpty()) {	//스택 공백상태라면 모든 노드 삭제되었으므로 return
			System.out.println("스택 공백");
			return;
		}
		if(top.link == null) {	//스택에 노드가 1개 남았다면
			head = null;	//초기화
			top = null;
		}
		else {
			pre = top;	//pre노드는 top 포인터가 가리키는 노드 할당
			temp = top.link;	//temp노드는 top포인터가 가리키는 노드 다음 노드 할당
			
			while(temp.link != null) {	//temp는 마지막 노드로, pre는 temp 이전 노드로
				pre = temp;
				temp = temp.link;
			}
			pre.link = null;	//마지막 노드 삭제
		}
		count--;	//재고 하나 감소
	}
	//스택의 개수
	public int count() {
		return count;
	}
}


//음료 종류별 클래스(이름 및 가격 설정)
class water{		//물
	int price;		//가격
	String name;	//음료 이름
	public water() {
		price = 450;	//가격 설정
		name = "물";		//이름 설정
	}
	void rename(String n) {	//음료 이름 재설정 메소드
		name = n;
	}
	void resetting(int p) {	//음교 가격 재설정 메소드
		price = p;
	}
	
}
class coffee{		//커피
	int price;		//가격
	String name;	//음료 이름
	public coffee() {
		price = 500;	//가격 설정
		name = "커피";	//이름 설정
	}
	void rename(String n) {	//음료 이름 재설정 메소드
		name = n;
	}
	void resetting(int p) {	//음료 가격 재설정 메소드
		price = p;
	}
}
class sport{		//이온음료
	int price;		//가격
	String name;	//음료 이름
	public sport() {
		price = 550;	//가격 설정
		name = "이온음료";	//이름 설정
	}
	void rename(String n) {	//음료 이름 재설정 메소드
		name = n;
	}
	void resetting(int p) {	//음료 가격 재설정 메소드
		price = p;
	}
}
class highCoffee{	//고급커피
	int price;		//가격
	String name;	//음료 이름
	public highCoffee() {
		price = 700;	//가격 설정
		name = "고급커피";	//이름 설정
	}
	void rename(String n) {	//음료 이름 재설정 메소드
		name = n;
	}
	void resetting(int p) {	//음료 가격 재설정 메소드
		price = p;
	}
}
class sparkling{	//탄산음료
	int price;		//가격
	String name;	//이름
	public sparkling() {
		price = 750;	//가격 설정
		name = "탄산음료";	//이름 설정
	}
	void rename(String n) {	//음료 이름 재설정 메소드
		name = n;
	}
	void resetting(int p) {	//음료 가격 재설정 메소드
		price = p;
	}
}

//화폐(잔돈) 클래스
class coin10{	//10원
	int price;		//가격
	public coin10() {
		price = 10;		//가격 설정
	}
}
class coin50{	//50원
	int price;
	public coin50() {
		price = 50;
	}
}
class coin100{	//100원
	int price;
	public coin100() {
		price = 100;
	}
}
class coin500{	//500원
	int price;
	public coin500() {
		price = 500;
	}
}
class bill1000{	//1000원
	int price;
	public bill1000() {
		price = 1000;
	}
}
//비밀번호 클래스
class password{
	String password;	//비밀번호
	public password() {
		password = "20194054!";	//초기 비밀번호 설정
	}
	void change(String p) {	//비밀번호 변경 메소드
		password = p;
	}
}
//자판기 클래스
public class vendingMachine{
	public JFrame frame;	//J프레임 선언
	public int currPrice = 0;	//현재 투입 금액
	int selectPrice = 0;	//결제 금액
	int i;
	int retClick = 0;	//반환버튼 클릭 횟수
	int tmp1000 = 0;	//현재 입력된 1000원 개수(1000원 3개 초과 입력 불가)
	int savePrice = 0;	//현재 자판기 보유 금액
	int canoutput = 0;	//현재 수금 가능 금액
	
	//각 음료의 객체, 스택 생성
	water water = new water();
	ListStack waterstack = new ListStack();
	
	coffee coffee = new coffee();
	ListStack coffeestack = new ListStack();
	
	sport sport = new sport();
	ListStack sportstack = new ListStack();
	
	highCoffee highCoffee = new highCoffee();
	ListStack highCoffeestack = new ListStack();
	
	sparkling sparkling = new sparkling();
	ListStack sparklingstack = new ListStack();
	
	//패스워드 객체 생성
	password password = new password();
	
	//각 화폐의 객체, 스택 생성
	coin10 coin10 = new coin10();
	ListStack coin10stack = new ListStack();
	coin50 coin50 = new coin50();
	ListStack coin50stack = new ListStack();
	coin100 coin100 = new coin100();
	ListStack coin100stack = new ListStack();
	coin500 coin500 = new coin500();
	ListStack coin500stack = new ListStack();
	bill1000 bill1000 = new bill1000();
	ListStack bill1000stack = new ListStack();
	
	public vendingMachine() {	//생성자	
		//각 음료의 재고 초기화(스택 사용) - 각 음료의 기본 재고는 3개
		for(i=0; i<3; i++)	//스택에 재고 저장
			waterstack.push();		
		for(i=0; i<3; i++)	//스택에 재고 저장
			coffeestack.push();				
		for(i=0; i<3; i++)	//스택에 재고 저장
			sportstack.push();				
		for(i=0; i<3; i++)	//스택에 재고 저장
			highCoffeestack.push();				
		for(i=0; i<3; i++)	//스택에 재고 저장
			sparklingstack.push();
		
		//각 화폐의 재고 초기화(스택 사용) - 각 화폐의 기본 재고는 5개
		for(i=0; i<5; i++)	//스택에 재고 저장
			coin10stack.push();
		for(i=0; i<5; i++)	//스택에 재고 저장
			coin50stack.push();
		for(i=0; i<5; i++)	//스택에 재고 저장
			coin100stack.push();
		for(i=0; i<5; i++)	//스택에 재고 저장
			coin500stack.push();
		for(i=0; i<5; i++)	//스택에 재고 저장
			bill1000stack.push();
		
		//각 화면의 초기활성/비활성 설정
		machinePage.setVisible(true);
		passwordPage.setVisible(false);
		managerPage.setVisible(false);
		moneyMenu.setVisible(false);
		passwordMenu.setVisible(false);
		infoMenu.setVisible(false);
		storageMenu.setVisible(false);
		
		initialize();
		
		retBtn.doClick();	//버튼 비활성화 기능을 버튼 클릭시 실행하도록 하였음으로 프로그램 시작시 임의로 반환버튼을 클릭한다
		retClick = 0;	//임의로 누른 반환버튼 클릭횟수 다시 0으로 설정
	}
	
	//GUI 환경 구축
	//판넬
	JPanel machinePage = new JPanel();	//자판기 메인화면 판넬
	JPanel managerPage = new JPanel();	//관리자메뉴 판넬
	JPanel passwordPage = new JPanel();	//비밀번호 판넬
	JPanel moneyMenu = new JPanel();	//수금메뉴 판넬
	JPanel passwordMenu = new JPanel();	//비밀번호 변경 메뉴
	JPanel infoMenu = new JPanel();		//판매정보 수정 메뉴	
	JLabel priceInput = new JLabel();	//투입금액 레이블
	JPanel storageMenu = new JPanel();	//재고보충 메뉴
	
	//자판기화면
	JButton retBtn = new JButton("반환");	//반환버튼
	JButton waterBtn = new JButton(water.name);	//물 버튼
	JButton coffeeBtn = new JButton(coffee.name);	//커피 버튼
	JButton sportBtn = new JButton(sport.name);	//이온음료 버튼
	JButton highCoffeeBtn = new JButton(highCoffee.name);	//고급커피 버튼
	JButton sparklingBtn = new JButton(sparkling.name);	//탄산음료 버튼
	JButton coinBtn500 = new JButton(Integer.toString(coin500.price));	//500원 버튼
	JButton coinBtn100 = new JButton(Integer.toString(coin100.price));	//100원 버튼
	JButton coinBtn50 = new JButton(Integer.toString(coin50.price));	//50원 버튼
	JButton coinBtn10 = new JButton(Integer.toString(coin10.price));	//10원 버튼
	JButton coinBtn1000 = new JButton(Integer.toString(bill1000.price));	//1000원 버튼	
	JLabel waterPrice = new JLabel(Integer.toString(water.price)+"원");	//물 가격 표시
	JLabel coffeePrice = new JLabel(Integer.toString(coffee.price)+"원");	//커피 가격 표시
	JLabel sportPrice = new JLabel(Integer.toString(sport.price)+"원");	//이온음료 가격 표시
	JLabel highCoffeePrice = new JLabel(Integer.toString(highCoffee.price)+"원");	//고급커피 가격 표시
	JLabel sparklingPrice = new JLabel(Integer.toString(sparkling.price)+"원");	//탄산음료 가격 표시
	
	//비밀번호 화면
	private JPasswordField passwordField;	//비밀번호 입력창
	
	//메뉴아이템
	JMenuBar managerMenuBar = new JMenuBar();	//관리자 메뉴 메뉴바 생성
	JMenu managerMenu = new JMenu("관리자메뉴");	//관리자 메뉴
	private final JMenuItem moneyMenuItem = new JMenuItem("수금");	//수금 메뉴 아이템
	private final JMenuItem storageMenuItem = new JMenuItem("재고보충");	//매출 정보 메뉴 아이템
	private final JMenuItem modifyMenuItem = new JMenuItem("정보수정");	//판매 정보 수정 메뉴 아이템
	private final JMenuItem passwordMenuItem = new JMenuItem("비밀번호");	//비밀번호 변경 메뉴 아이템
	private final JMenuItem closeMenuItem = new JMenuItem("종료");	//관리자메뉴 종료 메뉴 아이템
	private final JLabel showCanOutput = new JLabel();	//수금 가능 금액
	private final JLabel canOutputCash = new JLabel();	//각 종류별 남은 잔돈 개수
	private final JLabel showSavePrice = new JLabel();	//현재 보유 금액
	
	//비밀번호 변경 메뉴
	private JPasswordField currPassInput;	//현재 비밀번호 입력
	private JPasswordField newPassInput;	//새 비밀번호 입력
	
	//판매정보 변경 메뉴
	//변경버튼
	private final JButton waterNameChangeButton = new JButton("변경");	//물 이름
	private final JButton coffeeNameChangeButton = new JButton("변경");	//커피 이름
	private final JButton sportNameChangeButton = new JButton("변경");	//이온음료 이름
	private final JButton highCoffeeNameChangeButton = new JButton("변경");	//고급커피 이름
	private final JButton sparklingNameChangeButton = new JButton("변경");	//탄산음료 이름
	private final JButton waterPriceChangeButton = new JButton("변경");	//물 가격
	private final JButton coffeePriceChangeButton = new JButton("변경");	//커피 가격
	private final JButton sportPriceChangeButton = new JButton("변경");	//이온음료 가격
	private final JButton highCoffeePriceChangeButton = new JButton("변경");	//고급커피 가격
	private final JButton sparklingPriceChangeButton = new JButton("변경");	//탄산음료 가격	
	private final JLabel nameInfo = new JLabel("이름");	//이름 텍스트 레이블
	private final JLabel priceInfo = new JLabel("가격");	//가격 텍스트 레이블
	//현재 음료 이름 표시
	private final JLabel waterInfo = new JLabel(water.name);	//물
	private final JLabel coffeeInfo = new JLabel(coffee.name);	//커피
	private final JLabel sportInfo = new JLabel(sport.name);	//이온음료
	private final JLabel highCoffeeInfo = new JLabel(highCoffee.name);	//고급커피
	private final JLabel sparklingInfo = new JLabel(sparkling.name);	//탄산음료
	
	//각 정보 변경 입력
	private final JTextField waterNameChange = new JTextField();	//물 이름
	private final JTextField coffeeNameChange = new JTextField();	//커피 이름
	private final JTextField sportNameChange = new JTextField();	//이온음료 이름
	private final JTextField highCoffeeNameChange = new JTextField();	//고급커피 이름
	private final JTextField sparklingNameChange = new JTextField();	//탄산음료 이름

	private final JTextField waterPriceChange = new JTextField();	//물 가격
	private final JTextField coffeePriceChange = new JTextField();	//커피 가격
	private final JTextField sportPriceChange = new JTextField();	//이온음료 가격
	private final JTextField highCoffeePriceChange = new JTextField();	//고급커피 가격
	private final JTextField sparklingPriceChange = new JTextField();	//탄산음료 가격
	
	//재고보충 메뉴
	private final JLabel waterStoreName = new JLabel("물");
	private final JLabel coffeeStoreName = new JLabel("커피");
	private final JLabel sportStoreName = new JLabel("이온음료");
	private final JLabel highCoffeeStoreName = new JLabel("고급커피");
	private final JLabel sparklingStoreName = new JLabel("탄산음료");
	private final JLabel waterStorage = new JLabel(Integer.toString(waterstack.count()));	//물 재고 표시
	private final JLabel coffeeStorage = new JLabel(Integer.toString(coffeestack.count()));	//커피 재고 표시
	private final JLabel sportStorage = new JLabel(Integer.toString(sportstack.count()));	//이온음료 재고 표시
	private final JLabel highCoffeeStorage = new JLabel(Integer.toString(highCoffeestack.count()));	//고급커피 재고 표시
	private final JLabel sparklingStorage = new JLabel(Integer.toString(sparklingstack.count()));	//탄산음료 재고 표시
	
	//수금 메뉴
	private final JButton moneyRefreshBtn = new JButton("새로고침");	//수금메뉴 새로고침
	private final JButton output10 = new JButton("10원");	//수금할 10원 버튼
	private final JButton output50 = new JButton("50원");	//수금할 50원 버튼
	private final JButton output100 = new JButton("100원");	//수금할 100원 버튼
	private final JButton output500 = new JButton("500원");	//수금할 500원 버튼
	private final JButton output1000 = new JButton("1000원");	//수금할 1000원 버튼
	
	
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 653, 457);
		frame.setTitle("자판기");	//타이틀 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//실행 프레임 나가면 프로그램 종료
		frame.setResizable(false);	//프레임 크기 조절 비활성화
		frame.getContentPane().setLayout(null);
		
		//<자판기 화면>***************************************************************
		//자판기 메인화면 판넬
		machinePage.setBounds(0, 0, 647, 422);
		frame.getContentPane().add(machinePage);
		machinePage.setLayout(null);
		priceInput.setText("0");		
		
		//투입금액 레이블
		priceInput.setBounds(443, 31, 167, 52);
		priceInput.setHorizontalAlignment(SwingConstants.CENTER);
		priceInput.setFont(new Font("굴림", Font.BOLD, 20));
		priceInput.setOpaque(true);
		priceInput.setBackground(Color.WHITE);
		priceInput.setForeground(Color.BLACK);
		machinePage.add(priceInput);
		
		//반환버튼
		retBtn.setBounds(561, 237, 60, 60);
		retBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//반환버튼 누르면
				retClick++;	//반환버튼 클릭횟수 증가시키기		
				tmp1000 = 0;	//1000원 투입 개수 0으로 초기화
				//반환버튼이 5번 연속 눌리면 비밀번호 입력 페이지로 전환
				if(retClick == 5)
				{
					//비밀번호 입력 페이지로 넘어가기
					machinePage.setVisible(false);
					passwordPage.setVisible(true);
					retClick = 0;	//반환버튼 클릭 횟수 초기화
				}
			
				//[거스름돈 알고리즘](단, 1000원은 거스름돈에 포함되지 않는다)
				if(retClick == 1) {	//반환버튼 1번 눌렀을때 실행						
					//거스름돈 계산
					int ch;	//거스름돈 계산을 도울 변수
					//500원
					ch = currPrice / 500;	//필요한 500원 개수 계산
					if(ch<=coin500stack.count()) {	//만약 거슬러줄 500원이 충분하다면
						currPrice -= coin500.price*ch;	//총 거스름돈에서 500원을 필요한만큼 제외한다
						for(i=0; i<ch; i++) {
							coin500stack.pop();	//500원 스택에서도 빼준다
						}
					}
					else if(ch < coin500stack.count() && ch > 0){				//거슬러줄 500원이 모자라다면
						currPrice -= coin500.price*coin500stack.count();	//현재 갖고있는 500원 개수만큼만 거스름돈에서 제외한다
						for(i=0;i<coin500stack.count();i++) 
							coin500stack.pop();	//500원 스택에서도 빼준다
					}
					//100원
					ch = currPrice / 100;	//필요한 100원 개수 계산
					if(ch<=coin100stack.count()) {	//만약 거슬러줄 100원이 충분하다면
						currPrice -= coin100.price*ch;	//총 거스름돈에서 100원을 필요한만큼 제외한다
						for(i=0; i<ch; i++) {
							coin100stack.pop();	//100원 스택에서도 빼준다
						}
					}
					else if(ch < coin100stack.count() && ch > 0){				//거슬러줄 100원이 모자라다면
						currPrice -= coin100.price*coin100stack.count();	//현재 갖고있는 100원 개수만큼만 거스름돈에서 제외한다
						for(i=0;i<coin100stack.count();i++) 
							coin100stack.pop();	//100원 스택에서도 빼준다
						//coin100stack.count() = 0;	//100원 재고 비우기
					}
					//50원
					ch = currPrice / 50;	//필요한 50원 개수 계산
					if(ch<=coin50stack.count()) {	//만약 거슬러줄 50원이 충분하다면
						currPrice -= coin50.price*ch;	//총 거스름돈에서 50원을 필요한만큼 제외한다
						for(i=0; i<ch; i++) {
							coin50stack.pop();	//50원 스택에서도 빼준다
						}
					}
					else if(ch < coin50stack.count() && ch > 0){				//거슬러줄 50원이 모자라다면
						currPrice -= coin50.price*coin50stack.count();	//현재 갖고있는 50원 개수만큼만 거스름돈에서 제외한다
						for(i=0;i<coin50stack.count();i++)
							coin50stack.pop();	//50원 스택에서도 빼준다
					}
					//10원
					ch = currPrice / 10;	//필요한 10원 개수 계산
					if(ch<=coin10stack.count()) {	//만약 거슬러줄 10원이 충분하다면
						currPrice -= coin10.price*ch;	//총 거스름돈에서 10원을 필요한만큼 제외한다
						for(i=0; i<ch; i++) {
							coin10stack.pop();	//10원 스택에서도 빼준다
						}
					}
					else if(ch < coin10stack.count() && ch > 0){				//거슬러줄 10원이 모자라다면
						currPrice -= coin10.price*coin10stack.count();	//현재 갖고있는 10원 개수만큼만 거스름돈에서 제외한다
						for(i=0;i<coin10stack.count();i++)
							coin10stack.pop();	//10원 스택에서도 빼준다
					}
					
					currPrice = 0;	//현재 투입 금액 초기화
					//버튼 비활성화&활성화 버튼
					if(currPrice < water.price)
						waterBtn.setEnabled(false);
					else
						waterBtn.setEnabled(true);	
					if(currPrice < coffee.price)
						coffeeBtn.setEnabled(false);
					else
						coffeeBtn.setEnabled(true);	
					if(currPrice < sport.price)
						sportBtn.setEnabled(false);
					else
						sportBtn.setEnabled(true);	
					if(currPrice < highCoffee.price)
						highCoffeeBtn.setEnabled(false);
					else
						highCoffeeBtn.setEnabled(true);	
					if(currPrice < sparkling.price)
						sparklingBtn.setEnabled(false);
					else
						sparklingBtn.setEnabled(true);
					priceInput.setText("0");	//현재 투입 금액 레이블 초기화
					
				}
			}
		});
		machinePage.add(retBtn);
		
		//음료 메뉴 버튼
		waterBtn.setBounds(42, 48, 90, 35);
		waterBtn.addActionListener(new ActionListener() {	//물 버튼 클릭시
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//반환버튼 클릭횟수 초기화
				currPrice -= 450;	//현재 투입 금액에서 물 금액 제외
				waterstack.pop();	//물 스택에서 하나 빼기
				//버튼 비활성화&활성화 버튼
				if(waterstack.count() <= 0)
					waterBtn.setEnabled(false);
				else if(currPrice < water.price)
					waterBtn.setEnabled(false);
				else
					waterBtn.setEnabled(true);
				if(coffeestack.count() <= 0)
					coffeeBtn.setEnabled(false);
				else if(currPrice < coffee.price)
					coffeeBtn.setEnabled(false);
				else
					coffeeBtn.setEnabled(true);	
				if(sportstack.count() <= 0)
					sportBtn.setEnabled(false);
				else if(currPrice < sport.price)
					sportBtn.setEnabled(false);
				else
					sportBtn.setEnabled(true);	
				if(highCoffeestack.count() <= 0)
					highCoffeeBtn.setEnabled(false);
				else if(currPrice < highCoffee.price)
					highCoffeeBtn.setEnabled(false);
				else
					highCoffeeBtn.setEnabled(true);	
				if(sparklingstack.count() <= 0)
					sparklingBtn.setEnabled(false);
				else if(currPrice < sparkling.price)
					sparklingBtn.setEnabled(false);
				else
					sparklingBtn.setEnabled(true);
				priceInput.setText(Integer.toString(currPrice));	//현재 투입 금액 새로고침
			}
		});
		machinePage.add(waterBtn);
		
		coffeeBtn.setBounds(146, 48, 90, 35);
		coffeeBtn.addActionListener(new ActionListener() {	//커피 버튼 클릭시
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//반환버튼 클릭횟수 초기화
				currPrice -= 500;	//현재 투입 금액에서 커피금액 제외
				coffeestack.pop();	//커피 스택에서 하나 빼기
				//버튼 비활성화&활성화 버튼
				if(waterstack.count() <= 0)
					waterBtn.setEnabled(false);
				else if(currPrice < water.price)
					waterBtn.setEnabled(false);
				else
					waterBtn.setEnabled(true);
				if(coffeestack.count() <= 0)
					coffeeBtn.setEnabled(false);
				else if(currPrice < coffee.price)
					coffeeBtn.setEnabled(false);
				else
					coffeeBtn.setEnabled(true);	
				if(sportstack.count() <= 0)
					sportBtn.setEnabled(false);
				else if(currPrice < sport.price)
					sportBtn.setEnabled(false);
				else
					sportBtn.setEnabled(true);	
				if(highCoffeestack.count() <= 0)
					highCoffeeBtn.setEnabled(false);
				else if(currPrice < highCoffee.price)
					highCoffeeBtn.setEnabled(false);
				else
					highCoffeeBtn.setEnabled(true);	
				if(sparklingstack.count() <= 0)
					sparklingBtn.setEnabled(false);
				else if(currPrice < sparkling.price)
					sparklingBtn.setEnabled(false);
				else
					sparklingBtn.setEnabled(true);
				priceInput.setText(Integer.toString(currPrice));	//현재 투입 금액 새로고침
			}
		});
		machinePage.add(coffeeBtn);
		
		sportBtn.setBounds(250, 48, 90, 35);
		sportBtn.addActionListener(new ActionListener() {	//이온음료 버튼 클릭시
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//반환버튼 클릭횟수
				currPrice -= 550;	//현재 투입 금액에서 이온음료 금액 제외
				sportstack.pop();	//이온음료 스택에서 하나 빼기
				//버튼 비활성화&활성화 버튼
				if(waterstack.count() <= 0)
					waterBtn.setEnabled(false);
				else if(currPrice < water.price)
					waterBtn.setEnabled(false);
				else
					waterBtn.setEnabled(true);
				if(coffeestack.count() <= 0)
					coffeeBtn.setEnabled(false);
				else if(currPrice < coffee.price)
					coffeeBtn.setEnabled(false);
				else
					coffeeBtn.setEnabled(true);	
				if(sportstack.count() <= 0)
					sportBtn.setEnabled(false);
				else if(currPrice < sport.price)
					sportBtn.setEnabled(false);
				else
					sportBtn.setEnabled(true);	
				if(highCoffeestack.count() <= 0)
					highCoffeeBtn.setEnabled(false);
				else if(currPrice < highCoffee.price)
					highCoffeeBtn.setEnabled(false);
				else
					highCoffeeBtn.setEnabled(true);	
				if(sparklingstack.count() <= 0)
					sparklingBtn.setEnabled(false);
				else if(currPrice < sparkling.price)
					sparklingBtn.setEnabled(false);
				else
					sparklingBtn.setEnabled(true);
				priceInput.setText(Integer.toString(currPrice));	//현재 투입 금액 새로고침
			}
		});
		machinePage.add(sportBtn);
		
		highCoffeeBtn.setBounds(80, 142, 90, 35);
		highCoffeeBtn.addActionListener(new ActionListener() {	//고급커피 버튼 클릭시
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//반환버튼 클릭 횟수 초기화
				currPrice -= 700;	//현재 투입 금액에서 고급커피 가격 제외
				highCoffeestack.pop();	//고급커피 스택에서 하나 빼기
				//버튼 비활성화&활성화 버튼
				if(waterstack.count() <= 0)
					waterBtn.setEnabled(false);
				else if(currPrice < water.price)
					waterBtn.setEnabled(false);
				else
					waterBtn.setEnabled(true);
				if(coffeestack.count() <= 0)
					coffeeBtn.setEnabled(false);
				else if(currPrice < coffee.price)
					coffeeBtn.setEnabled(false);
				else
					coffeeBtn.setEnabled(true);	
				if(sportstack.count() <= 0)
					sportBtn.setEnabled(false);
				else if(currPrice < sport.price)
					sportBtn.setEnabled(false);
				else
					sportBtn.setEnabled(true);	
				if(highCoffeestack.count() <= 0)
					highCoffeeBtn.setEnabled(false);
				else if(currPrice < highCoffee.price)
					highCoffeeBtn.setEnabled(false);
				else
					highCoffeeBtn.setEnabled(true);	
				if(sparklingstack.count() <= 0)
					sparklingBtn.setEnabled(false);
				else if(currPrice < sparkling.price)
					sparklingBtn.setEnabled(false);
				else
					sparklingBtn.setEnabled(true);
				priceInput.setText(Integer.toString(currPrice));	//현재 투입 금액 새로고침
			}
		});
		machinePage.add(highCoffeeBtn);
		
		sparklingBtn.setBounds(203, 142, 90, 35);
		sparklingBtn.addActionListener(new ActionListener() {	//탄산음료 버튼 클릭시
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//반환버튼 클릭 횟수 초기화
				currPrice -= 750;	//현재 투입 금액에서 탄산음료 가격 제외
				sparklingstack.pop();	//탄산음료 스택  하나 빼기
				//버튼 비활성화&활성화 버튼
				if(waterstack.count() <= 0)
					waterBtn.setEnabled(false);
				else if(currPrice < water.price)
					waterBtn.setEnabled(false);
				else
					waterBtn.setEnabled(true);
				if(coffeestack.count() <= 0)
					coffeeBtn.setEnabled(false);
				else if(currPrice < coffee.price)
					coffeeBtn.setEnabled(false);
				else
					coffeeBtn.setEnabled(true);	
				if(sportstack.count() <= 0)
					sportBtn.setEnabled(false);
				else if(currPrice < sport.price)
					sportBtn.setEnabled(false);
				else
					sportBtn.setEnabled(true);	
				if(highCoffeestack.count() <= 0)
					highCoffeeBtn.setEnabled(false);
				else if(currPrice < highCoffee.price)
					highCoffeeBtn.setEnabled(false);
				else
					highCoffeeBtn.setEnabled(true);	
				if(sparklingstack.count() <= 0)
					sparklingBtn.setEnabled(false);
				else if(currPrice < sparkling.price)
					sparklingBtn.setEnabled(false);
				else
					sparklingBtn.setEnabled(true);
				priceInput.setText(Integer.toString(currPrice));	//현재 투입 금액 새로고침
			}
		});
		machinePage.add(sparklingBtn);
		
		//돈 입력 버튼(10, 50, 100, 500, 1000)
		coinBtn500.setBounds(561, 323, 60, 60);
		coinBtn500.addActionListener(new ActionListener() {	//500원 버튼 클릭시
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//반환버튼 클릭횟수 초기화
				currPrice += 500;	//현재 투입 금액에 500 추가
				coin500stack.push();	//500원 스택에 추가
				//만약 투입 금액이 5000원 초과시 메시지 출력 
				if(currPrice > 5000) {
					priceInput.setText("최대금액 초과");
					return;
				}
				priceInput.setText(Integer.toString(currPrice));	//현재 투입 금액 새로고침
				
				//버튼 비활성화&활성화 버튼
				if(waterstack.count() <= 0)
					waterBtn.setEnabled(false);
				else if(currPrice < water.price)
					waterBtn.setEnabled(false);
				else
					waterBtn.setEnabled(true);
				if(coffeestack.count() <= 0)
					coffeeBtn.setEnabled(false);
				else if(currPrice < coffee.price)
					coffeeBtn.setEnabled(false);
				else
					coffeeBtn.setEnabled(true);	
				if(sportstack.count() <= 0)
					sportBtn.setEnabled(false);
				else if(currPrice < sport.price)
					sportBtn.setEnabled(false);
				else
					sportBtn.setEnabled(true);	
				if(highCoffeestack.count() <= 0)
					highCoffeeBtn.setEnabled(false);
				else if(currPrice < highCoffee.price)
					highCoffeeBtn.setEnabled(false);
				else
					highCoffeeBtn.setEnabled(true);	
				if(sparklingstack.count() <= 0)
					sparklingBtn.setEnabled(false);
				else if(currPrice < sparkling.price)
					sparklingBtn.setEnabled(false);
				else
					sparklingBtn.setEnabled(true);
			}
		});
		machinePage.add(coinBtn500);
		
		coinBtn100.setBounds(497, 323, 60, 60);
		coinBtn100.addActionListener(new ActionListener() {	//100원 버튼 클릭시
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//반환버튼 클릭횟수 초기화
				currPrice += 100;	//현재 투입금액에 100 추가
				coin100stack.push();	//100원 스택에 추가
				//만약 투입 금액이 5000원 초과시 메시지 출력 
				if(currPrice > 5000) {
					priceInput.setText("최대금액 초과");
					return;
				}
				priceInput.setText(Integer.toString(currPrice));	//현재 투입 금액 새로고침
				
				//버튼 비활성화&활성화 버튼
				if(waterstack.count() <= 0)
					waterBtn.setEnabled(false);
				else if(currPrice < water.price)
					waterBtn.setEnabled(false);
				else
					waterBtn.setEnabled(true);
				if(coffeestack.count() <= 0)
					coffeeBtn.setEnabled(false);
				else if(currPrice < coffee.price)
					coffeeBtn.setEnabled(false);
				else
					coffeeBtn.setEnabled(true);	
				if(sportstack.count() <= 0)
					sportBtn.setEnabled(false);
				else if(currPrice < sport.price)
					sportBtn.setEnabled(false);
				else
					sportBtn.setEnabled(true);	
				if(highCoffeestack.count() <= 0)
					highCoffeeBtn.setEnabled(false);
				else if(currPrice < highCoffee.price)
					highCoffeeBtn.setEnabled(false);
				else
					highCoffeeBtn.setEnabled(true);	
				if(sparklingstack.count() <= 0)
					sparklingBtn.setEnabled(false);
				else if(currPrice < sparkling.price)
					sparklingBtn.setEnabled(false);
				else
					sparklingBtn.setEnabled(true);
			}
		});
		machinePage.add(coinBtn100);
		
		coinBtn50.setBounds(443, 323, 50, 50);
		coinBtn50.addActionListener(new ActionListener() {	//50원 버튼 클릭시
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//반환버튼 클릭 초기화시
				currPrice += 50;	//현재 투입 금액에 50 추가
				coin50stack.push();	//50원 스택에 추가
				//만약 투입 금액이 5000원 초과시  메시지 출력 
				if(currPrice > 5000) {
					priceInput.setText("최대금액 초과");
					return;
				}
				priceInput.setText(Integer.toString(currPrice));	//현재 투입 금액 새로고침
				
				//버튼 비활성화&활성화 버튼
				if(waterstack.count() <= 0)
					waterBtn.setEnabled(false);
				else if(currPrice < water.price)
					waterBtn.setEnabled(false);
				else
					waterBtn.setEnabled(true);
				if(coffeestack.count() <= 0)
					coffeeBtn.setEnabled(false);
				else if(currPrice < coffee.price)
					coffeeBtn.setEnabled(false);
				else
					coffeeBtn.setEnabled(true);	
				if(sportstack.count() <= 0)
					sportBtn.setEnabled(false);
				else if(currPrice < sport.price)
					sportBtn.setEnabled(false);
				else
					sportBtn.setEnabled(true);	
				if(highCoffeestack.count() <= 0)
					highCoffeeBtn.setEnabled(false);
				else if(currPrice < highCoffee.price)
					highCoffeeBtn.setEnabled(false);
				else
					highCoffeeBtn.setEnabled(true);	
				if(sparklingstack.count() <= 0)
					sparklingBtn.setEnabled(false);
				else if(currPrice < sparkling.price)
					sparklingBtn.setEnabled(false);
				else
					sparklingBtn.setEnabled(true);
			}
		});
		machinePage.add(coinBtn50);
		
		coinBtn10.setBounds(389, 323, 50, 50);
		coinBtn10.addActionListener(new ActionListener() {	//10원 버튼 클릭시
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//반환버튼 클릭 횟수 초기화
				currPrice += 10;	//현재 투입 금액 에 10 추가
				coin10stack.push();	//10원 스택에 추가
				//만약 투입 금액이 5000원 초과시  메시지 출력 
				if(currPrice > 5000) {
					priceInput.setText("최대금액 초과");
					return;
				}
				priceInput.setText(Integer.toString(currPrice));	//현재 투입 금액 새로고침
				
				//버튼 비활성화&활성화 버튼
				if(waterstack.count() <= 0)
					waterBtn.setEnabled(false);
				else if(currPrice < water.price)
					waterBtn.setEnabled(false);
				else
					waterBtn.setEnabled(true);
				if(coffeestack.count() <= 0)
					coffeeBtn.setEnabled(false);
				else if(currPrice < coffee.price)
					coffeeBtn.setEnabled(false);
				else
					coffeeBtn.setEnabled(true);	
				if(sportstack.count() <= 0)
					sportBtn.setEnabled(false);
				else if(currPrice < sport.price)
					sportBtn.setEnabled(false);
				else
					sportBtn.setEnabled(true);	
				if(highCoffeestack.count() <= 0)
					highCoffeeBtn.setEnabled(false);
				else if(currPrice < highCoffee.price)
					highCoffeeBtn.setEnabled(false);
				else
					highCoffeeBtn.setEnabled(true);	
				if(sparklingstack.count() <= 0)
					sparklingBtn.setEnabled(false);
				else if(currPrice < sparkling.price)
					sparklingBtn.setEnabled(false);
				else
					sparklingBtn.setEnabled(true);
			}
		});
		machinePage.add(coinBtn10);
		
		coinBtn1000.setBounds(275, 323, 100, 60);
		coinBtn1000.addActionListener(new ActionListener() {	//1000원 버튼 클릭시
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//반환버튼 클릭 횟수 초기화
				currPrice += 1000;	//현재 투입 금액 에 1000 추가
				bill1000stack.push();	//1000원 스택에 추가
				tmp1000++;
				//만약 투입 금액이 5000원 초과 혹은 1000원 투입 개수가 3개 초과시  메시지 출력 
				if((currPrice > 5000) || (tmp1000 > 3)) {
					priceInput.setText("최대금액 초과");
					return;
				}
				priceInput.setText(Integer.toString(currPrice));	//현재 투입 금액 새로고침
				
				//버튼 비활성화&활성화 버튼
				if(waterstack.count() <= 0)
					waterBtn.setEnabled(false);
				else if(currPrice < water.price)
					waterBtn.setEnabled(false);
				else
					waterBtn.setEnabled(true);
				if(coffeestack.count() <= 0)
					coffeeBtn.setEnabled(false);
				else if(currPrice < coffee.price)
					coffeeBtn.setEnabled(false);
				else
					coffeeBtn.setEnabled(true);	
				if(sportstack.count() <= 0)
					sportBtn.setEnabled(false);
				else if(currPrice < sport.price)
					sportBtn.setEnabled(false);
				else
					sportBtn.setEnabled(true);	
				if(highCoffeestack.count() <= 0)
					highCoffeeBtn.setEnabled(false);
				else if(currPrice < highCoffee.price)
					highCoffeeBtn.setEnabled(false);
				else
					highCoffeeBtn.setEnabled(true);	
				if(sparklingstack.count() <= 0)
					sparklingBtn.setEnabled(false);
				else if(currPrice < sparkling.price)
					sparklingBtn.setEnabled(false);
				else
					sparklingBtn.setEnabled(true);
				
			}
		});
		machinePage.add(coinBtn1000);		
				
				
		JLabel bill = new JLabel("<지폐투입>");
		bill.setBounds(286, 293, 80, 20);
		machinePage.add(bill);
		
		JLabel coin = new JLabel("<동전투입>");
		coin.setBounds(464, 291, 80, 20);
		machinePage.add(coin);		
				
		//음료별 가격 표시
		waterPrice.setBounds(65, 83, 40, 20);
		waterPrice.setHorizontalAlignment(SwingConstants.CENTER);
		machinePage.add(waterPrice);
		
		coffeePrice.setBounds(168, 84, 40, 20);
		coffeePrice.setHorizontalAlignment(SwingConstants.CENTER);
		machinePage.add(coffeePrice);
		
		sportPrice.setBounds(273, 84, 40, 20);
		sportPrice.setHorizontalAlignment(SwingConstants.CENTER);
		machinePage.add(sportPrice);
		
		highCoffeePrice.setBounds(107, 177, 40, 20);
		highCoffeePrice.setHorizontalAlignment(SwingConstants.CENTER);
		machinePage.add(highCoffeePrice);
		
		
		sparklingPrice.setBounds(227, 178, 40, 20);
		sparklingPrice.setHorizontalAlignment(SwingConstants.CENTER);
		machinePage.add(sparklingPrice);
		
		//최대 투입 금액 메세지 표시
		JLabel maxInputMessage = new JLabel("최대 투입금액 5000원");
		maxInputMessage.setBounds(443, 95, 167, 20);
		maxInputMessage.setHorizontalAlignment(SwingConstants.CENTER);
		machinePage.add(maxInputMessage);
		
		//현재 투입 금액 메세지 표시
		JLabel currInput = new JLabel("현재금액");
		currInput.setBounds(443, 12, 167, 20);
		currInput.setFont(new Font("굴림", Font.BOLD, 17));
		currInput.setHorizontalAlignment(SwingConstants.CENTER);
		machinePage.add(currInput);
		
		//<비밀번호 화면>***************************************************************
		//비밀번호 판넬
		passwordPage.setBounds(0, 0, 647, 422);
		frame.getContentPane().add(passwordPage);
		passwordPage.setLayout(null);
		
		//비밀번호 입력창
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 180, 210, 35);
		passwordPage.add(passwordField);
		
		//비밀번호 텍스트 레이블
		JLabel lblNewLabel = new JLabel("비밀번호");
		lblNewLabel.setBounds(295, 150, 60, 20);
		passwordPage.add(lblNewLabel);
		
		//비밀번호 엔터 버튼
		JButton enterButton = new JButton("ENTER");
		enterButton.setFont(new Font("굴림", Font.PLAIN, 11));
		enterButton.setBounds(430, 180, 70, 35);
		enterButton.addActionListener(new ActionListener() {	//엔터버튼 클릭시
			public void actionPerformed(ActionEvent e) {
				//만약 비밀번호와 입력한 텍스트가 일치하다면
				if(password.password.equals(passwordField.getText())) {
					passwordPage.setVisible(false);
					managerPage.setVisible(true);	//관리자메뉴 페이지로 이동
					passwordField.setText("");
				}
				else {	//아니라면 오류 메시지 띄우기
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다(특수문자 포함)");
					passwordField.setText("");
				}
			}
		});
		passwordPage.add(enterButton);
		
		
		//<관리자메뉴 화면>***************************************************************
		//관리자메뉴 판넬
		managerPage.setBounds(0, 0, 647, 422);
		frame.getContentPane().add(managerPage);
		managerPage.setLayout(null);		
		
		//메뉴바 생성
		managerMenuBar.setBounds(0, 0, 647, 30);
		managerPage.add(managerMenuBar);		
		managerMenuBar.add(managerMenu);
		
		//수금 메뉴아이템
		moneyMenuItem.setHorizontalAlignment(SwingConstants.CENTER);	
		moneyMenuItem.addActionListener(new MenuActionListener());
		managerMenu.add(moneyMenuItem);
		
		JSeparator separator1 = new JSeparator();	//메뉴 구분선 추가
		managerMenu.add(separator1);
		
		//재고보충 메뉴 아이템
		storageMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		storageMenuItem.addActionListener(new MenuActionListener());
		managerMenu.add(storageMenuItem);
		
		JSeparator separator2 = new JSeparator();	//메뉴 구분선 추가
		managerMenu.add(separator2);
		
		//정보수정 메뉴아이템
		modifyMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		modifyMenuItem.addActionListener(new MenuActionListener());
		managerMenu.add(modifyMenuItem);
		
		JSeparator separator3 = new JSeparator();	//메뉴 구분선 추가
		managerMenu.add(separator3);
		
		//비밀번호 변경 메뉴아이템
		passwordMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		passwordMenuItem.addActionListener(new MenuActionListener());
		managerMenu.add(passwordMenuItem);
		
		JSeparator separator4 = new JSeparator();	//메뉴 구분선 추가
		managerMenu.add(separator4);
		
		//종료 메뉴아이템
		closeMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		closeMenuItem.addActionListener(new MenuActionListener());
		managerMenu.add(closeMenuItem);
		
		//[관리자메뉴 - 수금 메뉴]
		moneyMenu.setBounds(0, 31, 647, 391);
		managerPage.add(moneyMenu);
		moneyMenu.setLayout(null);
		
		//현재금액 텍스트 레이블
		JLabel savePricetext = new JLabel("현재 금액 : ");
		savePricetext.setBounds(236, 88, 80, 30);
		moneyMenu.add(savePricetext);
		
		//현재 금액 레이블
		showSavePrice.setBounds(330, 88, 110, 30);
		showSavePrice.setOpaque(true);
		showSavePrice.setForeground(Color.BLACK);
		showSavePrice.setBackground(Color.WHITE);
		moneyMenu.add(showSavePrice);
		
		
		//수금 가능 금액 텍스트 레이블
		JLabel canOutput = new JLabel("수금 가능 금액 : ");
		canOutput.setBounds(196, 180, 120, 30);
		moneyMenu.add(canOutput);
		
		//금액 입력 텍스트 레이블
		JLabel OutputPrice = new JLabel("<수금할 금액 클릭>");
		OutputPrice.setBounds(257, 247, 134, 30);
		moneyMenu.add(OutputPrice);
		
		//수금 가능 금액 텍스트 레이블
		showCanOutput.setBounds(330, 180, 110, 30);
		showCanOutput.setOpaque(true);
		showCanOutput.setForeground(Color.BLACK);
		showCanOutput.setBackground(Color.WHITE);
		moneyMenu.add(showCanOutput);
		
		//화폐 별 재고 표시 텍스트 레이블
		canOutputCash.setBounds(132, 138, 350, 30);
		canOutputCash.setHorizontalAlignment(SwingConstants.CENTER);		
		moneyMenu.add(canOutputCash);		
		
		//수금메뉴 새로고침 버튼
		moneyRefreshBtn.setBounds(543, 12, 90, 40);
		moneyRefreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//버튼 클릭시
				savePrice = 10*coin10stack.count() + 50*coin50stack.count() + 100*coin100stack.count()
				+ 500*coin500stack.count() + 1000*bill1000stack.count();
				showSavePrice.setText(Integer.toString(savePrice));	//현재 보유 금액 표시 새로고침
				
				canOutputCash.setText("10원:"+coin10stack.count()+" 50원:"+coin50stack.count()+" 100원:"+coin100stack.count()
						+" 500원:"+coin500stack.count()+" 1000원:"+bill1000stack.count());	//현재 금액 표시 새로고침
				
				//수금 가능 금액 계산(각 화폐의 최소재고 3개는 남겨둔다)
				canoutput = 0;
				if(coin10stack.count() > 3)	//10원 재고가 3개보다 크다면
					canoutput += 10*(coin10stack.count() - 3);	//현재 재고에서 3개를 뺀만큼 수금 가능
				if(coin50stack.count() > 3)	//50원 재고가 3개보다 크다면
					canoutput += 50*(coin50stack.count() - 3);	//현재 재고에서 3개를 뺀만큼 수금 가능
				if(coin100stack.count() > 3)	//100원 재고가 3개보다 크다면
					canoutput += 100*(coin100stack.count() - 3);	//현재 재고에서 3개를 뺀만큼 수금 가능
				if(coin500stack.count() > 3)	//500원 재고가 3개보다 크다면
					canoutput += 500*(coin500stack.count() - 3);	//현재 재고에서 3개를 뺀만큼 수금 가능
				if(bill1000stack.count() > 3)	//1000원 재고가 3개보다 크다면
					canoutput += 1000*(bill1000stack.count() - 3);	//현재 재고에서 3개를 뺀만큼 수금 가능
				showCanOutput.setText(Integer.toString(canoutput));	//수금 가능 금액 표시 새로고침
			}
		});
		moneyMenu.add(moneyRefreshBtn);
		
		//화폐별 수금 버튼(수금시 최소 재고 3개는 남긴다)
		output10.setBounds(94, 289, 70, 40);
		output10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//버튼 클릭시
				if(coin10stack.count() > 3) {	//10원 재고가 3개 초과라면 수금 실행
					coin10stack.pop();	//스택에서 하나 빼기
				}
			}
		});
		moneyMenu.add(output10);
		
		output50.setBounds(192, 289, 70, 40);
		output50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//버튼 클릭시
				if(coin50stack.count() > 3) {	//50원 재고가 3개 초과라면 수금 실행
					coin50stack.pop();	//스택에서 하나 빼기
				}
			}
		});
		moneyMenu.add(output50);
		
		output100.setBounds(293, 289, 70, 40);	
		output100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//버튼 클릭시
				if(coin100stack.count() > 3) {	//100원 재고가 3개 초과라면 수금 실행
					coin100stack.pop();	//스택에서 하나 빼기
				}
			}
		});
		moneyMenu.add(output100);
		
		output500.setBounds(391, 289, 70, 40);	
		output500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//버튼 클릭시
				if(coin500stack.count() > 3) {	//500원 재고가 3개 초과라면 수금 실행
					coin500stack.pop();	//스택에서 하나 빼기
				}
			}
		});
		moneyMenu.add(output500);
		
		output1000.setBounds(485, 289, 80, 40);		
		output1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//버튼 클릭시
				if(bill1000stack.count() > 3) {	//10원 재고가 3개 초과라면 수금 실행
					bill1000stack.pop();	//스택에서 하나 빼기
				}
			}
		});
		moneyMenu.add(output1000);
		
		
		//[관리자메뉴 - 재고 수정 메뉴]
		storageMenu.setBounds(0, 31, 647, 391);
		managerPage.add(storageMenu);
		storageMenu.setLayout(null);	
		
		//각 음료의 이름 표시
		waterStoreName.setHorizontalAlignment(SwingConstants.CENTER);	//물 이름
		waterStoreName.setBounds(164, 60, 70, 30);
		storageMenu.add(waterStoreName);
		coffeeStoreName.setHorizontalAlignment(SwingConstants.CENTER);	//커피 이름
		coffeeStoreName.setBounds(164, 115, 70, 30);
		storageMenu.add(coffeeStoreName);
		sportStoreName.setHorizontalAlignment(SwingConstants.CENTER);	//이온음료 이름
		sportStoreName.setBounds(164, 173, 70, 30);		
		storageMenu.add(sportStoreName);
		highCoffeeStoreName.setHorizontalAlignment(SwingConstants.CENTER);	//고급커피 이름
		highCoffeeStoreName.setBounds(164, 232, 70, 30);		
		storageMenu.add(highCoffeeStoreName);
		sparklingStoreName.setHorizontalAlignment(SwingConstants.CENTER);	//탄산음료 이름
		sparklingStoreName.setBounds(164, 295, 70, 30);
		storageMenu.add(sparklingStoreName);
		
		//각 음료의 재고 표시
		waterStorage.setOpaque(true);	//물 재고
		waterStorage.setBackground(Color.WHITE);
		waterStorage.setForeground(Color.BLACK);
		waterStorage.setHorizontalAlignment(SwingConstants.CENTER);
		waterStorage.setBounds(293, 60, 75, 30);		
		storageMenu.add(waterStorage);	
		coffeeStorage.setOpaque(true);	//커피 재고
		coffeeStorage.setHorizontalAlignment(SwingConstants.CENTER);
		coffeeStorage.setForeground(Color.BLACK);
		coffeeStorage.setBackground(Color.WHITE);
		coffeeStorage.setBounds(293, 115, 75, 30);		
		storageMenu.add(coffeeStorage);
		sportStorage.setOpaque(true);	//커피 재고
		sportStorage.setHorizontalAlignment(SwingConstants.CENTER);
		sportStorage.setForeground(Color.BLACK);
		sportStorage.setBackground(Color.WHITE);
		sportStorage.setBounds(293, 173, 75, 30);		
		storageMenu.add(sportStorage);
		highCoffeeStorage.setOpaque(true);	//고급커피 재고
		highCoffeeStorage.setHorizontalAlignment(SwingConstants.CENTER);
		highCoffeeStorage.setForeground(Color.BLACK);
		highCoffeeStorage.setBackground(Color.WHITE);
		highCoffeeStorage.setBounds(293, 232, 75, 30);		
		storageMenu.add(highCoffeeStorage);
		sparklingStorage.setOpaque(true);	//탄산음료 재고
		sparklingStorage.setHorizontalAlignment(SwingConstants.CENTER);
		sparklingStorage.setForeground(Color.BLACK);
		sparklingStorage.setBackground(Color.WHITE);
		sparklingStorage.setBounds(293, 295, 75, 30);		
		storageMenu.add(sparklingStorage);
		
		//각 음료의 재고 보충 알고리즘
		JButton waterPlus = new JButton("+");	//물 보충 버튼
		waterPlus.setBounds(420, 62, 45, 30);
		waterPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//버튼 클릭시
				waterstack.push();	//물 스택 하나 추가
				waterStorage.setText(Integer.toString(waterstack.count()));	//재고 표시 칸에 표기
			}
		});
		storageMenu.add(waterPlus);
		
		JButton coffeePlus = new JButton("+");	//커피 보충 버튼
		coffeePlus.setBounds(420, 117, 45, 30);
		coffeePlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//버튼 클릭시
				coffeestack.push();	//커피 스택 하나 추가
				coffeeStorage.setText(Integer.toString(coffeestack.count()));	//재고 표시 칸에 표기
			}
		});
		storageMenu.add(coffeePlus);
		
		JButton sportPlus = new JButton("+");	//이온음료 보충 버튼
		sportPlus.setBounds(420, 175, 45, 30);
		sportPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//버튼 클릭시
				sportstack.push();	//이온음료 스택 하나 추가
				sportStorage.setText(Integer.toString(sportstack.count()));	//재고 표시 칸에 표기
			}
		});
		storageMenu.add(sportPlus);
		
		JButton highCoffeePlus = new JButton("+");	//고급커피 보충 버튼
		highCoffeePlus.setBounds(420, 234, 45, 30);
		highCoffeePlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//버튼 클릭시
				highCoffeestack.push();	//고급커피 스택 하나 추가
				highCoffeeStorage.setText(Integer.toString(highCoffeestack.count()));	//재고 표시 칸에 표기
			}
		});
		storageMenu.add(highCoffeePlus);
		
		JButton sparklingPlus = new JButton("+");	//탄산음료 보충 버튼
		sparklingPlus.setBounds(420, 297, 45, 30);
		sparklingPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//버튼 클릭시
				sparklingstack.push();	//탄산음료 스택 하나 추가
				sparklingStorage.setText(Integer.toString(sparklingstack.count()));	//재고 표시 칸에 표기
			}
		});
		storageMenu.add(sparklingPlus);
		
		//재고보충 메뉴 새로고침 버튼
		JButton storageRefreshBtn = new JButton("새로고침");
		storageRefreshBtn.setBounds(543, 12, 90, 40);
		storageRefreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//버튼 클릭시
				waterStorage.setText(Integer.toString(waterstack.count()));	//재고 표시 새로고침
				coffeeStorage.setText(Integer.toString(coffeestack.count()));	//재고 표시 새로고침
				sportStorage.setText(Integer.toString(sportstack.count()));	//재고 표시 새로고침
				highCoffeeStorage.setText(Integer.toString(highCoffeestack.count()));	//재고 표시 새로고침
				sparklingStorage.setText(Integer.toString(sparklingstack.count()));	//재고 표시 새로고침
			}
		});
		storageMenu.add(storageRefreshBtn);
				
		
		//[관리자메뉴 - 판매정보 수정 메뉴]
		infoMenu.setBounds(0, 31, 647, 391);
		managerPage.add(infoMenu);
		infoMenu.setLayout(null);
		nameInfo.setBounds(184, 28, 60, 38);
		//음료 이름 표시
		nameInfo.setHorizontalAlignment(SwingConstants.CENTER);
		infoMenu.add(nameInfo);
		waterInfo.setBounds(95, 73, 60, 38);
		//물 이름 표시
		waterInfo.setHorizontalAlignment(SwingConstants.CENTER);
		infoMenu.add(waterInfo);
		coffeeInfo.setBounds(95, 124, 60, 38);
		//커피 이름 표시
		coffeeInfo.setHorizontalAlignment(SwingConstants.CENTER);
		infoMenu.add(coffeeInfo);
		sportInfo.setBounds(95, 174, 60, 38);
		//이온음료 이름 표시
		sportInfo.setHorizontalAlignment(SwingConstants.CENTER);
		infoMenu.add(sportInfo);
		highCoffeeInfo.setBounds(95, 228, 60, 38);
		//고급커피 이름 표시
		highCoffeeInfo.setHorizontalAlignment(SwingConstants.CENTER);
		infoMenu.add(highCoffeeInfo);
		sparklingInfo.setBounds(95, 278, 60, 38);
		//탄산음료 이름 표시
		sparklingInfo.setHorizontalAlignment(SwingConstants.CENTER);
		infoMenu.add(sparklingInfo);
		waterNameChange.setBounds(171, 80, 95, 24);
		
		//변경할 음료 이름 & 가격 입력창
		//변경할 물 이름 입력창
		waterNameChange.setHorizontalAlignment(SwingConstants.CENTER);
		waterNameChange.setColumns(10);
		infoMenu.add(waterNameChange);
		coffeeNameChange.setBounds(171, 131, 95, 24);
		//변경할 커피 이름 입력창
		coffeeNameChange.setHorizontalAlignment(SwingConstants.CENTER);
		coffeeNameChange.setColumns(10);
		infoMenu.add(coffeeNameChange);
		sportNameChange.setBounds(171, 181, 95, 24);
		//변경할 이온음료 이름 입력창
		sportNameChange.setHorizontalAlignment(SwingConstants.CENTER);
		sportNameChange.setColumns(10);
		infoMenu.add(sportNameChange);
		highCoffeeNameChange.setBounds(171, 235, 95, 24);
		//변경할 고급커피 이름 입력창
		highCoffeeNameChange.setHorizontalAlignment(SwingConstants.CENTER);
		highCoffeeNameChange.setColumns(10);
		infoMenu.add(highCoffeeNameChange);
		sparklingNameChange.setBounds(171, 285, 95, 24);
		//변경할 탄산음료 이름 입력창
		sparklingNameChange.setHorizontalAlignment(SwingConstants.CENTER);
		sparklingNameChange.setColumns(10);
		infoMenu.add(sparklingNameChange);
		
		priceInfo.setBounds(386, 28, 60, 38);		
		priceInfo.setHorizontalAlignment(SwingConstants.CENTER);
		infoMenu.add(priceInfo);
		//변경할 물 가격 입력창
		waterPriceChange.setBounds(374, 80, 95, 24);
		waterPriceChange.setHorizontalAlignment(SwingConstants.CENTER);
		waterPriceChange.setColumns(10);
		infoMenu.add(waterPriceChange);
		//변경할 커피 가격 입력창
		coffeePriceChange.setBounds(374, 131, 95, 24);		
		coffeePriceChange.setHorizontalAlignment(SwingConstants.CENTER);
		coffeePriceChange.setColumns(10);
		infoMenu.add(coffeePriceChange);
		//변경할 이온음료 가격 입력창
		sportPriceChange.setBounds(374, 181, 95, 24);		
		sportPriceChange.setHorizontalAlignment(SwingConstants.CENTER);
		sportPriceChange.setColumns(10);
		infoMenu.add(sportPriceChange);
		//변경할 고급커피 가격 입력창
		highCoffeePriceChange.setBounds(374, 235, 95, 24);		
		highCoffeePriceChange.setHorizontalAlignment(SwingConstants.CENTER);
		highCoffeePriceChange.setColumns(10);
		infoMenu.add(highCoffeePriceChange);
		//변경할 탄산음료 가격 입력창
		sparklingPriceChange.setBounds(374, 285, 95, 24);		
		sparklingPriceChange.setHorizontalAlignment(SwingConstants.CENTER);
		sparklingPriceChange.setColumns(10);
		infoMenu.add(sparklingPriceChange);
		
		//물 이름 변경 버튼
		waterNameChangeButton.setBounds(278, 79, 80, 25);
		infoMenu.add(waterNameChangeButton);
		waterNameChangeButton.addActionListener(new ActionListener() {	//물 이름 변경 버튼 누르면
			public void actionPerformed(ActionEvent e) {
				water.rename(waterNameChange.getText());	//입력한 새 이름으로 변경
				waterBtn.setText(water.name);	//음료 선택 버튼에 표기 변경
			}
		});
		//커피 이름 변경 버튼
		coffeeNameChangeButton.setBounds(278, 130, 80, 25);
		infoMenu.add(coffeeNameChangeButton);
		coffeeNameChangeButton.addActionListener(new ActionListener() {	//커피 이름 변경 버튼 누르면
			public void actionPerformed(ActionEvent e) {
				coffee.rename(coffeeNameChange.getText());	//입력한 새 이름으로 변경
				coffeeBtn.setText(coffee.name);	//음료 선택 버튼에 표기 변경
			}
		});
		//이온음료 이름 변경 버튼
		sportNameChangeButton.setBounds(278, 180, 80, 25);
		infoMenu.add(sportNameChangeButton);
		sportNameChangeButton.addActionListener(new ActionListener() {	//이온음료 이름 변경 버튼 누르면
			public void actionPerformed(ActionEvent e) {
				sport.rename(sportNameChange.getText());	//입력한 새 이름으로 변경
				sportBtn.setText(sport.name);	//음료 선택 버튼에 표기 변경
			}
		});
		//고급커피 이름 변경 버튼
		highCoffeeNameChangeButton.setBounds(278, 234, 80, 25);
		infoMenu.add(highCoffeeNameChangeButton);
		highCoffeeNameChangeButton.addActionListener(new ActionListener() {	//고급커피 이름 변경 버튼 누르면
			public void actionPerformed(ActionEvent e) {
				highCoffee.rename(highCoffeeNameChange.getText());	//입력한 새 이름으로 변경
				highCoffeeBtn.setText(highCoffee.name);	//음료 선택 버튼에 표기 변경
			}
		});
		//탄산음료 이름 변경 버튼
		sparklingNameChangeButton.setBounds(278, 284, 80, 25);
		infoMenu.add(sparklingNameChangeButton);
		sparklingNameChangeButton.addActionListener(new ActionListener() {	//탄산음료 이름 변경 버튼 누르면
			public void actionPerformed(ActionEvent e) {
				sparkling.rename(sparklingNameChange.getText());	//입력한 새 이름으로 변경
				sparklingBtn.setText(sparkling.name);	//음료 선택 버튼에 표기 변경
			}
		});
		//물 가격 변경 버튼
		waterPriceChangeButton.setBounds(483, 79, 80, 25);
		infoMenu.add(waterPriceChangeButton);	
		waterPriceChangeButton.addActionListener(new ActionListener() {	//물 가격 변경 버튼 누르면
			public void actionPerformed(ActionEvent e) {
				water.resetting(Integer.parseInt(waterPriceChange.getText()));	//입력한 새 가격으로 변경
				waterPrice.setText(water.price+"원");	//음료 가격 표기 변경
			}
		});
		//커피 가격 변경 버튼
		coffeePriceChangeButton.setBounds(483, 130, 80, 25);
		infoMenu.add(coffeePriceChangeButton);
		coffeePriceChangeButton.addActionListener(new ActionListener() {	//커피 가격 변경 버튼 누르면
			public void actionPerformed(ActionEvent e) {
				coffee.resetting(Integer.parseInt(coffeePriceChange.getText()));	//입력한 새 가격으로 변경
				coffeePrice.setText(coffee.price+"원");	//음료 가격 표기 변경
			}
		});
		//이온음료 가격 변경 버튼
		sportPriceChangeButton.setBounds(483, 180, 80, 25);
		infoMenu.add(sportPriceChangeButton);
		sportPriceChangeButton.addActionListener(new ActionListener() {	//이온음료 가격 변경 버튼 누르면
			public void actionPerformed(ActionEvent e) {
				sport.resetting(Integer.parseInt(sportPriceChange.getText()));	//입력한 새 가격으로 변경
				sportPrice.setText(sport.price+"원");	//음료 가격 표기 변경
			}
		});
		//고급커피 가격 변경 버튼 
		highCoffeePriceChangeButton.setBounds(483, 234, 80, 25);
		infoMenu.add(highCoffeePriceChangeButton);
		highCoffeePriceChangeButton.addActionListener(new ActionListener() {	//고급커피 가격 변경 버튼 누르면
			public void actionPerformed(ActionEvent e) {
				highCoffee.resetting(Integer.parseInt(highCoffeePriceChange.getText()));	//입력한 새 가격으로 변경
				highCoffeePrice.setText(highCoffee.price+"원");	//음료 가격 표기 변경
			}
		});
		//탄산음료 가격 변경 버튼 
		sparklingPriceChangeButton.setBounds(483, 284, 80, 25);
		infoMenu.add(sparklingPriceChangeButton);
		sparklingPriceChangeButton.addActionListener(new ActionListener() {	//탄산음료 가격 변경 버튼 누르면
			public void actionPerformed(ActionEvent e) {
				sparkling.resetting(Integer.parseInt(sparklingPriceChange.getText()));	//입력한 새 가격으로 변경
				sparklingPrice.setText(sparkling.price+"원");	//음료 가격 표기 변경
			}
		});
		
		//[관리자 메뉴 - 비밀번호 변경 메뉴]
		passwordMenu.setBounds(0, 31, 647, 391);			
		managerPage.add(passwordMenu);
		passwordMenu.setLayout(null);
		
		//현재 비밀번호 텍스트 레이블
		JLabel currPass = new JLabel("현재 비밀번호 : ");
		currPass.setHorizontalAlignment(SwingConstants.CENTER);
		currPass.setBounds(200, 109, 112, 38);
		passwordMenu.add(currPass);
		//새 비밀번호 텍스트 레이블
		JLabel newPass = new JLabel("새 비밀번호 : ");
		newPass.setHorizontalAlignment(SwingConstants.CENTER);
		newPass.setBounds(200, 172, 112, 38);
		passwordMenu.add(newPass);
		//현재 비밀번호 입력 패스워드필드
		currPassInput = new JPasswordField();
		currPassInput.setHorizontalAlignment(SwingConstants.CENTER);
		currPassInput.setBounds(326, 116, 120, 35);
		passwordMenu.add(currPassInput);
		//새(바꿀) 비밀번호 입력 패스워드필드
		newPassInput = new JPasswordField();
		newPassInput.setHorizontalAlignment(SwingConstants.CENTER);
		newPassInput.setBounds(326, 172, 120, 35);
		passwordMenu.add(newPassInput);
		
		//비밀번호 변경(엔터)버튼
		JButton passEnterButton = new JButton("Enter");
		passEnterButton.setBounds(270, 237, 100, 40);
		passEnterButton.addActionListener(new ActionListener() {	//버튼 클릭시
			public void actionPerformed(ActionEvent e) {
				//만약 현재 비밀번호가 일치한다면
				if(currPassInput.getText().equals(password.password)) {
					currPassInput.setText("");
					//만약 새 비밀번호에 특수문자(!, *, @)가 하나 이상 포함되어 있다면
					if(newPassInput.getText().contains("!")||newPassInput.getText().contains("*")||newPassInput.getText().contains("@")) {
						password.change(newPassInput.getText());	//비밀번호 변경
						newPassInput.setText("");
					}
						
					//아니면 오류메시지 띄우기
					else {
						newPassInput.setText("");
						JOptionPane.showMessageDialog(null, "특수문자 1개 이상 포함해야함(!, *, @)");
					}
				}
				//아니면 오류메시지 띄우기
				else {
					currPassInput.setText("");
					newPassInput.setText("");
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다(특수문자 포함)");
				}
			}
		});
		passwordMenu.add(passEnterButton);
	}
	
	//관리자 메뉴 아이템 액션리스너
	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();	//선택한 메뉴아이템의 문자열 리턴
			switch(cmd) {
			case "수금":	//수금메뉴 클릭시
				moneyMenu.setVisible(true);	//수금패널 보이기
				passwordMenu.setVisible(false);	//나머지패널은 비활성화
				infoMenu.setVisible(false);
				storageMenu.setVisible(false);
				break;
			case "재고보충":	//재고보충 메뉴 클릭시
				storageMenu.setVisible(true);	//재고보충 패널 보이기
				moneyMenu.setVisible(false);	//나머지패널은 비활성화
				passwordMenu.setVisible(false);
				infoMenu.setVisible(false);
				break;
			case "정보수정":	//정보수정 메뉴 클릭시
				infoMenu.setVisible(true);	//정보수정 수정 패널 보이기
				moneyMenu.setVisible(false);	//나머지패널은 비활성화
				passwordMenu.setVisible(false);
				storageMenu.setVisible(false);
				break;
			case "비밀번호":	//비밀번호(변경)메뉴 클릭시
				passwordMenu.setVisible(true);	//비밀번호 변경 패널 보이기
				moneyMenu.setVisible(false);	//나머지패널은 비활성화
				infoMenu.setVisible(false);
				storageMenu.setVisible(false);
				break;
			case "종료":
				machinePage.setVisible(true);	//다시 자판기 화면 보이기
				managerPage.setVisible(false);	//나머지패널은 비활성화
				moneyMenu.setVisible(false);
				passwordMenu.setVisible(false);
				infoMenu.setVisible(false);
				storageMenu.setVisible(false);
				break;
		}
	}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {	//쓰레드에 의해 실행될 수 있는 코드
			public void run() {
				try {
					vendingMachine window = new vendingMachine();
					window.frame.setVisible(true);
				} catch (Exception e) {	//예외 발생시
					e.printStackTrace();	//예외 정보 제시 & 프로그램 종료
				}
			}
		});
		
		
		
	}
	
}
