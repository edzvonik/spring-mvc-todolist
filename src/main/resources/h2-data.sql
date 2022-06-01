CREATE TABLE todolist.tasks(
  id INT NOT NULL,
  title VARCHAR NOT NULL,
  is_complete BOOLEAN,
  created_at DATE NOT NULL
);

INSERT INTO todolist.tasks VALUES (1, 'buy milk', false, '2022-06-01');
INSERT INTO todolist.tasks VALUES (2, 'learn 10 spain words', true, '2022-06-02');
INSERT INTO todolist.tasks VALUES (3, 'wash the cat', false, '2022-06-02');