/*
 *  Copyright 2014 Dan Haywood
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.isisaddons.app.kitchensink.fixture.hierarchy;

import javax.inject.Inject;
import org.isisaddons.app.kitchensink.dom.hierarchy.child.ChildObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.child.ChildObjects;
import org.isisaddons.app.kitchensink.dom.hierarchy.grandchild.GrandchildObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.grandchild.GrandchildObjects;
import org.isisaddons.app.kitchensink.dom.hierarchy.parent.ParentObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.parent.ParentObjects;
import org.apache.isis.applib.fixturescripts.FixtureScript;

public class HierarchyObjectsFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {

        // create
        final ParentObject parent_1 = createParent("Parent 1", executionContext);
        final ChildObject child_1_1 = createChild("Child 1 1", parent_1, executionContext);
        createGrandchild("Grandchild 1 1 1", child_1_1, executionContext);
        createGrandchild("Grandchild 1 1 2", child_1_1, executionContext);
        createGrandchild("Grandchild 1 1 3", child_1_1, executionContext);

        final ChildObject child_1_2 = createChild("Child 1 2", parent_1, executionContext);
        createGrandchild("Grandchild 1 2 1", child_1_2, executionContext);
        createGrandchild("Grandchild 1 2 2", child_1_2, executionContext);
        createGrandchild("Grandchild 1 2 3", child_1_2, executionContext);

        final ChildObject child_1_3 = createChild("Child 1 3", parent_1, executionContext);
        createGrandchild("Grandchild 1 3 1", child_1_3, executionContext);
        createGrandchild("Grandchild 1 3 2", child_1_3, executionContext);
        createGrandchild("Grandchild 1 3 3", child_1_3, executionContext);



        final ParentObject parent_2 = createParent("Parent 2", executionContext);
        final ChildObject child_2_1 = createChild("Child 2 1", parent_2, executionContext);
        createGrandchild("Grandchild 2 1 1", child_2_1, executionContext);
        createGrandchild("Grandchild 2 1 2", child_2_1, executionContext);
        createGrandchild("Grandchild 2 1 3", child_2_1, executionContext);

        final ChildObject child_2_2 = createChild("Child 2 2", parent_2, executionContext);
        createGrandchild("Grandchild 2 2 1", child_2_2, executionContext);
        createGrandchild("Grandchild 2 2 2", child_2_2, executionContext);
        createGrandchild("Grandchild 2 2 3", child_2_2, executionContext);

        final ChildObject child_2_3 = createChild("Child 2 3", parent_2, executionContext);
        createGrandchild("Grandchild 2 3 1", child_2_3, executionContext);
        createGrandchild("Grandchild 2 3 2", child_2_3, executionContext);
        createGrandchild("Grandchild 2 3 3", child_2_3, executionContext);


        final ParentObject parent_3 = createParent("Parent 3", executionContext);
        final ChildObject child_3_1 = createChild("Child 3 1", parent_3, executionContext);
        createGrandchild("Grandchild 3 1 1", child_3_1, executionContext);
        createGrandchild("Grandchild 3 1 2", child_3_1, executionContext);
        createGrandchild("Grandchild 3 1 3", child_3_1, executionContext);

        final ChildObject child_3_2 = createChild("Child 3 2", parent_3, executionContext);
        createGrandchild("Grandchild 3 2 1", child_3_2, executionContext);
        createGrandchild("Grandchild 3 2 2", child_3_2, executionContext);
        createGrandchild("Grandchild 3 2 3", child_3_2, executionContext);

        final ChildObject child_3_3 = createChild("Child 3 3", parent_3, executionContext);
        createGrandchild("Grandchild 3 3 1", child_3_3, executionContext);
        createGrandchild("Grandchild 3 3 2", child_3_3, executionContext);
        createGrandchild("Grandchild 3 3 3", child_3_3, executionContext);


    }


    private ParentObject createParent(final String name, ExecutionContext executionContext) {
        return executionContext.addResult(this, parentObjects.create(name));
    }

    private ChildObject createChild(final String name, ParentObject parentObject, ExecutionContext executionContext) {
        return executionContext.addResult(this, childObjects.create(name, parentObject));
    }

    private GrandchildObject createGrandchild(final String name, ChildObject childObject, ExecutionContext executionContext) {
        return executionContext.addResult(this, grandchildObjects.create(name, childObject));
    }

    @Inject
    private ParentObjects parentObjects;

    @Inject
    private ChildObjects childObjects;

    @Inject
    private GrandchildObjects grandchildObjects;

}
