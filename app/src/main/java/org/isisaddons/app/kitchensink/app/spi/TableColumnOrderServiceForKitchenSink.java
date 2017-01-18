/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
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
package org.isisaddons.app.kitchensink.app.spi;

import java.util.Arrays;
import java.util.List;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.services.tablecol.TableColumnOrderService;

import org.isisaddons.app.kitchensink.dom.hierarchy.parent.ParentObject;

@DomainService(nature = NatureOfService.DOMAIN, menuOrder = "100")
public class TableColumnOrderServiceForKitchenSink implements TableColumnOrderService {

    @Override
    public List<String> orderParented(
            final Object parent,
            final String collectionId, final Class<?> collectionType, final List<String> propertyIds) {
        if(parent instanceof ParentObject) {
            if("children".equals(collectionId)) {
                return Arrays.asList("parent", "name");
            }
        }
        return null;
    }

    @Override
    public List<String> orderStandalone(
            final Class<?> collectionType,
            final List<String> propertyIds) {
        return null;
    }
}
