package org.isisaddons.app.kitchensink.dom.dependent;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.SemanticsOf;

@Mixin(
        method = "act"
)
public class NflPlayer_clone {
    private final NflPlayer nflPlayer;

    public NflPlayer_clone(final NflPlayer nflPlayer) {
        this.nflPlayer = nflPlayer;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public NflPlayer act(
            final String newName,
            final String unused) {
        return nflPlayers.create(newName, nflPlayer.getLeague(), nflPlayer.getRegion(), nflPlayer.getTeamEnum());
    }

    public String validate0Act(String newName) {
        return null;
    }
    public String default0Act() {
        return nflPlayer.getName();
    }

    @Inject
    NflPlayers nflPlayers;

}
