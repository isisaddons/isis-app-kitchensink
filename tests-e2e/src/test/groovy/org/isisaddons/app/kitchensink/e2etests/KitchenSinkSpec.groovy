package org.isisaddons.app.kitchensink.e2etests

import geb.spock.GebReportingSpec
import org.isisaddons.app.kitchensink.e2etests.base.CollectionResultsPage
import org.isisaddons.app.kitchensink.e2etests.pages.HomePage
import org.isisaddons.app.kitchensink.e2etests.pages.LoginPage
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

        given:
            LoginPage loginPage = at(LoginPage)

        when: "Enter user and password"
            loginPage.username = "sven"
            loginPage.password = 'pass'

        and: "sign in"
            loginPage.signIn.click()

        then:
            at HomePage
            report "home page"
    }

    void "Business Rules Object > find Bus Rules Object"() {

        given:
            HomePage homePage = at(HomePage)

        when:
            homePage.busRulesObject.menu.jquery.mouseover()

        and:
            homePage.busRulesObject.findBusRulesObject.menuItem.click()

        then:
            homePage.busRulesObject.findBusRulesObject.prompt.form.displayed

        when:
            homePage.busRulesObject.findBusRulesObject.prompt.parameters.name = "Foo"
            homePage.busRulesObject.findBusRulesObject.prompt.ok_button.click()

        then:
            at CollectionResultsPage

    }

}
