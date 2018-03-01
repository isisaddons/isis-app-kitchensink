package org.isisaddons.app.kitchensink.e2etests.specs

import org.isisaddons.app.kitchensink.e2etests.pages.EntityPage
import org.isisaddons.app.kitchensink.e2etests.pages.HomePage
import org.isisaddons.app.kitchensink.e2etests.pages.StandaloneCollectionPage
import org.incode.platform.lib.gebspock.specs.GebReportingSpecWithApprovals
import org.isisaddons.app.kitchensink.e2etests.pages.LoggedInPage
import org.isisaddons.app.kitchensink.e2etests.pages.LoginPage

import spock.lang.Stepwise

@Stepwise
class KitchenSinkSpec extends GebReportingSpecWithApprovals {

    void "Open"() {
        when:
            to LoginPage

        then:
            at LoginPage
    }

    void "Sign in"() {

        given:
            def page = at LoginPage
            //reportAndApprove "given"

        when: "Enter user and password"
            page.username = "sven"
            page.password = 'pass'

        and: "sign in"
            report "about to sign in"
            page.signIn.click()

        then:
            def nextPage = at LoggedInPage
            nextPage.currentUser.text() == 'sven'

    }

    void "Business Rules Object > Find Bus Rules Object"() {

        given:
            def page = at LoggedInPage

        when:
            page.busRulesObjects.menu.jquery.mouseover()

        and:
            page.busRulesObjects.findBusRulesObject.menuItem.click()

        then:
            page.busRulesObjects.findBusRulesObject.prompt.form.displayed

        when:
            page.busRulesObjects.findBusRulesObject.prompt.parameters.name = "Foo"
            page.busRulesObjects.findBusRulesObject.prompt.ok.click()

        then:
            at EntityPage

    }

    void "Reset to Home Page"() {

        given:
            def page = at EntityPage

        when:
            page.logo.click()

        then:
            at HomePage
    }

    void "Business Rules Object > List All Bus Rules Object"() {

        given:
            def page = at LoggedInPage

        when:
            page.busRulesObjects.menu.jquery.mouseover()

        and:
            page.busRulesObjects.listAllBusRulesObject.menuItem.click()

        then:
            at StandaloneCollectionPage
            page.busRulesObjects.listAllBusRulesObject.results.table.displayed
    }

}
