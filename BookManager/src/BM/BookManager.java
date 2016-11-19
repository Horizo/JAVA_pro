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
 * code by �������ѧ�뼼��ѧԺ ���1402 ��ʢǰ 0121410880420
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
			//���ļ��е���Ϣ��ȡ��HashMap��
			String str;
			String[] bookInfo;
			while((str=read.readLine())!=null)
			{
				bookInfo=str.split("#");//��#�ָ��ַ���
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
		//System.out.println("***��¼***");
		String acount=Tacount;
		String password=Tpassword;
		//Scanner in=new Scanner(System.in);
		/*for(;;)
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
			System.out.println("Ŀǰδ����ͼ��");
		}
		else
		{
			System.out.printf("%s\t\t%s\t\t%s\t\t%s\n","����","����","�۸�","������");
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
			
		}*/
		String name=BK_name;
		String author=BK_author;
		double price=BK_price;
		String publisher=BK_publisher;
		/*Scanner in=new Scanner(System.in);
		System.out.println("�������鼮����:");
		name=in.next();
		System.out.println("�������鼮����:");
		author=in.next();
		System.out.println("�������鼮�۸�:");
		price=in.nextDouble();
		System.out.println("�������鼮������:");
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
		/*System.out.println("������Ҫ�����鼮������:");
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
			System.out.println("δ�ҵ����ڸ��鼮����Ϣ");
			return false;
		}*/
		tempbook=map.get(target);
		if(tempbook==null)
		{
			return null;
		}
		//System.out.printf("%s\t\t%s\t\t%s\t\t%s\n","����","����","�۸�","������");
		
		return tempbook.toST();
	}
	public boolean modifyBook(String BK_name,String BK_author,double BK_price,String BK_publisher )
	{
		/*System.out.println("������Ҫ�޸��鼮������:");
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
			System.out.println("δ�ҵ����ڸ��鼮����Ϣ");
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
				case 1:{System.out.println("�������µ�����");String name;name=in.next();map.remove(tempbook.name);tempbook.name=name;map.put(tempbook.name, tempbook);break;}
				case 2:{System.out.println("�������µ�������");String author;author=in.next();tempbook.author=author;map.put(tempbook.name, tempbook);break;}
				case 3:{System.out.println("�������µļ۸�");double price;price=in.nextDouble();tempbook.price=price;map.put(tempbook.name, tempbook);break;}
				case 4:{System.out.println("�������µĳ�����");String publisher;publisher=in.next();tempbook.publisher=publisher;map.put(tempbook.name, tempbook);break;}
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
	//		System.out.println("1:��ʾ�����鼮");
	//		System.out.println("2:����鼮");
	//		System.out.println("3:ɾ���鼮");
	//		System.out.println("4:�޸��鼮");
	//		System.out.println("5:�����鼮");
	//		System.out.println("6:�޸�����");
	//		System.out.println("0:�˳�");
	//		System.out.println("********");
	//		System.out.print("�����빦��ѡ��:");
	//		choice=in.nextInt();
	//		System.out.println("");
	//		
	//		switch(choice)
	//			{
	//			case 1:{BM.showAll();break;}/*��ʾ�����鼮*/
	//			case 2:{BM.addBook();break;}/*����鼮*/
	//			case 3:{System.out.print("������Ҫɾ���鼮������:");String name;name=in.next();BM.deleteBook(name);break;}/*ɾ���鼮*/
	//			case 4:{BM.modifyBook();break;}/*�޸��鼮*/
	//			case 5:{BM.search();break;}
	//			case 6:{BM.manager.changeInfo();break;}
	//			case 0:{System.out.println("���˳�ϵͳ����ӭ�´μ���ʹ��");BM.saveData();break;}/*�˳�ϵͳ*/
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
		//System.out.println("�������µ�����:");
		//String newPassword=in.next();
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
		System.out.printf("%s\t\t%s\t\t%.2f\t\t%s\n",this.name,this.author,this.price,this.publisher);
	}
	public String[] toST()
	{
		String price=String.valueOf(this.price);
	    String []x ={this.name,this.author,price,this.publisher};
		return (x);
	}
}