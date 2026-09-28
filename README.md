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

## Project structure

```text
.
├── src/main/java/
│   ├── dao/                 # Database access and persistence logic
│   ├── metier/              # Domain models such as Post, User, Comment, and Like
│   ├── package_test/        # Test or development-related classes
│   └── web/                 # Servlet controller and request models
├── src/main/webapp/
│   ├── WEB-INF/             # Web deployment descriptor and libraries
│   ├── META-INF/            # Web application metadata
│   ├── assets/              # CSS and JavaScript assets
│   ├── index.jsp            # Login and registration page
│   ├── home.jsp             # Main feed
│   ├── postDetails.jsp      # Post details and comments
│   └── profile.jsp          # User profile
└── build/                   # Compiled classes
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

Before running the project, install:

- JDK 16 or a compatible Java Development Kit
- Apache Tomcat 8.5
- MySQL Server
- Eclipse IDE for Enterprise Java Developers, or another IDE capable of deploying Java web applications

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

## Run locally

1. Clone the repository:

   ```bash
   git clone https://github.com/so-high-l/blog.git
   cd blog
   ```

2. Create and configure the `blog_db` MySQL database.

3. Import the project into Eclipse as an existing Java web project.

4. Confirm that the project uses:
   - Java 16
   - Apache Tomcat 8.5
   - The MySQL Connector/J driver
   - The JSTL libraries included under `src/main/webapp/WEB-INF/lib`

5. Add the project to a Tomcat server and start the server.

6. Open the application at:

   ```text
   http://localhost:8080/blog/
   ```

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

- The repository does not currently include a Maven or Gradle build file.
- Database schema and seed scripts are not included, so the schema must be created separately.
- Database credentials are currently hard-coded for local development.
- Deployment is configured around Eclipse and Tomcat rather than a reproducible command-line build.

## Contributing

Contributions are welcome. A typical workflow is:

1. Fork the repository.
2. Create a feature branch.
3. Make and test your changes locally.
4. Open a pull request with a clear description of the change.

## License

No license has been declared for this repository. All rights are reserved unless the owner adds a license.
