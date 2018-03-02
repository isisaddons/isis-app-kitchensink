package org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string

import geb.Module
import geb.module.TextInput

final class StringPanel extends Module {

    static content = {
        input { $("input").module(TextInput) }
        feedback { $(".alert") }

        column { $( "div.scalarNameAndValueComponentType.stringPanel" ) }
    }

}
