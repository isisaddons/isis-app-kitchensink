package org.incode.platform.lib.gebspock.wicket.ui.components.header

import geb.Module

final class HeaderPanel extends Module {

    static content = {

        primary { $(".navbar-nav.primary")}
        secondary { $(".navbar-nav.secondary")}
        tertiary { $(".navbar-nav.tertiary")}

        logo { $(".navbar-header a.navbar-brand") }
        currentUser { tertiary.$("span.userName") }

    }
}