# Demo Test Automation Project - Trello
<img src="images/Trello-Logo.png" alt="Trello logo" width="300">

# <a name="Tech stack">Tech stack</a>
<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="images/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="images/java-logo.svg"></code>
  <code><img width="5%" title="Selenide" src="images/selenide-logo.svg"></code>
  <code><img width="5%" title="REST-Assured" src="images/rest-assured-logo.svg"></code>
  <code><img width="5%" title="Selenoid" src="images/selenoid-logo.svg"></code>
  <code><img width="5%" title="Gradle" src="images/gradle-logo.svg "></code>
  <code><img width="5%" title="JUnit5" src="images/junit5-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="images/allure-Report-logo.svg"></code>
  <code><img width="5%" title="Github" src="images/git-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="images/jenkins-logo.svg"></code>
  <code><img width="5%" title="Jira" src="images/jira-logo.svg"></code>
  <code><img width="5%" title="Telegram" src="images/Telegram.svg"></code>
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


# <a name="Test running"> How to run tests </a>
## Precondition
For success tests running you need to add 2 files <code>apiAuth.properties</code> and <code>uiAuth.properties</code> and put them into <code>src/test/resources</code>
<details>
<summary>apiAuth.properties example</summary>
```
uri=https://api.trello.com
key=83048509344509c03449583
token=ATTA36da17ab56cd0frje48b9b7c43dd5b6311a7e7baf977e7a9b35c54mfk78a246B69F7CD
```
</details>
<details>
<summary>uiAuth.properties example</summary>
```
userLogin=someEmail@gmail.com
userPassword=somePassword
uiAuth.properties
</details>










