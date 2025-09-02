# 🧾 Employee Payroll System (Java + MySQL)

## 📌 Overview
A **console-based Employee Payroll System** built using **Java** and **MySQL**.  
The system manages employees and their payroll information with full CRUD functionality.  

---

## 🚀 Features
- 👤 **Add Employee** – register new employees  
- 💵 **Add Payrolls** – create payroll records for employees  
- 📋 **View All Employees** – display employee list  
- 📊 **View Payroll Records** – show payroll history  
- ✏ **Update Employee Info** – update employee details  
- 📝 **Update Payroll** – update payroll records  
- 🔍 **View Employee Payroll** – view specific employee payroll  
- ❌ **Fire Employees** – remove employee records  

---

## 🛠️ Technologies Used
- **Java** (OOP, JDBC)  
- **MySQL** (Relational Database)  
- **IntelliJ IDEA** (IDE)  
- **MySQL Connector/J** (JDBC Driver)  

---

## 📂 Project Structure
EmployeePayrollSystemWithDB/
├─ src/
│ ├─ app/
│ │ └─ payRoll.java # Payroll logic
│ ├─ dao/
│ │ └─ EmployeeDAO.java # Handles DB operations for employees
│ ├─ model/
│ │ └─ EmployeeInfo.java # Employee entity/model
│ ├─ util/
│ │ └─ DBConnection.java # Database connection helper
│ └─ Main.java # Entry point with menu system
├─ db/
│ └─ mysql-connector-j-9.4.0.jar # JDBC driver
├─ .gitignore
└─ README.md


---

## ⚡ How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/Lukyshi/EmployeePayrollSystemWithDB.git
   cd EmployeePayrollSystemWithDB
