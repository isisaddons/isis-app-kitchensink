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
package org.isisaddons.app.kitchensink.webapp.ro.tck;

import java.net.URI;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import org.apache.isis.core.runtime.system.context.IsisContext;
import org.apache.isis.core.webserver.WebServer;
import org.apache.isis.viewer.restfulobjects.applib.client.RestfulClient;

public class IsisWebServerRule implements MethodRule {

    private static ThreadLocal<WebServer> WEBSERVER = new ThreadLocal<WebServer>();

    private final int port;
    private final String path;
    private final String user;
    private final String pass;

    public IsisWebServerRule() {
        this(39393, "restful/", "sven", "pass");
    }

    public IsisWebServerRule(final int port, final String path, final String user, final String pass) {
        this.port = port;
        this.path = path;
        this.user = user;
        this.pass = pass;
    }

    private RestfulClient client;

    @Override
    public Statement apply(final Statement base, final FrameworkMethod method, final Object target) {
        getWebServer(); // creates and starts running if required
        return base;
    }

    public WebServer getWebServer() {
        WebServer webServer = WEBSERVER.get();
        if(webServer == null) {
            webServer = new WebServer();
            WEBSERVER.set(webServer);
            webServer.run(port);
        }
        return webServer;
    }
    
    public void discardWebApp() {
        getWebServer().stop();
        WEBSERVER.set(null);
        IsisContext.testReset();
    }

    public RestfulClient getClient() {
        return getClient(this.path);
    }

    private RestfulClient getClient(final String path) {
        if(client == null) {
            final URI restfulUri = resolveUri(path);

            final ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager();
            final DefaultHttpClient httpClient = new DefaultHttpClient(threadSafeClientConnManager);

            if(user != null) {
                httpClient.getCredentialsProvider().setCredentials(
                        new AuthScope("localhost", port),
                        new UsernamePasswordCredentials(user, pass)
                );
            }

            client = new RestfulClient(restfulUri, httpClient);
        }
        return client;
    }


    private URI resolveUri(final String path) {
        final WebServer webServer = getWebServer();
        final URI base = webServer.getBase();
        return path != null? base.resolve(path): base;
    }

}
