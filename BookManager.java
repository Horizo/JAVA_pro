package BM;


/**
 * code by 计算机科学与技术学院 软件1402 田盛前 0121410880420
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
		System.out.println("***登录***");
		String acount="";
		String password="";
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		for(;;)
		{
			System.out.println("请输入管理员账号:");
			acount=in.next();
			System.out.println("请输入管理员密码:");
			password=in.next();
			if(acount.equals(manager.acount) && password.equals(manager.password) )
			{
				System.out.println("登录成功！");
				break;
			}
			System.out.println("账号/密码错误！重新登录");
		}
		
		
	}
	public void showAll()
	{
		if(num==0)
		{
			System.out.println("目前未导入图书");
		}
		else
		{
			System.out.printf("%s\t%s\t%s\t%s\n","书名","作者","价格","出版社");
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
			System.out.println("系统中没有存贮书籍，无法删除书本");
		}
		System.out.println("无法找到该书籍！");
		return false;
	}
	public boolean addBook()
	{
		if(num>=100)
		{
			System.out.println("空间已满，不能添加！");
			return false;
		}
		else
		{
			String name;
			String author;
			double price;
			String publisher;
			Scanner in=new Scanner(System.in);
			System.out.println("请输入书籍名称");
			name=in.next();
			System.out.println("请输入书籍作者");
			author=in.next();
			System.out.println("请输入书籍价格");
			price=in.nextDouble();
			System.out.println("请输入书籍出版商");
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
			System.out.println("系统中没有存贮书籍！");
			return false;
		}
		System.out.print("请输入要查找书籍的名称:");
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
			System.out.println("未找到关于该书籍的信息");
			return false;
		}
		System.out.printf("%s\t%s\t%s\t%s\n","书名","作者","价格","出版社");
		book[find].showSelf();
		return true;
	}
	public boolean modifyBook()
	{
		System.out.print("请输入要修改书籍的名称:");
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
			System.out.println("未找到关于该书籍的信息");
			return false;
		}
		int choice=5;
		while(choice!=0)
		{
			System.out.println("********");
			System.out.println("1:更改书名");
			System.out.println("2:更改书作者");
			System.out.println("3:更改书价格");
			System.out.println("4:更改出版商");
			System.out.println("0:退出更改");
			System.out.println("********");
			System.out.print("输入选择:");
			choice=in.nextInt();
			System.out.println("");
			switch(choice)
			{
				case 1:{System.out.println("请输入新的书名");String name;name=in.next();book[find].name=name;break;}
				case 2:{System.out.println("请输入新的作者名");String author;author=in.next();book[find].author=author;break;}
				case 3:{System.out.println("请输入新的价格");double price;price=in.nextDouble();book[find].price=price;break;}
				case 4:{System.out.println("请输入新的出版商");String publisher;publisher=in.next();book[find].publisher=publisher;break;}
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
			System.out.println("1:显示所有书籍");
			System.out.println("2:添加书籍");
			System.out.println("3:删除书籍");
			System.out.println("4:修改书籍");
			System.out.println("5:查找书籍");
			System.out.println("6:修改密码");
			System.out.println("0:退出");
			System.out.println("********");
			System.out.print("请输入功能选项:");
			choice=in.nextInt();
			System.out.println("");
			
			switch(choice)
				{
				case 1:{BM.showAll();break;}/*显示所有书籍*/
				case 2:{BM.addBook();break;}/*添加书籍*/
				case 3:{System.out.print("请输入要删除书籍的名字:");String name;name=in.next();BM.deleteBook(name);break;}/*删除书籍*/
				case 4:{BM.modifyBook();break;}/*修改书籍*/
				case 5:{BM.search();break;}
				case 6:{BM.manager.changeInfo();break;}
				case 0:{System.out.println("已退出系统，欢迎下次继续使用");break;}/*退出系统*/
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
		System.out.println("请输入新的密码:");
		String newPassword=in.next();
		this.password=newPassword;
		System.out.println("密码修改成功！");
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