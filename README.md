# Campus Connect Portal

A modular, role-based Java web application designed to streamline campus communication and event management. Built with Maven, JSP, Servlets, and MySQL, this portal supports students, faculty, and administrators with tailored dashboards, notice boards, feedback systems, and more.

---

## 📁 Project Structure

```
campus-connect-portal/
├── backend/
│   ├── .mvn/                      # Maven wrapper
│   ├── mvnw, mvnw.cmd             # Maven executables
│   ├── pom.xml                    # Maven build config
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/campusconnect/
│   │       │       ├── admin/
│   │       │       ├── announcement/
│   │       │       ├── assignment/
│   │       │       ├── attendance/
│   │       │       ├── auth/
│   │       │       ├── faculty/
│   │       │       ├── notification/
│   │       │       ├── project/
│   │       │       ├── student/
│   │       │       └── utils/
│   │       └── webapp/            # JSPs, static assets
│
├── frontend/
│   ├── css/                       # Stylesheets
│   ├── js/                        # Scripts
│   ├── assets/                   # Images, icons, fonts
│   └── jsp/                       # JSP templates (if separate from webapp)
│
├── database/
│   ├── schema.sql                 # Table definitions
│   └── seed.sql                   # Sample data for testing/demo
│
├── docs/
│   ├── README.md                  # Project overview
│   └── architecture.md            # Diagrams, flowcharts, module interactions
│
├── .idea/, .vscode/               # IDE configs
├── .gitignore                    # Clean repo hygiene
├── LICENSE
└── campus-connect-portal.iml     # IntelliJ module file
```

---

## 🚀 Features

- 🔐 Role-based access (Student, Faculty, Admin)
- 📅 Event creation and participation
- 📢 Notice board for campus-wide updates
- 📝 Feedback system with sentiment tracking
- 📊 Personalized dashboards
- 🧩 Modular backend with DAO, models, and servlets

---

## 🛠️ Tech Stack

- **Backend**: Java, JSP, Servlets, JDBC, Maven
- **Frontend**: HTML, CSS, JS, JSP
- **Database**: MySQL
- **Build Tool**: Maven
- **Version Control**: Git + GitHub

---

## ⚙️ Setup Instructions

1. Clone the repo:
   ```bash
   git clone https://github.com/CampusConnectHub/campus-connect-portal.git
   cd campus-connect-portal/backend
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Deploy the generated `.war` file (`target/campus-connect-portal.war`) to a servlet container like Tomcat.

4. Import the SQL scripts from `/sql` into your MySQL database.

---

## 📸 Screenshots

Find UI previews and module walkthroughs in [`docs/screenshots`](docs/screenshots).

---

## 📚 Documentation

- [`docs/modules.md`](docs/modules.md): Feature breakdown
- [`docs/setup.md`](docs/setup.md): Environment setup and deployment guide

---

## 🧠 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to improve or add.

---

## 📄 License

This project is licensed under the MIT License. See the [`LICENSE`](LICENSE) file for details.
