package org.isisaddons.app.kitchensink.dom.dependent;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

@Mixin(
        method = "act"
)
public class NflPlayer_moveTeamMembers {
    private final NflPlayer nflPlayer;

    public NflPlayer_moveTeamMembers(final NflPlayer nflPlayer) {
        this.nflPlayer = nflPlayer;
    }

    @Action(
            semantics = SemanticsOf.IDEMPOTENT
    )
    @MemberOrder(
            sequence = "90.1"
    )
    public Object act(
            final NflRegion nflRegion,
            final NflTeamEnum nflTeam,
            @ParameterLayout(named = "move all?")
            final boolean moveAll,
            final List<NflPlayer> nflPlayers) {
        for (final NflPlayer nflPlayer : nflPlayers) {
            nflPlayer.updateUsingEnum(this.nflPlayer.getLeague(), nflRegion, nflTeam);
        }
        return this.nflPlayer;
    }

    public List<NflRegion> choices0Act() {
        return NflRegion.thoseFor(this.nflPlayer.getLeague());
    }
    public NflRegion default0Act() {
        return this.nflPlayer.getRegion();
    }
    public List<NflTeamEnum> choices1Act(final NflRegion nflRegion) {
        return NflTeamEnum.thoseFor(nflRegion);
    }
    public NflTeamEnum default1Act() {
        return this.nflPlayer.getTeamEnum();
    }

    public List<NflPlayer> choices3Act(
            final NflRegion nflRegion,
            final NflTeamEnum nflTeamEnum) {
        return nflPlayers.listAll().stream().filter(x -> x.getTeamEnum() == nflTeamEnum).collect(Collectors.toList());
    }
    public List<NflPlayer> default3Act(
            final NflRegion nflRegion,
            final NflTeamEnum nflTeamEnum,
            final boolean moveAll) {
        return moveAll ? choices3Act(nflRegion, nflTeamEnum) : Collections.emptyList();
    }

    @Inject
    NflPlayers nflPlayers;
}
