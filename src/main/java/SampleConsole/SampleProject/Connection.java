package SampleConsole.SampleProject;

import java.util.Scanner;

//import ConsoleApplication.ZealousAcademy;

public class Connection implements ZealousAcademyActions
{
	ZealousAcademy[] academy =new ZealousAcademy[6];//here zealousAcademy is data type
	Scanner scan = new Scanner(System.in);
	public Connection()
	{
		academy [0] = new ZealousAcademy("Thilak", "Javafullstack","Manojkumar", 5, 1.30, 30000.0);
		academy [1] = new ZealousAcademy("Thivin", "Python","razak", 10,11.00, 50000.00);
		academy [2] = new ZealousAcademy("Pradeep", "C#","Annamalai", 5,2, 40000.0);
		academy [3] = new ZealousAcademy("Ganesh", "C++","Aarthi", 7, 3.00, 35000.0);
		academy [4] = new ZealousAcademy("Vishnu", "Gaming","Sabari", 12, 2.00, 20000.0);
		academy [5] = new ZealousAcademy("ManojKumar", "PHP","Manojkumar", 15, 4.00, 25000.0);
	}

	public static void main(String[] args) 
	{
		Connection connect=new Connection();
		//System.out.println(Arrays.toString(academy));
		do
		{
			System.out.println("which process you want 1.addnewstudnetdetails\n2.List\n3.Update\n4.Search\n5.Sort\n6.Delete\n7.Exit");
			int menu=connect.scan.nextInt();
			switch(menu)
			{
			case 1:
				System.out.println("new student details is created by you StudentName,technology,incharge,memberscount,Hours,price");
				ZealousAcademy z1=new ZealousAcademy(connect.scan.next(), connect.scan.next(), connect.scan.next(),connect.scan.nextInt(),connect.scan.nextDouble(), connect.scan.nextDouble());
				System.out.println(connect.addnewstudentdetails(z1));
				break;

			case 2:
				System.out.println("your values is listed");
				connect.Listallstudentdetails();
				break;
			case 3:
				System.out.println("which student name you want update");
				String stud=connect.scan.next();
				connect.updateStudentdetails(stud);
				connect.Listallstudentdetails();
				break;
			case 4:
				System.out.println("search based on technolgy");
				System.out.println("which technology you want search");
				String tech=connect.scan.next();
				connect.searchStduentdetails(tech);
				break;
			case 5:
				System.out.println("your values is sorted");
				connect.SortStudentdetails();
				break;
			case 6:
				System.out.println("which name you want to delete in academic");
				String nm=connect.scan.next();
				connect.DeleteStduentdetails(nm);
			}


		}
		while(true);
	}

	@Override
	public String addnewstudentdetails(ZealousAcademy zealous) {
		for(int index=0;index<academy.length;index++)
		{
			if(academy[index]==null)
			{
				academy[index]=zealous;
				return zealous.getStudentName()+"has name is added succesfully";
			}
		}
		return zealous.getStudentName()+"has name is not added";
	}

	@Override
	public void Listallstudentdetails()
	{
		for(ZealousAcademy zea:academy)
		{
			System.out.println(zea);
		}
		
	}

	@Override
	public void updateStudentdetails(String name)
	{
	 try
	 {
		for(int index=0;index<academy.length;index++)
		{
			if(academy[index].getStudentName().equalsIgnoreCase(name))
			{
				System.out.println(name+"which field you want to update");
				System.out.println(academy[index]);
				//System.out.println("that fields are studentname,inchargename,members");
				String field=scan.next();
				switch(field)
				{
				case "studentname":
					System.out.println("try to your new student name");
					String newstud=scan.next();
					academy[index].setStudentName(newstud);
					return;
				case "studentTechnology":
					System.out.println("try to your new technology name");
					String tech=scan.next();
					academy[index].setStudentTechnology(tech);
					return;
				case "studentIncharge":
					System.out.println("try to your new Incharge name");
					String inch=scan.next();
					academy[index].setStudentIncharge(inch);
					return;
				case "studentMemberscount":
					System.out.println("try to your new Memberscount");
					int count=scan.nextInt();
					academy[index].setStudentMemberscount(count);
					return;
				case "studentHours":
					System.out.println("try to your new Hours details");
					double hours=scan.nextDouble();
					academy[index].setStudentHours(hours);
					return;
				case "studentCourseprice":
					System.out.println("try to your new price details");
					double price=scan.nextDouble();
					academy[index].setStudentCourseprice(price);
					return;
				default: throw new ZealousAcademyException();
				}
//				System.out.println(field+"has been updated");
//				System.out.println(field+"has been updated"+name);
//				return;
			}
		}
		/* System.out.println(name+"has not updated"); */
	 }
	 catch(ZealousAcademyException exe)
	 {
		 System.out.println(exe);
		 updateStudentdetails(scan.next());
	 }
	}

	@Override
	public void searchStduentdetails(String technology) 
	{
		System.out.println("i have trying to serach for technologies"+technology);
		for(int index=0;index<academy.length;index++)
		{
			if(academy[index].getStudentTechnology().equalsIgnoreCase(technology))
			{
				System.out.println(academy[index]);
			}
		}
		return;
		
	}

	@Override
	public void SortStudentdetails()
	{
		ZealousAcademy zealous=null;
		System.out.println("based on what field you want sort");
		String field=scan.next();
		for(int index=0;index<academy.length;index++)
		{
			for(int pos=index+1;pos<academy.length;pos++)
			{
				if(field.equalsIgnoreCase("studentname"))
				{
					if(academy[index].getStudentName().compareTo(academy[pos].getStudentName())>0)
					{
						zealous=academy[index];
						academy[index]=academy[pos];
						academy[pos]=zealous;
					}
				}
				else if(field.equalsIgnoreCase("studentMemberscount"))
				{
					if(academy[index].getStudentMemberscount()>=academy[pos].getStudentMemberscount())
					{
						zealous=academy[index];
						academy[index]=academy[pos];
						academy[pos]=zealous;
					}
				}
				else if(field.equalsIgnoreCase("studentHours"))
				{
					if(academy[index].getStudentHours()>=academy[pos].getStudentHours());
					{
						zealous=academy[index];
						academy[index]=academy[pos];
						academy[pos]=zealous;
					}
				}
				else if(field.equalsIgnoreCase("studentCourseprice"))
				{
					if(academy[index].getStudentCourseprice()>=academy[pos].getStudentCourseprice());
					{
						zealous=academy[index];
						academy[index]=academy[pos];
						academy[pos]=zealous;
					}
				}
				else if(field.equalsIgnoreCase("studentTechnology"))
				{
					if(academy[index].getStudentTechnology().compareTo(academy[pos].getStudentTechnology())>0)
					{
						zealous=academy[index];
						academy[index]=academy[pos];
						academy[pos]=zealous;
					}
				}
				else if(field.equalsIgnoreCase("studentIncharge"))
				{
					if(academy[index].getStudentIncharge().compareTo(academy[pos].getStudentIncharge())>0)
					{
						zealous=academy[index];
						academy[index]=academy[pos];
						academy[pos]=zealous;
					}
				}

			}
		}
		
	}

	@Override
	public void DeleteStduentdetails(String name) 
	{
		for(int index=0;index<academy.length;index++)
		{
			if(academy[index].getStudentName().equalsIgnoreCase(name))
			{
				academy[index]=null;
				System.out.println(name+"has been deleted succesfully");
				return;
			}
		}
		System.out.println(name+"has't deleted....");
	}
		
}


