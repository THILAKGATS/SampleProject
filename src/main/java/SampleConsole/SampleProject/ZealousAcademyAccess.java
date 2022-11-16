package SampleConsole.SampleProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ZealousAcademyAccess implements Runnable,ZealousAcademyActions
{
	ZealousAcademy[] academy =new ZealousAcademy[6];//here zealousAcademy is data type
	Scanner scan = new Scanner(System.in);
	public ZealousAcademyAccess()
	{
		academy [0] = new ZealousAcademy("Thilak", "Javafullstack","Manojkumar", 5, 1.30, 30000.0);
		academy [1] = new ZealousAcademy("Thivin", "Python","razak", 10,11.00, 50000.00);
		academy [2] = new ZealousAcademy("Pradeep", "C#","Annamalai", 5,2, 40000.0);
		academy [3] = new ZealousAcademy("Ganesh", "C++","Aarthi", 7, 3.00, 35000.0);
		academy [4] = new ZealousAcademy("Vishnu", "Gaming","Sabari", 12, 2.00, 20000.0);
		academy [5] = new ZealousAcademy("ManojKumar", "PHP","Manojkumar", 15, 4.00, 25000.0);
	}	
	@Override
	public String addnewstudentdetails(ZealousAcademy zealous) 
	{
		try
		{
			for(int index=0;index<academy.length;index++)
			{
				if(academy[index]==null)
				{
					academy[index]=zealous;
					return zealous.getStudentName()+"has name is add successfully";
				}
			}
			throw new ZealousAcademyException();
		}
		catch(ZealousAcademyException exe)
		{
			System.out.println(exe+"memory is full, so if you need any one data is deleted");
			for(ZealousAcademy zea:academy)
			{
				System.out.println(zea.getStudentName());
			}
			System.out.println("which name you want delete");
			DeleteStduentdetails(scan.next());
			addnewstudentdetails(zealous);
		}
		
	return zealous.getStudentName()+"has name is added successfully";
		
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
					try
					{
						System.out.println(name+"which field you want to update");
						System.out.println(academy[index]);
						String field=scan.next();
						switch(field)
						{
						case "studentName":
							System.out.println("Enter your new student name");
							String newstud=scan.next();
							academy[index].setStudentName(newstud);
							break;
						case "studentTechnology":
							System.out.println("Enter your new Technology");
							String tech=scan.next();
							academy[index].setStudentTechnology(tech);
							break;
						case "studentIncharge":
							System.out.println("Enter your new InchargeName");
							String Incharge=scan.next();
							academy[index].setStudentIncharge(Incharge);
							break;
						case "studentMemberscount":
							System.out.println("Enter your new members count");
							int count=scan.nextInt();
							academy[index].setStudentMemberscount(count);
							break;
						case "studentClasstiming":
							System.out.println("Enter your new class Timing");
							double time=scan.nextDouble();
							academy[index].getStudentHours();
							break;
						case "studentCourseprice":
							System.out.println("Enter your new course price");
							double price=scan.nextDouble();
							academy[index].setStudentCourseprice(price);
							break;
							default:
								throw new ZealousAcademyException();
						}
						System.out.println(field+"has been updated");
						return;
					}
					catch(ZealousAcademyException |InputMismatchException exe)
					{
						Scanner scan=new Scanner(System.in);
						System.out.println(name+"your field name is wrong,place enter correct value\n studentName\n studentTechnology\n studentIncharge\n studentMemberscount\n studentClasstiming\n studentCourseprice");
						System.out.println(name+"which field you want to update");
						System.out.println(academy[index]);
						String field=scan.next();
						switch(field)
						{
						case "studentName":
							System.out.println("Enter your new student name");
							String newstud=scan.next();
							academy[index].setStudentName(newstud);
							break;
						case "studentTechnology":
							System.out.println("Enter your new Technology");
							String tech=scan.next();
							academy[index].setStudentTechnology(tech);
							break;
						case "studentIncharge":
							System.out.println("Enter your new InchargeName");
							String Incharge=scan.next();
							academy[index].setStudentIncharge(Incharge);
							break;
						case "studentMemberscount":
							System.out.println("Enter your new members count");
							int count=scan.nextInt();
							academy[index].setStudentMemberscount(count);
							break;
						case "studentClasstiming":
							System.out.println("Enter your new class Timing");
							double time=scan.nextDouble();
							academy[index].getStudentHours();
							break;
						case "studentCourseprice":
							System.out.println("Enter your new course price");
							double price=scan.nextDouble();
							academy[index].setStudentCourseprice(price);
							break;
//							default:
//								throw new ZealousAcademyException();
						}
						System.out.println(field+"has been updated");
						return;
					}
				}
			}
			throw new ZealousAcademyException();
		}
		catch(ZealousAcademyException exe)
		{
			System.out.println(exe+"enter your correct student value");
			for(ZealousAcademy zea:academy)
			{
				System.out.println(zea.getStudentName());
			}
			System.out.println("which value you update");
			updateStudentdetails(scan.next());
		}
		
	}

	@Override
	public void searchStduentdetails(String technology)
	{
		try
		{
			System.out.println("i have trying to search for technology"+"  "+technology);
			for(int index=0;index<academy.length;index++)
			{
				if(academy[index].getStudentTechnology().equalsIgnoreCase(technology))
				{
					System.out.println(academy[index]);
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
		try
		{
			ZealousAcademy zealous=null;
			System.out.println("based on what filed you want sort");
			String field=scan.next();
			for(int index=0;index<academy.length;index++)
			{
				for(int pos=index+1;pos<academy.length;pos++)
				{
					if(field.equalsIgnoreCase("StudentName"))
					{
						if(academy[index].getStudentName().compareTo(academy[pos].getStudentName())>0)
						{
							zealous=academy[index];
							academy[index]=academy[pos];
							academy[pos]=zealous;
							//System.out.println(zealous.getStudentName());
						}
						
					}
					
					else if(field.equalsIgnoreCase("studentMembersCount"))
					{
						if(academy[index].getStudentMemberscount()>=academy[pos].getStudentMemberscount())
						{
							zealous=academy[index];
							academy[index]=academy[pos];
							academy[pos]=zealous;
						}
					}
					else if(field.equalsIgnoreCase("studentCourseprice"))
					{
						if(academy[index].getStudentCourseprice()>=academy[pos].getStudentCourseprice())
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
			throw new ZealousAcademyException();
		}
		catch(ZealousAcademyException exe)
		{
			System.out.println(exe+"your field name is wrong,place enter correct value\n studentName\n studentTechnology\n studentIncharge\n studentMemberscount\n studentClasstiming\n studentCourseprice");
			System.out.println("which field you want to sort");
			//Sortstudentdetails(scan.next());
			ZealousAcademy zealous=null;
			String field=scan.next();
			for(int index=0;index<academy.length;index++)
			{
				for(int pos=index+1;pos<academy.length;pos++)
				{
					if(field.equalsIgnoreCase("StudentName"))
					{
						if(academy[index].getStudentName().compareTo(academy[pos].getStudentName())>0)
						{
							zealous=academy[index];
							academy[index]=academy[pos];
							academy[pos]=zealous;
							//System.out.println(zealous.getStudentName());
						}
						
					}
					
					else if(field.equalsIgnoreCase("studentMembersCount"))
					{
						if(academy[index].getStudentMemberscount()>=academy[pos].getStudentMemberscount())
						{
							zealous=academy[index];
							academy[index]=academy[pos];
							academy[pos]=zealous;
						}
					}
					else if(field.equalsIgnoreCase("studentCourseprice"))
					{
						if(academy[index].getStudentCourseprice()>=academy[pos].getStudentCourseprice())
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
		
	}

	@Override
	public void DeleteStduentdetails(String name) 
	{
		try
		{
			for(int index=0;index<academy.length;index++)
			{
				if(academy[index].getStudentName().equalsIgnoreCase(name))
				{
					academy[index]=null;
					System.out.println(name+"has been deleted successfully");
					return;
				}
			}
			throw new ZealousAcademyException();
		}
		catch(ZealousAcademyException exe)
		{
			System.out.println(exe+"name is not matching.place enter matching values are");
			for(ZealousAcademy zea:academy)
			{
				System.out.println(zea.getStudentName());
			}
			System.out.println("whitch name you want delete");
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

