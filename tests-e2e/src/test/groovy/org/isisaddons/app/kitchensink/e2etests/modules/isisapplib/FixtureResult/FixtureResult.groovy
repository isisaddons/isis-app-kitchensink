package org.isisaddons.app.kitchensink.e2etests.modules.isisapplib.FixtureResult

import org.incode.platform.lib.gebspock.wicket.ui.components.collectioncontents.ajaxtable.CollectionContentsAsAjaxTablePanel
import org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string.StringPanel
import org.incode.platform.lib.gebspock.wicket.ui.components.standalonecollection.StandaloneCollectionPanel
import org.incode.platform.lib.gebspock.wicket.ui.pages.standalonecollection.StandaloneCollectionPage

class FixtureResult_StandaloneCollectionPage extends StandaloneCollectionPage {

    static at = {
        body.displayed
    }

    static content = {
        body(wait: true) { $(".standaloneCollectionPage").$(".isis-isisApplib-FixtureResult") }

        tablePanel { module(FixtureResult_CollectionContentsAsAjaxTablePanel) }
    }
}

class FixtureResult_CollectionContentsAsAjaxTablePanel extends CollectionContentsAsAjaxTablePanel {

    static base = { module(StandaloneCollectionPanel).$(".isis-isisApplib-FixtureResult") }

    static content = {
        columns { module(FixtureResult_CollectionContentsAsAjaxTablePanel_Columns) }
    }
}

class FixtureResult_CollectionContentsAsAjaxTablePanel_Columns extends CollectionContentsAsAjaxTablePanel {
    static content = {
        className { tbody.$("td.isis-isis-isisApplib-FixtureResult-className").module(StringPanel).columnValue(it) }
        fixtureScriptClassName { tbody.$("td.isis-isis-isisApplib-FixtureResult-fixtureScriptClassName").module(StringPanel).columnValue(it) }
        key { tbody.$("td.isis-isis-isisApplib-FixtureResult-key").module(StringPanel).columnValue(it) }
        object { tbody.$("td.isis-isis-isisApplib-FixtureResult-object").module(StringPanel).columnValue(it) }
    }
}