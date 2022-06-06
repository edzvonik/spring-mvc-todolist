package ru.dzvonik.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping(value = "/{id}/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Task edit(@PathVariable("id") int id) {
        return taskDAO.show(id);
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute Task task, @PathVariable("id") int id) {
        taskDAO.update(id, task);
        return "redirect:/tasks";
    }

}
