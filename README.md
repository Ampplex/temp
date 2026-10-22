# Skill-Based Course V – Advanced Java Programming
## Complete Windows Practical Guide (All 30 Experiments)

This repository contains beginner-friendly implementations for all 30 practical experiments. Each `ExpNN_*.java` class is a standalone program unless noted otherwise.

This guide is written specifically for **Windows** (Command Prompt / PowerShell) in college laboratory and examination environments.

---

## Prerequisites on Windows

Before starting, check what is already installed on your lab PC by opening **Command Prompt (`cmd`)**:
```cmd
java -version
javac -version
mysql --version
mvn -version
```

### 1. Java JDK (JDK 17 or 21)
* If `javac` is not recognized, install **JDK 17 or 21** (x64 Windows installer) to `C:\Program Files\Java\jdk-21`.
* **Set Environment Variables**:
  1. Open Start → Search **Environment Variables** → Click **Edit the system environment variables**.
  2. Click **Environment Variables...** button.
  3. Under **System Variables**, click **New**:
     * **Variable Name:** `JAVA_HOME`
     * **Variable Value:** `C:\Program Files\Java\jdk-21` (your JDK folder)
  4. Under **System Variables**, select **`Path`** → Click **Edit** → Click **New** → Add:
     ```text
     %JAVA_HOME%\bin
     ```
  5. Click **OK** on all windows, then open a fresh `cmd` window.

---

## 1. Swing (Experiments 1–6)

Swing is included with the JDK; no external libraries are needed.

Open `cmd` in the `01_Swing` folder:
```cmd
cd 01_Swing
javac Exp01_Calculator.java
java Exp01_Calculator
```

Replace `Exp01_Calculator` with any experiment:
* `Exp01_Calculator.java` – Arithmetic calculator with GUI
* `Exp02_RegistrationForm.java` – Student registration form
* `Exp03_LayoutDemo.java` – FlowLayout, BorderLayout, GridLayout in tabs
* `Exp04_TemperatureConverter.java` – Celsius ↔ Fahrenheit converter
* `Exp05_StudentInfoDialog.java` – Form with JOptionPane popups
* `Exp06_NotepadMenu.java` – Text editor with File Open and Save menu

---

## 2. Event Handling (Experiments 7–12)

Open `cmd` in the `02_Event_Handling` folder:
```cmd
cd 02_Event_Handling
javac Exp08_MouseListenerDemo.java
java Exp08_MouseListenerDemo
```

Replace with any experiment:
* `Exp07_LoginValidation.java` – Login button event check (`admin` / `java123`)
* `Exp08_MouseListenerDemo.java` – Mouse clicks, enter, exit, and coordinates
* `Exp09_KeyListenerDemo.java` – Key typed, pressed, and released events
* `Exp10_MouseAdapterDemo.java` – Mouse adapter click coordinates
* `Exp11_FourOperationsListener.java` – Inner class, anonymous, and lambda listeners
* `Exp12_ColorChooserDemo.java` – JColorChooser background changer

---

## 3. JDBC (Experiments 13–20)

### Step 3.1: Start MySQL
* **If using MySQL Server:** Ensure the MySQL service is running. Default credentials are user `root`, password `change_me`, port `3306`.
* **If using XAMPP:** Open **XAMPP Control Panel** and click **Start** next to **MySQL**. If the root password is empty in XAMPP, open [03_JDBC/DBUtil.java](03_JDBC/DBUtil.java) and change `PASSWORD = "change_me"` to `PASSWORD = ""`.

### Step 3.2: Load the Database Schema
Open `cmd` in the project root directory and run:
```cmd
mysql -u root -pchange_me < 03_JDBC\schema.sql
```
*(If password is empty, run `mysql -u root < 03_JDBC\schema.sql`)*

This creates the `college` database, `departments` and `students` tables, and sample rows.

### Step 3.3: Compile & Run on Windows
The required driver `mysql-connector-j-9.4.0.jar` is already located in the `03_JDBC` folder.

> [!IMPORTANT]
> **Windows Classpath Rule:** In Windows Command Prompt, use a **semicolon (`;`)** as the classpath separator, not a colon (`:`).

