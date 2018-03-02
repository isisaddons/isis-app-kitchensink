package org.incode.platform.lib.gebspock.wicket.ui.components.actionmenu.serviceactions

import geb.Module

final class ServiceActionsPanel_Module extends Module {
    static base = { $("ul.navbar-nav") }
    static content =
    {
        dropdown { $("ul.navbar-nav li.dropdown") }
    }
}