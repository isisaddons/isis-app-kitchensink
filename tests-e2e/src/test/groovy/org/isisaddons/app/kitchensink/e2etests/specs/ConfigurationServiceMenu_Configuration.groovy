package org.isisaddons.app.kitchensink.e2etests.specs

import org.incode.platform.lib.gebspock.specs.GebReportingSpecWithApprovals
import org.incode.platform.lib.gebspock.wicket.ui.pages.LoggedInPage
import org.incode.platform.lib.gebspock.wicket.ui.pages.home.HomePage
import org.incode.platform.lib.gebspock.wicket.ui.pages.signin.WicketSignInPage
import org.isisaddons.app.kitchensink.e2etests.modules.isisapplib.ConfigurationProperty.ConfigurationProperty_StandaloneCollectionPage
import spock.lang.Stepwise

@Stepwise
class ConfigurationServiceMenu_Configuration extends GebReportingSpecWithApprovals {

    void "Login"() {
        when:
        def page = to WicketSignInPage
        page.username = "sven"
        page.password = 'pass'
        page.login.click()

        then:
        at LoggedInPage
    }

    void "Configuration Service Menu > Configuration"() {

        given:
        def page = at LoggedInPage

        when:
        page.configurationService.menu.jquery.mouseover()
        page.configurationService.configuration.menuItem.click()

        then:
        at ConfigurationProperty_StandaloneCollectionPage
    }

    void "Reset to Home Page"() {

        given:
        def page = at LoggedInPage

        when:
        page.logo.click()

        then:
        at HomePage
    }


}
