package org.isisaddons.app.kitchensink.e2etests.specs

import org.incode.platform.lib.gebspock.specs.GebReportingSpecWithApprovals
import org.incode.platform.lib.gebspock.wicket.ui.pages.LoggedInPage
import org.incode.platform.lib.gebspock.wicket.ui.pages.entity.EntityPage
import org.incode.platform.lib.gebspock.wicket.ui.pages.home.HomePage
import org.incode.platform.lib.gebspock.wicket.ui.pages.signin.WicketSignInPage
import org.isisaddons.app.kitchensink.e2etests.modules.isisapplib.FixtureResult.FixtureResult_StandaloneCollectionPage
import spock.lang.Stepwise

@Stepwise
class S_050_BusRulesObjects_FindBusRulesObject extends GebReportingSpecWithApprovals {

    void "Login, run fixtures, back to home page"() {
        when:
        def page = to WicketSignInPage
        page.username = "sven"
        page.password = 'pass'
        page.login.click()

        then:
        def loggedInPage = at LoggedInPage

        when:
        page = loggedInPage
        page.fixtureScripts.menu.jquery.mouseover()
        page.fixtureScripts.runFixtureScript.menuItem.click()
        page.fixtureScripts.runFixtureScript.prompt.ok.click()

        then:
        def collectionPage = at(FixtureResult_StandaloneCollectionPage)

        when:
        page = collectionPage
        page.logo.click()

        then:
        at HomePage
    }

    void "Business Rules Object > Find Bus Rules Object"() {

        given:
        def page = at LoggedInPage

        when:
        page.busRulesObjects.menu.jquery.mouseover()
        page.busRulesObjects.findBusRulesObject.menuItem.click()

        then:
        page.busRulesObjects.findBusRulesObject.prompt.displayed

        when: "Missing name"
        page.busRulesObjects.findBusRulesObject.prompt.parameters.name.input = ""
        page.busRulesObjects.findBusRulesObject.prompt.ok.click()

        then:
        page.busRulesObjects.findBusRulesObject.prompt.parameters.name.feedback.text() =~ /'Name' is required./
        report "name is required"

        when: "Enter all details"
        page.busRulesObjects.findBusRulesObject.prompt.parameters.name.input = "Foo"
        page.busRulesObjects.findBusRulesObject.prompt.ok.click()

        then:
        at EntityPage

    }


}
