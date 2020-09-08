package com.example.demo.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.RessourceNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	/* tasks Repository */
	@GetMapping("/tasks")
	public List<Task> getAllTasks() {

		return taskRepository.findAll();
	}

	@PostMapping("/tasks")
	public Task createTask(@RequestBody Task task) {
		return taskRepository.save(task);

	}

	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable long id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Employee not found with id =" + id));
		return ResponseEntity.ok(task);
	}

	@PutMapping("/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody Task taskUpdt) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Employee not found with id =" + id));

		task.setDescription(taskUpdt.getDescription());
		task.setDay_start(taskUpdt.getDay_start());
		task.setDay_end(taskUpdt.getDay_end());
		task.setStatee(taskUpdt.getStatee());

		Task UpdateTask = taskRepository.save(task);
		return ResponseEntity.ok(UpdateTask);
	}

}