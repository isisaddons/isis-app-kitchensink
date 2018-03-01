package org.isisaddons.app.kitchensink.e2etests.base

import geb.Module

class ScalarPropertyOrParameterModule extends Module {

    static content = {

        feedback { $(".xxx",0) }

    }

}