Open `cmd` in `03_JDBC`:
```cmd
cd 03_JDBC

:: Exp 13: Display all students
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp13_DisplayStudents.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp13_DisplayStudents

:: Exp 14: Insert student (interactive)
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp14_InsertStudent.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp14_InsertStudent

:: Exp 15: Update student
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp15_UpdateStudent.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp15_UpdateStudent

:: Exp 16: Delete student
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp16_DeleteStudent.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp16_DeleteStudent

:: Exp 17: Search student by ID or Name
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp17_SearchStudent.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp17_SearchStudent

:: Exp 18: Join tables (Students + Departments)
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp18_JoinTables.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp18_JoinTables

:: Exp 19: JTable Swing database viewer
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp19_StudentsJTable.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp19_StudentsJTable

:: Exp 20: Transaction commit & rollback demo
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp20_TransactionDemo.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp20_TransactionDemo
```

---

## 4. Servlets (Experiments 21–25)

These servlets use Jakarta Servlet 6 (`jakarta.servlet.*`) annotations like `@WebServlet`. No `web.xml` is needed.

### Setup Tools on Windows
1. **Maven**: Download binary zip from [maven.apache.org](https://maven.apache.org/download.cgi), extract to `C:\apache-maven`, and add `C:\apache-maven\bin` to `Path`.
2. **Tomcat**: Download **Tomcat 10.1 or 11 (64-bit Windows zip)** from [tomcat.apache.org](https://tomcat.apache.org/) and extract to `C:\apache-tomcat`.

### Build & Deploy on Windows
1. Open `cmd` in `04_Servlets` and build the WAR package:
   ```cmd
   cd 04_Servlets
   mvn package
   ```
2. Deploy the WAR file to Tomcat's `webapps` folder:
   ```cmd
   copy target\advanced-java-servlets.war C:\apache-tomcat\webapps\
   ```
3. Start Tomcat:
   ```cmd
   cd C:\apache-tomcat\bin
   startup.bat
   ```
   A separate Tomcat console window will pop up. Keep this window open.

### Accessing Servlets in Browser (Port 8080)
* **Exp 21 (Hello World):** [http://localhost:8080/advanced-java-servlets/hello](http://localhost:8080/advanced-java-servlets/hello)
* **Exp 22 (Student Form):** [http://localhost:8080/advanced-java-servlets/student-form.html](http://localhost:8080/advanced-java-servlets/student-form.html) (submits POST to `/student-details`)
* **Exp 23 (doGet vs doPost):** [http://localhost:8080/advanced-java-servlets/get-post](http://localhost:8080/advanced-java-servlets/get-post)
* **Exp 24 (Login Form):** [http://localhost:8080/advanced-java-servlets/login-form.html](http://localhost:8080/advanced-java-servlets/login-form.html) (credentials `admin` / `java123`, submits to `/login`)
* **Exp 25 (Two-Number Sum):** [http://localhost:8080/advanced-java-servlets/sum-form.html](http://localhost:8080/advanced-java-servlets/sum-form.html) (submits to `/sum`)

---

## 5. JSP and Database Integration (Experiments 26–30)

These JSP pages connect to the `college` database in MySQL.

### Setup on Windows
1. Ensure MySQL is running and the database schema is loaded (see Section 3).
2. **Copy the MySQL JDBC Driver to Tomcat `lib`** (required for JSP database connections):
   ```cmd
   copy 03_JDBC\mysql-connector-j-9.4.0.jar C:\apache-tomcat\lib\
   ```

### Build & Deploy on Windows
1. Open `cmd` in `05_JSP` and build the WAR package:
   ```cmd
   cd 05_JSP
   mvn package
   ```
2. Deploy the WAR file to Tomcat's `webapps` folder:
   ```cmd
   copy target\advanced-java-jsp.war C:\apache-tomcat\webapps\
   ```
3. If Tomcat is already running, it automatically redeploys. If not, start it:
   ```cmd
   cd C:\apache-tomcat\bin
   startup.bat
   ```

### Accessing JSP in Browser (Port 8080)
* **Exp 26 (Welcome JSP):** [http://localhost:8080/advanced-java-jsp/welcome.jsp?name=Student](http://localhost:8080/advanced-java-jsp/welcome.jsp?name=Student) (JSP declaration, scriptlet, expression & hit count)
* **Exp 27 (Display MySQL Records):** [http://localhost:8080/advanced-java-jsp/students.jsp](http://localhost:8080/advanced-java-jsp/students.jsp) (queries and renders student table)
* **Exp 28 (JSP Login):** [http://localhost:8080/advanced-java-jsp/login.jsp](http://localhost:8080/advanced-java-jsp/login.jsp) (submits to `JspLoginServlet`, credentials `admin` / `java123`)
* **Exp 29 (Insert Student via JSP):** [http://localhost:8080/advanced-java-jsp/student-insert.jsp](http://localhost:8080/advanced-java-jsp/student-insert.jsp) (inserts record and updates display)
* **Exp 30 (CRUD Student Management):** [http://localhost:8080/advanced-java-jsp/student-management.jsp](http://localhost:8080/advanced-java-jsp/student-management.jsp) (Search by ID, Update name/course, Delete by ID)

### Stopping Tomcat
When you are done testing:
```cmd
cd C:\apache-tomcat\bin
shutdown.bat
```

---

## Demo Credentials
For all hard-coded login demonstrations:
* **Username:** `admin`
* **Password:** `java123`

---

## Windows Practical Exam Troubleshooting

| Issue | Cause | Fix on Windows |
| :--- | :--- | :--- |
| `startup.bat` window flashes and closes | `JAVA_HOME` is not set | In Windows Environment Variables, set `JAVA_HOME` = `C:\Program Files\Java\jdk-21`. |
| `ClassNotFoundException: com.mysql.cj.jdbc.Driver` | Classpath error or missing jar | In `cmd`, use semicolon (`;`) in `-cp ".;mysql-connector-j-9.4.0.jar"`. For JSP, copy the jar to `C:\apache-tomcat\lib\`. |
| `Access denied for user 'root'@'localhost'` | MySQL password mismatch | Change `PASSWORD` in [03_JDBC/DBUtil.java](03_JDBC/DBUtil.java) to match your local MySQL password (or `""` for empty password). |
| Port 8080 already in use | Another application using 8080 | Open `C:\apache-tomcat\conf\server.xml`, change `port="8080"` to `port="8081"`, save, and access via `http://localhost:8081/...`. |
| `mvn` is not recognized | Maven not in `Path` | Add `C:\apache-maven\bin` to your System Variables `Path` and restart Command Prompt. |

---

## Expected Behavior Quick Reference (1–30)
1. Calculator performs +, -, *, / with zero-division handling.
2. Registration form gathers name, roll, gender, course, and subjects.
3. Layout demo switches between FlowLayout, BorderLayout, and GridLayout.
4. Converts temperature between Celsius and Fahrenheit in real time.
5. Displays student info dialogs with JOptionPane.
6. Simple notepad with File Open and Save menu options.
7. Login button validates credentials (`admin` / `java123`).
8. Mouse listener logs clicks, coordinates, and events.
9. Key listener tracks pressed, released, and typed characters.
10. MouseAdapter records click points cleanly.
11. Four operations using different listener styles (named, inner, anonymous, lambda).
12. Color chooser dynamically changes the panel's background color.
13. Displays all student records in console table format.
14. Inserts student using parameterized PreparedStatement.
15. Updates student name and course by ID.
16. Deletes student by ID.
17. Searches student records by ID or name substring.
18. Performs SQL JOIN between Students and Departments.
19. Displays student records in a Swing JTable window.
20. Demonstrates transaction commit and rollback on failure.
21. Servlets Hello World page in browser.
22. HTML form submits student details to servlet via POST.
23. Demonstrates `doGet()` and `doPost()` in a single servlet.
24. Validates login credentials through a servlet.
25. Calculates the sum of two numbers submitted through an HTML form.
26. Demonstrates JSP declaration, scriptlet, expression, and page hit counter.
27. Displays live MySQL student table directly via JSP.
28. Forwards JSP form data to servlet for credential validation.
29. Inserts a new student and re-renders the database table on the same page.
30. Complete student management system (Search, Update, Delete) in JSP.
