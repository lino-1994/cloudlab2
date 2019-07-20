package hello.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Event;
import hello.repository.EventsRepository;

@RestController
public class EventsController {

    @Autowired
    EventsRepository eventsRepository;

    @GetMapping("/events")
    public List<Event> fetchEvents() {
        return eventsRepository.findAll();
    }
    

    @PostMapping("/events")
    public Event postEvents(@RequestBody Event event){
    	eventsRepository.save(event);
    	return event;
    }
    
    @GetMapping("/events/search")
    public Event searchEvent(@RequestParam(defaultValue = "1") long id) {
        return eventsRepository.findById(id).get();
    }
    
    @PutMapping ("/events/update/{id}")
    public ResponseEntity<Object> updateEvent(@PathVariable long id, @RequestBody Event newEvent) {
    	Optional<Event> optEvent= eventsRepository.findById(id);
    	if (optEvent.isPresent()) {
    		newEvent.setId(id);
    		eventsRepository.save(newEvent);
    		return ResponseEntity.noContent().build();
    	}
    	return ResponseEntity.notFound().build();
    	
    }
    
    @DeleteMapping ("/events/delete")
    public void deleteEvents(@RequestParam long id){
    	eventsRepository.deleteById(id);
    }
}

