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
package org.isisaddons.app.kitchensink.dom.layout.layout_6_0_6_12C;

import javax.inject.Inject;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import org.isisaddons.app.kitchensink.dom.Entity;
import org.isisaddons.app.kitchensink.dom.dependent.NflPlayers;
import org.isisaddons.app.kitchensink.dom.javamath.JavaMathObjects;
import org.isisaddons.app.kitchensink.dom.text.TextObject;
import org.isisaddons.app.kitchensink.dom.text.TextObjects;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.clock.ClockService;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@ObjectType("LAYOUT_6_0_6_12C")
@Bookmarkable
public class Layout_6_0_6_12C_Object implements Entity<Layout_6_0_6_12C_Object> {

    //region > name (property)

    private String name;

    @Column(allowsNull="false")
    @Title(sequence="1")
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    //endregion


    //region > someString1 (property)
    private String someString1;

    @Column(allowsNull="true")
    public String getSomeString1() {
        return someString1;
    }

    public void setSomeString1(final String someString1) {
        this.someString1 = someString1;
    }
    //endregion

    //region > someString2 (property)
    private String someString2;

    @Column(allowsNull="true")
    public String getSomeString2() {
        return someString2;
    }

    public void setSomeString2(final String someString2) {
        this.someString2 = someString2;
    }
    //endregion

    //region > someString3 (property)
    private String someString3;

    @Column(allowsNull="true")
    public String getSomeString3() {
        return someString3;
    }

    public void setSomeString3(final String someString3) {
        this.someString3 = someString3;
    }
    //endregion

    //region > someString4 (property)
    private String someString4;

    @Column(allowsNull="true")
    public String getSomeString4() {
        return someString4;
    }

    public void setSomeString4(final String someString4) {
        this.someString4 = someString4;
    }
    //endregion

    //region > someString5 (property)
    private String someString5;

    @Column(allowsNull="true")
    public String getSomeString5() {
        return someString5;
    }

    public void setSomeString5(final String someString5) {
        this.someString5 = someString5;
    }
    //endregion

    //region > someString6 (property)
    private String someString6;

    @Column(allowsNull="true")
    public String getSomeString6() {
        return someString6;
    }

    public void setSomeString6(final String someString6) {
        this.someString6 = someString6;
    }
    //endregion


    //region > someTextObjects (collection)
    public java.util.List<TextObject> getSomeTextObjects() {
        return textObjects.listAll();
    }
    //endregion

    //region > someMathObjects (collection)
    public java.util.List<org.isisaddons.app.kitchensink.dom.javamath.JavaMathObject> getSomeMathObjects() {
        return mathObjects.listAll();
    }
    //endregion

    //region > someNflPlayers (collection)
    public java.util.List<org.isisaddons.app.kitchensink.dom.dependent.NflPlayer> getSomeNflPlayers() {
        return nflPlayers.listAll();
    }
    //endregion


    //region > compareTo

    @Override
    public int compareTo(Layout_6_0_6_12C_Object other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion


    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;
    @javax.inject.Inject
    @SuppressWarnings("unused")
    private ClockService clockService;

    @Inject
    private TextObjects textObjects;
    @Inject
    private JavaMathObjects mathObjects;
    @Inject
    private NflPlayers nflPlayers;

    //endregion

}
