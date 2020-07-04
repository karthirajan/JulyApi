package com.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src//test//resources//Pet//PetDetails.feature",glue="com.stepdefinition",monochrome=true)

public class TestRunner {

}
