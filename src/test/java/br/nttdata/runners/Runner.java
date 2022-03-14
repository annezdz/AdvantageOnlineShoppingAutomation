package br.nttdata.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.nttdata.tests.BaseTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/produto.feature",
		glue = "br.nttdata.steps",
//		tags = ("@Cenario2"),
		plugin = {"pretty", 
				"html:target/HtmlReports/html_report",
				"json:target/JsonReports/json_report",
				"junit:target/JUnitReports/junit_report"}, 
				monochrome = true,
				stepNotifications = true,
				snippets = SnippetType.CAMELCASE,
				dryRun = false
				)

public class Runner extends BaseTest{
	
}
