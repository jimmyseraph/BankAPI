# API Automation test framework
[![Build Status](https://travis-ci.org/jimmyseraph/BankAPI.svg?branch=master)](https://travis-ci.org/jimmyseraph/BankAPI)
## How to run
### Environment requirements
> 1. Download `JDK1.8`(from https://www.oracle.com) or `OpenJDK1.8` from official website.
> 2. Config user environment of JDK: `JAVA_HOME`, and add JDK binary directory to `PATH`
> 3. Download `Maven` from [Maven official Website](https://maven.apache.org)
> 4. Add maven binary directory to `PATH`.
 
### Run test case using Maven
> If you have downloaded source from repository, you can run test cases easily by typing the `Maven` command in CLI:
```shell
mvn test
```
## Collect Test Report
> When you have finished the test, you can find test report in `json` format in `target/cucumber-report/api-test-report.json`;
> And you also can find the `HTML` test report in `target/cucumber-report/html` directory.
> This framework also support Allure-report. Run maven goal in CLI:
```shell
mvn allure:report
```
> You can also generate report site server using maven:
```shell
mvn allure:serve
```

## Something remain
> 1. I didn't add the Log module to collect important logs in runtime, as this is just a simple test framework and I don't need the logs to help me for debugging.
> 2. I did't add the `variables pool` to solve the `relative` between requests.(some important variables from the previous response is needed for the next request)
