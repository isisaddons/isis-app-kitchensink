package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects

import org.isisaddons.app.kitchensink.e2etests.base.ScalarPropertyOrParameterModule

class FindBusRulesObject_PromptParams extends ScalarPropertyOrParameterModule {
    static content = {
        name { $("div.actionPanel div.actionParametersForm form.isis-busrules-busrulesobjects-findbusrulesobject fieldset.parameters input", 0) }
    }
}
