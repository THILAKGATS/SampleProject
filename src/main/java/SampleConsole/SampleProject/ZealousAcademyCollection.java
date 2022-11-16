package SampleConsole.SampleProject;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;


public class ZealousAcademyCollection implements Runnable,ZealousAcademyActions
{
		
		TreeSet<ZealousAcademy>academy = new TreeSet<ZealousAcademy>();
		Scanner scan = new Scanner(System.in);
		public ZealousAcademyCollection()
		{
			academy.add(new ZealousAcademy("Thilak", "Javafullstack","Manojkumar", 5, 1.30, 30000.0));
			academy.add(new ZealousAcademy("Thivin", "Python","razak", 10,11.00, 50000.00));
			academy.add(new ZealousAcademy("Pradeep", "C#","Annamalai", 5,2, 40000.0));
			academy.add(new ZealousAcademy("Ganesh", "C++","Aarthi", 7, 3.00, 35000.0));
			academy.add(new ZealousAcademy("Vishnu", "Gaming","Sabari", 12, 2.00, 20000.0));
			academy.add(new ZealousAcademy("ManojKumar", "PHP","Manojkumar", 15, 4.00, 25000.0));


		}

	@Override
	public String addnewstudentdetails(ZealousAcademy zealous) 
	{
		academy.add(zealous);
		return zealous.getStudentName()+"has name is added successfully";
	}

