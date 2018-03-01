package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject.findBusRulesObject

import org.isisaddons.app.kitchensink.e2etests.base.ActionParametersModule

class Parameters_Module extends ActionParametersModule {

    static content = {

        name { $("div.actionPanel div.actionParametersForm form.isis-busrulesobject-findbusrulesobject fieldset.parameters input", 0) }

    }



}
