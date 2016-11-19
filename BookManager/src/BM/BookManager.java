package BM;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
/**
 * code by 计算机科学与技术学院 软件1402 田盛前 0121410880420
 * 
 */
import java.util.Scanner;

public class BookManager 
{
	private int num=0;
	//private Book book[]=new Book[100];
	private Book tempbook;
	private Manager manager=new Manager("horizon","1697994922");
	public HashMap<String,Book> map=new HashMap<>();
	
	public int getNum()
	{
		return num;
	}
	File file= new File("src\\BM\\book.txt");
	BookManager() 
	{
		try (BufferedReader read=new BufferedReader(new FileReader(file));)
		{
			//将文件中的信息读取到HashMap中
			String str;
			String[] bookInfo;
			while((str=read.readLine())!=null)
			{
				bookInfo=str.split("#");//用#分割字符串
				tempbook =new Book(bookInfo[0],bookInfo[1],Double.parseDouble(bookInfo[2]),bookInfo[3]);
				map.put(bookInfo[0],tempbook);
			}
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		} 
		
		num=map.size();
	}
	
	
	public boolean login_m(String Tacount,String Tpassword)
	{
		//System.out.println("***登录***");
		String acount=Tacount;
		String password=Tpassword;
		//Scanner in=new Scanner(System.in);
		/*for(;;)
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
		*/
		if(acount.equals(manager.acount) && password.equals(manager.password) )
		{
			return true;
		}
		return false;
	}
	public String[][] getDATA()
	{
		String[][] st_data=new String[num][4];
		
		int i=0;
		for(Book bk:map.values())
		{
			st_data[i]=bk.toST();
			i++;
		}
		
		return st_data;
	}
	public void showAll()
	{
		if(num==0)
		{
			System.out.println("目前未导入图书");
		}
		else
		{
			System.out.printf("%s\t\t%s\t\t%s\t\t%s\n","书名","作者","价格","出版社");
			for(Book i:map.values())
			{
				i.showSelf();
			}
		}
	}
	public boolean deleteBook(String name)
	{
		if(num>0)
		{
			/*for(int i=0;i<num;i++)
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
			}*/
			if(map.get(name)!=null)
			{
				map.remove(name);
				num--;
				return true;
			}
			return false;
		}
		return false;
	}
	public boolean addBook(String BK_name,String BK_author,double BK_price,String BK_publisher)
	{
		/*if(num>=100)
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
			
		}*/
		String name=BK_name;
		String author=BK_author;
		double price=BK_price;
		String publisher=BK_publisher;
		/*Scanner in=new Scanner(System.in);
		System.out.println("请输入书籍名称:");
		name=in.next();
		System.out.println("请输入书籍作者:");
		author=in.next();
		System.out.println("请输入书籍价格:");
		price=in.nextDouble();
		System.out.println("请输入书籍出版商:");
		publisher=in.next();*/
		tempbook=new Book(name,author,price,publisher);
		map.put(name, tempbook);
		num++;
		return true;
	}
	public String[] search(String target)
	{
		if(num==0)
		{
			return null;
		}
		/*System.out.println("请输入要查找书籍的名称:");
		Scanner in=new Scanner(System.in);
		String target;
		target=in.next();*/
		/*int find=99;
		
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
		}*/
		tempbook=map.get(target);
		if(tempbook==null)
		{
			return null;
		}
		//System.out.printf("%s\t\t%s\t\t%s\t\t%s\n","书名","作者","价格","出版社");
		
		return tempbook.toST();
	}
	public boolean modifyBook(String BK_name,String BK_author,double BK_price,String BK_publisher )
	{
		/*System.out.println("请输入要修改书籍的名称:");
		Scanner in=new Scanner(System.in);*/
		String target=BK_name;
		//target=in.next();
		/*int find=99;
		
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
		}*/
		tempbook=map.get(target);
		if(tempbook==null)
		{
			return false;
		}
		/*int choice=5;
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
				case 1:{System.out.println("请输入新的书名");String name;name=in.next();map.remove(tempbook.name);tempbook.name=name;map.put(tempbook.name, tempbook);break;}
				case 2:{System.out.println("请输入新的作者名");String author;author=in.next();tempbook.author=author;map.put(tempbook.name, tempbook);break;}
				case 3:{System.out.println("请输入新的价格");double price;price=in.nextDouble();tempbook.price=price;map.put(tempbook.name, tempbook);break;}
				case 4:{System.out.println("请输入新的出版商");String publisher;publisher=in.next();tempbook.publisher=publisher;map.put(tempbook.name, tempbook);break;}
			}
		}*/
		map.remove(tempbook.name);
		tempbook.author=BK_author;
		tempbook.price=BK_price;
		tempbook.publisher=BK_publisher;
		map.put(tempbook.name, tempbook);
		return true;
	}
	public boolean changePassword(String newPassword)
	{
		manager.changeInfo(newPassword);
		return true;
	}
	public void saveData()
	{
		try (BufferedWriter write=new BufferedWriter(new FileWriter(file));)
		{
			for(Book i:map.values())
			{
				String s=i.name+"#"+i.author+"#"+i.price+"#"+i.publisher+"#"+"\r\n";
				write.write(s);
			}
		} 
		catch (IOException e) 
		{
			System.out.println("error!");
			e.printStackTrace();
		}
		
	}
	
	//public static void main(String arg[])
	//{
	//	BookManager BM=new BookManager();
	//	Scanner in=new Scanner(System.in);
		
	//	BM.login_m();
	//	int choice=6;
	//	while(choice!=0)
	//	{
	//		System.out.println("********");
	//		System.out.println("1:显示所有书籍");
	//		System.out.println("2:添加书籍");
	//		System.out.println("3:删除书籍");
	//		System.out.println("4:修改书籍");
	//		System.out.println("5:查找书籍");
	//		System.out.println("6:修改密码");
	//		System.out.println("0:退出");
	//		System.out.println("********");
	//		System.out.print("请输入功能选项:");
	//		choice=in.nextInt();
	//		System.out.println("");
	//		
	//		switch(choice)
	//			{
	//			case 1:{BM.showAll();break;}/*显示所有书籍*/
	//			case 2:{BM.addBook();break;}/*添加书籍*/
	//			case 3:{System.out.print("请输入要删除书籍的名字:");String name;name=in.next();BM.deleteBook(name);break;}/*删除书籍*/
	//			case 4:{BM.modifyBook();break;}/*修改书籍*/
	//			case 5:{BM.search();break;}
	//			case 6:{BM.manager.changeInfo();break;}
	//			case 0:{System.out.println("已退出系统，欢迎下次继续使用");BM.saveData();break;}/*退出系统*/
	//			}
	//	}
	//}

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
	public void changeInfo(String newPassword)
	{
		//Scanner in=new Scanner(System.in);
		//System.out.println("请输入新的密码:");
		//String newPassword=in.next();
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
		System.out.printf("%s\t\t%s\t\t%.2f\t\t%s\n",this.name,this.author,this.price,this.publisher);
	}
	public String[] toST()
	{
		String price=String.valueOf(this.price);
	    String []x ={this.name,this.author,price,this.publisher};
		return (x);
	}
}