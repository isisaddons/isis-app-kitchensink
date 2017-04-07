import ch.silviowangler.geb.pages.GoogleFrontPage
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class GoogleSpec extends GebReportingSpec {

  void "Visit Google.com"() {

    when:
    to GoogleFrontPage

    then:
    title == 'Google'
  }

  void "Make sure the query field is initially empty"() {

    expect: 'The search field is initially empty'
    searchInputField.text() == ''
  }

  void "Enter a query"() {

    when: 'Enter "Geb Framework" into the search field'
    searchInputField.value 'Geb Framework'

    and: 'Click the search button'
    searchButton.click()

    and: 'wait until the search result element is visible'
    waitFor { searchResultsContainer.displayed }

    then:
    title == 'Geb Framework - Google Search'

    and:
    firstResult.text() == 'Geb - Very Groovy Browser Automation'
  }
}
