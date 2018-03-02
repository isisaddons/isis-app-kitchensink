package org.isisaddons.app.kitchensink.e2etests.modules.isisapplib.Logout

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.header.HeaderPanel

class LogoutMenu extends Module {
    static content = {
        menu { module(HeaderPanel).tertiary.$("a") }

        logout { module Logout_MenuItem }
    }
}

class Logout_MenuItem extends Module {
    static content = {
        menuItem { $(".tertiary .dropdown a.logout")}
//        menuItem { module(HeaderPanel).tertiary.$(".dropdown a.logout")}
    }
}


