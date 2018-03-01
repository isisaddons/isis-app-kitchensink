package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject.findBusRulesObject

import org.isisaddons.app.kitchensink.e2etests.base.ActionParametersModule

class Prompt_Module extends ActionParametersModule {

    static content = {

        form { $("div.actionPanel div.actionParametersForm form.isis-busrulesobject-findbusrulesobject", 0) }

        parameters { module(Parameters_Module) }

    }



}
