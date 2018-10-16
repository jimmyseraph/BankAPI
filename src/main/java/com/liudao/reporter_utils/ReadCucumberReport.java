package com.liudao.reporter_utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadCucumberReport {
    private File jsonFile;
    public ReadCucumberReport(File jsonFile){
        this.jsonFile = jsonFile;
    }

    public FeatureEntity[] getFeatures() throws FileNotFoundException{
        Gson gson = new Gson();
        FeatureEntity[] featureEntities = gson.fromJson(new FileReader(jsonFile), FeatureEntity[].class);
        return featureEntities;
    }

    public static void main(String[] args) throws Exception{
        ReadCucumberReport read = new ReadCucumberReport(new File("./target/cucumber-report/api-test-report.json"));
        System.out.println(read.getFeatures()[0].getId());
        File path = new File("./target/extent-report");
        if(!path.isDirectory()){
            path.mkdir();
        }
        ExtentReports extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(new File(path,"extent-report.html"));
        extent.attachReporter(htmlReporter);
        for(FeatureEntity featureEntity : read.getFeatures()){
            ExtentTest feature = extent.createTest(featureEntity.getName(),featureEntity.getDescription());
            for(FeatureElement element : featureEntity.getElements()){
                    ExtentTest scenario = feature.createNode(
                            new GherkinKeyword(element.getKeyword()),
                            element.getName().equals("")?" ":element.getName());
                for(StepEntity stepEntity : element.getSteps()){
                    ExtentTest step = scenario.createNode(new GherkinKeyword(stepEntity.getKeyword()),stepEntity.getName());
                    switch (stepEntity.getResult().getStatus()){
                        case "passed":
                            step.pass("passed");
                            break;
                        case "failed":
                            step.fail(stepEntity.getResult().getError_message());
                            break;
                        case "skipped":
                            step.skip("skipped");
                            break;
                        default:
                            step.debug("unknown");
                            break;
                    }
                }
            }
        }
        extent.flush();
    }

}
