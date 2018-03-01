package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects

import org.isisaddons.app.kitchensink.e2etests.base.ActionParametersModule

class FindBusRulesObject_Prompt extends ActionParametersModule {
    static content = {
        form { $("div.actionPanel div.actionParametersForm form.isis-busrules-busrulesobjects-findbusrulesobject", 0) }
        parameters { module FindBusRulesObject_PromptParams }
    }
}