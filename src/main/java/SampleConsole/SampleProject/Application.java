package SampleConsole.SampleProject;

public class Application 
{

	public static void main(String[] args) 
	{
		ZealousAcademyCollection access=new ZealousAcademyCollection();
		   Thread th1=new Thread(access,"Thivinkanth");
		   Thread th2=new Thread(access,"Pradeep");
		   Thread th3=new Thread(access,"Thilak");
		   Thread th4=new Thread(access,"Manojkumar");
		   Thread th5=new Thread(access,"Vishnu");
		   Thread th6=new Thread(access,"Ganesh");
		   th1.start();
		   th2.start();
		   th3.start();
		   th4.start();
		   th5.start();
		   th6.start();

	}

}
