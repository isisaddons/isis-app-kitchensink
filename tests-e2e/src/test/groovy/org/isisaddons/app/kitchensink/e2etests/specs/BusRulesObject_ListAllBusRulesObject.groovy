package org.isisaddons.app.kitchensink.e2etests.specs

import org.incode.platform.lib.gebspock.specs.GebReportingSpecWithApprovals
import org.incode.platform.lib.gebspock.wicket.ui.pages.LoggedInPage
import org.incode.platform.lib.gebspock.wicket.ui.pages.signin.WicketSignInPage
import org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject.BusRulesObject_EntityPage
import org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject.BusRulesObject_StandaloneCollectionPage
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
        at BusRulesObject_StandaloneCollectionPage
    }

    void "Check 1st Row"() {

        when:
        def page = at BusRulesObject_StandaloneCollectionPage

        then:
        page.tablePanel.nameColumn(0) =~ /Foo/
        page.tablePanel.enableActionsColumn(0) == false
    }

    void "Navigate to 1st Entity"() {

        given:
        def page = at BusRulesObject_StandaloneCollectionPage

        when:
        page.tablePanel.titleColumn(0).click()

        then:
        def nextPage = at BusRulesObject_EntityPage
        nextPage.objectTitle =~ /Foo/
    }

}
