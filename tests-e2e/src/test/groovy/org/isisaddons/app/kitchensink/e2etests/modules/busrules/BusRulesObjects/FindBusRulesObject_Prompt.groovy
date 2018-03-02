package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects

import org.incode.platform.lib.gebspock.wicket.ui.components.actions.ActionParametersFormPanelModule

class FindBusRulesObject_Prompt extends ActionParametersFormPanelModule {

    static content = {
        form { modalBody.$("form.isis-busrules-busrulesobjects-findbusrulesobject") }
        //form { ActionPromptModalWindowModule.modalBody.$("form.isis-busrules-busrulesobjects-findbusrulesobject") }
        //form { $("div.actionPanel div.actionParametersForm form.isis-busrules-busrulesobjects-findbusrulesobject", 0) }
        parameters { form.module FindBusRulesObject_PromptParams }
    }
}