package SampleConsole.SampleProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor



class ZealousAcademy implements Comparable<ZealousAcademy>
{
	private String studentName;
	private String studentTechnology;
	private String studentIncharge;
	private int studentMemberscount;
	private double studentHours;
	private double studentCourseprice;
	@Override
	public int compareTo(ZealousAcademy o) 
	{
		
		return this.studentName.compareTo(o.studentName);
	}
	

}
  