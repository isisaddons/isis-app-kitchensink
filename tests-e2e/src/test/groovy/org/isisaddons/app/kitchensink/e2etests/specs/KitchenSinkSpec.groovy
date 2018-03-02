package org.isisaddons.app.kitchensink.e2etests.specs

import org.incode.platform.lib.gebspock.wicket.ui.pages.entity.EntityPage
import org.incode.platform.lib.gebspock.wicket.ui.pages.home.HomePage
import org.incode.platform.lib.gebspock.wicket.ui.pages.standalonecollection.StandaloneCollectionPage
import org.incode.platform.lib.gebspock.specs.GebReportingSpecWithApprovals
import org.incode.platform.lib.gebspock.wicket.ui.pages.LoggedInPage
import org.incode.platform.lib.gebspock.wicket.ui.pages.signin.WicketSignInPage

import spock.lang.Stepwise

@Stepwise
class KitchenSinkSpec extends GebReportingSpecWithApprovals {

    void "Open"() {
        when:
            to WicketSignInPage

        then:
            at WicketSignInPage
    }

    void "Sign in"() {

        given:
            def page = at WicketSignInPage
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
            page.busRulesObjects.findBusRulesObject.prompt.displayed

        when:
            page.busRulesObjects.findBusRulesObject.prompt.parameters.name = ""
            page.busRulesObjects.findBusRulesObject.prompt.ok.click()

        then:
            page.busRulesObjects.findBusRulesObject.prompt.parameters.nameFeedback.displayed
            page.busRulesObjects.findBusRulesObject.prompt.parameters.nameFeedback.text() =~ /'Name' is required./

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
