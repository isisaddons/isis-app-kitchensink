import ch.silviowangler.geb.pages.CollectionResultsPage
import ch.silviowangler.geb.pages.HomePage
import ch.silviowangler.geb.pages.LoginPage
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class KitchenSinkSpec extends GebReportingSpec {

    void "Open"() {

        when:
            to LoginPage

        then:
            at LoginPage
    }

    void "Sign in"() {

        when: "Enter user and password"
            username_field = "sven"
            password_field = 'pass'

        and: "sign in"
            signIn_button.click()

        then:
            at HomePage
    }

    void "Install fixtures"() {

        when:
            prototypingMenu.menu.jquery.mouseover()

        and:
            prototypingMenu.runFixtureScripts.menuItem.click()

        and:
            actionParameters.form.displayed
            actionParameters.ok_button.click()

        then:
            at CollectionResultsPage
            prototypingMenu.runFixtureScripts.results.displayed

    }

}
