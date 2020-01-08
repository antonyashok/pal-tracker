package io.pivotal.pal.tracker;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
	
	private TimeEntry timeEntry;
	private static long count=0l;
	private List<TimeEntry> actual=new ArrayList<TimeEntry>();
	public InMemoryTimeEntryRepository() {
		count=0l;
		timeEntry=null;
	}
	

	@Override
	public TimeEntry create(TimeEntry timeEntry) {
		this.timeEntry=timeEntry;
		 this.timeEntry.setId(count+1);
		 count=this.timeEntry.getId();
		 List<TimeEntry> a = asList( this.timeEntry );
		 actual.addAll(a);
		return this.timeEntry;
	}

	@Override
	public TimeEntry find(Long id) {
		if(id ==null || timeEntry==null||id!= timeEntry.getId()) {
			return null;
		}
		return timeEntry;
	}

	@Override
	public List<TimeEntry> list() {
		
		return actual;
		
		
	}

	@Override
	public TimeEntry update(long timeEntryId, TimeEntry expected) {
		if(find(timeEntryId) == null) {
			return null;
		}
		 Long id1 = find(timeEntryId).getId();
		 this.timeEntry=expected;
		 this.timeEntry.setId(id1);
		 return this.timeEntry;
		
		
		
	}

	@Override
	public void delete(long timeEntryId) {
		count=timeEntryId;
		this.timeEntry=null;
		this.actual.clear();
			
	}
	
	
	

	
	

}
