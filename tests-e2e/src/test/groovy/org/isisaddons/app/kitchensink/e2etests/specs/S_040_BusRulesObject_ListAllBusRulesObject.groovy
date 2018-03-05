package org.isisaddons.app.kitchensink.e2etests.specs

import org.incode.platform.lib.gebspock.specs.GebReportingSpecWithApprovals
import org.incode.platform.lib.gebspock.wicket.ui.pages.LoggedInPage
import org.incode.platform.lib.gebspock.wicket.ui.pages.home.HomePage
import org.incode.platform.lib.gebspock.wicket.ui.pages.signin.WicketSignInPage
import org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject.BusRulesObject_EntityPage
import org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject.BusRulesObject_StandaloneCollectionPage
import org.isisaddons.app.kitchensink.e2etests.modules.isisapplib.FixtureResult.FixtureResult_StandaloneCollectionPage
import spock.lang.Stepwise

@Stepwise
class S_040_BusRulesObject_ListAllBusRulesObject extends GebReportingSpecWithApprovals {

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

    void "Business Rules Object > List All Bus Rules Object"() {

        given:
        def page = at LoggedInPage

        when:
        page.busRulesObjects.menu.jquery.mouseover()
        page.busRulesObjects.listAllBusRulesObject.menuItem.click()

        then:
        at BusRulesObject_StandaloneCollectionPage
    }

    void "Check 1st Row"() {

        when:
        def page = at BusRulesObject_StandaloneCollectionPage

        then:
        page.tablePanel.columns.name(0) =~ /Foo/
        page.tablePanel.columns.enableActions(0) == false
    }

    void "Navigate to 1st Entity"() {

        given:
        def page = at BusRulesObject_StandaloneCollectionPage

        when:
        page.tablePanel.columns.objectTitle(0).click()

        then:
        def nextPage = at BusRulesObject_EntityPage
        nextPage.objectTitle =~ /Foo/
    }

}
