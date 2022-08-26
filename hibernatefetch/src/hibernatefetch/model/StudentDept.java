package hibernatefetch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class StudentDept
{
	@Id
	@Column
	private int stdid;
	@Column
    private String name;
	@Column
	  private String dept;
	@Column
	   private String collegeyear;
	  
	  public StudentDept() { 
		  super(); // TODO Auto-generated constructor stub }
	  }
	  
	  public StudentDept(int stdid, String name, String dept, String collegeyear) 
	  {
	  super(); 
	  this.stdid = stdid; 
	  this.name = name; 
	  this.dept = dept;
	  this.collegeyear = collegeyear;
	  }
	  
	  public int getStdId() 
	  { return stdid; 
	  }
	  
	  public void setStdId(int stdid)
	  { 
		  this.stdid = stdid;
	  }
	  
	  public String getName() 
	  { 
		  return name; 
		  }
	  
	  public void setName(String name) { 
		  this.name = name; 
		  }
	  
	  public String getDept() {
		  return dept; 
		  }
	  
	  public void setDept(String dept) {
		  this.dept = dept; 
		  }
	  
	  public String getCollegeyear() {
		  return collegeyear; 
		  }
	  
	  public void setCollegeyear(String collegeyear) { 
		  this.collegeyear = collegeyear;
	  }
	  
	  }
	

