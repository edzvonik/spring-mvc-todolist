package ru.dzvonik.todolist.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Task {

    private int id;
    private String title;
    private boolean complete;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date updatedAt;

}
