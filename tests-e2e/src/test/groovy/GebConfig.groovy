/**
 *
 * Geb configuration file.
 *
 * See: http://www.gebish.org/manual/current/#configuration
 *
 */


//
// To run the tests with all browsers just run “./gradlew test”
// To run for just chrome, use “./gradlew chromeTest”
//



import com.aoe.gebspockreports.GebReportingListener
import geb.Browser
import geb.report.CompositeReporter
import geb.report.PageSourceReporter
import io.github.bonigarcia.wdm.ChromeDriverManager
import org.incode.platform.lib.gebspock.spi.EmptyNavigator
import org.incode.platform.lib.gebspock.spi.NonEmptyNavigator
import org.incode.platform.lib.gebspock.spi.Screenshot
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

waiting {
	timeout = 3
	retryInterval = 0.5
}

environments {

	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {

		def driverManager = ChromeDriverManager.instance
		driverManager.setup()
		driver = {

			def headlessMode = false

			ChromeDriver driverInstance

			if(headlessMode) {
				def options = new ChromeOptions()
				options.addArguments("--headless")
				options.addArguments("--window-size=2048x1024");
				driverInstance = new ChromeDriver(options)
			} else {
				driverInstance = new ChromeDriver()
				driverInstance.manage().window().setSize(new Dimension(2048,1024))
			}

			driverInstance
		}
	}
}



innerNavigatorFactory = { Browser browser, List<WebElement> elements ->
	elements ? new NonEmptyNavigator(browser, elements) : new EmptyNavigator(browser)
}

baseUrl = "http://localhost:8080/wicket"

reportingListener = new GebReportingListener()
reportsDir = 'build/geb-spock-reports'

reporter = new CompositeReporter(new PageSourceReporter(), new Screenshot())


