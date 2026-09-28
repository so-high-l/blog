# Blog

A lightweight blog web application built with **Java EE**, **JSP**, **Servlets**, and **MySQL**—without a large application framework.

The project demonstrates a classic MVC-style web application with:

- User registration and login
- Session-based authentication
- Blog post creation and deletion
- Categories for posts
- Likes and comments
- Trending posts based on engagement
- User profiles with authored and liked posts
- JSP-based views with custom CSS and JavaScript

## Technology stack

- **Java 16**
- **Java EE Servlets and JSP**
- **Apache Tomcat 8.5**
- **MySQL**
- **JDBC** with the MySQL Connector/J driver
- **HTML, CSS, and JavaScript**
- **JSTL** tag libraries
- **Maven** for dependency management and WAR packaging

## Project structure

```text
.
├── pom.xml                  # Maven build and dependency configuration
├── src/main/java/
│   ├── dao/                 # Database access and persistence logic
│   ├── metier/              # Domain models such as Post, User, Comment, and Like
│   ├── package_test/        # Test or development-related classes
│   └── web/                 # Servlet controller and request models
├── src/main/webapp/
│   ├── WEB-INF/             # Web deployment descriptor
│   ├── META-INF/            # Web application metadata
│   ├── assets/              # CSS and JavaScript assets
│   ├── index.jsp            # Login and registration page
│   ├── home.jsp             # Main feed
│   ├── postDetails.jsp      # Post details and comments
│   └── profile.jsp          # User profile
└── target/                  # Maven build output, generated locally
```

## Application flow

Requests ending in `.do` are handled by the main servlet controller in `web.Controller`. The controller:

1. Receives the HTTP request.
2. Checks the current session where authentication is required.
3. Delegates database operations to the DAO layer.
4. Builds a view model.
5. Forwards the request to the appropriate JSP page.

The DAO layer uses JDBC and a shared connection managed by `dao.SingletonConnection`.

## Requirements

Install the following before running the application:

- JDK 16 or a compatible Java Development Kit
- Apache Maven 3.8+
- Apache Tomcat 8.5
- MySQL Server

The project is configured for the `javax.servlet` API used by Tomcat 8.5. It is not currently a Jakarta EE 9+ application.

## Database setup

Create a MySQL database named `blog_db`:

```sql
CREATE DATABASE blog_db;
```

Create the tables required by the application and add any initial categories before starting the server. The application currently connects using the following local configuration:

```text
Host:     localhost
Port:     3306
Database: blog_db
Username: root
Password: [empty]
```

> **Security note:** The database connection is currently configured in `src/main/java/dao/SingletonConnection.java`. For anything beyond local development, move credentials to environment variables or an external configuration file, use a dedicated database user, and never commit production secrets.

## Build the application

Compile the Java sources and package the application as a WAR:

```bash
mvn clean package
```

The generated artifact is:

```text
target/blog.war
```

Maven downloads the Servlet API, JSTL, and MySQL Connector/J dependencies automatically. The old JAR files under `src/main/webapp/WEB-INF/lib` are retained for Eclipse compatibility, but Maven is the source of truth for new builds.

## Run locally with Tomcat

1. Clone the repository:

   ```bash
   git clone https://github.com/so-high-l/blog.git
   cd blog
   ```

2. Create and configure the `blog_db` MySQL database.

3. Build the WAR:

   ```bash
   mvn clean package
   ```

4. Copy `target/blog.war` to Tomcat's `webapps` directory:

   ```bash
   cp target/blog.war "$CATALINA_HOME/webapps/"
   ```

5. Start Tomcat:

   ```bash
   "$CATALINA_HOME/bin/startup.sh"
   ```

   On Windows, run `startup.bat` instead.

6. Open the application at:

   ```text
   http://localhost:8080/blog/
   ```

You can also import the project into Eclipse as a Maven project and attach it to a configured Tomcat 8.5 server.

## Main pages

| Page | Purpose |
| --- | --- |
| `index.jsp` | Sign in or create an account |
| `home.jsp` | Browse posts and trending content |
| `postDetails.jsp` | Read a post and view or add comments |
| `profile.jsp` | View authored posts, liked posts, and profile activity |

## Main request paths

The servlet controller supports routes including:

- `/login.do` — authenticate a user
- `/signup.do` — register a user
- `/home.do` — load the authenticated user's feed
- `/profile.do` — load profile activity
- `/postDetails.do?id=<post-id>` — view a post
- `/savePost.do` — create a post
- `/addComment.do` — add a comment
- `/deletePost.do?id=<post-id>` — delete an owned post
- `/logout.do` — end the current session

## Current limitations

- Database schema and seed scripts are not included, so the schema must be created separately.
- Database credentials are currently hard-coded for local development.
- The application targets the older `javax.servlet` namespace and Tomcat 8.5.
- Automated tests and CI configuration are not currently included.

## Contributing

Contributions are welcome. A typical workflow is:

1. Fork the repository.
2. Create a feature branch.
3. Make and test your changes locally with `mvn clean package`.
4. Open a pull request with a clear description of the change.

## License

No license has been declared for this repository. All rights are reserved unless the owner adds a license.
