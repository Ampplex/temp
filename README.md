# Skill-Based Course V – Advanced Java Programming
## Implementations for all 30 practical experiments

This folder contains beginner-friendly source code grouped by topic. Each `ExpNN_*.java` class is a separate program unless noted otherwise.

## 1. Swing (Experiments 1–6)
Open a terminal in `01_Swing` and compile/run one experiment:

```bash
javac Exp01_Calculator.java
java Exp01_Calculator
```

Replace the class/file name for another experiment. Swing is included with the JDK; no extra library is required.

## 2. Event handling (Experiments 7–12)
Use the same command inside `02_Event_Handling`, for example:

```bash
javac Exp08_MouseListenerDemo.java
java Exp08_MouseListenerDemo
```

## 3. JDBC (Experiments 13–20)
1. Install MySQL Server and create/open a SQL client.
2. Run `03_JDBC/schema.sql` to create the `college` database, `students` and `departments` tables, and sample records.
3. In `03_JDBC/DBUtil.java`, set `USER` and `PASSWORD` for your MySQL account.
4. Add MySQL Connector/J to your classpath. For example, if `mysql-connector-j-<version>.jar` is in this folder:

macOS/Linux:
```bash
javac -cp ".:mysql-connector-j-<version>.jar" DBUtil.java Exp13_DisplayStudents.java
java -cp ".:mysql-connector-j-<version>.jar" Exp13_DisplayStudents
```
Windows uses `;` rather than `:` in the classpath. Compile the desired `ExpNN_*.java` alongside `DBUtil.java`; Experiment 19 opens a Swing table window.

The JDBC examples use these columns: `id`, `name`, `age`, `email`, `course`, `dept_id`. If your college lab schema differs, update the SQL and column names accordingly.

## 4. Servlets (Experiments 21–25)
These examples use the `jakarta.servlet.*` namespace for Tomcat 10+. They use annotations such as `@WebServlet`, so no `web.xml` is required. The HTML forms belong in `src/main/webapp`; Java servlet classes belong in `src/main/java`.

With Maven installed, from `04_Servlets` run:
```bash
mvn package
```
Deploy `target/advanced-java-servlets.war` to Tomcat 10.1 or another compatible Jakarta Servlet 6 container. Then use URLs such as `/advanced-java-servlets/hello`, `/advanced-java-servlets/student-form.html`, `/advanced-java-servlets/login-form.html`, `/advanced-java-servlets/sum-form.html`, and `/advanced-java-servlets/get-post`.

If your lab uses Tomcat 9, it expects `javax.servlet.*`, not `jakarta.servlet.*`; change the imports and use the matching Servlet API dependency/container version.

## 5. JSP and database integration (Experiments 26–30)
The JSP examples are in `05_JSP/src/main/webapp`. The JSP web app uses `jakarta.servlet` and MySQL Connector/J in its `pom.xml`. Update the MySQL username/password in each JSP file before running. Build with `mvn package` from `05_JSP` and deploy the generated WAR to a compatible Tomcat 10.1 server. The MySQL Connector/J dependency is included for this web app.

URLs after deployment include `/advanced-java-jsp/welcome.jsp`, `/advanced-java-jsp/students.jsp`, `/advanced-java-jsp/login.jsp`, `/advanced-java-jsp/student-insert.jsp`, and `/advanced-java-jsp/student-management.jsp`.

## Demo credentials
For the hard-coded login experiments, use:
- Username: `admin`
- Password: `java123`

These credentials are for classroom demonstrations only. Do not use hard-coded passwords in real applications.

## Expected behavior quick list
1. Calculator performs +, -, *, / and handles division by zero.
2. Registration form gathers name, roll, gender, course and selected subjects.
3. Tabs demonstrate FlowLayout, BorderLayout and GridLayout.
4. Converts temperatures in both directions.
5. Displays entered student information.
6. Opens and saves plain-text files via a menu.
7. Shows login success or invalid credentials.
8. Displays mouse events and coordinates.
9. Displays key press/type/release information.
10. Shows click coordinates using MouseAdapter.
11. Performs four arithmetic operations using different listener styles.
12. Opens a color chooser and changes panel background.
13. Prints all student records.
14. Inserts a student using PreparedStatement.
15. Updates student name and course by ID.
16. Deletes a student by ID.
17. Searches by ID or partial name.
18. Uses an SQL JOIN to show department names.
19. Shows records in a JTable.
20. Commits two updates together or rolls both back if an ID is missing.
21. Prints “Hello World” in the browser.
22. Accepts student details and prints them.
23. Demonstrates doGet and doPost.
24. Validates hard-coded login credentials.
25. Calculates the sum of two submitted numbers.
26. Demonstrates JSP declaration, scriptlet, expression and comment.
27. Displays records from MySQL.
28. Sends JSP login form to a servlet for validation.
29. Inserts a student and displays the current records.
30. Searches, updates and deletes student records.

## Exam tip
For each practical, remember the **aim**, important classes/methods, how to run it, and one or two lines explaining the output. Practice typing rather than memorizing every character.
