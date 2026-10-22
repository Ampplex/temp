# Skill-Based Course V – Advanced Java Programming
chats: https://chatgpt.com/share/6ad91399-7c2c-83e8-bacf-9a1cfacd3087?ogimg=plain

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
1. Install and start MySQL Server:
   ```bash
   brew install mysql
   brew services start mysql
   ```
2. Initialize the `college` database with tables and sample records:
   ```bash
   mysql -u root -pchange_me < 03_JDBC/schema.sql
   ```
3. `03_JDBC/DBUtil.java` is preconfigured for user `root` and password `change_me` on port 3306.
4. The driver jar `mysql-connector-j-9.4.0.jar` is already placed inside `03_JDBC/`.
5. Compile and run:

macOS/Linux:
```bash
cd 03_JDBC
javac -cp ".:mysql-connector-j-9.4.0.jar" DBUtil.java Exp13_DisplayStudents.java
java -cp ".:mysql-connector-j-9.4.0.jar" Exp13_DisplayStudents
```
Windows (use `;` as classpath separator):
```cmd
cd 03_JDBC
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp13_DisplayStudents.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp13_DisplayStudents
```

Replace `Exp13_DisplayStudents` with the desired experiment name (`Exp14_InsertStudent`, `Exp15_UpdateStudent`, `Exp16_DeleteStudent`, `Exp17_SearchStudent`, `Exp18_JoinTables`, `Exp19_StudentsJTable`, `Exp20_TransactionDemo`).

## 4. Servlets (Experiments 21–25)
These examples use Jakarta Servlet 6 (`jakarta.servlet.*`) annotations like `@WebServlet`.

### Prerequisites
Install Maven and Tomcat (if not already installed):
```bash
brew install maven tomcat
```

### Build & Deploy
1. Build the WAR package:
   ```bash
   cd 04_Servlets
   mvn package
   ```
2. Deploy `target/advanced-java-servlets.war` to Tomcat's `webapps` folder:
   ```bash
   cp target/advanced-java-servlets.war /opt/homebrew/opt/tomcat/libexec/webapps/
   ```
3. Start or restart Tomcat:
   ```bash
   brew services restart tomcat
   # OR run directly in the foreground:
   catalina run
   ```

### Accessing in Browser (Port 8080)
* **Exp 21 (Hello World):** [http://localhost:8080/advanced-java-servlets/hello](http://localhost:8080/advanced-java-servlets/hello)
* **Exp 22 (Student Form):** [http://localhost:8080/advanced-java-servlets/student-form.html](http://localhost:8080/advanced-java-servlets/student-form.html) (submits POST to `/student-details`)
* **Exp 23 (doGet vs doPost):** [http://localhost:8080/advanced-java-servlets/get-post](http://localhost:8080/advanced-java-servlets/get-post)
* **Exp 24 (Login Validation):** [http://localhost:8080/advanced-java-servlets/login-form.html](http://localhost:8080/advanced-java-servlets/login-form.html) (submits POST to `/login`, credentials `admin` / `java123`)
* **Exp 25 (Two-Number Sum):** [http://localhost:8080/advanced-java-servlets/sum-form.html](http://localhost:8080/advanced-java-servlets/sum-form.html) (submits POST to `/sum`)

## 5. JSP and Database Integration (Experiments 26–30)
The JSP web application integrates with MySQL using `mysql-connector-j-9.4.0.jar`.

### Prerequisites
1. Ensure MySQL is running and the `college` database is loaded (see Section 3).
2. Ensure MySQL Connector/J is in Tomcat's shared `lib/` directory:
   ```bash
   cp 03_JDBC/mysql-connector-j-9.4.0.jar /opt/homebrew/opt/tomcat/libexec/lib/
   ```

### Build & Deploy
1. Build the WAR package:
   ```bash
   cd 05_JSP
   mvn package
   ```
2. Deploy `target/advanced-java-jsp.war` to Tomcat's `webapps` folder:
   ```bash
   cp target/advanced-java-jsp.war /opt/homebrew/opt/tomcat/libexec/webapps/
   ```
3. Restart Tomcat to apply updates:
   ```bash
   brew services restart tomcat
   ```

### Accessing in Browser (Port 8080)
* **Exp 26 (Welcome JSP):** [http://localhost:8080/advanced-java-jsp/welcome.jsp?name=Student](http://localhost:8080/advanced-java-jsp/welcome.jsp?name=Student)
* **Exp 27 (Display Students from MySQL):** [http://localhost:8080/advanced-java-jsp/students.jsp](http://localhost:8080/advanced-java-jsp/students.jsp)
* **Exp 28 (JSP Login to Servlet):** [http://localhost:8080/advanced-java-jsp/login.jsp](http://localhost:8080/advanced-java-jsp/login.jsp) (submits to `/jsp-login`, credentials `admin` / `java123`)
* **Exp 29 (Insert Student via JSP):** [http://localhost:8080/advanced-java-jsp/student-insert.jsp](http://localhost:8080/advanced-java-jsp/student-insert.jsp)
* **Exp 30 (Search, Update & Delete Records):** [http://localhost:8080/advanced-java-jsp/student-management.jsp](http://localhost:8080/advanced-java-jsp/student-management.jsp)

### Stopping Tomcat
When you are done testing:
```bash
brew services stop tomcat
```

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
