# Demo Test Automation Project - Trello

<img src="images/Trello-Logo.png" alt="Trello logo" width="300">

## Navigation

+ [Tech stack](#TechStack)
+ [How to run tests](#TestRunning)
    + [Run Tests Locally](#RunTestsLocally)
        + [Precondition](#Precondition)
        + [1. Run tests and reporting using terminal](#RunTerminal)
        + [2. Run tests and reporting using gradle tasks in IntelliJ IDEA](#RunIntelliJ)
    + [Run tests remotely using Jenkins](#RunJenkins)
        + [1. Setup environment with Docker](#SetupDocker)
        + [2. Setup Jenkins job](#SetupJob)
        + [3. Run Jenkins job and get results](#RunJob)
    + [Run tests remotely using Github Actions](#RunActions)
+ [Reporting with Allure](#AllureReport)
+ [Telegram Notification](#TelegramNotification)
<!-- + [Интеграция с Allure TestOps](#AllureTestOps) -->
<!-- + [Результаты выполнения тестов](#Results) -->
<!-- + [Интеграция с Jira](#Jira) -->

# <a name="TechStack">Tech stack</a>

<p  align="center">
  <img width="5%" title="IntelliJ IDEA" src="images/IDEA-logo.svg">
  <img width="5%" title="Java" src="images/java-logo.svg">
  <img width="5%" title="Selenide" src="images/selenide-logo.svg">
  <img width="5%" title="REST-Assured" src="images/rest-assured-logo.svg">
  <img width="5%" title="Selenoid" src="images/selenoid-logo.svg">
  <img width="5%" title="Gradle" src="images/gradle-logo.svg ">
  <img width="5%" title="JUnit5" src="images/junit5-logo.svg">
  <img width="5%" title="Allure Report" src="images/allure-Report-logo.svg">
  <img width="5%" title="Github" src="images/git-logo.svg">
  <img width="5%" title="Jenkins" src="images/jenkins-logo.svg">
  <img width="5%" title="Jira" src="images/jira-logo.svg">
  <img width="5%" title="Telegram" src="images/Telegram.svg">
</p>

This project is written in <code>Java</code> \
<code>Selenide</code> is used for UI tests and <code>Rest-Assured</code> for API
>
> <code>Selenoid</code> is employed to launch browsers within <code>Docker</code> containers, providing an isolated testing environment.
>
> <code>Allure Report</code> is integrated into the project to generate comprehensive test run reports,
>
> <code>Gradle</code> is used for automated project build.
>
> <code>JUnit 5</code> is used as a unit testing library.
>
> <code>Jenkins</code> runs the tests.
>
> Upon completion of a test run, notifications are dispatched via a <code>Telegram</code> bot for seamless communication.

# <a name="TestRunning"> How to run tests </a>

## <a name="RunTestsLocally"> Run tests locally </a>

### <a name="Precondition"> Precondition </a>

<p>
For success tests running you need to add 2 files <code>apiAuth.properties</code> 
and <code>uiAuth.properties</code> and put them into <code>src/test/resources</code>
</p>

<details>
<summary><code>apiAuth.properties</code> example</summary>

```properties
uri=https://api.trello.com
key=83048509344509c03449583
token=ATTA36da17ab56cd0frje48b9b7c43dd5b6311a7e7baf977e7a9b35c54mfk78a246B69F7CD
```

</details>
<details>
<summary><code>uiAuth.properties</code> example</summary>

```properties
userLogin=someEmail@gmail.com
userPassword=somePassword
```

</details>

<p>
There are 2 options to run tests locally
</p>

### <a name="RunTerminal"> 1. Run tests and reporting using terminal </a>

To run tests put this command in terminal

```
gradle clean {task}
```

Task options:
> <code>test</code>, <code>regressionTests</code>, <code>apiTests</code>, <code>uiTests</code>

#### To open Allure report

```
allure serve build/allure-results
```

### <a name="RunIntelliJ"> 2. Run tests and reporting using gradle tasks in IntelliJ IDEA </a>

<img width="20%" title="Gradle run tests" src="images/Gradle_run_tests.png">

#### To open Allure report run task allure-serve

## <a name="RunJenkins"> Run tests remotely using Jenkins </a>

### <a name="SetupDocker"> 1. Setup environment with Docker </a>

- Put files <code>docker-compose.yaml</code> and <code>browsers.json</code> in target directory.
- Download necessary docker images

```
docker pull {image}
```

- Open terminal in this directory and run the command

```
docker-compose up -d
```

<p>Docker container should be created and running</p>
<p><img width="70%" title="Docker container" src="images/docker-container.png"></p>

### <a name="SetupJob"> 2. Setup Jenkins job </a>

Create **Freestyle project** and create following steps:

<details>
<summary>Source Code Management</summary>
<img width="70%" title="Source-Code-Management" src="images/Source-Code-Management-Jenkins.png">
</details>

<details>
<summary>Create file for telegram notification</summary>
<img width="70%" title="Create-file-for-telegram-notif" src="images/Create-file-for-telegram-notif.png">
</details>

<details>
<summary>Create file apiAuth.properties</summary>
<img width="70%" title="Create-File-apiAuth-properties" src="images/Create-File-apiAuth-properties.png">
</details>

<details>
<summary>Create file uiAuth.properties</summary>
<img width="70%" title="Create-File-uiAuth-properties" src="images/Create-File-uiAuth-properties.png">
</details>

<details>
<summary>Gradle script</summary>
<img width="70%" title="Gradle-script" src="images/Gradle-script.png">

```
clean test
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView="${BROWSER_MOBILE}"
-DremoteDriverUrl=https://user1:1234@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/
-Dthreads=${THREADS}
```

</details>

<details>
<summary>Allure Report</summary>
<img width="70%" title="Allure-Report" src="images/Allure-Report.png">
</details>

<details>
<summary>Telegram notification post-build task</summary>
<img width="70%" title="telegram-notif-post-build-task" src="images/telegram-notif-post-build-task.png">
</details>

### <a name="RunJob"> 3. Run Jenkins job and get results </a>

<img width="50%" title="Jenkins-Job" src="images/Jenkins-Job.png">

## <a name="RunActions"> Run tests remotely using Github Actions </a>

The GitHub workflow has been set up, and the Allure Report is published on GitHub Pages. Example: [Allure Report](https://kira-vlsv.github.io/trello-demo-project/23/).

## <a name="AllureReport"> Reporting with Allure </a>

### Main Page

<img width="50%" title="Main-page-allure" src="images/Main-Page.png">

### Suite view

<img width="50%" title="Suite-view-allure" src="images/Suite-view-allure.png">

### Behavior view

<img width="50%" title="Behavior-view-allure" src="images/Behavior-view-allure.png">

### Filtering by tag

<img width="50%" title="Tag-filtering-allure" src="images/Tag-filtering-allure.png">

## <a name="TelegramNotification"> Telegram Notification </a>

<img width="50%" title="Telegram-notification" src="images/Telegram-notification.png">




