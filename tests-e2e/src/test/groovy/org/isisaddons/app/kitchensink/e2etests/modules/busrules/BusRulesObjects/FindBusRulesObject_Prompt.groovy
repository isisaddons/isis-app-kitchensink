package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects

import org.isisaddons.app.kitchensink.e2etests.base.ActionParametersModule

class FindBusRulesObject_Prompt extends ActionParametersModule {

    static base = { $("div.actionPanel div.actionParametersForm" ) }
    
    static content = {
        form { $("form.isis-busrules-busrulesobjects-findbusrulesobject", 0) }
        //form { $("div.actionPanel div.actionParametersForm form.isis-busrules-busrulesobjects-findbusrulesobject", 0) }
        parameters { form.module FindBusRulesObject_PromptParams }
    }
}