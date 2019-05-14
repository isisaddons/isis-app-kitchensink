package org.isisaddons.app.kitchensink.dom.dependent;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.SemanticsOf;

@Mixin(
        method = "act"
)
public class NflPlayer_moveEnum {
    private final NflPlayer nflPlayer;

    public NflPlayer_moveEnum(final NflPlayer nflPlayer) {
        this.nflPlayer = nflPlayer;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public Object act(
            final INflLeague nflLeague,
            final NflRegion nflRegion,
            final NflTeamEntity nflTeam) {
        nflPlayer.updateUsingEntity((NflLeague)nflLeague, nflRegion, nflTeam);
        return this.nflPlayer;
    }

    public List<? extends INflLeague> choices0Act() {
        return Arrays.asList(NflLeague.values());
    }

    public List<NflRegion> choices1Act(INflLeague nflLeague) {
        return NflRegion.thoseFor(nflLeague);
    }

    public List<NflTeamEntity> choices2Act(INflLeague nflLeague, NflRegion nflRegion) {
        return nflTeams.thoseFor(nflRegion);
    }


    @Inject
    NflTeams nflTeams;

}
