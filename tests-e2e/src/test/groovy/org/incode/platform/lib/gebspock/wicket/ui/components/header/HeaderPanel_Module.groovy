package org.incode.platform.lib.gebspock.wicket.ui.components.header

import geb.Module

final class HeaderPanel_Module extends Module {
    static at = { $("header.navbar") }
    static content = {
        primary { $(".primary")}
        secondary { $(".secondary")}
        tertiary { $(".tertiary")}
    }
}