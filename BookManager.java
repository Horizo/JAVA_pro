package BM;


/**
 * code by �������ѧ�뼼��ѧԺ ���1402 ��ʢǰ 0121410880420
 * 
 */
import java.util.Scanner;

public class BookManager 
{
	private int num=0;
	private Book book[]=new Book[100];
	private Manager manager=new Manager("horizon","1697994922");
	
	
	public void login_m()
	{
		System.out.println("***��¼***");
		String acount="";
		String password="";
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		for(;;)
		{
			System.out.println("���������Ա�˺�:");
			acount=in.next();
			System.out.println("���������Ա����:");
			password=in.next();
			if(acount.equals(manager.acount) && password.equals(manager.password) )
			{
				System.out.println("��¼�ɹ���");
				break;
			}
			System.out.println("�˺�/����������µ�¼");
		}
		
		
	}
	public void showAll()
	{
		if(num==0)
		{
			System.out.println("Ŀǰδ����ͼ��");
		}
		else
		{
			System.out.printf("%s\t%s\t%s\t%s\n","����","����","�۸�","������");
			for(int i=0;i<num;i++)
			{
				book[i].showSelf();
			}
		}
	}
	public boolean deleteBook(String name)
	{
		if(num>0)
		{
			for(int i=0;i<num;i++)
			{
				if(book[i].name.equals(name))
				{
					for(int j=i;j<num-1;j++)
					{
						book[j].name=book[j+1].name;
						book[j].author=book[j+1].author;
						book[j].price=book[j+1].price;
						book[j].publisher=book[j+1].publisher;
					}
					num--;
					return true;
				}
			}
		}
		if(num==0)
		{
			System.out.println("ϵͳ��û�д����鼮���޷�ɾ���鱾");
		}
		System.out.println("�޷��ҵ����鼮��");
		return false;
	}
	public boolean addBook()
	{
		if(num>=100)
		{
			System.out.println("�ռ�������������ӣ�");
			return false;
		}
		else
		{
			String name;
			String author;
			double price;
			String publisher;
			Scanner in=new Scanner(System.in);
			System.out.println("�������鼮����");
			name=in.next();
			System.out.println("�������鼮����");
			author=in.next();
			System.out.println("�������鼮�۸�");
			price=in.nextDouble();
			System.out.println("�������鼮������");
			publisher=in.next();
			book[num]=new Book(name,author,price,publisher);
			num++;
			return true;
			
		}
	}
	public boolean search()
	{
		if(num==0)
		{
			System.out.println("ϵͳ��û�д����鼮��");
			return false;
		}
		System.out.print("������Ҫ�����鼮������:");
		Scanner in=new Scanner(System.in);
		String target;
		target=in.next();
		int find=99;
		
		for(int i=0;i<num;i++)
		{
			if(book[i].name.equals(target))
			{
				find=i;
				break;
			}
		}
		if(find==99)
		{
			System.out.println("δ�ҵ����ڸ��鼮����Ϣ");
			return false;
		}
		System.out.printf("%s\t%s\t%s\t%s\n","����","����","�۸�","������");
		book[find].showSelf();
		return true;
	}
	public boolean modifyBook()
	{
		System.out.print("������Ҫ�޸��鼮������:");
		Scanner in=new Scanner(System.in);
		String target;
		target=in.next();
		int find=99;
		
		for(int i=0;i<num;i++)
		{
			if(book[i].name.equals(target))
			{
				find=i;
				break;
			}
		}
		if(find==99)
		{
			System.out.println("δ�ҵ����ڸ��鼮����Ϣ");
			return false;
		}
		int choice=5;
		while(choice!=0)
		{
			System.out.println("********");
			System.out.println("1:��������");
			System.out.println("2:����������");
			System.out.println("3:������۸�");
			System.out.println("4:���ĳ�����");
			System.out.println("0:�˳�����");
			System.out.println("********");
			System.out.print("����ѡ��:");
			choice=in.nextInt();
			System.out.println("");
			switch(choice)
			{
				case 1:{System.out.println("�������µ�����");String name;name=in.next();book[find].name=name;break;}
				case 2:{System.out.println("�������µ�������");String author;author=in.next();book[find].author=author;break;}
				case 3:{System.out.println("�������µļ۸�");double price;price=in.nextDouble();book[find].price=price;break;}
				case 4:{System.out.println("�������µĳ�����");String publisher;publisher=in.next();book[find].publisher=publisher;break;}
			}
		}
		return true;
	}
	
	public static void main(String arg[])
	{
		BookManager BM=new BookManager();
		Scanner in=new Scanner(System.in);
		
		BM.login_m();
		int choice=6;
		while(choice!=0)
		{
			System.out.println("********");
			System.out.println("1:��ʾ�����鼮");
			System.out.println("2:����鼮");
			System.out.println("3:ɾ���鼮");
			System.out.println("4:�޸��鼮");
			System.out.println("5:�����鼮");
			System.out.println("6:�޸�����");
			System.out.println("0:�˳�");
			System.out.println("********");
			System.out.print("�����빦��ѡ��:");
			choice=in.nextInt();
			System.out.println("");
			
			switch(choice)
				{
				case 1:{BM.showAll();break;}/*��ʾ�����鼮*/
				case 2:{BM.addBook();break;}/*����鼮*/
				case 3:{System.out.print("������Ҫɾ���鼮������:");String name;name=in.next();BM.deleteBook(name);break;}/*ɾ���鼮*/
				case 4:{BM.modifyBook();break;}/*�޸��鼮*/
				case 5:{BM.search();break;}
				case 6:{BM.manager.changeInfo();break;}
				case 0:{System.out.println("���˳�ϵͳ����ӭ�´μ���ʹ��");break;}/*�˳�ϵͳ*/
				}
		}
	}

}
class Manager
{
	String acount;
	String password;
	Manager()
	{
		this.acount="test";
		this.password="105577";
	}
	Manager(String acount,String password)
	{
		this.acount=acount;
		this.password=password;
	}
	public void changeInfo()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("�������µ�����:");
		String newPassword=in.next();
		this.password=newPassword;
		System.out.println("�����޸ĳɹ���");
	}
}
class Book
{
    String name;
	String author;
	double price;
	String publisher;
	Book(String name,String author,double price,String publisher)
	{
		this.name=name;
		this.author=author;
		this.price=price;
		this.publisher=publisher;
	}
	Book()
	{
		this.name="";
		this.author="";
		this.price=0;
		this.publisher="";
	}
	public void showSelf()
	{
		System.out.printf("%s\t%s\t%.2f\t%s\n",this.name,this.author,this.price,this.publisher);
	}
}