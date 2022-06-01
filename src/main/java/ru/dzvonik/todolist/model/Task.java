package ru.dzvonik.todolist.model;

import java.time.LocalDate;

public class Task {

    private int id;
    private String title;
    private boolean is_complete;
    private LocalDate created_at;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        is_complete = false;
        created_at = LocalDate.now();
    }

    public Task(int id, String title, boolean is_complete, LocalDate created_at) {
        this.id = id;
        this.title = title;
        this.is_complete = is_complete;
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isIs_complete() {
        return is_complete;
    }

    public void setIs_complete(boolean is_complete) {
        this.is_complete = is_complete;
    }

    public int getId() {
        return id;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }
}
