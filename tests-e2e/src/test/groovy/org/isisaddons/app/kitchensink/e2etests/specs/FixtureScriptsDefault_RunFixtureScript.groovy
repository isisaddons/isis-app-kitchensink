package org.isisaddons.app.kitchensink.e2etests.specs

import org.incode.platform.lib.gebspock.specs.GebReportingSpecWithApprovals
import org.incode.platform.lib.gebspock.wicket.ui.pages.LoggedInPage
import org.incode.platform.lib.gebspock.wicket.ui.pages.signin.WicketSignInPage
import org.isisaddons.app.kitchensink.e2etests.modules.isisapplib.FixtureResult.FixtureResult_StandaloneCollectionPage
import spock.lang.Stepwise

@Stepwise
class FixtureScriptsDefault_RunFixtureScript extends GebReportingSpecWithApprovals {

    void "Login"() {
        when:
        def page = to WicketSignInPage
        page.username = "sven"
        page.password = 'pass'
        page.login.click()

        then:
        at LoggedInPage
    }

    void "Fixture Scripts > Run Fixture Script"() {

        given:
        def page = at LoggedInPage

        when:
        page.fixtureScripts.menu.jquery.mouseover()
        page.fixtureScripts.runFixtureScript.menuItem.click()

//        then:
//        page.fixtureScripts.runFixtureScript.prompt.displayed

//        and: "default script is selected"
//        page.fixtureScripts.runFixtureScript.prompt.parameters.script.value == "Kitchensink Setup Fixture"
//
//        when:
//        page.fixtureScripts.runFixtureScript.prompt.ok.click()
//
//        then:
//        def nextPage = at FixtureResult_StandaloneCollectionPage
//        // TODO: assert records found
//
//        when:
//        page.fixtureScripts.menu.jquery.mouseover()
//        page.fixtureScripts.runFixtureScript.menuItem.click()

        and: "select teardown"

        page.fixtureScripts.runFixtureScript.prompt.parameters.script.input = "Kitchensink Tear Down Fixture"

//        page.fixtureScripts.runFixtureScript.prompt.parameters.script.select.click()
//        def element = driver.findElement(By.cssSelector("input.select2-search__field"))
//        element.sendKeys("Kitchensink Tear Down Fixture")
//        element.sendKeys(Keys.ENTER)

        page.fixtureScripts.runFixtureScript.prompt.ok.click()

        then:
        def nextPage2 = at FixtureResult_StandaloneCollectionPage
        // TODO: assert no records found

    }


}
