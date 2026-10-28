# Library Book Manager (JSP + Servlet + JDBC + MySQL)

A starter library-management web app for Eclipse. It supports adding books, registering borrowers, issuing available copies, viewing issue history and marking books returned. Uses prepared statements and transactions for issue/return stock updates.

## Requirements
- JDK 11 or newer
- Eclipse IDE for Enterprise Java and Web Developers (or Eclipse with Web Tools)
- Apache Tomcat 11.0 (important: this project uses `jakarta.servlet`, so use Tomcat 11, not Tomcat 10/11)
- MySQL Server 8.x and MySQL Workbench
- Maven (Eclipse m2e can manage Maven dependencies)

## 1. Create the database
1. Open MySQL Workbench and connect to your local MySQL server.
2. Open `database/schema.sql` and execute the whole script.
3. This creates `book_issue_tracker` and tables `books`, `borrowers`, `issues`, with two sample books.

## 2. Configure the database password
Set the `BOOKTRACKER_DB_PASSWORD` environment variable before starting Tomcat; do not store the database password in source code. In PowerShell, for example, run `$env:BOOKTRACKER_DB_PASSWORD = '<your password>'` in the same session used to start Tomcat. The default connection is `localhost:3306`.

Alternative: pass JVM system properties to Tomcat:
- `-Dbooktracker.db.url=jdbc:mysql://localhost:3306/book_issue_tracker?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC`
- `-Dbooktracker.db.user=root`
- `-Dbooktracker.db.password=your_password`

## 3. Import into Eclipse
1. Extract `LibraryBookManager.zip` to a folder.
2. In Eclipse choose **File → Import → Maven → Existing Maven Projects**.
3. Select the extracted `LibraryBookManager` folder (the one containing `pom.xml`) and finish.
4. Wait for Maven dependencies to download. If needed, right-click project → **Maven → Update Project**.
5. Configure Tomcat 11: **Window → Show View → Servers** → create a new Apache Tomcat v9.0 server and point it to your Tomcat installation.
6. Right-click project → **Run As → Run on Server** and select Tomcat 11.
7. Open `http://localhost:8080/LibraryBookManager/`.

## 4. How it works
- `books`: title, author, ISBN, total copies, available copies
- `borrowers`: name, email, phone
- `issues`: book/borrower foreign keys, issue date, due date, return date and status
- `TrackerDAO`: JDBC operations
- `DashboardServlet`: loads dashboard data
- `ActionServlet`: handles add book, add borrower, issue and return actions
- `index.jsp`: UI and inventory/borrower/issue tables

## Troubleshooting
- **Access denied for user**: verify the MySQL username/password in `DBUtil.java`.
- **Unknown database `book_issue_tracker`**: execute `database/schema.sql` in Workbench.
- **Driver not found**: right-click project → Maven → Update Project; confirm MySQL Connector/J dependency downloaded.
- **404 error**: verify Tomcat 11 is running and use `/LibraryBookManager/` context path.
- **Tomcat 10 errors about `jakarta.servlet`**: use Tomcat 11 for this project, because Tomcat 10 changed the API namespace to `jakarta.servlet`.

This is a learning/demo project. Add authentication, CSRF protection, and role-based access before deploying it publicly.
