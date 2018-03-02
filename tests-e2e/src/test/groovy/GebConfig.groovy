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

	// from https://stackoverflow.com/a/44190548/56880
	// headless chrome ?
//	chrome {
//		driver = {
//			ChromeOptions options = new ChromeOptions()
//			DesiredCapabilities capabilities = DesiredCapabilities.chrome()
//
//			String chromiumPath = "/usr/bin/chromium-browser"
//			String macChromePath = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"
//
//			def chromiumBinary = new File(chromiumPath)
//			def isAgent = chromiumBinary.exists()
//			def macChromeBinary = new File(macChromePath)
//			if (isAgent) {
//				options.setBinary(chromiumBinary) //Set binary using file to avoid NoClassDefFound error on mac
//			} else if (macChromeBinary.exists()) {
//				options.setBinary(macChromeBinary)
//			}
//
//			options.addArguments("headless")
//			capabilities.setCapability(ChromeOptions.CAPABILITY, options)
//			new ChromeDriver(capabilities)
//		}
//	}

}



// To run the tests with all browsers just run “./gradlew test”

baseUrl = "http://localhost:8080/wicket"

reportingListener = new GebReportingListener()
reportsDir = 'build/geb-spock-reports'

reporter = new CompositeReporter(new PageSourceReporter(), new Screenshot())


