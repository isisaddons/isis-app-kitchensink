package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string.StringPanelModule

class FindBusRulesObject_PromptParams extends Module {
    static content = {
        name { $("fieldset.parameters .isis-name").module(StringPanelModule) }
    }
}
