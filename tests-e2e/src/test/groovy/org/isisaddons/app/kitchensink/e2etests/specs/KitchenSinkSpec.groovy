package org.isisaddons.app.kitchensink.e2etests.specs

import org.isisaddons.app.kitchensink.e2etests.pages.EntityPage
import org.isisaddons.app.kitchensink.e2etests.pages.StandaloneCollectionPage
import org.incode.platform.lib.gebspock.GebReportingSpecWithApprovals
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
            LoginPage loginPage = at(LoginPage)
            //reportAndApprove "given"

        when: "Enter user and password"
            loginPage.username = "sven"
            loginPage.password = 'pass'

        and: "sign in"
            report "about to sign in"
            loginPage.signIn.click()

        then:
            LoggedInPage page = at(LoggedInPage)
            page.currentUser.text() == 'sven'

    }

    void "Business Rules Object > Find Bus Rules Object"() {

        given:
            LoggedInPage page = at(LoggedInPage)

        when:
            page.busRulesObject.menu.jquery.mouseover()

        and:
            page.busRulesObject.findBusRulesObject.menuItem.click()

        then:
            page.busRulesObject.findBusRulesObject.prompt.form.displayed

        when:
            page.busRulesObject.findBusRulesObject.prompt.parameters.name = "Foo"
            page.busRulesObject.findBusRulesObject.prompt.ok_button.click()

        then:
            at EntityPage

    }

    void "Business Rules Object > List All Bus Rules Object"() {

        given:
            LoggedInPage loggedInPage = at(LoggedInPage)

        when:
            loggedInPage.busRulesObject.menu.jquery.mouseover()

        and:
            loggedInPage.busRulesObject.listAllBusRulesObject.menuItem.click()

        then:
            at StandaloneCollectionPage
            loggedInPage.busRulesObject.listAllBusRulesObject.results.table.displayed
    }

}