	@Override
	public void Listallstudentdetails() 
	{
		Iterator<ZealousAcademy> it = academy.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
			
		}
		
	}

	@Override
	public void updateStudentdetails(String name) 
	{
		ZealousAcademy ac=null;
		for(ZealousAcademy temp:academy)
		{
			if(temp.getStudentName().equalsIgnoreCase(name))
			{
				ac=temp;
				break;
			}
		}
		if(ac!=null)
		{
			try
			{
				System.out.println(name+"which field you want to update");
				//System.out.println(academy[index]);
				String field=scan.next();
				switch(field)
				{
				case "studentName":
					System.out.println("Enter your new student name");
					String newstud=scan.next();
					ac.setStudentName(newstud);
					break;
				case "studentTechnology":
					System.out.println("Enter your new Technology");
					String tech=scan.next();
					ac.setStudentTechnology(tech);
					break;
				case "studentIncharge":
					System.out.println("Enter your new InchargeName");
					String Incharge=scan.next();
					ac.setStudentIncharge(Incharge);
					break;
				case "studentMemberscount":
					System.out.println("Enter your new members count");
					int count=scan.nextInt();
					ac.setStudentMemberscount(count);
					break;
				case "studentClasstiming":
					System.out.println("Enter your new class Timing");
					double time=scan.nextDouble();
					ac.setStudentHours(time);
					break;
				case "studentCourseprice":
					System.out.println("Enter your new course price");
					double price=scan.nextDouble();
					ac.setStudentCourseprice(price);
					break;
					default:
						throw new ZealousAcademyException();
				}
				System.out.println(field+" "+"has been updated");
				//academy.add(ac);
				return;
			}
			catch(ZealousAcademyException |InputMismatchException exe)
			{
				Scanner scan=new Scanner(System.in);
				System.out.println(name+"your field name is wrong,place enter correct value\n studentName\n studentTechnology\n studentIncharge\n studentMemberscount\n studentClasstiming\n studentCourseprice");
				System.out.println(name+"which field you want to update");
				//System.out.println(academy[index]);
				String field=scan.next();
				switch(field)
				{
				case "studentName":
					System.out.println("Enter your new student name");
					String newstud=scan.next();
					ac.setStudentName(name);
					break;
				case "studentTechnology":
					System.out.println("Enter your new Technology");
					String tech=scan.next();
					ac.setStudentTechnology(tech);
					break;
				case "studentIncharge":
					System.out.println("Enter your new InchargeName");
					String Incharge=scan.next();
					ac.setStudentIncharge(Incharge);
					break;
				case "studentMemberscount":
					System.out.println("Enter your new members count");
					int count=scan.nextInt();
					ac.setStudentMemberscount(count);
					break;
				case "studentClasstiming":
					System.out.println("Enter your new class Timing");
					double time=scan.nextDouble();
					ac.setStudentHours(time);
					break;
				case "studentCourseprice":
					System.out.println("Enter your new course price");
					double price=scan.nextDouble();
					ac.setStudentCourseprice(price);
					break;
					default:
						System.out.println("Maximum choice is over");
				}
				System.out.println(field+" "+"has been updated");
				//academy.add(ac);
				return;
			}
		}
		else
		{
			System.out.println("it is not matching");
		}
		
	}

	@Override
	public void searchStduentdetails(String technology) 
	{
		List<ZealousAcademy>temp= new Vector<ZealousAcademy>();
		temp.addAll(academy);
		try
		{
			System.out.println("i have trying to search for technology"+"  "+technology);
			for(int index=0;index<temp.size();index++)
			{
				if(temp.get(index).getStudentTechnology().equalsIgnoreCase(technology))
				{
					System.out.println(temp.get(index));
					return;
				}
			}
			throw  new ZealousAcademyException();
		}
		catch(ZealousAcademyException exe)
		{
			System.out.println(exe+"Technology is not matching,available Technologys are");
			for(ZealousAcademy zea:academy)
			{
				System.out.println(zea.getStudentTechnology());
			}
			System.out.println("which Technology you want ");
			searchStduentdetails(scan.next());
		}
		
		
	}

	@Override
	public void SortStudentdetails() 
	{
		
		
	}

	@Override
	public void DeleteStduentdetails(String name)
	{
		List<ZealousAcademy>temp= new Vector<ZealousAcademy>();
		temp.addAll(academy);
		try
		{
			for(int index=0;index<temp.size();index++)
			{
				if(temp.get(index).getStudentName().equalsIgnoreCase(name))
				{
					academy.remove(temp.get(index));
					System.out.println(name+" "+"has been Deleted Successfully");
					return;
				}
			}
			throw new ZealousAcademyException();
		}
		catch(ZealousAcademyException exe)
		{
			System.out.println(exe+"name is  not matching,place matching values are");
			for(ZealousAcademy zea:academy)
			{
				System.out.println(zea.getStudentName());
			}
			System.out.println("Enter which name you want delete");
			DeleteStduentdetails(scan.next());
		}
		System.out.println(name+"has deleted");
	}

	@Override
	synchronized public void run() 
	{
		System.out.println("Welcome to ZealousAcademy"+" "+Thread.currentThread().getName());
		do
		{
			System.out.println("which process you want\n 1.Addnewstudentdetails\n 2.List\n 3.Update\n 4.Search\n 5.Sort\n 6.Delete\n 7.Exit");
			int menu=scan.nextInt();
			switch(menu)
			{
			case 1:
				System.out.println("Enter StudentName,Techmology,Incharge,MemberCount,ClassTimig,CoursePrice");
				ZealousAcademy z1=new ZealousAcademy(scan.next(),scan.next(),scan.next(),scan.nextInt(),scan.nextDouble(),scan.nextDouble());
				System.out.println(addnewstudentdetails(z1));
				break;
			case 2:
				System.out.println("your vale is listed");
				Listallstudentdetails();
				break;
			case 3:
				System.out.println("which student name you want update");
				String stud=scan.next();
				updateStudentdetails(stud);
				break;
			case 4:
				System.out.println("search based on technology");
				System.out.println("which technology you want to search");
				String tech1=scan.next();
				searchStduentdetails(tech1);
				break;
			case 5:
				SortStudentdetails();
				break;
			case 6:
				System.out.println("which name you want to delete in academic");
				String nm=scan.next();
				DeleteStduentdetails(nm);
			case 7:
				if(menu==7)
				{
					System.out.println("Thank You");
					return;
				}
			//default:return ;
			}
		}
		while(true);
		
	}
		
}


