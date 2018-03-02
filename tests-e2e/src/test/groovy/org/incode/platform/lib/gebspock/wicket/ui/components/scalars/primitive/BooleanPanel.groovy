package org.incode.platform.lib.gebspock.wicket.ui.components.scalars.primitive

import geb.Module

final class BooleanPanel extends Module {

    static content = {
        input { $("input") }

        columnValue { $("div.scalarNameAndValueComponentType.booleanPanel input", it).value().toBoolean() }
    }

}
