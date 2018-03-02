package org.incode.platform.lib.gebspock.wicket.ui.pages

import geb.Page
import org.incode.platform.lib.gebspock.wicket.ui.components.header.HeaderPanel
import org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects.BusRulesObjects_DomainService
import org.isisaddons.app.kitchensink.e2etests.modules.isisapplib.ConfigurationServiceMenu.ConfigurationServiceMenu_DomainService
import org.isisaddons.app.kitchensink.e2etests.modules.isisapplib.Logout.LogoutMenu

class LoggedInPage extends Page {

    static at = {
        module(HeaderPanel).tertiary.displayed
    }

    static content = {
        currentUser { module(HeaderPanel).currentUser }
        logo { module(HeaderPanel).logo }

        // primary menu bar
        busRulesObjects { module BusRulesObjects_DomainService }

        // tertiary menu bar
        configurationService { module ConfigurationServiceMenu_DomainService }
        logoutMenu { module LogoutMenu }
    }

}
