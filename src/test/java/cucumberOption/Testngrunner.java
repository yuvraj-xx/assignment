package cucumberOption;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",
glue="stepDef",
monochrome= true,
dryRun=false,
plugin= {"pretty", "html:target/cucumber.html"} )
public class Testngrunner extends AbstractTestNGCucumberTests{
@Override
@DataProvider(parallel=true)
public Object[][] scenarios()
{
	
return super.scenarios();

}
}

