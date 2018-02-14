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
package org.isisaddons.app.kitchensink.dom.bulk;

import java.util.List;

import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = WorkflowObject.class
)
@DomainServiceLayout(
        named="Misc",
        menuOrder = "10.9"
)
public class WorkflowObjects extends RepositoryAbstract<WorkflowObject> {

    public WorkflowObjects() {
        super(WorkflowObject.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public WorkflowObject createWorkflowObject(
            @ParameterLayout(named="Name")
            final String name) {
        final WorkflowObject obj = repositoryService.instantiate(WorkflowObject.class);
        obj.setName(name);
        obj.setState(State.OPEN);

        repositoryService.persist(obj);
        return obj;
    }

    @ActionLayout(named = "first Workflow Object (bulk)")
    @Override
    public WorkflowObject first() {
        return super.first();
    }

    @ActionLayout(named = "list all Workflow Objects (bulk)")
    @Override
    public List<WorkflowObject> listAll() {
        return super.listAll();
    }
}
