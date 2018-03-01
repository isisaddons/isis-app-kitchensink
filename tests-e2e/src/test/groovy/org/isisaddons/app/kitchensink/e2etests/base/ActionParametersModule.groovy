package org.isisaddons.app.kitchensink.e2etests.base

import geb.Module

class ActionParametersModule extends Module {

    static content = {

        //form { $(".actionParametersForm form", 0)}
        ok_button { $(".actionParametersForm .buttons input",0) }
        cancel_button { $(".actionParametersForm .buttons input",1) }

    }

}
