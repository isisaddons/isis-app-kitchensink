package org.incode.platform.lib.gebspock.wicket.ui.components.actions

import geb.Module

abstract class ActionParametersFormPanel_Module extends Module {

    static content = {

        ok { $("div.actionPanel div.actionParametersForm .buttons input",0) }
        cancel { $(".buttons input",1) }

        feedback { $(".xxx",0) }

    }

}
