package org.isisaddons.app.kitchensink.e2etests.modules.isisapplib.ConfigurationServiceMenu

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.header.HeaderPanel

class ConfigurationServiceMenu_DomainService extends Module {
    static content = {
        menu { module(HeaderPanel).tertiary.$("a") }

        configuration { module Configuration_MenuItem }
    }
}

class Configuration_MenuItem extends Module {
    static content = {
        menuItem { module(HeaderPanel).tertiary.$(".dropdown")
                    $("li.isis-isisapplib-configurationservicemenu-configuration a")}
    }
}


