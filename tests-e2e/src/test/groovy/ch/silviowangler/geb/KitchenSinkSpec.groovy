import ch.silviowangler.geb.pages.KitchenSinkLoginPage
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class KitchenSinkSpec extends GebReportingSpec {

    void "Login"() {

        when:
            to KitchenSinkLoginPage

        then:
            title == 'Kitchensink'
    }

    void "Make sure the user name and password initially empty"() {

        expect: 'The user name and password is initially empty'
        usernameField.text() == ''
        passwordField.text() == ''

        when:
            usernameField.value 'sven'
            passwordField.value 'pass'

        then:
            title == 'Kitchensink'

    }

    /*
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
    */
}
