package com.example.question5_task_api.controller;

import com.example.question5_task_api.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    // STEP 4.1: Sample data
    public TaskController() {
        tasks.add(new Task(1L, "Study Spring Boot", "Practice REST APIs", false, "HIGH", "2026-02-15"));
        tasks.add(new Task(2L, "Do assignment", "Finish Question 5", false, "MEDIUM", "2026-02-18"));
        tasks.add(new Task(3L, "Clean room", "Organize desk", true, "LOW", "2026-02-10"));
    }

        @GetMapping
    public List<Task> getAllTasks() {
        return tasks;
    }

        @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        for (Task t : tasks) {
            if (t.getTaskId().equals(taskId)) {
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }

        @GetMapping("/status")
    public List<Task> getByStatus(@RequestParam boolean completed) {
        List<Task> result = new ArrayList<>();
        for (Task t : tasks) {
            if (t.isCompleted() == completed) {
                result.add(t);
            }
        }
        return result;
    }

        @GetMapping("/priority/{priority}")
    public List<Task> getByPriority(@PathVariable String priority) {
        List<Task> result = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getPriority().equalsIgnoreCase(priority)) {
                result.add(t);
            }
        }
        return result;
    }

        @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        tasks.add(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

        @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long taskId,
            @RequestBody Task updated) {

        for (Task t : tasks) {
            if (t.getTaskId().equals(taskId)) {
                t.setTitle(updated.getTitle());
                t.setDescription(updated.getDescription());
                t.setPriority(updated.getPriority());
                t.setDueDate(updated.getDueDate());
                t.setCompleted(updated.isCompleted());
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }


        @PatchMapping("/{taskId}/complete")
    public ResponseEntity<Task> markCompleted(@PathVariable Long taskId) {
        for (Task t : tasks) {
            if (t.getTaskId().equals(taskId)) {
                t.setCompleted(true);
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }

        @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        for (Task t : tasks) {
            if (t.getTaskId().equals(taskId)) {
                tasks.remove(t);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}








