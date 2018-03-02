package org.incode.platform.lib.gebspock.wicket.ui.components.actionprompt

import geb.Module

final class ActionPromptModalWindowModule extends Module {

    // static base = { $(".modal-body div.actionPanel" ) }

    static content = {

        //modalBody { $("div.inputForm") }
        modalBody { $(".modal-body div.actionPanel div.inputForm") }

    }

}
