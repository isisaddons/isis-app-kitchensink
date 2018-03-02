package org.incode.platform.lib.gebspock.wicket.ui.components.actionprompt

import geb.Module

/**
 * Provides a base for the modal dialog.
 */
final class ActionPromptModalWindow extends Module {

    static base = { $(".modal-body div.actionPanel" ) }

    static content = {

    }

}
