# Windows Setup & Execution Guide
## Advanced Java Programming (Practical Experiments 1–30)

This guide provides complete, step-by-step instructions for setting up, installing dependencies, and running all practical experiments on **Windows** in a college lab or examination environment.

---

## Table of Contents
1. [Pre-Check Lab Environment](#1-pre-check-lab-environment)
2. [Java JDK Setup (Experiments 1–12)](#2-java-jdk-setup-experiments-112)
3. [MySQL & JDBC Setup (Experiments 13–20)](#3-mysql--jdbc-setup-experiments-1320)
4. [Apache Maven Setup (Build Tool)](#4-apache-maven-setup-build-tool)
5. [Apache Tomcat Setup (Experiments 21–30)](#5-apache-tomcat-setup-experiments-2130)
6. [Complete URL Directory (Port 8080)](#6-complete-url-directory-port-8080)
7. [Troubleshooting & Common Exam Errors](#7-troubleshooting--common-exam-errors)

---

## 1. Pre-Check Lab Environment

Before downloading anything, check what software is already installed on the lab PC. Open **Command Prompt (`cmd`)**:

```cmd
java -version
javac -version
mysql --version
mvn -version
```

Also check if common lab tools are installed on the machine:
* Check `C:\Program Files\Java\` or `C:\Program Files (x86)\Java\`
* Check `C:\xampp\` (many colleges use XAMPP for Apache & MySQL)
* Check `C:\Program Files\MySQL\` or `C:\Program Files\Apache Software Foundation\`

---

## 2. Java JDK Setup (Experiments 1–12)

If `javac -version` gives `'javac' is not recognized as an internal or external command`:

### Installation:
1. Download **JDK 17 or JDK 21 (Windows x64 Installer)** from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [Eclipse Adoptium](https://adoptium.net/).
2. Run the `.exe` installer. Default path is typically:
   ```text
   C:\Program Files\Java\jdk-21
   ```

### Set Environment Variables:
1. Press `Win + S` → Type **Environment Variables** → Click **Edit the system environment variables**.
2. Click the **Environment Variables...** button.
3. Under **System Variables**, click **New**:
   * **Variable name:** `JAVA_HOME`
   * **Variable value:** `C:\Program Files\Java\jdk-21` (enter your exact installed JDK folder)
4. Under **System Variables**, find the variable named **`Path`** → Click **Edit**:
   * Click **New** → Type: `%JAVA_HOME%\bin`
   * Move it up near the top.
5. Click **OK** on all dialogs.
6. Open a **new Command Prompt** and verify:
   ```cmd
   javac -version
   ```

### Running Swing & Event Handling (Exp 1–12):
Swing and AWT are built into the JDK. No additional libraries are needed.

```cmd
:: Experiments 1–6 (Swing)
cd 01_Swing
javac Exp01_Calculator.java
java Exp01_Calculator

:: Experiments 7–12 (Event Handling)
cd ..\02_Event_Handling
javac Exp08_MouseListenerDemo.java
java Exp08_MouseListenerDemo
```

---

## 3. MySQL & JDBC Setup (Experiments 13–20)

### Step 3.1: Install & Start MySQL

#### Option A: Dedicated MySQL Server (Installer)
1. Download **MySQL Community Server (Windows MSI Installer)** from [dev.mysql.com](https://dev.mysql.com/downloads/installer/).
2. Choose **Server only** (or Developer Default).
3. In the configuration wizard:
   * Keep port as `3306`.
   * Set root password to: `change_me` (matching the codebase).
4. Finish installation. MySQL runs automatically in the background as a Windows service.

#### Option B: Using XAMPP (Common in College Labs)
1. Open **XAMPP Control Panel**.
2. Click **Start** next to **MySQL**.
3. Default user in XAMPP is `root` with no password (`""`). If using XAMPP:
   * Open `03_JDBC\DBUtil.java` and change:
     ```java
     private static final String PASSWORD = "";
     ```

### Step 3.2: Load the Database Schema (`schema.sql`)
Open Command Prompt in your repository directory:
```cmd
mysql -u root -pchange_me < 03_JDBC\schema.sql
```
*(If using XAMPP with no password, run `mysql -u root < 03_JDBC\schema.sql`)*

### Step 3.3: Compiling & Running JDBC Programs
The JDBC driver [`03_JDBC\mysql-connector-j-9.4.0.jar`](03_JDBC/mysql-connector-j-9.4.0.jar) is already included in this repository.

> [!IMPORTANT]
> **Windows Classpath Rule:** In Windows Command Prompt, use a **semicolon (`;`)** as the classpath separator, not a colon (`:`).

Open `cmd` inside `03_JDBC`:
```cmd
cd 03_JDBC

:: 1. Exp 13: Display all students
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp13_DisplayStudents.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp13_DisplayStudents

:: 2. Exp 14: Insert student (interactive prompt)
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp14_InsertStudent.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp14_InsertStudent

:: 3. Exp 15: Update student
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp15_UpdateStudent.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp15_UpdateStudent

:: 4. Exp 16: Delete student
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp16_DeleteStudent.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp16_DeleteStudent

:: 5. Exp 17: Search student
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp17_SearchStudent.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp17_SearchStudent

:: 6. Exp 18: Join tables
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp18_JoinTables.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp18_JoinTables

:: 7. Exp 19: JTable Swing GUI
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp19_StudentsJTable.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp19_StudentsJTable

:: 8. Exp 20: Transactions & Rollback
javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp20_TransactionDemo.java
java -cp ".;mysql-connector-j-9.4.0.jar" Exp20_TransactionDemo
```

---

## 4. Apache Maven Setup (Build Tool)

Maven is required to package the Servlets and JSP web applications into `.war` files.

### Installation:
1. Download the **Binary zip archive** (e.g., `apache-maven-3.9.x-bin.zip`) from [maven.apache.org](https://maven.apache.org/download.cgi).
2. Extract the zip file directly to:
   ```text
   C:\apache-maven
   ```
3. Add to Environment Variables:
   * Open **System Variables** → Edit **`Path`** → Click **New** → Add:
     ```text
     C:\apache-maven\bin
     ```
4. Open a fresh Command Prompt and test:
   ```cmd
   mvn -version
   ```

### Packaging WAR Files:
```cmd
:: Build Servlets WAR
cd 04_Servlets
mvn package

:: Build JSP WAR
cd ..\05_JSP
mvn package
```
This generates:
* `04_Servlets\target\advanced-java-servlets.war`
* `05_JSP\target\advanced-java-jsp.war`

---

## 5. Apache Tomcat Setup (Experiments 21–30)

### Installation:
1. Download **Tomcat 10.1 or Tomcat 11** ("64-bit Windows zip" under Binary Distributions > Core) from [tomcat.apache.org](https://tomcat.apache.org/).
   *(Tomcat 10.1 and 11 support Jakarta Servlet 6.0).*
2. Extract the downloaded zip file directly to:
   ```text
   C:\apache-tomcat
   ```

### Step 5.1: Copy MySQL Driver to Tomcat Shared Library
For JSP pages to connect to MySQL, copy the MySQL Connector jar into Tomcat's `lib` directory:
```cmd
copy 03_JDBC\mysql-connector-j-9.4.0.jar C:\apache-tomcat\lib\
```

### Step 5.2: Deploy Web Applications
Copy both generated `.war` files to Tomcat's `webapps` directory:
```cmd
copy 04_Servlets\target\advanced-java-servlets.war C:\apache-tomcat\webapps\
copy 05_JSP\target\advanced-java-jsp.war C:\apache-tomcat\webapps\
```

### Step 5.3: Start Tomcat
Open Command Prompt and run:
```cmd
cd C:\apache-tomcat\bin
startup.bat
```
A separate Tomcat console window will open. Wait 3–5 seconds until you see:
```text
INFO [main] org.apache.catalina.startup.Catalina.start Server startup in [xxx] milliseconds
```
> [!NOTE]
> Keep the Tomcat console window open while testing your applications in the browser.

### Stopping Tomcat:
When done testing, either close the console window or run:
```cmd
cd C:\apache-tomcat\bin
shutdown.bat
```

---

## 6. Complete URL Directory (Port 8080)

Once Tomcat is running, open your web browser (Chrome / Edge / Firefox) and visit the following URLs:

### Servlets (Experiments 21–25)
Base URL: `http://localhost:8080/advanced-java-servlets/`

| Experiment | Class / File | Browser URL | Action / Input |
| :--- | :--- | :--- | :--- |
| **Exp 21** | `HelloServlet.java` | [http://localhost:8080/advanced-java-servlets/hello](http://localhost:8080/advanced-java-servlets/hello) | Direct GET request; prints "Hello World". |
| **Exp 22** | `StudentDetailsServlet.java` | [http://localhost:8080/advanced-java-servlets/student-form.html](http://localhost:8080/advanced-java-servlets/student-form.html) | Fill Name, Roll, Course → Submits POST to `/student-details`. |
| **Exp 23** | `GetPostServlet.java` | [http://localhost:8080/advanced-java-servlets/get-post](http://localhost:8080/advanced-java-servlets/get-post) | Demonstrates `doGet()` and form submission via `doPost()`. |
| **Exp 24** | `LoginServlet.java` | [http://localhost:8080/advanced-java-servlets/login-form.html](http://localhost:8080/advanced-java-servlets/login-form.html) | Enter credentials `admin` / `java123` → Submits POST to `/login`. |
| **Exp 25** | `SumServlet.java` | [http://localhost:8080/advanced-java-servlets/sum-form.html](http://localhost:8080/advanced-java-servlets/sum-form.html) | Enter two numbers → Submits POST to `/sum`. |

---

### JSP & Database Integration (Experiments 26–30)
Base URL: `http://localhost:8080/advanced-java-jsp/`

| Experiment | File | Browser URL | Action / Input |
| :--- | :--- | :--- | :--- |
| **Exp 26** | `welcome.jsp` | [http://localhost:8080/advanced-java-jsp/welcome.jsp?name=Student](http://localhost:8080/advanced-java-jsp/welcome.jsp?name=Student) | Demonstrates JSP declaration, scriptlet, expression & hit count. |
| **Exp 27** | `students.jsp` | [http://localhost:8080/advanced-java-jsp/students.jsp](http://localhost:8080/advanced-java-jsp/students.jsp) | Connects to MySQL and displays all records in a table. |
| **Exp 28** | `login.jsp` | [http://localhost:8080/advanced-java-jsp/login.jsp](http://localhost:8080/advanced-java-jsp/login.jsp) | JSP login form forwarding to `JspLoginServlet` (`admin` / `java123`). |
| **Exp 29** | `student-insert.jsp` | [http://localhost:8080/advanced-java-jsp/student-insert.jsp](http://localhost:8080/advanced-java-jsp/student-insert.jsp) | Inserts student into MySQL database and refreshes record table. |
| **Exp 30** | `student-management.jsp` | [http://localhost:8080/advanced-java-jsp/student-management.jsp](http://localhost:8080/advanced-java-jsp/student-management.jsp) | Full CRUD: Search by ID, Update student name/course, or Delete by ID. |

---

## 7. Troubleshooting & Common Exam Errors

### 1. `startup.bat` window opens and closes immediately
* **Cause:** `JAVA_HOME` environment variable is not set or points to an invalid path.
* **Fix:** Open `cmd` and run `echo %JAVA_HOME%`. Verify the path exists. If not, set it as shown in [Section 2](#2-java-jdk-setup-experiments-112).

### 2. `ClassNotFoundException: com.mysql.cj.jdbc.Driver`
* **In Command Line (JDBC):** Ensure you use a **semicolon (`;`)** on Windows:
  ```cmd
  javac -cp ".;mysql-connector-j-9.4.0.jar" DBUtil.java Exp13_DisplayStudents.java
  java -cp ".;mysql-connector-j-9.4.0.jar" Exp13_DisplayStudents
  ```
* **In JSP / Tomcat:** Ensure `mysql-connector-j-9.4.0.jar` was copied into `C:\apache-tomcat\lib\`.

### 3. Port 8080 Already in Use
* **Cause:** Oracle Database (`XDB`), another Tomcat instance, or IIS is using port 8080.
* **Fix:**
  1. Open `C:\apache-tomcat\conf\server.xml` in Notepad.
  2. Find `<Connector port="8080" protocol="HTTP/1.1"`
  3. Change `8080` to `8081` or `8090`.
  4. Save and restart Tomcat. Access via `http://localhost:8081/...`.

### 4. `Access denied for user 'root'@'localhost'`
* **Cause:** MySQL root password doesn't match `change_me`.
* **Fix:** Check your local MySQL password. Update `PASSWORD` in `03_JDBC\DBUtil.java` and in the JSP files (`students.jsp`, `student-insert.jsp`, `student-management.jsp`) to match your lab password (or `""` for empty password).

### 5. `javac: file not found: ExpNN_*.java`
* **Fix:** Make sure your `cmd` prompt is in the exact folder where the `.java` files are located (`cd 01_Swing`, `cd 03_JDBC`, etc.). Use `dir` to verify the files are present.
