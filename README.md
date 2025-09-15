# Campus Connect Portal

A modular, role-based Java web application designed to streamline campus communication and event management. Built with Maven, JSP, Servlets, and MySQL, this portal supports students, faculty, and administrators with tailored dashboards, notice boards, feedback systems, and more.

---

## 📁 Project Structure

```
campus-connect-portal/
├── backend/           # Maven-based Java web app
│   ├── pom.xml
│   ├── .mvn/
│   ├── src/
│   │   └── main/
│   │       └── webapp/
│   │           ├── WEB-INF/
│   │           │   └── web.xml
│   │           └── index.jsp
│   └── target/
│       ├── campus-connect-portal/
│       │   ├── META-INF/
│       │   └── WEB-INF/
│       │       ├── classes
│       │       └── lib
│       ├── maven-archiver/
│       │   └── pom.properties
│       └── campus-connect-portal.war
│
│
├── frontend/          # Static assets (CSS, JS, JSP)
│   ├── css/
│   ├── js/
│   └── jsp/
├── sql/               # Database schema and seed scripts
├── docs/              # Screenshots, module breakdowns, setup guides
│   ├── screenshots/
│   ├── modules.md
│   └── setup.md
├── .gitignore         # Clean exclusions for build artifacts and IDE clutter
├── LICENSE            # MIT License
└── README.md          # You're reading it!
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
```
