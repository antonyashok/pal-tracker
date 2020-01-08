package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
	
	private long id;
	private long projectId;
	private long userId;
	private LocalDate date;
	private int hours;
	
	
	
	public TimeEntry() {
		
	}
	
	
	
	public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.userId = userId;
		this.date = date;
		this.hours = hours;
	}



	public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
		this.projectId = projectId;
		this.userId = userId;
		this.date = date;
		this.hours = hours;
	}



	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getId() {
		
		 return this.id;
		
	}
	@Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof TimeEntry)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        TimeEntry c = (TimeEntry) o; 
          
        // Compare the data members and return accordingly  
        return 
                 Long.compare(projectId, c.projectId) == 0
                		&& Long.compare(userId, c.userId) == 0
                				&& date.compareTo(c.date) == 0
                						&& Integer.compare(hours, c.hours) == 0; 
    } 
	@Override
	public int hashCode() {
	   return (int) this.projectId;
	}
}
