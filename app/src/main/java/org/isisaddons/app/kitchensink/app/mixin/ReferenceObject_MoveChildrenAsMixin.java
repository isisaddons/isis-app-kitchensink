package org.isisaddons.app.kitchensink.app.mixin;

import java.util.List;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.SemanticsOf;

import org.isisaddons.app.kitchensink.dom.reference.ReferenceChildObject;
import org.isisaddons.app.kitchensink.dom.reference.ReferenceChildObjects;
import org.isisaddons.app.kitchensink.dom.reference.ReferenceObject;

@Mixin
public class ReferenceObject_MoveChildrenAsMixin {

    private final ReferenceObject object;
    public ReferenceObject_MoveChildrenAsMixin(ReferenceObject object){
        this.object = object;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public ReferenceObject moveChildrenMixinTest(
            final List<ReferenceChildObject> childObjects
            ){
        for (ReferenceChildObject childObject : childObjects) {
            childObject.setParent(object);
        }
        return object;
    }

    public List<ReferenceChildObject> choices0MoveChildrenMixinTest() {
        return otherChildren(object);
    }

    private List<ReferenceChildObject> otherChildren(final ReferenceObject object) {
        final List<ReferenceChildObject> referenceChildObjects = this.referenceChildObjects.listAll();
        referenceChildObjects.removeAll(object.getChildren());
        return referenceChildObjects;
    }

    @Inject
    ReferenceChildObjects referenceChildObjects;

}
