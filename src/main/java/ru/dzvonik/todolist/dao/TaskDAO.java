package ru.dzvonik.todolist.dao;

import org.springframework.stereotype.Component;
import ru.dzvonik.todolist.model.Task;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskDAO {

    static final String URL = "jdbc:h2:mem:todolist";
    static final String USERNAME = "sa";
    static final String PASSWORD = "";

    private static Connection connection;

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM tasks";
            ResultSet rs = statement.executeQuery(SQL);

            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");

                // LocalDate dateToLD = created_at.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                Task task = new Task(id, title);
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

}
