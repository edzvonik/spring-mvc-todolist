package ru.dzvonik.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dzvonik.todolist.dao.TaskDAO;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskDAO taskDAO;

    @Autowired
    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GetMapping()
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskDAO.getTasks());
        return "tasks";
    }

}
