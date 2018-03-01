/**
 *
 * Geb configuration file.
 *
 * See: http://www.gebish.org/manual/current/#configuration
 *
 */



import com.aoe.gebspockreports.GebReportingListener
import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.chrome.ChromeDriver

waiting {
	timeout = 3
	retryInterval = 0.5
}

environments {

	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		ChromeDriverManager.instance.setup()
		driver = {
			def driverInstance = new ChromeDriver()
			driverInstance.manage().window().maximize()
			driverInstance
		}
	}
}

// To run the tests with all browsers just run “./gradlew test”

baseUrl = "http://localhost:8080/wicket"

reportingListener = new GebReportingListener()
reportsDir = 'build/geb-spock-reports'

