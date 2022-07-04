package ru.dzvonik.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dzvonik.todolist.dao.TaskDAO;
import ru.dzvonik.todolist.model.Task;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskDAO taskDAO;

    @Autowired
    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("tasks", taskDAO.index());
        return "tasks";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("task", taskDAO.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("task") Task task) {
        taskDAO.update(id, task);
        return "redirect:/tasks";
    }

}
