package org.incode.platform.lib.gebspock.wicket.ui.components.actions

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.actionprompt.ActionPromptModalWindow_Module

class ActionParametersFormPanel_Module extends Module {

    static content = {

        modalBody { $(".modal-body div.actionPanel div.inputForm") }

        ok { module(ActionPromptModalWindow_Module).$("div.actionPanel div.actionParametersForm .buttons input",0) }
        cancel { module(ActionPromptModalWindow_Module).$(".buttons input",1) }

        feedback { $(".xxx",0) }

    }

}
