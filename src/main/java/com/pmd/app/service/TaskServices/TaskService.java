package com.pmd.app.service.TaskServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmd.app.model.TaskModels.Task;
import com.pmd.app.model.TeamModels.ChatGroup;
import com.pmd.app.repository.TasksRepositories.TaskRepository;
import com.pmd.app.repository.TeamRepositories.ChatGroupRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    private ChatGroupRepository chatGroupRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task closeTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(true); // Assuming true means the task is closed
        taskRepository.save(task);

        // Check if all tasks in each associated chat group are closed
        for (ChatGroup chatGroup : task.getChatGroups()) {
            boolean allTasksClosed = chatGroup.getTasks().stream().allMatch(Task::getStatus);
            if (allTasksClosed) {
                closeChatGroup(chatGroup);
            }
        }

        return task;
    }

    private void closeChatGroup(ChatGroup chatGroup) {
        chatGroup.setStatus(true); // Assuming true means the chat group is closed
        chatGroupRepository.save(chatGroup);
    }
}