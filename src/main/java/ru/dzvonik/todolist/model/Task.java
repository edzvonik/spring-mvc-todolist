package ru.dzvonik.todolist.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Task {

    private int id;
    private String title;
    private boolean complete;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
