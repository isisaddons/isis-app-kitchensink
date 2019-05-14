package org.isisaddons.app.kitchensink.dom.dependent;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.value.Blob;

@Mixin(
        method = "act"
)
public class NflPlayer_maintainProfile {
    private final NflPlayer nflPlayer;

    public NflPlayer_maintainProfile(final NflPlayer nflPlayer) {
        this.nflPlayer = nflPlayer;
    }

    public enum HideOrDisable {
        HIDE,
        DISABLE
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public Object act(
            final HideOrDisable hideOrDisable,
            final boolean uploadImage,
            final String comment,
            final String dropDown,
            @Nullable
            final Blob image) {
        // TODO - do something with it..
        System.out.println(image != null ? image.getName() : "<no image>");
        return this.nflPlayer;
    }

    public boolean hide1Act(HideOrDisable hideOrDisable) {
        return false; //hideOrDisable == null;
        //return hideOrDisable == null;
    }
    public String disable1Act(HideOrDisable hideOrDisable) {
        return hideOrDisable == null ? "select hide/disable" : null;
        //return hideOrDisable == null ? "select hide/disable" : null;
    }

    public boolean hide2Act(HideOrDisable hideOrDisable, boolean uploadImage) {
        //return hideOrDisable == null || hideOrDisable == HideOrDisable.HIDE && !uploadImage;
        return hideOrDisable == HideOrDisable.HIDE && !uploadImage;
    }
    public String disable2Act(HideOrDisable hideOrDisable, boolean uploadImage) {
        //return hideOrDisable == HideOrDisable.DISABLE && !uploadImage ? "Uploading image not selected" : null;
        return hideOrDisable == null || hideOrDisable == HideOrDisable.DISABLE && !uploadImage ? "Uploading image not selected" : null;
    }

    public boolean hide3Act(HideOrDisable hideOrDisable, boolean uploadImage) {
        //return hideOrDisable == null || hideOrDisable == HideOrDisable.HIDE && !uploadImage;
        return hideOrDisable == HideOrDisable.HIDE && !uploadImage;
    }
    public String disable3Act(HideOrDisable hideOrDisable, boolean uploadImage) {
        //return hideOrDisable == HideOrDisable.DISABLE && !uploadImage ? "Uploading image not selected" : null;
        return hideOrDisable == null || hideOrDisable == HideOrDisable.DISABLE && !uploadImage ? "Uploading image not selected" : null;
    }
    public List<String> choices3Act() {
        return Arrays.asList("a", "b", "c");
    }

    public boolean hide4Act(HideOrDisable hideOrDisable, boolean uploadImage) {
        return hideOrDisable == null || hideOrDisable == HideOrDisable.HIDE && !uploadImage;
    }
    public String disable4Act(HideOrDisable hideOrDisable, boolean uploadImage) {
        return hideOrDisable == HideOrDisable.DISABLE && !uploadImage ? "Uploading image not selected" : null;
    }

}
