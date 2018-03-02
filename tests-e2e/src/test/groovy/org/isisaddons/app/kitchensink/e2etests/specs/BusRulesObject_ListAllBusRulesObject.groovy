package org.isisaddons.app.kitchensink.e2etests.specs

import org.incode.platform.lib.gebspock.specs.GebReportingSpecWithApprovals
import org.incode.platform.lib.gebspock.wicket.ui.pages.LoggedInPage
import org.incode.platform.lib.gebspock.wicket.ui.pages.signin.WicketSignInPage
import org.incode.platform.lib.gebspock.wicket.ui.pages.standalonecollection.StandaloneCollectionPage
import spock.lang.Stepwise

@Stepwise
class BusRulesObject_ListAllBusRulesObject extends GebReportingSpecWithApprovals {

    void "Login"() {
        when:
        def page = to WicketSignInPage
        page.username = "sven"
        page.password = 'pass'
        page.login.click()

        then:
        at LoggedInPage
    }

    void "Business Rules Object > List All Bus Rules Object"() {

        given:
        def page = at LoggedInPage

        when:
        page.busRulesObjects.menu.jquery.mouseover()
        page.busRulesObjects.listAllBusRulesObject.menuItem.click()

        then:
        at StandaloneCollectionPage
        page.busRulesObjects.listAllBusRulesObject.results.table.displayed
    }

}
