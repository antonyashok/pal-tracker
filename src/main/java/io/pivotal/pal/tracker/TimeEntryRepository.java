package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
	public TimeEntry create(TimeEntry timeEntry);
	 public TimeEntry find(Long id);
	 public List<TimeEntry> list();
	 public TimeEntry update(long timeEntryId, TimeEntry expected);
	 public void delete(long timeEntryId);
}
