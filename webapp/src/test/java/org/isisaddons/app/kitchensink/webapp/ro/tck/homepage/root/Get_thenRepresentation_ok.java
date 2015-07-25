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
package org.isisaddons.app.kitchensink.webapp.ro.tck.homepage.root;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.apache.isis.viewer.restfulobjects.applib.Rel;
import org.apache.isis.viewer.restfulobjects.applib.RepresentationType;
import org.apache.isis.viewer.restfulobjects.applib.RestfulHttpMethod;
import org.apache.isis.viewer.restfulobjects.applib.client.RestfulClient;
import org.apache.isis.viewer.restfulobjects.applib.client.RestfulResponse;
import org.apache.isis.viewer.restfulobjects.applib.client.RestfulResponse.HttpStatusCode;
import org.apache.isis.viewer.restfulobjects.applib.homepage.HomePageRepresentation;
import org.apache.isis.viewer.restfulobjects.applib.homepage.HomePageResource;

import org.isisaddons.app.kitchensink.webapp.ro.tck.IsisWebServerRule;
import org.isisaddons.app.kitchensink.webapp.ro.tck.RestfulMatchers;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class Get_thenRepresentation_ok {

    @Rule
    public IsisWebServerRule webServerRule = new IsisWebServerRule();

    private RestfulClient client;
    private HomePageResource resource;

    @Before
    public void setUp() throws Exception {
        client = webServerRule.getClient();
        resource = client.getHomePageResource();
    }

    @Test
    public void representation() throws Exception {

        // given
        final Response resp = resource.homePage();

        // when
        final RestfulResponse<HomePageRepresentation> restfulResponse = RestfulResponse.ofT(resp);
        assertThat(restfulResponse.getStatus().getFamily(), is(Family.SUCCESSFUL));

        // then
        assertThat(restfulResponse.getStatus(), is(HttpStatusCode.OK));

        final HomePageRepresentation repr = restfulResponse.getEntity();
        assertThat(repr, is(not(nullValue())));
        assertThat(repr, RestfulMatchers.isMap());

        RestfulMatchers.assertThat(repr.getSelf(), RestfulMatchers.isLink(client)
                        .rel(Rel.SELF)
                        .href(endsWith(":39393/restful/"))
                        .httpMethod(RestfulHttpMethod.GET)
                        .type(RepresentationType.HOME_PAGE.getMediaType())
                        .returning(HttpStatusCode.OK)
        );
        RestfulMatchers.assertThat(repr.getUser(), RestfulMatchers.isLink(client)
                        .rel(Rel.USER)
                        .href(endsWith(":39393/restful/user"))
                        .httpMethod(RestfulHttpMethod.GET)
                        .type(RepresentationType.USER.getMediaType())
                        .returning(HttpStatusCode.OK)
        );
        RestfulMatchers.assertThat(repr.getServices(), RestfulMatchers.isLink(client)
                        .rel(Rel.SERVICES)
                        .href(endsWith(":39393/restful/services"))
                        .httpMethod(RestfulHttpMethod.GET)
                        .type(RepresentationType.LIST.getMediaType())
                        .returning(HttpStatusCode.OK)
        );
        RestfulMatchers.assertThat(repr.getVersion(), RestfulMatchers.isLink(client)
                        .rel(Rel.VERSION)
                        .href(endsWith(":39393/restful/version"))
                        .httpMethod(RestfulHttpMethod.GET)
                        .type(RepresentationType.VERSION.getMediaType())
                        .returning(HttpStatusCode.OK)
        );

        assertThat(repr.getLinks(), RestfulMatchers.isArray());
        assertThat(repr.getExtensions(), RestfulMatchers.isMap());
    }

}
