package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void shouldMapToTask() {
        // Given
        TaskDto taskDto = new TaskDto(1L, "Test Task", "Test Content");

        // When
        Task task = taskMapper.mapToTask(taskDto);

        // Then
        assertEquals(taskDto.getId(), task.getId());
        assertEquals(taskDto.getTitle(), task.getTitle());
        assertEquals(taskDto.getContent(), task.getContent());
    }

    @Test
    public void shouldMapToTaskDto() {
        // Given
        Task task = new Task(1L, "Test Task", "Test Content");

        // When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        // Then
        assertEquals(task.getId(), taskDto.getId());
        assertEquals(task.getTitle(), taskDto.getTitle());
        assertEquals(task.getContent(), taskDto.getContent());
    }

    @Test
    public void shouldMapToTaskDtoList() {
        // Given
        List<Task> taskList = Arrays.asList(
                new Task(1L, "Task 1", "Content 1"),
                new Task(2L, "Task 2", "Content 2"),
                new Task(3L, "Task 3", "Content 3")
        );

        // When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        // Then
        assertEquals(taskList.size(), taskDtoList.size());
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            TaskDto taskDto = taskDtoList.get(i);
            assertEquals(task.getId(), taskDto.getId());
            assertEquals(task.getTitle(), taskDto.getTitle());
            assertEquals(task.getContent(), taskDto.getContent());
        }
    }

}