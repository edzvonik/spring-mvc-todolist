package ru.dzvonik.todolist.dao;

import org.springframework.stereotype.Component;
import ru.dzvonik.todolist.model.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskDAO {

    private static String URL = "jdbc:h2:mem:todolist";
    private static String USERNAME = "sa";
    private static String PASSWORD = "";

    private static Connection connection;

    static {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Task> index() {
        List<Task> tasks = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tasks");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                boolean complete = rs.getBoolean("is_complete");
                LocalDate createdAt = rs.getDate("created_at").toLocalDate();
                LocalDate updatedAt = rs.getDate("updated_at").toLocalDate();

                Task task = Task.builder()
                        .id(id)
                        .title(title)
                        .complete(complete)
                        .createdAt(createdAt)
                        .updatedAt(updatedAt)
                        .build();
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    public Task show(int id) {
        Task task = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tasks WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int taskId = rs.getInt("id");
                String title = rs.getString("title");
                boolean complete = rs.getBoolean("is_complete");
                LocalDate createdAt = rs.getDate("created_at").toLocalDate();
                LocalDate updatedAt = rs.getDate("updated_at").toLocalDate();

                task = Task.builder()
                        .id(taskId)
                        .title(title)
                        .complete(complete)
                        .createdAt(createdAt)
                        .updatedAt(updatedAt)
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return task;
    }

    public void update(int id, Task task) {
        try {
            String query = "UPDATE tasks SET title=?, is_complete=?, created_at=?, updated_at=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            ps.setString(1, task.getTitle());
            ps.setBoolean(2, task.isComplete());
            ps.setDate(3, java.sql.Date.valueOf(task.getCreatedAt()));
            ps.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
            ps.setInt(5, task.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
