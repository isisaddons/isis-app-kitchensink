package org.incode.platform.lib.gebspock.wicket.ui.components.standalonecollection

import geb.Module

final class StandaloneCollectionPanel extends Module {

    // HACK: ought to be '.standaloneCollectionPage', but positioning of 'isis-' CSS is incorrect
    static base = { $(".standaloneCollectionPage") }

}
