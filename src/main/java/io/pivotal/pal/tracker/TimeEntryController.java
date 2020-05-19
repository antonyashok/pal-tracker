package io.pivotal.pal.tracker;

import java.util.List;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

	private TimeEntryRepository timeEntryRepository;
	private final DistributionSummary timeEntrySummary;
	private final Counter actionCounter;



	public TimeEntryController(TimeEntryRepository timeEntryRepository,
							   MeterRegistry meterRegistry) {
		
		this.timeEntryRepository=timeEntryRepository;
		timeEntrySummary = meterRegistry.summary("timeEntry.summary");
		actionCounter = meterRegistry.counter("timeEntry.actionCounter");

	}

	@PostMapping
	public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
		TimeEntry createResponse = timeEntryRepository.create(timeEntryToCreate);
		return new ResponseEntity<TimeEntry>(createResponse,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TimeEntry> read(@PathVariable("id") long timeEntryId) {
		TimeEntry readResponse = timeEntryRepository.find(timeEntryId);
		if(readResponse!=null) {
			return new ResponseEntity<TimeEntry>(readResponse,HttpStatus.OK);
		}else {
			return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping
	public ResponseEntity<List<TimeEntry>> list() {
		List<TimeEntry> listcreateResponse = timeEntryRepository.list();
		return new ResponseEntity<List<TimeEntry>>(listcreateResponse,HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<TimeEntry> update(@PathVariable("id") long timeEntryId, @RequestBody TimeEntry expected) {
		TimeEntry updateResponse = timeEntryRepository.update(timeEntryId, expected);
		if(updateResponse!=null) {
			return new ResponseEntity<TimeEntry>(updateResponse,HttpStatus.OK);
		}else {
			return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<TimeEntry> delete(@PathVariable("id") long timeEntryId) {
		timeEntryRepository.delete(timeEntryId);
		return new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);
	}

}
