package org.incode.platform.lib.gebspock.wicket.ui.components.actions

import geb.Module

class ActionParametersFormPanelModule extends Module {

    // static base = { $("div.actionPanel div.actionParametersForm" ) }

    static content = {

        modalBody { $(".modal-body div.actionPanel div.inputForm") }

        ok { modalBody.$("div.actionPanel div.actionParametersForm .buttons input",0) }
        cancel { modalBody.$(".buttons input",1) }

        feedback { $(".xxx",0) }

    }

}
