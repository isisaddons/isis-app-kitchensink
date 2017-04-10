package org.isisaddons.app.kitchensink.e2etests

import org.isisaddons.app.kitchensink.e2etests.pages.CollectionResultsPage
import org.isisaddons.app.kitchensink.e2etests.pages.HomePage
import org.isisaddons.app.kitchensink.e2etests.pages.LoginPage
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
