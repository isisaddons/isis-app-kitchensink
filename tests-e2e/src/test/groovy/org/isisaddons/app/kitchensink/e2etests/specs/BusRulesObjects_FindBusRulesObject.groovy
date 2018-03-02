package org.isisaddons.app.kitchensink.e2etests.specs

import org.incode.platform.lib.gebspock.specs.GebReportingSpecWithApprovals
import org.incode.platform.lib.gebspock.wicket.ui.pages.LoggedInPage
import org.incode.platform.lib.gebspock.wicket.ui.pages.entity.EntityPage
import org.incode.platform.lib.gebspock.wicket.ui.pages.signin.WicketSignInPage
import spock.lang.Stepwise

@Stepwise
class BusRulesObjects_FindBusRulesObject extends GebReportingSpecWithApprovals {

    void "Login"() {
        when:
        def page = to WicketSignInPage
        page.username = "sven"
        page.password = 'pass'
        page.login.click()

        then:
        at LoggedInPage
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
        page.busRulesObjects.findBusRulesObject.prompt.parameters.name = ""
        page.busRulesObjects.findBusRulesObject.prompt.ok.click()

        then:
        page.busRulesObjects.findBusRulesObject.prompt.parameters.nameFeedback.displayed
        page.busRulesObjects.findBusRulesObject.prompt.parameters.nameFeedback.text() =~ /'Name' is required./
        report "name is required"

        when: "Enter all details"
        page.busRulesObjects.findBusRulesObject.prompt.parameters.name = "Foo"
        page.busRulesObjects.findBusRulesObject.prompt.ok.click()

        then:
        at EntityPage

    }


}
