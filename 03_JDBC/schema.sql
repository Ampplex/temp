CREATE DATABASE IF NOT EXISTS college;
USE college;

CREATE TABLE IF NOT EXISTS departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(80) NOT NULL
);

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(120),
    course VARCHAR(80),
    dept_id INT DEFAULT 1,
    CONSTRAINT fk_students_department FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
);

INSERT IGNORE INTO departments(dept_id, dept_name) VALUES
(1, 'Computer Science'), (2, 'Information Technology'), (3, 'Electronics');

INSERT INTO students(name, age, email, course, dept_id)
SELECT 'Asha', 20, 'asha@example.com', 'B.Tech CSE', 1
WHERE NOT EXISTS (SELECT 1 FROM students WHERE email = 'asha@example.com');
INSERT INTO students(name, age, email, course, dept_id)
SELECT 'Rohan', 21, 'rohan@example.com', 'B.Tech IT', 2
WHERE NOT EXISTS (SELECT 1 FROM students WHERE email = 'rohan@example.com');
