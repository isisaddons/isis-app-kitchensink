package org.isisaddons.app.kitchensink.e2etests.specs

import org.incode.platform.lib.gebspock.specs.GebReportingSpecWithApprovals
import org.incode.platform.lib.gebspock.wicket.ui.pages.LoggedInPage
import org.incode.platform.lib.gebspock.wicket.ui.pages.signin.WicketSignInPage
import spock.lang.Stepwise

@Stepwise
class LoginAndLogout extends GebReportingSpecWithApprovals {

    void "Open"() {
        when:
        to WicketSignInPage

        then:
        at WicketSignInPage
    }

    void "Login"() {

        given:
        def page = at WicketSignInPage
        // compares against Login-given.png approved file
        //reportAndApprove "given"

        when: "Enter user and password"
        page.username = "sven"
        page.password = 'pass'

        and: "login"
        report "about to login"
        page.login.click()

        then:
        def nextPage = at LoggedInPage
        nextPage.currentUser.text() == 'sven'

    }

    void "Logout"() {

        given:
        def page = at LoggedInPage

        when: "Enter user and password"
        page.logoutMenu.menu.jquery.mouseover()
        def logout = page.logoutMenu.logout.menuItem.click()


        then:
        def nextPage = at WicketSignInPage
        nextPage.username == ""
        nextPage.password == ""
    }


}
