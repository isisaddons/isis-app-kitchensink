package org.incode.platform.lib.gebspock.wicket.ui.components.actions

import geb.Module

abstract class ActionParametersFormPanel_Abstract extends Module {

    static content = {

        ok { $("div.actionPanel div.actionParametersForm .buttons input",0) }
        cancel { $("div.actionPanel div.actionParametersForm .buttons input",1) }

        feedback { $(".xxx",0) }

    }

}
