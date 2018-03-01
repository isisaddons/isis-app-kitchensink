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
import org.incode.platform.lib.gebspock.Screenshot
import org.openqa.selenium.chrome.ChromeDriver

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

reporter = new CompositeReporter(new PageSourceReporter(), new Screenshot())


