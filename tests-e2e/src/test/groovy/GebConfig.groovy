/**
 *
 * Geb configuration file.
 *
 * See: http://www.gebish.org/manual/current/#configuration
 *
 */






import com.aoe.gebspockreports.GebReportingListener
import geb.report.CompositeReporter
import geb.report.PageSourceReporter
import io.github.bonigarcia.wdm.ChromeDriverManager
import org.incode.platform.lib.gebspock.reporters.Screenshot
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

waiting {
	timeout = 3
	retryInterval = 0.5
}

environments {

	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		def driverManager = ChromeDriverManager.instance
		driverManager.setup()
		driver = {
			def options = new ChromeOptions()
			options.addArguments("--headless")
			options.addArguments("--window-size=2560x1440");

			def driverInstance = new ChromeDriver(options)
			driverInstance
		}
	}
}



// To run the tests with all browsers just run “./gradlew test”

baseUrl = "http://localhost:8080/wicket"

reportingListener = new GebReportingListener()
reportsDir = 'build/geb-spock-reports'

reporter = new CompositeReporter(new PageSourceReporter(), new Screenshot())


