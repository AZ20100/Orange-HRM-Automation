# OrangeHRM — Selenium Automation Framework

## 📌 Overview
A full UI test automation framework for [OrangeHRM](https://opensource-demo.orangehrmlive.com) — an open-source HR management system.
Built using **Page Object Model (POM)** design pattern with **Allure Reports** for rich test reporting.

---

## 🛠️ Tech Stack

| Tool | Version |
|---|---|
| Java | 25 |
| Selenium WebDriver | 4.x |
| TestNG | 7.9.0 |
| Allure Reports | 2.30 |
| Maven | 3.x |
| Git & GitHub | — |

---

## 📎 Project Artifacts

| Artifact | Link |
|---|---|

| 📋 Test Cases | [View on Google Sheets](https://docs.google.com/spreadsheets/d/1oQYtN2rZZlEQxV0Iolgtsqrxy07mJnsO/edit?gid=185291308#gid=185291308)) |
| ▶️ Test Execution | [View on Google Sheets](https://docs.google.com/spreadsheets/d/1oQYtN2rZZlEQxV0Iolgtsqrxy07mJnsO/edit?gid=738195822#gid=738195822) |
| 🐛 Bug Report | [View on Google Sheets](https://docs.google.com/spreadsheets/d/1oQYtN2rZZlEQxV0Iolgtsqrxy07mJnsO/edit?gid=618750107#gid=618750107) |

---

## ✅ Test Coverage

### 🔐 Authentication Module
| TC ID | Title | Status |
|---|---|---|
| PA_Auth_01 | Valid login with correct credentials | ✅ Passed |
| PA_Auth_02 | Login with wrong username | ✅ Passed |
| PA_Auth_03 | Login with empty username | ✅ Passed |
| PA_Auth_04 | Login with both fields empty | ✅ Passed |
| PA_Auth_05 | Login with lowercase username | ❌ Failed |
| PA_Auth_06 | Logout successfully | ✅ Passed |

### 👥 PIM Module — Employee Management
| TC ID | Title | Status |
|---|---|---|
| PA_Emp_06 | Add employee with valid data | ✅ Passed |
| PA_Emp_07 | Add employee with empty First Name | ✅ Passed |
| PA_Emp_08 | Add employee with empty Last Name | ✅ Passed |
| PA_Emp_09 | Add employee with special characters | ❌ Failed |
| PA_Emp_10 | Search employee by Employee ID | ✅ Passed |
| PA_Emp_11 | Search employee by name | ✅ Passed |
| PA_Emp_12 | Search with non-existent Employee ID | 🔄 Not Executed |
| PA_Emp_13 | Search with non-existent name | 🔄 Not Executed |
| PA_Emp_14 | Edit employee personal details | ✅ Passed |
| PA_Emp_15 | Edit employee with empty required field | ❌ Failed |
| PA_Emp_16 | Delete single employee | ✅ Passed |
| PA_Emp_17 | Bulk delete multiple employees | 🔄 Not Executed |

### 🖼️ Upload Profile Picture
| TC ID | Title | Status |
|---|---|---|
| PA_Pic_18 | Upload valid profile picture (JPG) | 🔄 Not Executed |
| PA_Pic_19 | Upload valid profile picture (PNG) | 🔄 Not Executed |
| PA_Pic_20 | Upload invalid file type (PDF) | 🔄 Not Executed |
| PA_Pic_21 | Upload image exceeding size limit | 🔄 Not Executed |

### 🧑‍💼 Recruitment — Add Candidate
| TC ID | Title | Status |
|---|---|---|
| PA_Cand_22 | Add candidate with valid data | 🔄 Not Executed |
| PA_Cand_23 | Add candidate with empty required fields | 🔄 Not Executed |
| PA_Cand_24 | Add candidate with invalid email format | 🔄 Not Executed |
| PA_Cand_25 | Search candidate by name | 🔄 Not Executed |
| PA_Cand_26 | Delete candidate | 🔄 Not Executed |

### 💼 Job Title Management
| TC ID | Title | Status |
|---|---|---|
| PA_Job_27 | Add new job title | 🔄 Not Executed |
| PA_Job_28 | Add job title with empty name | 🔄 Not Executed |
| PA_Job_29 | Edit existing job title | 🔄 Not Executed |
| PA_Job_30 | Delete job title | 🔄 Not Executed |
| PA_Job_31 | Assign job title to employee | 🔄 Not Executed |

---

## 📊 Execution Summary

| Status | Count |
|---|---|
| ✅ Passed | 11 |
| ❌ Failed | 3 |
| 🔄 Not Executed | 17 |
| **Total** | **31** |

---

## 🐛 Known Bugs

| Bug | TC ID | Severity |
|---|---|---|
| Lowercase "admin" logs in successfully — should be case-sensitive | PA_Auth_05 | Medium |
| Special characters accepted in employee name field | PA_Emp_09 | High |
| Empty Last Name accepted on edit — no validation error shown | PA_Emp_15 | High |

---

## 📂 Project Structure

```
OrangeHRM-Automation/
├── pom.xml
├── testng.xml
├── README.md
└── src/
    ├── main/java/
    │   ├── base/
    │   │   └── BasePage.java
    │   ├── pages/
    │   │   ├── LoginPage.java
    │   │   ├── DashboardPage.java
    │   │   └── PIMPage.java
    │   └── utils/
    │       └── DriverFactory.java
    └── test/java/
        ├── base/
        │   └── BaseTest.java
        └── tests/
            ├── LoginTests.java
            └── PIMTests.java
```

---

## ▶️ How to Run

### Run All Tests
```bash
mvn clean test
```

### Generate Allure Report
```bash
allure generate target/allure-results --clean -o target/allure-report
```

### Open Allure Report
```bash
allure open target/allure-report
```

---

## ⚙️ Prerequisites

- Java 25 installed
- Maven installed
- Microsoft Edge browser installed
- Allure CLI installed

```bash
# Install Allure via Scoop (Windows)
scoop install allure
```

---

## 🌐 Application Under Test

- **URL:** https://opensource-demo.orangehrmlive.com
- **Username:** Admin
- **Password:** admin123
