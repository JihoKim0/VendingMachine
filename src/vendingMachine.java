/*
 ���α׷��� : VendingMachine
 ���α׷��� ���� : ListStackNode(���� ��� Ŭ����)
 			ListStack(���Ḯ��Ʈ ���� Ŭ����) - isEmpty(���� ������� ���� �޼ҵ�), init(�����ʱ�ȭ �޼ҵ�), 
 			push(���� ���� �޼ҵ�), pop(���û����޼ҵ�), count(���ð��� ��ȯ �޼ҵ�)
			water, coffee, sport, highCoffee, sparkling(���� Ŭ����) - rename(�̸� �缳�� �޼ҵ�), resetting(���� �缳�� �޼ҵ�)
			coin10, coin50, coin100, coin500, bill1000(ȭ�� Ŭ����
			password(��й�ȣ Ŭ����) - change(��й�ȣ ���� �޼ҵ�)
			vendingMachine(���Ǳ� Ŭ����)-initialize(��ü ���Ǳ� �˰��� �޼ҵ�)
 ����ȯ�� : Windows 10, Eclipse IDE 2020dnp-06, intel core i5 8th Gen
 ����ȯ�� : JDK version 1.8
 �ۼ��� : JihoKim0
 ���α׷� ���� : ���Ǳ� ���� ���α׷�
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

//���� ��� Ŭ����
class ListStackNode{
	private int data;	//������ ���
	public ListStackNode link;	//��ũ ���
	
	//������ �� ��ũ ��� �ʱ�ȭ
	public ListStackNode() {
		this.data = 1;
		this.link = null;
	}
}

//���Ḯ��Ʈ ���� Ŭ����
class ListStack{
	private ListStackNode head;	//�����
	private ListStackNode top;	//������ top���
	private int count;	//���� ũ��
	
	//���� ������
	public ListStack() {
		head = null;
		top = null;
	}
	
	//���� ������� ����
	public boolean isEmpty() {
		return (top == null);
	}
	//���ÿ� ����
	public void push() {
		ListStackNode newNode = new ListStackNode();	//�� ��� ����
		if(isEmpty()) {	//���� ������¶��
			head = newNode;	//head�� �� ��带 �����ϵ��� ��
			top = head;
		}
		else {	//top��尡 null�� �ƴ϶��
			ListStackNode temp = top;	//temp��尡 top ����
			while(temp.link != null) {
				temp = temp.link;	//���� ��� ����
			}
			temp.link = newNode;	//temp�� link�� ���� ��� (�� ���)����
		}
		count++;	//��� �ϳ� ����
	}
	//������ top��� ����
	public void pop() {
		ListStackNode pre;
		ListStackNode temp;
		
		if(isEmpty()) {	//���� ������¶�� ��� ��� �����Ǿ����Ƿ� return
			System.out.println("���� ����");
			return;
		}
		if(top.link == null) {	//���ÿ� ��尡 1�� ���Ҵٸ�
			head = null;	//�ʱ�ȭ
			top = null;
		}
		else {
			pre = top;	//pre���� top �����Ͱ� ����Ű�� ��� �Ҵ�
			temp = top.link;	//temp���� top�����Ͱ� ����Ű�� ��� ���� ��� �Ҵ�
			
			while(temp.link != null) {	//temp�� ������ ����, pre�� temp ���� ����
				pre = temp;
				temp = temp.link;
			}
			pre.link = null;	//������ ��� ����
		}
		count--;	//��� �ϳ� ����
	}
	//������ ����
	public int count() {
		return count;
	}
}


//���� ������ Ŭ����(�̸� �� ���� ����)
class water{		//��
	int price;		//����
	String name;	//���� �̸�
	public water() {
		price = 450;	//���� ����
		name = "��";		//�̸� ����
	}
	void rename(String n) {	//���� �̸� �缳�� �޼ҵ�
		name = n;
	}
	void resetting(int p) {	//���� ���� �缳�� �޼ҵ�
		price = p;
	}
	
}
class coffee{		//Ŀ��
	int price;		//����
	String name;	//���� �̸�
	public coffee() {
		price = 500;	//���� ����
		name = "Ŀ��";	//�̸� ����
	}
	void rename(String n) {	//���� �̸� �缳�� �޼ҵ�
		name = n;
	}
	void resetting(int p) {	//���� ���� �缳�� �޼ҵ�
		price = p;
	}
}
class sport{		//�̿�����
	int price;		//����
	String name;	//���� �̸�
	public sport() {
		price = 550;	//���� ����
		name = "�̿�����";	//�̸� ����
	}
	void rename(String n) {	//���� �̸� �缳�� �޼ҵ�
		name = n;
	}
	void resetting(int p) {	//���� ���� �缳�� �޼ҵ�
		price = p;
	}
}
class highCoffee{	//���Ŀ��
	int price;		//����
	String name;	//���� �̸�
	public highCoffee() {
		price = 700;	//���� ����
		name = "���Ŀ��";	//�̸� ����
	}
	void rename(String n) {	//���� �̸� �缳�� �޼ҵ�
		name = n;
	}
	void resetting(int p) {	//���� ���� �缳�� �޼ҵ�
		price = p;
	}
}
class sparkling{	//ź������
	int price;		//����
	String name;	//�̸�
	public sparkling() {
		price = 750;	//���� ����
		name = "ź������";	//�̸� ����
	}
	void rename(String n) {	//���� �̸� �缳�� �޼ҵ�
		name = n;
	}
	void resetting(int p) {	//���� ���� �缳�� �޼ҵ�
		price = p;
	}
}

//ȭ��(�ܵ�) Ŭ����
class coin10{	//10��
	int price;		//����
	public coin10() {
		price = 10;		//���� ����
	}
}
class coin50{	//50��
	int price;
	public coin50() {
		price = 50;
	}
}
class coin100{	//100��
	int price;
	public coin100() {
		price = 100;
	}
}
class coin500{	//500��
	int price;
	public coin500() {
		price = 500;
	}
}
class bill1000{	//1000��
	int price;
	public bill1000() {
		price = 1000;
	}
}
//��й�ȣ Ŭ����
class password{
	String password;	//��й�ȣ
	public password() {
		password = "20194054!";	//�ʱ� ��й�ȣ ����
	}
	void change(String p) {	//��й�ȣ ���� �޼ҵ�
		password = p;
	}
}
//���Ǳ� Ŭ����
public class vendingMachine{
	public JFrame frame;	//J������ ����
	public int currPrice = 0;	//���� ���� �ݾ�
	int selectPrice = 0;	//���� �ݾ�
	int i;
	int retClick = 0;	//��ȯ��ư Ŭ�� Ƚ��
	int tmp1000 = 0;	//���� �Էµ� 1000�� ����(1000�� 3�� �ʰ� �Է� �Ұ�)
	int savePrice = 0;	//���� ���Ǳ� ���� �ݾ�
	int canoutput = 0;	//���� ���� ���� �ݾ�
	
	//�� ������ ��ü, ���� ����
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
	
	//�н����� ��ü ����
	password password = new password();
	
	//�� ȭ���� ��ü, ���� ����
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
	
	public vendingMachine() {	//������	
		//�� ������ ��� �ʱ�ȭ(���� ���) - �� ������ �⺻ ���� 3��
		for(i=0; i<3; i++)	//���ÿ� ��� ����
			waterstack.push();		
		for(i=0; i<3; i++)	//���ÿ� ��� ����
			coffeestack.push();				
		for(i=0; i<3; i++)	//���ÿ� ��� ����
			sportstack.push();				
		for(i=0; i<3; i++)	//���ÿ� ��� ����
			highCoffeestack.push();				
		for(i=0; i<3; i++)	//���ÿ� ��� ����
			sparklingstack.push();
		
		//�� ȭ���� ��� �ʱ�ȭ(���� ���) - �� ȭ���� �⺻ ���� 5��
		for(i=0; i<5; i++)	//���ÿ� ��� ����
			coin10stack.push();
		for(i=0; i<5; i++)	//���ÿ� ��� ����
			coin50stack.push();
		for(i=0; i<5; i++)	//���ÿ� ��� ����
			coin100stack.push();
		for(i=0; i<5; i++)	//���ÿ� ��� ����
			coin500stack.push();
		for(i=0; i<5; i++)	//���ÿ� ��� ����
			bill1000stack.push();
		
		//�� ȭ���� �ʱ�Ȱ��/��Ȱ�� ����
		machinePage.setVisible(true);
		passwordPage.setVisible(false);
		managerPage.setVisible(false);
		moneyMenu.setVisible(false);
		passwordMenu.setVisible(false);
		infoMenu.setVisible(false);
		storageMenu.setVisible(false);
		
		initialize();
		
		retBtn.doClick();	//��ư ��Ȱ��ȭ ����� ��ư Ŭ���� �����ϵ��� �Ͽ������� ���α׷� ���۽� ���Ƿ� ��ȯ��ư�� Ŭ���Ѵ�
		retClick = 0;	//���Ƿ� ���� ��ȯ��ư Ŭ��Ƚ�� �ٽ� 0���� ����
	}
	
	//GUI ȯ�� ����
	//�ǳ�
	JPanel machinePage = new JPanel();	//���Ǳ� ����ȭ�� �ǳ�
	JPanel managerPage = new JPanel();	//�����ڸ޴� �ǳ�
	JPanel passwordPage = new JPanel();	//��й�ȣ �ǳ�
	JPanel moneyMenu = new JPanel();	//���ݸ޴� �ǳ�
	JPanel passwordMenu = new JPanel();	//��й�ȣ ���� �޴�
	JPanel infoMenu = new JPanel();		//�Ǹ����� ���� �޴�	
	JLabel priceInput = new JLabel();	//���Աݾ� ���̺�
	JPanel storageMenu = new JPanel();	//����� �޴�
	
	//���Ǳ�ȭ��
	JButton retBtn = new JButton("��ȯ");	//��ȯ��ư
	JButton waterBtn = new JButton(water.name);	//�� ��ư
	JButton coffeeBtn = new JButton(coffee.name);	//Ŀ�� ��ư
	JButton sportBtn = new JButton(sport.name);	//�̿����� ��ư
	JButton highCoffeeBtn = new JButton(highCoffee.name);	//���Ŀ�� ��ư
	JButton sparklingBtn = new JButton(sparkling.name);	//ź������ ��ư
	JButton coinBtn500 = new JButton(Integer.toString(coin500.price));	//500�� ��ư
	JButton coinBtn100 = new JButton(Integer.toString(coin100.price));	//100�� ��ư
	JButton coinBtn50 = new JButton(Integer.toString(coin50.price));	//50�� ��ư
	JButton coinBtn10 = new JButton(Integer.toString(coin10.price));	//10�� ��ư
	JButton coinBtn1000 = new JButton(Integer.toString(bill1000.price));	//1000�� ��ư	
	JLabel waterPrice = new JLabel(Integer.toString(water.price)+"��");	//�� ���� ǥ��
	JLabel coffeePrice = new JLabel(Integer.toString(coffee.price)+"��");	//Ŀ�� ���� ǥ��
	JLabel sportPrice = new JLabel(Integer.toString(sport.price)+"��");	//�̿����� ���� ǥ��
	JLabel highCoffeePrice = new JLabel(Integer.toString(highCoffee.price)+"��");	//���Ŀ�� ���� ǥ��
	JLabel sparklingPrice = new JLabel(Integer.toString(sparkling.price)+"��");	//ź������ ���� ǥ��
	
	//��й�ȣ ȭ��
	private JPasswordField passwordField;	//��й�ȣ �Է�â
	
	//�޴�������
	JMenuBar managerMenuBar = new JMenuBar();	//������ �޴� �޴��� ����
	JMenu managerMenu = new JMenu("�����ڸ޴�");	//������ �޴�
	private final JMenuItem moneyMenuItem = new JMenuItem("����");	//���� �޴� ������
	private final JMenuItem storageMenuItem = new JMenuItem("�����");	//���� ���� �޴� ������
	private final JMenuItem modifyMenuItem = new JMenuItem("��������");	//�Ǹ� ���� ���� �޴� ������
	private final JMenuItem passwordMenuItem = new JMenuItem("��й�ȣ");	//��й�ȣ ���� �޴� ������
	private final JMenuItem closeMenuItem = new JMenuItem("����");	//�����ڸ޴� ���� �޴� ������
	private final JLabel showCanOutput = new JLabel();	//���� ���� �ݾ�
	private final JLabel canOutputCash = new JLabel();	//�� ������ ���� �ܵ� ����
	private final JLabel showSavePrice = new JLabel();	//���� ���� �ݾ�
	
	//��й�ȣ ���� �޴�
	private JPasswordField currPassInput;	//���� ��й�ȣ �Է�
	private JPasswordField newPassInput;	//�� ��й�ȣ �Է�
	
	//�Ǹ����� ���� �޴�
	//�����ư
	private final JButton waterNameChangeButton = new JButton("����");	//�� �̸�
	private final JButton coffeeNameChangeButton = new JButton("����");	//Ŀ�� �̸�
	private final JButton sportNameChangeButton = new JButton("����");	//�̿����� �̸�
	private final JButton highCoffeeNameChangeButton = new JButton("����");	//���Ŀ�� �̸�
	private final JButton sparklingNameChangeButton = new JButton("����");	//ź������ �̸�
	private final JButton waterPriceChangeButton = new JButton("����");	//�� ����
	private final JButton coffeePriceChangeButton = new JButton("����");	//Ŀ�� ����
	private final JButton sportPriceChangeButton = new JButton("����");	//�̿����� ����
	private final JButton highCoffeePriceChangeButton = new JButton("����");	//���Ŀ�� ����
	private final JButton sparklingPriceChangeButton = new JButton("����");	//ź������ ����	
	private final JLabel nameInfo = new JLabel("�̸�");	//�̸� �ؽ�Ʈ ���̺�
	private final JLabel priceInfo = new JLabel("����");	//���� �ؽ�Ʈ ���̺�
	//���� ���� �̸� ǥ��
	private final JLabel waterInfo = new JLabel(water.name);	//��
	private final JLabel coffeeInfo = new JLabel(coffee.name);	//Ŀ��
	private final JLabel sportInfo = new JLabel(sport.name);	//�̿�����
	private final JLabel highCoffeeInfo = new JLabel(highCoffee.name);	//���Ŀ��
	private final JLabel sparklingInfo = new JLabel(sparkling.name);	//ź������
	
	//�� ���� ���� �Է�
	private final JTextField waterNameChange = new JTextField();	//�� �̸�
	private final JTextField coffeeNameChange = new JTextField();	//Ŀ�� �̸�
	private final JTextField sportNameChange = new JTextField();	//�̿����� �̸�
	private final JTextField highCoffeeNameChange = new JTextField();	//���Ŀ�� �̸�
	private final JTextField sparklingNameChange = new JTextField();	//ź������ �̸�

	private final JTextField waterPriceChange = new JTextField();	//�� ����
	private final JTextField coffeePriceChange = new JTextField();	//Ŀ�� ����
	private final JTextField sportPriceChange = new JTextField();	//�̿����� ����
	private final JTextField highCoffeePriceChange = new JTextField();	//���Ŀ�� ����
	private final JTextField sparklingPriceChange = new JTextField();	//ź������ ����
	
	//����� �޴�
	private final JLabel waterStoreName = new JLabel("��");
	private final JLabel coffeeStoreName = new JLabel("Ŀ��");
	private final JLabel sportStoreName = new JLabel("�̿�����");
	private final JLabel highCoffeeStoreName = new JLabel("���Ŀ��");
	private final JLabel sparklingStoreName = new JLabel("ź������");
	private final JLabel waterStorage = new JLabel(Integer.toString(waterstack.count()));	//�� ��� ǥ��
	private final JLabel coffeeStorage = new JLabel(Integer.toString(coffeestack.count()));	//Ŀ�� ��� ǥ��
	private final JLabel sportStorage = new JLabel(Integer.toString(sportstack.count()));	//�̿����� ��� ǥ��
	private final JLabel highCoffeeStorage = new JLabel(Integer.toString(highCoffeestack.count()));	//���Ŀ�� ��� ǥ��
	private final JLabel sparklingStorage = new JLabel(Integer.toString(sparklingstack.count()));	//ź������ ��� ǥ��
	
	//���� �޴�
	private final JButton moneyRefreshBtn = new JButton("���ΰ�ħ");	//���ݸ޴� ���ΰ�ħ
	private final JButton output10 = new JButton("10��");	//������ 10�� ��ư
	private final JButton output50 = new JButton("50��");	//������ 50�� ��ư
	private final JButton output100 = new JButton("100��");	//������ 100�� ��ư
	private final JButton output500 = new JButton("500��");	//������ 500�� ��ư
	private final JButton output1000 = new JButton("1000��");	//������ 1000�� ��ư
	
	
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 653, 457);
		frame.setTitle("���Ǳ�");	//Ÿ��Ʋ ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//���� ������ ������ ���α׷� ����
		frame.setResizable(false);	//������ ũ�� ���� ��Ȱ��ȭ
		frame.getContentPane().setLayout(null);
		
		//<���Ǳ� ȭ��>***************************************************************
		//���Ǳ� ����ȭ�� �ǳ�
		machinePage.setBounds(0, 0, 647, 422);
		frame.getContentPane().add(machinePage);
		machinePage.setLayout(null);
		priceInput.setText("0");		
		
		//���Աݾ� ���̺�
		priceInput.setBounds(443, 31, 167, 52);
		priceInput.setHorizontalAlignment(SwingConstants.CENTER);
		priceInput.setFont(new Font("����", Font.BOLD, 20));
		priceInput.setOpaque(true);
		priceInput.setBackground(Color.WHITE);
		priceInput.setForeground(Color.BLACK);
		machinePage.add(priceInput);
		
		//��ȯ��ư
		retBtn.setBounds(561, 237, 60, 60);
		retBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//��ȯ��ư ������
				retClick++;	//��ȯ��ư Ŭ��Ƚ�� ������Ű��		
				tmp1000 = 0;	//1000�� ���� ���� 0���� �ʱ�ȭ
				//��ȯ��ư�� 5�� ���� ������ ��й�ȣ �Է� �������� ��ȯ
				if(retClick == 5)
				{
					//��й�ȣ �Է� �������� �Ѿ��
					machinePage.setVisible(false);
					passwordPage.setVisible(true);
					retClick = 0;	//��ȯ��ư Ŭ�� Ƚ�� �ʱ�ȭ
				}
			
				//[�Ž����� �˰���](��, 1000���� �Ž������� ���Ե��� �ʴ´�)
				if(retClick == 1) {	//��ȯ��ư 1�� �������� ����						
					//�Ž����� ���
					int ch;	//�Ž����� ����� ���� ����
					//500��
					ch = currPrice / 500;	//�ʿ��� 500�� ���� ���
					if(ch<=coin500stack.count()) {	//���� �Ž����� 500���� ����ϴٸ�
						currPrice -= coin500.price*ch;	//�� �Ž��������� 500���� �ʿ��Ѹ�ŭ �����Ѵ�
						for(i=0; i<ch; i++) {
							coin500stack.pop();	//500�� ���ÿ����� ���ش�
						}
					}
					else if(ch < coin500stack.count() && ch > 0){				//�Ž����� 500���� ���ڶ�ٸ�
						currPrice -= coin500.price*coin500stack.count();	//���� �����ִ� 500�� ������ŭ�� �Ž��������� �����Ѵ�
						for(i=0;i<coin500stack.count();i++) 
							coin500stack.pop();	//500�� ���ÿ����� ���ش�
					}
					//100��
					ch = currPrice / 100;	//�ʿ��� 100�� ���� ���
					if(ch<=coin100stack.count()) {	//���� �Ž����� 100���� ����ϴٸ�
						currPrice -= coin100.price*ch;	//�� �Ž��������� 100���� �ʿ��Ѹ�ŭ �����Ѵ�
						for(i=0; i<ch; i++) {
							coin100stack.pop();	//100�� ���ÿ����� ���ش�
						}
					}
					else if(ch < coin100stack.count() && ch > 0){				//�Ž����� 100���� ���ڶ�ٸ�
						currPrice -= coin100.price*coin100stack.count();	//���� �����ִ� 100�� ������ŭ�� �Ž��������� �����Ѵ�
						for(i=0;i<coin100stack.count();i++) 
							coin100stack.pop();	//100�� ���ÿ����� ���ش�
						//coin100stack.count() = 0;	//100�� ��� ����
					}
					//50��
					ch = currPrice / 50;	//�ʿ��� 50�� ���� ���
					if(ch<=coin50stack.count()) {	//���� �Ž����� 50���� ����ϴٸ�
						currPrice -= coin50.price*ch;	//�� �Ž��������� 50���� �ʿ��Ѹ�ŭ �����Ѵ�
						for(i=0; i<ch; i++) {
							coin50stack.pop();	//50�� ���ÿ����� ���ش�
						}
					}
					else if(ch < coin50stack.count() && ch > 0){				//�Ž����� 50���� ���ڶ�ٸ�
						currPrice -= coin50.price*coin50stack.count();	//���� �����ִ� 50�� ������ŭ�� �Ž��������� �����Ѵ�
						for(i=0;i<coin50stack.count();i++)
							coin50stack.pop();	//50�� ���ÿ����� ���ش�
					}
					//10��
					ch = currPrice / 10;	//�ʿ��� 10�� ���� ���
					if(ch<=coin10stack.count()) {	//���� �Ž����� 10���� ����ϴٸ�
						currPrice -= coin10.price*ch;	//�� �Ž��������� 10���� �ʿ��Ѹ�ŭ �����Ѵ�
						for(i=0; i<ch; i++) {
							coin10stack.pop();	//10�� ���ÿ����� ���ش�
						}
					}
					else if(ch < coin10stack.count() && ch > 0){				//�Ž����� 10���� ���ڶ�ٸ�
						currPrice -= coin10.price*coin10stack.count();	//���� �����ִ� 10�� ������ŭ�� �Ž��������� �����Ѵ�
						for(i=0;i<coin10stack.count();i++)
							coin10stack.pop();	//10�� ���ÿ����� ���ش�
					}
					
					currPrice = 0;	//���� ���� �ݾ� �ʱ�ȭ
					//��ư ��Ȱ��ȭ&Ȱ��ȭ ��ư
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
					priceInput.setText("0");	//���� ���� �ݾ� ���̺� �ʱ�ȭ
					
				}
			}
		});
		machinePage.add(retBtn);
		
		//���� �޴� ��ư
		waterBtn.setBounds(42, 48, 90, 35);
		waterBtn.addActionListener(new ActionListener() {	//�� ��ư Ŭ����
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//��ȯ��ư Ŭ��Ƚ�� �ʱ�ȭ
				currPrice -= 450;	//���� ���� �ݾ׿��� �� �ݾ� ����
				waterstack.pop();	//�� ���ÿ��� �ϳ� ����
				//��ư ��Ȱ��ȭ&Ȱ��ȭ ��ư
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
				priceInput.setText(Integer.toString(currPrice));	//���� ���� �ݾ� ���ΰ�ħ
			}
		});
		machinePage.add(waterBtn);
		
		coffeeBtn.setBounds(146, 48, 90, 35);
		coffeeBtn.addActionListener(new ActionListener() {	//Ŀ�� ��ư Ŭ����
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//��ȯ��ư Ŭ��Ƚ�� �ʱ�ȭ
				currPrice -= 500;	//���� ���� �ݾ׿��� Ŀ�Ǳݾ� ����
				coffeestack.pop();	//Ŀ�� ���ÿ��� �ϳ� ����
				//��ư ��Ȱ��ȭ&Ȱ��ȭ ��ư
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
				priceInput.setText(Integer.toString(currPrice));	//���� ���� �ݾ� ���ΰ�ħ
			}
		});
		machinePage.add(coffeeBtn);
		
		sportBtn.setBounds(250, 48, 90, 35);
		sportBtn.addActionListener(new ActionListener() {	//�̿����� ��ư Ŭ����
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//��ȯ��ư Ŭ��Ƚ��
				currPrice -= 550;	//���� ���� �ݾ׿��� �̿����� �ݾ� ����
				sportstack.pop();	//�̿����� ���ÿ��� �ϳ� ����
				//��ư ��Ȱ��ȭ&Ȱ��ȭ ��ư
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
				priceInput.setText(Integer.toString(currPrice));	//���� ���� �ݾ� ���ΰ�ħ
			}
		});
		machinePage.add(sportBtn);
		
		highCoffeeBtn.setBounds(80, 142, 90, 35);
		highCoffeeBtn.addActionListener(new ActionListener() {	//���Ŀ�� ��ư Ŭ����
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//��ȯ��ư Ŭ�� Ƚ�� �ʱ�ȭ
				currPrice -= 700;	//���� ���� �ݾ׿��� ���Ŀ�� ���� ����
				highCoffeestack.pop();	//���Ŀ�� ���ÿ��� �ϳ� ����
				//��ư ��Ȱ��ȭ&Ȱ��ȭ ��ư
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
				priceInput.setText(Integer.toString(currPrice));	//���� ���� �ݾ� ���ΰ�ħ
			}
		});
		machinePage.add(highCoffeeBtn);
		
		sparklingBtn.setBounds(203, 142, 90, 35);
		sparklingBtn.addActionListener(new ActionListener() {	//ź������ ��ư Ŭ����
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//��ȯ��ư Ŭ�� Ƚ�� �ʱ�ȭ
				currPrice -= 750;	//���� ���� �ݾ׿��� ź������ ���� ����
				sparklingstack.pop();	//ź������ ����  �ϳ� ����
				//��ư ��Ȱ��ȭ&Ȱ��ȭ ��ư
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
				priceInput.setText(Integer.toString(currPrice));	//���� ���� �ݾ� ���ΰ�ħ
			}
		});
		machinePage.add(sparklingBtn);
		
		//�� �Է� ��ư(10, 50, 100, 500, 1000)
		coinBtn500.setBounds(561, 323, 60, 60);
		coinBtn500.addActionListener(new ActionListener() {	//500�� ��ư Ŭ����
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//��ȯ��ư Ŭ��Ƚ�� �ʱ�ȭ
				currPrice += 500;	//���� ���� �ݾ׿� 500 �߰�
				coin500stack.push();	//500�� ���ÿ� �߰�
				//���� ���� �ݾ��� 5000�� �ʰ��� �޽��� ��� 
				if(currPrice > 5000) {
					priceInput.setText("�ִ�ݾ� �ʰ�");
					return;
				}
				priceInput.setText(Integer.toString(currPrice));	//���� ���� �ݾ� ���ΰ�ħ
				
				//��ư ��Ȱ��ȭ&Ȱ��ȭ ��ư
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
		coinBtn100.addActionListener(new ActionListener() {	//100�� ��ư Ŭ����
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//��ȯ��ư Ŭ��Ƚ�� �ʱ�ȭ
				currPrice += 100;	//���� ���Աݾ׿� 100 �߰�
				coin100stack.push();	//100�� ���ÿ� �߰�
				//���� ���� �ݾ��� 5000�� �ʰ��� �޽��� ��� 
				if(currPrice > 5000) {
					priceInput.setText("�ִ�ݾ� �ʰ�");
					return;
				}
				priceInput.setText(Integer.toString(currPrice));	//���� ���� �ݾ� ���ΰ�ħ
				
				//��ư ��Ȱ��ȭ&Ȱ��ȭ ��ư
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
		coinBtn50.addActionListener(new ActionListener() {	//50�� ��ư Ŭ����
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//��ȯ��ư Ŭ�� �ʱ�ȭ��
				currPrice += 50;	//���� ���� �ݾ׿� 50 �߰�
				coin50stack.push();	//50�� ���ÿ� �߰�
				//���� ���� �ݾ��� 5000�� �ʰ���  �޽��� ��� 
				if(currPrice > 5000) {
					priceInput.setText("�ִ�ݾ� �ʰ�");
					return;
				}
				priceInput.setText(Integer.toString(currPrice));	//���� ���� �ݾ� ���ΰ�ħ
				
				//��ư ��Ȱ��ȭ&Ȱ��ȭ ��ư
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
		coinBtn10.addActionListener(new ActionListener() {	//10�� ��ư Ŭ����
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//��ȯ��ư Ŭ�� Ƚ�� �ʱ�ȭ
				currPrice += 10;	//���� ���� �ݾ� �� 10 �߰�
				coin10stack.push();	//10�� ���ÿ� �߰�
				//���� ���� �ݾ��� 5000�� �ʰ���  �޽��� ��� 
				if(currPrice > 5000) {
					priceInput.setText("�ִ�ݾ� �ʰ�");
					return;
				}
				priceInput.setText(Integer.toString(currPrice));	//���� ���� �ݾ� ���ΰ�ħ
				
				//��ư ��Ȱ��ȭ&Ȱ��ȭ ��ư
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
		coinBtn1000.addActionListener(new ActionListener() {	//1000�� ��ư Ŭ����
			public void actionPerformed(ActionEvent e) {
				retClick = 0;	//��ȯ��ư Ŭ�� Ƚ�� �ʱ�ȭ
				currPrice += 1000;	//���� ���� �ݾ� �� 1000 �߰�
				bill1000stack.push();	//1000�� ���ÿ� �߰�
				tmp1000++;
				//���� ���� �ݾ��� 5000�� �ʰ� Ȥ�� 1000�� ���� ������ 3�� �ʰ���  �޽��� ��� 
				if((currPrice > 5000) || (tmp1000 > 3)) {
					priceInput.setText("�ִ�ݾ� �ʰ�");
					return;
				}
				priceInput.setText(Integer.toString(currPrice));	//���� ���� �ݾ� ���ΰ�ħ
				
				//��ư ��Ȱ��ȭ&Ȱ��ȭ ��ư
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
				
				
		JLabel bill = new JLabel("<��������>");
		bill.setBounds(286, 293, 80, 20);
		machinePage.add(bill);
		
		JLabel coin = new JLabel("<��������>");
		coin.setBounds(464, 291, 80, 20);
		machinePage.add(coin);		
				
		//���Ằ ���� ǥ��
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
		
		//�ִ� ���� �ݾ� �޼��� ǥ��
		JLabel maxInputMessage = new JLabel("�ִ� ���Աݾ� 5000��");
		maxInputMessage.setBounds(443, 95, 167, 20);
		maxInputMessage.setHorizontalAlignment(SwingConstants.CENTER);
		machinePage.add(maxInputMessage);
		
		//���� ���� �ݾ� �޼��� ǥ��
		JLabel currInput = new JLabel("����ݾ�");
		currInput.setBounds(443, 12, 167, 20);
		currInput.setFont(new Font("����", Font.BOLD, 17));
		currInput.setHorizontalAlignment(SwingConstants.CENTER);
		machinePage.add(currInput);
		
		//<��й�ȣ ȭ��>***************************************************************
		//��й�ȣ �ǳ�
		passwordPage.setBounds(0, 0, 647, 422);
		frame.getContentPane().add(passwordPage);
		passwordPage.setLayout(null);
		
		//��й�ȣ �Է�â
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 180, 210, 35);
		passwordPage.add(passwordField);
		
		//��й�ȣ �ؽ�Ʈ ���̺�
		JLabel lblNewLabel = new JLabel("��й�ȣ");
		lblNewLabel.setBounds(295, 150, 60, 20);
		passwordPage.add(lblNewLabel);
		
		//��й�ȣ ���� ��ư
		JButton enterButton = new JButton("ENTER");
		enterButton.setFont(new Font("����", Font.PLAIN, 11));
		enterButton.setBounds(430, 180, 70, 35);
		enterButton.addActionListener(new ActionListener() {	//���͹�ư Ŭ����
			public void actionPerformed(ActionEvent e) {
				//���� ��й�ȣ�� �Է��� �ؽ�Ʈ�� ��ġ�ϴٸ�
				if(password.password.equals(passwordField.getText())) {
					passwordPage.setVisible(false);
					managerPage.setVisible(true);	//�����ڸ޴� �������� �̵�
					passwordField.setText("");
				}
				else {	//�ƴ϶�� ���� �޽��� ����
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�(Ư������ ����)");
					passwordField.setText("");
				}
			}
		});
		passwordPage.add(enterButton);
		
		
		//<�����ڸ޴� ȭ��>***************************************************************
		//�����ڸ޴� �ǳ�
		managerPage.setBounds(0, 0, 647, 422);
		frame.getContentPane().add(managerPage);
		managerPage.setLayout(null);		
		
		//�޴��� ����
		managerMenuBar.setBounds(0, 0, 647, 30);
		managerPage.add(managerMenuBar);		
		managerMenuBar.add(managerMenu);
		
		//���� �޴�������
		moneyMenuItem.setHorizontalAlignment(SwingConstants.CENTER);	
		moneyMenuItem.addActionListener(new MenuActionListener());
		managerMenu.add(moneyMenuItem);
		
		JSeparator separator1 = new JSeparator();	//�޴� ���м� �߰�
		managerMenu.add(separator1);
		
		//����� �޴� ������
		storageMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		storageMenuItem.addActionListener(new MenuActionListener());
		managerMenu.add(storageMenuItem);
		
		JSeparator separator2 = new JSeparator();	//�޴� ���м� �߰�
		managerMenu.add(separator2);
		
		//�������� �޴�������
		modifyMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		modifyMenuItem.addActionListener(new MenuActionListener());
		managerMenu.add(modifyMenuItem);
		
		JSeparator separator3 = new JSeparator();	//�޴� ���м� �߰�
		managerMenu.add(separator3);
		
		//��й�ȣ ���� �޴�������
		passwordMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		passwordMenuItem.addActionListener(new MenuActionListener());
		managerMenu.add(passwordMenuItem);
		
		JSeparator separator4 = new JSeparator();	//�޴� ���м� �߰�
		managerMenu.add(separator4);
		
		//���� �޴�������
		closeMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		closeMenuItem.addActionListener(new MenuActionListener());
		managerMenu.add(closeMenuItem);
		
		//[�����ڸ޴� - ���� �޴�]
		moneyMenu.setBounds(0, 31, 647, 391);
		managerPage.add(moneyMenu);
		moneyMenu.setLayout(null);
		
		//����ݾ� �ؽ�Ʈ ���̺�
		JLabel savePricetext = new JLabel("���� �ݾ� : ");
		savePricetext.setBounds(236, 88, 80, 30);
		moneyMenu.add(savePricetext);
		
		//���� �ݾ� ���̺�
		showSavePrice.setBounds(330, 88, 110, 30);
		showSavePrice.setOpaque(true);
		showSavePrice.setForeground(Color.BLACK);
		showSavePrice.setBackground(Color.WHITE);
		moneyMenu.add(showSavePrice);
		
		
		//���� ���� �ݾ� �ؽ�Ʈ ���̺�
		JLabel canOutput = new JLabel("���� ���� �ݾ� : ");
		canOutput.setBounds(196, 180, 120, 30);
		moneyMenu.add(canOutput);
		
		//�ݾ� �Է� �ؽ�Ʈ ���̺�
		JLabel OutputPrice = new JLabel("<������ �ݾ� Ŭ��>");
		OutputPrice.setBounds(257, 247, 134, 30);
		moneyMenu.add(OutputPrice);
		
		//���� ���� �ݾ� �ؽ�Ʈ ���̺�
		showCanOutput.setBounds(330, 180, 110, 30);
		showCanOutput.setOpaque(true);
		showCanOutput.setForeground(Color.BLACK);
		showCanOutput.setBackground(Color.WHITE);
		moneyMenu.add(showCanOutput);
		
		//ȭ�� �� ��� ǥ�� �ؽ�Ʈ ���̺�
		canOutputCash.setBounds(132, 138, 350, 30);
		canOutputCash.setHorizontalAlignment(SwingConstants.CENTER);		
		moneyMenu.add(canOutputCash);		
		
		//���ݸ޴� ���ΰ�ħ ��ư
		moneyRefreshBtn.setBounds(543, 12, 90, 40);
		moneyRefreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//��ư Ŭ����
				savePrice = 10*coin10stack.count() + 50*coin50stack.count() + 100*coin100stack.count()
				+ 500*coin500stack.count() + 1000*bill1000stack.count();
				showSavePrice.setText(Integer.toString(savePrice));	//���� ���� �ݾ� ǥ�� ���ΰ�ħ
				
				canOutputCash.setText("10��:"+coin10stack.count()+" 50��:"+coin50stack.count()+" 100��:"+coin100stack.count()
						+" 500��:"+coin500stack.count()+" 1000��:"+bill1000stack.count());	//���� �ݾ� ǥ�� ���ΰ�ħ
				
				//���� ���� �ݾ� ���(�� ȭ���� �ּ���� 3���� ���ܵд�)
				canoutput = 0;
				if(coin10stack.count() > 3)	//10�� ��� 3������ ũ�ٸ�
					canoutput += 10*(coin10stack.count() - 3);	//���� ����� 3���� ����ŭ ���� ����
				if(coin50stack.count() > 3)	//50�� ��� 3������ ũ�ٸ�
					canoutput += 50*(coin50stack.count() - 3);	//���� ����� 3���� ����ŭ ���� ����
				if(coin100stack.count() > 3)	//100�� ��� 3������ ũ�ٸ�
					canoutput += 100*(coin100stack.count() - 3);	//���� ����� 3���� ����ŭ ���� ����
				if(coin500stack.count() > 3)	//500�� ��� 3������ ũ�ٸ�
					canoutput += 500*(coin500stack.count() - 3);	//���� ����� 3���� ����ŭ ���� ����
				if(bill1000stack.count() > 3)	//1000�� ��� 3������ ũ�ٸ�
					canoutput += 1000*(bill1000stack.count() - 3);	//���� ����� 3���� ����ŭ ���� ����
				showCanOutput.setText(Integer.toString(canoutput));	//���� ���� �ݾ� ǥ�� ���ΰ�ħ
			}
		});
		moneyMenu.add(moneyRefreshBtn);
		
		//ȭ�� ���� ��ư(���ݽ� �ּ� ��� 3���� �����)
		output10.setBounds(94, 289, 70, 40);
		output10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//��ư Ŭ����
				if(coin10stack.count() > 3) {	//10�� ��� 3�� �ʰ���� ���� ����
					coin10stack.pop();	//���ÿ��� �ϳ� ����
				}
			}
		});
		moneyMenu.add(output10);
		
		output50.setBounds(192, 289, 70, 40);
		output50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//��ư Ŭ����
				if(coin50stack.count() > 3) {	//50�� ��� 3�� �ʰ���� ���� ����
					coin50stack.pop();	//���ÿ��� �ϳ� ����
				}
			}
		});
		moneyMenu.add(output50);
		
		output100.setBounds(293, 289, 70, 40);	
		output100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//��ư Ŭ����
				if(coin100stack.count() > 3) {	//100�� ��� 3�� �ʰ���� ���� ����
					coin100stack.pop();	//���ÿ��� �ϳ� ����
				}
			}
		});
		moneyMenu.add(output100);
		
		output500.setBounds(391, 289, 70, 40);	
		output500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//��ư Ŭ����
				if(coin500stack.count() > 3) {	//500�� ��� 3�� �ʰ���� ���� ����
					coin500stack.pop();	//���ÿ��� �ϳ� ����
				}
			}
		});
		moneyMenu.add(output500);
		
		output1000.setBounds(485, 289, 80, 40);		
		output1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//��ư Ŭ����
				if(bill1000stack.count() > 3) {	//10�� ��� 3�� �ʰ���� ���� ����
					bill1000stack.pop();	//���ÿ��� �ϳ� ����
				}
			}
		});
		moneyMenu.add(output1000);
		
		
		//[�����ڸ޴� - ��� ���� �޴�]
		storageMenu.setBounds(0, 31, 647, 391);
		managerPage.add(storageMenu);
		storageMenu.setLayout(null);	
		
		//�� ������ �̸� ǥ��
		waterStoreName.setHorizontalAlignment(SwingConstants.CENTER);	//�� �̸�
		waterStoreName.setBounds(164, 60, 70, 30);
		storageMenu.add(waterStoreName);
		coffeeStoreName.setHorizontalAlignment(SwingConstants.CENTER);	//Ŀ�� �̸�
		coffeeStoreName.setBounds(164, 115, 70, 30);
		storageMenu.add(coffeeStoreName);
		sportStoreName.setHorizontalAlignment(SwingConstants.CENTER);	//�̿����� �̸�
		sportStoreName.setBounds(164, 173, 70, 30);		
		storageMenu.add(sportStoreName);
		highCoffeeStoreName.setHorizontalAlignment(SwingConstants.CENTER);	//���Ŀ�� �̸�
		highCoffeeStoreName.setBounds(164, 232, 70, 30);		
		storageMenu.add(highCoffeeStoreName);
		sparklingStoreName.setHorizontalAlignment(SwingConstants.CENTER);	//ź������ �̸�
		sparklingStoreName.setBounds(164, 295, 70, 30);
		storageMenu.add(sparklingStoreName);
		
		//�� ������ ��� ǥ��
		waterStorage.setOpaque(true);	//�� ���
		waterStorage.setBackground(Color.WHITE);
		waterStorage.setForeground(Color.BLACK);
		waterStorage.setHorizontalAlignment(SwingConstants.CENTER);
		waterStorage.setBounds(293, 60, 75, 30);		
		storageMenu.add(waterStorage);	
		coffeeStorage.setOpaque(true);	//Ŀ�� ���
		coffeeStorage.setHorizontalAlignment(SwingConstants.CENTER);
		coffeeStorage.setForeground(Color.BLACK);
		coffeeStorage.setBackground(Color.WHITE);
		coffeeStorage.setBounds(293, 115, 75, 30);		
		storageMenu.add(coffeeStorage);
		sportStorage.setOpaque(true);	//Ŀ�� ���
		sportStorage.setHorizontalAlignment(SwingConstants.CENTER);
		sportStorage.setForeground(Color.BLACK);
		sportStorage.setBackground(Color.WHITE);
		sportStorage.setBounds(293, 173, 75, 30);		
		storageMenu.add(sportStorage);
		highCoffeeStorage.setOpaque(true);	//���Ŀ�� ���
		highCoffeeStorage.setHorizontalAlignment(SwingConstants.CENTER);
		highCoffeeStorage.setForeground(Color.BLACK);
		highCoffeeStorage.setBackground(Color.WHITE);
		highCoffeeStorage.setBounds(293, 232, 75, 30);		
		storageMenu.add(highCoffeeStorage);
		sparklingStorage.setOpaque(true);	//ź������ ���
		sparklingStorage.setHorizontalAlignment(SwingConstants.CENTER);
		sparklingStorage.setForeground(Color.BLACK);
		sparklingStorage.setBackground(Color.WHITE);
		sparklingStorage.setBounds(293, 295, 75, 30);		
		storageMenu.add(sparklingStorage);
		
		//�� ������ ��� ���� �˰���
		JButton waterPlus = new JButton("+");	//�� ���� ��ư
		waterPlus.setBounds(420, 62, 45, 30);
		waterPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//��ư Ŭ����
				waterstack.push();	//�� ���� �ϳ� �߰�
				waterStorage.setText(Integer.toString(waterstack.count()));	//��� ǥ�� ĭ�� ǥ��
			}
		});
		storageMenu.add(waterPlus);
		
		JButton coffeePlus = new JButton("+");	//Ŀ�� ���� ��ư
		coffeePlus.setBounds(420, 117, 45, 30);
		coffeePlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//��ư Ŭ����
				coffeestack.push();	//Ŀ�� ���� �ϳ� �߰�
				coffeeStorage.setText(Integer.toString(coffeestack.count()));	//��� ǥ�� ĭ�� ǥ��
			}
		});
		storageMenu.add(coffeePlus);
		
		JButton sportPlus = new JButton("+");	//�̿����� ���� ��ư
		sportPlus.setBounds(420, 175, 45, 30);
		sportPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//��ư Ŭ����
				sportstack.push();	//�̿����� ���� �ϳ� �߰�
				sportStorage.setText(Integer.toString(sportstack.count()));	//��� ǥ�� ĭ�� ǥ��
			}
		});
		storageMenu.add(sportPlus);
		
		JButton highCoffeePlus = new JButton("+");	//���Ŀ�� ���� ��ư
		highCoffeePlus.setBounds(420, 234, 45, 30);
		highCoffeePlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//��ư Ŭ����
				highCoffeestack.push();	//���Ŀ�� ���� �ϳ� �߰�
				highCoffeeStorage.setText(Integer.toString(highCoffeestack.count()));	//��� ǥ�� ĭ�� ǥ��
			}
		});
		storageMenu.add(highCoffeePlus);
		
		JButton sparklingPlus = new JButton("+");	//ź������ ���� ��ư
		sparklingPlus.setBounds(420, 297, 45, 30);
		sparklingPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//��ư Ŭ����
				sparklingstack.push();	//ź������ ���� �ϳ� �߰�
				sparklingStorage.setText(Integer.toString(sparklingstack.count()));	//��� ǥ�� ĭ�� ǥ��
			}
		});
		storageMenu.add(sparklingPlus);
		
		//����� �޴� ���ΰ�ħ ��ư
		JButton storageRefreshBtn = new JButton("���ΰ�ħ");
		storageRefreshBtn.setBounds(543, 12, 90, 40);
		storageRefreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//��ư Ŭ����
				waterStorage.setText(Integer.toString(waterstack.count()));	//��� ǥ�� ���ΰ�ħ
				coffeeStorage.setText(Integer.toString(coffeestack.count()));	//��� ǥ�� ���ΰ�ħ
				sportStorage.setText(Integer.toString(sportstack.count()));	//��� ǥ�� ���ΰ�ħ
				highCoffeeStorage.setText(Integer.toString(highCoffeestack.count()));	//��� ǥ�� ���ΰ�ħ
				sparklingStorage.setText(Integer.toString(sparklingstack.count()));	//��� ǥ�� ���ΰ�ħ
			}
		});
		storageMenu.add(storageRefreshBtn);
				
		
		//[�����ڸ޴� - �Ǹ����� ���� �޴�]
		infoMenu.setBounds(0, 31, 647, 391);
		managerPage.add(infoMenu);
		infoMenu.setLayout(null);
		nameInfo.setBounds(184, 28, 60, 38);
		//���� �̸� ǥ��
		nameInfo.setHorizontalAlignment(SwingConstants.CENTER);
		infoMenu.add(nameInfo);
		waterInfo.setBounds(95, 73, 60, 38);
		//�� �̸� ǥ��
		waterInfo.setHorizontalAlignment(SwingConstants.CENTER);
		infoMenu.add(waterInfo);
		coffeeInfo.setBounds(95, 124, 60, 38);
		//Ŀ�� �̸� ǥ��
		coffeeInfo.setHorizontalAlignment(SwingConstants.CENTER);
		infoMenu.add(coffeeInfo);
		sportInfo.setBounds(95, 174, 60, 38);
		//�̿����� �̸� ǥ��
		sportInfo.setHorizontalAlignment(SwingConstants.CENTER);
		infoMenu.add(sportInfo);
		highCoffeeInfo.setBounds(95, 228, 60, 38);
		//���Ŀ�� �̸� ǥ��
		highCoffeeInfo.setHorizontalAlignment(SwingConstants.CENTER);
		infoMenu.add(highCoffeeInfo);
		sparklingInfo.setBounds(95, 278, 60, 38);
		//ź������ �̸� ǥ��
		sparklingInfo.setHorizontalAlignment(SwingConstants.CENTER);
		infoMenu.add(sparklingInfo);
		waterNameChange.setBounds(171, 80, 95, 24);
		
		//������ ���� �̸� & ���� �Է�â
		//������ �� �̸� �Է�â
		waterNameChange.setHorizontalAlignment(SwingConstants.CENTER);
		waterNameChange.setColumns(10);
		infoMenu.add(waterNameChange);
		coffeeNameChange.setBounds(171, 131, 95, 24);
		//������ Ŀ�� �̸� �Է�â
		coffeeNameChange.setHorizontalAlignment(SwingConstants.CENTER);
		coffeeNameChange.setColumns(10);
		infoMenu.add(coffeeNameChange);
		sportNameChange.setBounds(171, 181, 95, 24);
		//������ �̿����� �̸� �Է�â
		sportNameChange.setHorizontalAlignment(SwingConstants.CENTER);
		sportNameChange.setColumns(10);
		infoMenu.add(sportNameChange);
		highCoffeeNameChange.setBounds(171, 235, 95, 24);
		//������ ���Ŀ�� �̸� �Է�â
		highCoffeeNameChange.setHorizontalAlignment(SwingConstants.CENTER);
		highCoffeeNameChange.setColumns(10);
		infoMenu.add(highCoffeeNameChange);
		sparklingNameChange.setBounds(171, 285, 95, 24);
		//������ ź������ �̸� �Է�â
		sparklingNameChange.setHorizontalAlignment(SwingConstants.CENTER);
		sparklingNameChange.setColumns(10);
		infoMenu.add(sparklingNameChange);
		
		priceInfo.setBounds(386, 28, 60, 38);		
		priceInfo.setHorizontalAlignment(SwingConstants.CENTER);
		infoMenu.add(priceInfo);
		//������ �� ���� �Է�â
		waterPriceChange.setBounds(374, 80, 95, 24);
		waterPriceChange.setHorizontalAlignment(SwingConstants.CENTER);
		waterPriceChange.setColumns(10);
		infoMenu.add(waterPriceChange);
		//������ Ŀ�� ���� �Է�â
		coffeePriceChange.setBounds(374, 131, 95, 24);		
		coffeePriceChange.setHorizontalAlignment(SwingConstants.CENTER);
		coffeePriceChange.setColumns(10);
		infoMenu.add(coffeePriceChange);
		//������ �̿����� ���� �Է�â
		sportPriceChange.setBounds(374, 181, 95, 24);		
		sportPriceChange.setHorizontalAlignment(SwingConstants.CENTER);
		sportPriceChange.setColumns(10);
		infoMenu.add(sportPriceChange);
		//������ ���Ŀ�� ���� �Է�â
		highCoffeePriceChange.setBounds(374, 235, 95, 24);		
		highCoffeePriceChange.setHorizontalAlignment(SwingConstants.CENTER);
		highCoffeePriceChange.setColumns(10);
		infoMenu.add(highCoffeePriceChange);
		//������ ź������ ���� �Է�â
		sparklingPriceChange.setBounds(374, 285, 95, 24);		
		sparklingPriceChange.setHorizontalAlignment(SwingConstants.CENTER);
		sparklingPriceChange.setColumns(10);
		infoMenu.add(sparklingPriceChange);
		
		//�� �̸� ���� ��ư
		waterNameChangeButton.setBounds(278, 79, 80, 25);
		infoMenu.add(waterNameChangeButton);
		waterNameChangeButton.addActionListener(new ActionListener() {	//�� �̸� ���� ��ư ������
			public void actionPerformed(ActionEvent e) {
				water.rename(waterNameChange.getText());	//�Է��� �� �̸����� ����
				waterBtn.setText(water.name);	//���� ���� ��ư�� ǥ�� ����
			}
		});
		//Ŀ�� �̸� ���� ��ư
		coffeeNameChangeButton.setBounds(278, 130, 80, 25);
		infoMenu.add(coffeeNameChangeButton);
		coffeeNameChangeButton.addActionListener(new ActionListener() {	//Ŀ�� �̸� ���� ��ư ������
			public void actionPerformed(ActionEvent e) {
				coffee.rename(coffeeNameChange.getText());	//�Է��� �� �̸����� ����
				coffeeBtn.setText(coffee.name);	//���� ���� ��ư�� ǥ�� ����
			}
		});
		//�̿����� �̸� ���� ��ư
		sportNameChangeButton.setBounds(278, 180, 80, 25);
		infoMenu.add(sportNameChangeButton);
		sportNameChangeButton.addActionListener(new ActionListener() {	//�̿����� �̸� ���� ��ư ������
			public void actionPerformed(ActionEvent e) {
				sport.rename(sportNameChange.getText());	//�Է��� �� �̸����� ����
				sportBtn.setText(sport.name);	//���� ���� ��ư�� ǥ�� ����
			}
		});
		//���Ŀ�� �̸� ���� ��ư
		highCoffeeNameChangeButton.setBounds(278, 234, 80, 25);
		infoMenu.add(highCoffeeNameChangeButton);
		highCoffeeNameChangeButton.addActionListener(new ActionListener() {	//���Ŀ�� �̸� ���� ��ư ������
			public void actionPerformed(ActionEvent e) {
				highCoffee.rename(highCoffeeNameChange.getText());	//�Է��� �� �̸����� ����
				highCoffeeBtn.setText(highCoffee.name);	//���� ���� ��ư�� ǥ�� ����
			}
		});
		//ź������ �̸� ���� ��ư
		sparklingNameChangeButton.setBounds(278, 284, 80, 25);
		infoMenu.add(sparklingNameChangeButton);
		sparklingNameChangeButton.addActionListener(new ActionListener() {	//ź������ �̸� ���� ��ư ������
			public void actionPerformed(ActionEvent e) {
				sparkling.rename(sparklingNameChange.getText());	//�Է��� �� �̸����� ����
				sparklingBtn.setText(sparkling.name);	//���� ���� ��ư�� ǥ�� ����
			}
		});
		//�� ���� ���� ��ư
		waterPriceChangeButton.setBounds(483, 79, 80, 25);
		infoMenu.add(waterPriceChangeButton);	
		waterPriceChangeButton.addActionListener(new ActionListener() {	//�� ���� ���� ��ư ������
			public void actionPerformed(ActionEvent e) {
				water.resetting(Integer.parseInt(waterPriceChange.getText()));	//�Է��� �� �������� ����
				waterPrice.setText(water.price+"��");	//���� ���� ǥ�� ����
			}
		});
		//Ŀ�� ���� ���� ��ư
		coffeePriceChangeButton.setBounds(483, 130, 80, 25);
		infoMenu.add(coffeePriceChangeButton);
		coffeePriceChangeButton.addActionListener(new ActionListener() {	//Ŀ�� ���� ���� ��ư ������
			public void actionPerformed(ActionEvent e) {
				coffee.resetting(Integer.parseInt(coffeePriceChange.getText()));	//�Է��� �� �������� ����
				coffeePrice.setText(coffee.price+"��");	//���� ���� ǥ�� ����
			}
		});
		//�̿����� ���� ���� ��ư
		sportPriceChangeButton.setBounds(483, 180, 80, 25);
		infoMenu.add(sportPriceChangeButton);
		sportPriceChangeButton.addActionListener(new ActionListener() {	//�̿����� ���� ���� ��ư ������
			public void actionPerformed(ActionEvent e) {
				sport.resetting(Integer.parseInt(sportPriceChange.getText()));	//�Է��� �� �������� ����
				sportPrice.setText(sport.price+"��");	//���� ���� ǥ�� ����
			}
		});
		//���Ŀ�� ���� ���� ��ư 
		highCoffeePriceChangeButton.setBounds(483, 234, 80, 25);
		infoMenu.add(highCoffeePriceChangeButton);
		highCoffeePriceChangeButton.addActionListener(new ActionListener() {	//���Ŀ�� ���� ���� ��ư ������
			public void actionPerformed(ActionEvent e) {
				highCoffee.resetting(Integer.parseInt(highCoffeePriceChange.getText()));	//�Է��� �� �������� ����
				highCoffeePrice.setText(highCoffee.price+"��");	//���� ���� ǥ�� ����
			}
		});
		//ź������ ���� ���� ��ư 
		sparklingPriceChangeButton.setBounds(483, 284, 80, 25);
		infoMenu.add(sparklingPriceChangeButton);
		sparklingPriceChangeButton.addActionListener(new ActionListener() {	//ź������ ���� ���� ��ư ������
			public void actionPerformed(ActionEvent e) {
				sparkling.resetting(Integer.parseInt(sparklingPriceChange.getText()));	//�Է��� �� �������� ����
				sparklingPrice.setText(sparkling.price+"��");	//���� ���� ǥ�� ����
			}
		});
		
		//[������ �޴� - ��й�ȣ ���� �޴�]
		passwordMenu.setBounds(0, 31, 647, 391);			
		managerPage.add(passwordMenu);
		passwordMenu.setLayout(null);
		
		//���� ��й�ȣ �ؽ�Ʈ ���̺�
		JLabel currPass = new JLabel("���� ��й�ȣ : ");
		currPass.setHorizontalAlignment(SwingConstants.CENTER);
		currPass.setBounds(200, 109, 112, 38);
		passwordMenu.add(currPass);
		//�� ��й�ȣ �ؽ�Ʈ ���̺�
		JLabel newPass = new JLabel("�� ��й�ȣ : ");
		newPass.setHorizontalAlignment(SwingConstants.CENTER);
		newPass.setBounds(200, 172, 112, 38);
		passwordMenu.add(newPass);
		//���� ��й�ȣ �Է� �н������ʵ�
		currPassInput = new JPasswordField();
		currPassInput.setHorizontalAlignment(SwingConstants.CENTER);
		currPassInput.setBounds(326, 116, 120, 35);
		passwordMenu.add(currPassInput);
		//��(�ٲ�) ��й�ȣ �Է� �н������ʵ�
		newPassInput = new JPasswordField();
		newPassInput.setHorizontalAlignment(SwingConstants.CENTER);
		newPassInput.setBounds(326, 172, 120, 35);
		passwordMenu.add(newPassInput);
		
		//��й�ȣ ����(����)��ư
		JButton passEnterButton = new JButton("Enter");
		passEnterButton.setBounds(270, 237, 100, 40);
		passEnterButton.addActionListener(new ActionListener() {	//��ư Ŭ����
			public void actionPerformed(ActionEvent e) {
				//���� ���� ��й�ȣ�� ��ġ�Ѵٸ�
				if(currPassInput.getText().equals(password.password)) {
					currPassInput.setText("");
					//���� �� ��й�ȣ�� Ư������(!, *, @)�� �ϳ� �̻� ���ԵǾ� �ִٸ�
					if(newPassInput.getText().contains("!")||newPassInput.getText().contains("*")||newPassInput.getText().contains("@")) {
						password.change(newPassInput.getText());	//��й�ȣ ����
						newPassInput.setText("");
					}
						
					//�ƴϸ� �����޽��� ����
					else {
						newPassInput.setText("");
						JOptionPane.showMessageDialog(null, "Ư������ 1�� �̻� �����ؾ���(!, *, @)");
					}
				}
				//�ƴϸ� �����޽��� ����
				else {
					currPassInput.setText("");
					newPassInput.setText("");
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�(Ư������ ����)");
				}
			}
		});
		passwordMenu.add(passEnterButton);
	}
	
	//������ �޴� ������ �׼Ǹ�����
	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();	//������ �޴��������� ���ڿ� ����
			switch(cmd) {
			case "����":	//���ݸ޴� Ŭ����
				moneyMenu.setVisible(true);	//�����г� ���̱�
				passwordMenu.setVisible(false);	//�������г��� ��Ȱ��ȭ
				infoMenu.setVisible(false);
				storageMenu.setVisible(false);
				break;
			case "�����":	//����� �޴� Ŭ����
				storageMenu.setVisible(true);	//����� �г� ���̱�
				moneyMenu.setVisible(false);	//�������г��� ��Ȱ��ȭ
				passwordMenu.setVisible(false);
				infoMenu.setVisible(false);
				break;
			case "��������":	//�������� �޴� Ŭ����
				infoMenu.setVisible(true);	//�������� ���� �г� ���̱�
				moneyMenu.setVisible(false);	//�������г��� ��Ȱ��ȭ
				passwordMenu.setVisible(false);
				storageMenu.setVisible(false);
				break;
			case "��й�ȣ":	//��й�ȣ(����)�޴� Ŭ����
				passwordMenu.setVisible(true);	//��й�ȣ ���� �г� ���̱�
				moneyMenu.setVisible(false);	//�������г��� ��Ȱ��ȭ
				infoMenu.setVisible(false);
				storageMenu.setVisible(false);
				break;
			case "����":
				machinePage.setVisible(true);	//�ٽ� ���Ǳ� ȭ�� ���̱�
				managerPage.setVisible(false);	//�������г��� ��Ȱ��ȭ
				moneyMenu.setVisible(false);
				passwordMenu.setVisible(false);
				infoMenu.setVisible(false);
				storageMenu.setVisible(false);
				break;
		}
	}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {	//�����忡 ���� ����� �� �ִ� �ڵ�
			public void run() {
				try {
					vendingMachine window = new vendingMachine();
					window.frame.setVisible(true);
				} catch (Exception e) {	//���� �߻���
					e.printStackTrace();	//���� ���� ���� & ���α׷� ����
				}
			}
		});
		
		
		
	}
	
}
