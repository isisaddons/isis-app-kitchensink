package org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string

import geb.Module
import geb.module.Textarea

final class MultiLineStringPanel extends Module {

    static content = {
        input { $("input").module(Textarea) }
        //feedback { $(".alert") }

        //columnValue { $( "div.scalarNameAndValueComponentType.multiLineStringPanel", it ).text() }
    }

}
