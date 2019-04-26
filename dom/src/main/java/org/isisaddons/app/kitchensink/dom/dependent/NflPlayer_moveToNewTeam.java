package org.isisaddons.app.kitchensink.dom.dependent;

import java.util.List;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.value.Markup;

@Mixin(
        method = "act"
)
public class NflPlayer_moveToNewTeam {
    private final NflPlayer nflPlayer;

    public NflPlayer_moveToNewTeam(final NflPlayer nflPlayer) {
        this.nflPlayer = nflPlayer;
    }

    public enum HideOrDisable {
        HIDE,
        DISABLE
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public Object act(
            final HideOrDisable hideOrDisable,
            final NflLeague nflLeague,
            final NflRegion nflRegion,
            final NflTeamEntity nflTeam) {
        nflPlayer.updateUsingEntity(nflLeague, nflRegion, nflTeam);
        return this.nflPlayer;
    }

    public boolean hide1Act(HideOrDisable hideOrDisable) {
        return hideOrDisable == null;
    }

    public boolean hide2Act(HideOrDisable hideOrDisable, NflLeague nflLeague) {
        return hideOrDisable == null || hideOrDisable == HideOrDisable.HIDE && nflLeague == null;
    }
    public String disable2Act(HideOrDisable hideOrDisable, NflLeague nflLeague) {
        return hideOrDisable == HideOrDisable.DISABLE && nflLeague == null ? "Specify NFL League first" : null;
    }
    public List<NflRegion> choices2Act(HideOrDisable hideOrDisable, NflLeague nflLeague) {
        return NflRegion.thoseFor(nflLeague);
    }


    public boolean hide3Act(HideOrDisable hideOrDisable, NflLeague nflLeague, NflRegion nflRegion) {
        return hideOrDisable == null || hideOrDisable == HideOrDisable.HIDE && nflRegion == null;
    }
    public String disable3Act(HideOrDisable hideOrDisable, NflLeague nflLeague, NflRegion nflRegion) {
        return hideOrDisable == HideOrDisable.DISABLE && nflRegion == null ? "Specify NFL Region first" : null;
    }
    public List<NflTeamEntity> choices3Act(HideOrDisable hideOrDisable, NflLeague nflLeague, NflRegion nflRegion) {
        return nflTeams.thoseFor(nflRegion);
    }

    @Inject
    NflTeams nflTeams;

}
