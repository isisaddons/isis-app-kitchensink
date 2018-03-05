package org.isisaddons.app.kitchensink.e2etests.modules.isisapplib.FixtureScriptsDefault

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.actionprompt.ActionPromptModalWindow
import org.incode.platform.lib.gebspock.wicket.ui.components.actions.ActionParametersFormPanel
import org.incode.platform.lib.gebspock.wicket.ui.components.header.HeaderPanel
import org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string.EntityLinkSelect2Panel
import org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string.MultiLineStringPanel

class FixtureScriptsDefault_DomainService extends Module {
    static content = {
        menu { $("li.dropdown.isis-isisApplib-FixtureScriptsDefault a", 0)}

        runFixtureScript { module RunFixtureScript_MenuItem }
    }
}

class RunFixtureScript_MenuItem extends Module {
    static content = {
        menuItem { module(HeaderPanel).tertiary.$(".dropdown")
                    $("li.isis-isisApplib-FixtureScriptsDefault-runFixtureScript a")}
        prompt(wait:true) { module RunFixtureScript_Prompt }
    }
}

class RunFixtureScript_Prompt extends ActionParametersFormPanel {
    static base = {
        module(ActionPromptModalWindow) // because this prompt is DIALOG, not INLINE
                .$(".isis-isisApplib-FixtureScriptsDefault-runFixtureScript")
    }
    static content = {
        parameters { $("fieldset.parameters").module RunFixtureScript_PromptParams }
    }
}

class RunFixtureScript_PromptParams extends Module {
    static content = {
        script { module(RunFixtureScript_Script) }
        parameters { module(RunFixtureScript_Parameters) }
    }
}

class RunFixtureScript_Script extends EntityLinkSelect2Panel {
    static base = { $(".isis-isisApplib-FixtureScriptsDefault-runFixtureScript-script") }
    static content = {
    }
}

class RunFixtureScript_Parameters extends Module {
    static content = {
        input { $(".isis-isisApplib-FixtureScriptsDefault-runFixtureScript-script").module(MultiLineStringPanel).input }
        feedback(wait:true) { $(".isis-isisApplib-FixtureScriptsDefault-runFixtureScript-script").module(MultiLineStringPanel).feedback }
    }
}

