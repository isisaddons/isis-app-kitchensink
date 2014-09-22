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
package org.isisaddons.app.kitchensink.dom.text;

import java.util.Collection;
import java.util.List;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import com.google.common.collect.Lists;
import org.isisaddons.app.kitchensink.dom.Entity;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@ObjectType("TEXT")
@Bookmarkable
public class TextObject implements Entity<TextObject> {


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

    //region > someChar (property)
    private char someChar;

    public char getSomeChar() {
        return someChar;
    }

    public void setSomeChar(final char someChar) {
        this.someChar = someChar;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeChar(final char i) {
        setSomeChar(i);
        return this;
    }
    public char default0UpdateSomeChar() {
        return getSomeChar();
    }
    //endregion

    //region > someCharHidden (property)
    private char someCharHidden;

    @Hidden
    public char getSomeCharHidden() {
        return someCharHidden;
    }

    public void setSomeCharHidden(final char someCharHidden) {
        this.someCharHidden = someCharHidden;
    }

    //endregion

    //region > someCharDisabled (property)
    private char someCharDisabled;

    @Disabled
    public char getSomeCharDisabled() {
        return someCharDisabled;
    }

    public void setSomeCharDisabled(final char someCharDisabled) {
        this.someCharDisabled = someCharDisabled;
    }

    //endregion

    //region > someCharWithValidation (property)
    private char someCharWithValidation;

    public char getSomeCharWithValidation() {
        return someCharWithValidation;
    }

    public void setSomeCharWithValidation(final char someCharWithValidation) {
        this.someCharWithValidation = someCharWithValidation;
    }

    public String validateSomeCharWithValidation(final char c) {
        return c % 2 != 0? "Can only enter even characters": null;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeCharWithValidation(final char i) {
        setSomeCharWithValidation(i);
        return this;
    }

    public String validateUpdateSomeCharWithValidation(final char i) {
        return validateSomeCharWithValidation(i);
    }
    public char default0UpdateSomeCharWithValidation() {
        return getSomeCharWithValidation();
    }

    //endregion

    //region > someCharWithChoices (property)
    private char someCharWithChoices;

    public char getSomeCharWithChoices() {
        return someCharWithChoices;
    }

    public void setSomeCharWithChoices(final char someCharWithChoices) {
        this.someCharWithChoices = someCharWithChoices;
    }

    public Collection<Character> choicesSomeCharWithChoices() {
        return Lists.newArrayList('a','b','c','d');
    }
    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeCharWithChoices(final char i) {
        setSomeCharWithChoices(i);
        return this;
    }

    public char default0UpdateSomeCharWithChoices() {
        return getSomeCharWithChoices();
    }

    public List<Character> choices0UpdateSomeCharWithChoices() {
        return Lists.newArrayList('a','b','c','d');
    }
    //endregion


    //region > someCharacterWrapperMandatory (property)
    private Character someCharacterWrapperMandatory;

    @Column(allowsNull = "false")
    public Character getSomeCharacterWrapperMandatory() {
        return someCharacterWrapperMandatory;
    }

    public void setSomeCharacterWrapperMandatory(final Character someCharacterWrapperMandatory) {
        this.someCharacterWrapperMandatory = someCharacterWrapperMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeCharacterWrapperMandatory(final Character i) {
        setSomeCharacterWrapperMandatory(i);
        return this;
    }
    public Character default0UpdateSomeCharacterWrapperMandatory() {
        return getSomeCharacterWrapperMandatory();
    }
    //endregion

    //region > someCharacterWrapperOptional (property)
    private Character someCharacterWrapperOptional;

    @Column(allowsNull = "true")
    public Character getSomeCharacterWrapperOptional() {
        return someCharacterWrapperOptional;
    }

    public void setSomeCharacterWrapperOptional(final Character someCharacterWrapperOptional) {
        this.someCharacterWrapperOptional = someCharacterWrapperOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeCharacterWrapperOptional(final @Optional Character i) {
        setSomeCharacterWrapperOptional(i);
        return this;
    }
    public Character default0UpdateSomeCharacterWrapperOptional() {
        return getSomeCharacterWrapperOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject resetSomeCharacterWrapperOptional() {
        setSomeCharacterWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someCharacterWrapperHidden (property)
    private java.lang.Character someCharacterWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Hidden
    public java.lang.Character getSomeCharacterWrapperHidden() {
        return someCharacterWrapperHidden;
    }

    public void setSomeCharacterWrapperHidden(final java.lang.Character someCharacterWrapperHidden) {
        this.someCharacterWrapperHidden = someCharacterWrapperHidden;
    }

    //endregion

    //region > someCharacterWrapperDisabled (property)
    private java.lang.Character someCharacterWrapperDisabled;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Disabled
    public java.lang.Character getSomeCharacterWrapperDisabled() {
        return someCharacterWrapperDisabled;
    }

    public void setSomeCharacterWrapperDisabled(final java.lang.Character someCharacterWrapperDisabled) {
        this.someCharacterWrapperDisabled = someCharacterWrapperDisabled;
    }

    //endregion

    //region > someCharacterWrapperWithValidation (property)
    private java.lang.Character someCharacterWrapperWithValidation;

    @javax.jdo.annotations.Column(allowsNull = "false")
    public java.lang.Character getSomeCharacterWrapperWithValidation() {
        return someCharacterWrapperWithValidation;
    }

    public void setSomeCharacterWrapperWithValidation(final java.lang.Character someCharacterWrapperWithValidation) {
        this.someCharacterWrapperWithValidation = someCharacterWrapperWithValidation;
    }

    public String validateSomeCharacterWrapperWithValidation(final java.lang.Character i) {
        return i % 2 != 0? "Can only enter even numbers": null;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeCharacterWrapperWithValidation(final java.lang.Character i) {
        setSomeCharacterWrapperWithValidation(i);
        return this;
    }

    public String validateUpdateSomeCharacterWrapperWithValidation(final java.lang.Character i) {
        return validateSomeCharacterWrapperWithValidation(i);
    }
    public java.lang.Character default0UpdateSomeCharacterWrapperWithValidation() {
        return getSomeCharacterWrapperWithValidation();
    }

    //endregion

    //region > someCharacterWrapperMandatoryWithChoices (property)
    private Character someCharacterWrapperMandatoryWithChoices;

    @Column(allowsNull = "false")
    public Character getSomeCharacterWrapperMandatoryWithChoices() {
        return someCharacterWrapperMandatoryWithChoices;
    }

    public void setSomeCharacterWrapperMandatoryWithChoices(final Character someCharacterWrapperMandatoryWithChoices) {
        this.someCharacterWrapperMandatoryWithChoices = someCharacterWrapperMandatoryWithChoices;
    }
    public Collection<Character> choicesSomeCharacterWrapperMandatoryWithChoices() {
        return Lists.newArrayList('a','b','c','d');
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeCharacterWrapperMandatoryWithChoices(final Character i) {
        setSomeCharacterWrapperMandatoryWithChoices(i);
        return this;
    }
    public Character default0UpdateSomeCharacterWrapperMandatoryWithChoices() {
        return getSomeCharacterWrapperMandatoryWithChoices();
    }
    public List<Character> choices0UpdateSomeCharacterWrapperMandatoryWithChoices() {
        return Lists.newArrayList('a','b','c','d');
    }
    //endregion

    //region > someCharacterWrapperOptionalWithChoices (property)
    private Character someCharacterWrapperOptionalWithChoices;

    @Column(allowsNull = "true")
    public Character getSomeCharacterWrapperOptionalWithChoices() {
        return someCharacterWrapperOptionalWithChoices;
    }

    public void setSomeCharacterWrapperOptionalWithChoices(final Character someCharacterWrapperOptionalWithChoices) {
        this.someCharacterWrapperOptionalWithChoices = someCharacterWrapperOptionalWithChoices;
    }
    public Collection<Character> choicesSomeCharacterWrapperOptionalWithChoices() {
        return Lists.newArrayList('a','b','c','d');
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeCharacterWrapperOptionalWithChoices(final @Optional Character i) {
        setSomeCharacterWrapperOptionalWithChoices(i);
        return this;
    }
    public Character default0UpdateSomeCharacterWrapperOptionalWithChoices() {
        return getSomeCharacterWrapperOptionalWithChoices();
    }
    public List<Character> choices0UpdateSomeCharacterWrapperOptionalWithChoices() {
        return Lists.newArrayList('a','b','c','d');
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject resetSomeCharacterWrapperOptionalWithChoices() {
        setSomeCharacterWrapperOptionalWithChoices(null);
        return this;
    }
    //endregion


    //region > someStringMandatory (property)
    private String someStringMandatory;

    @Column(allowsNull = "false")
    public String getSomeStringMandatory() {
        return someStringMandatory;
    }

    public void setSomeStringMandatory(final String someStringMandatory) {
        this.someStringMandatory = someStringMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeStringMandatory(final String i) {
        setSomeStringMandatory(i);
        return this;
    }
    public String default0UpdateSomeStringMandatory() {
        return getSomeStringMandatory();
    }
    //endregion

    //region > someStringOptional (property)
    private String someStringOptional;

    @Column(allowsNull = "true")
    public String getSomeStringOptional() {
        return someStringOptional;
    }

    public void setSomeStringOptional(final String someStringOptional) {
        this.someStringOptional = someStringOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeStringOptional(final @Optional String i) {
        setSomeStringOptional(i);
        return this;
    }
    public String default0UpdateSomeStringOptional() {
        return getSomeStringOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject resetSomeStringOptional() {
        setSomeStringOptional(null);
        return this;
    }
    //endregion

    //region > someStringHidden (property)
    private String someStringHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Hidden
    public String getSomeStringHidden() {
        return someStringHidden;
    }

    public void setSomeStringHidden(final String someStringHidden) {
        this.someStringHidden = someStringHidden;
    }

    //endregion

    //region > someStringDisabled (property)
    private String someStringDisabled;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Disabled
    public String getSomeStringDisabled() {
        return someStringDisabled;
    }

    public void setSomeStringDisabled(final String someStringDisabled) {
        this.someStringDisabled = someStringDisabled;
    }

    //endregion

    //region > someStringWithValidation (property)
    private String someStringWithValidation;

    @javax.jdo.annotations.Column(allowsNull = "false")
    public String getSomeStringWithValidation() {
        return someStringWithValidation;
    }

    public void setSomeStringWithValidation(final String someStringWithValidation) {
        this.someStringWithValidation = someStringWithValidation;
    }

    public String validateSomeStringWithValidation(final String x) {
        return !x.startsWith("a") ? "Must start with letter 'a'": null;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeStringWithValidation(final String i) {
        setSomeStringWithValidation(i);
        return this;
    }

    public String validateUpdateSomeStringWithValidation(final String i) {
        return validateSomeStringWithValidation(i);
    }
    public String default0UpdateSomeStringWithValidation() {
        return getSomeStringWithValidation();
    }

    //endregion

    //region > someStringMandatoryWithChoices (property)
    private String someStringMandatoryWithChoices;

    @Column(allowsNull = "false")
    public String getSomeStringMandatoryWithChoices() {
        return someStringMandatoryWithChoices;
    }

    public void setSomeStringMandatoryWithChoices(final String someStringMandatoryWithChoices) {
        this.someStringMandatoryWithChoices = someStringMandatoryWithChoices;
    }
    public Collection<String> choicesSomeStringMandatoryWithChoices() {
        return Lists.newArrayList("a", "ab", "abcd", "abcdefgh", "abcdefghijklmnop", "abcdefghijklmnopqrstuvwxyz");
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeStringMandatoryWithChoices(final String i) {
        setSomeStringMandatoryWithChoices(i);
        return this;
    }
    public String default0UpdateSomeStringMandatoryWithChoices() {
        return getSomeStringMandatoryWithChoices();
    }
    public List<String> choices0UpdateSomeStringMandatoryWithChoices() {
        return Lists.newArrayList("a", "ab", "abcd", "abcdefgh", "abcdefghijklmnop", "abcdefghijklmnopqrstuvwxyz");
    }
    //endregion

    //region > someStringOptionalWithChoices (property)
    private String someStringOptionalWithChoices;

    @Column(allowsNull = "true")
    public String getSomeStringOptionalWithChoices() {
        return someStringOptionalWithChoices;
    }

    public void setSomeStringOptionalWithChoices(final String someStringOptionalWithChoices) {
        this.someStringOptionalWithChoices = someStringOptionalWithChoices;
    }
    public Collection<String> choicesSomeStringOptionalWithChoices() {
        return Lists.newArrayList("a", "ab", "abcd", "abcdefgh", "abcdefghijklmnop", "abcdefghijklmnopqrstuvwxyz");
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeStringOptionalWithChoices(final @Optional String i) {
        setSomeStringOptionalWithChoices(i);
        return this;
    }
    public String default0UpdateSomeStringOptionalWithChoices() {
        return getSomeStringOptionalWithChoices();
    }
    public List<String> choices0UpdateSomeStringOptionalWithChoices() {
        return Lists.newArrayList("a", "ab", "abcd", "abcdefgh", "abcdefghijklmnop", "abcdefghijklmnopqrstuvwxyz");
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject resetSomeStringOptionalWithChoices() {
        setSomeStringOptionalWithChoices(null);
        return this;
    }
    //endregion


    //region > someString20 (property)
    private String someString20;

    @Column(allowsNull = "true", length = 20)
    public String getSomeString20() {
        return someString20;
    }

    public void setSomeString20(final String someString20) {
        this.someString20 = someString20;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeString20(final @Optional @MaxLength(20) String i) {
        setSomeString20(i);
        return this;
    }
    public String default0UpdateSomeString20() {
        return getSomeString20();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject resetSomeString20() {
        setSomeString20(null);
        return this;
    }
    //endregion

    //region > someString50 (property)
    private String someString50;

    @TypicalLength(20)
    @Column(allowsNull = "true", length = 50)
    public String getSomeString50() {
        return someString50;
    }

    public void setSomeString50(final String someString50) {
        this.someString50 = someString50;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeString50(final @Optional @MaxLength(50) @TypicalLength(20) String i) {
        setSomeString50(i);
        return this;
    }
    public String default0UpdateSomeString50() {
        return getSomeString50();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject resetSomeString50() {
        setSomeString50(null);
        return this;
    }
    //endregion


    //region > someStringMulti (property)
    private String someStringMulti;

    @MultiLine(numberOfLines = 10, preventWrapping = false) 
    @Column(allowsNull = "true", length = 2048)
    public String getSomeStringMulti() {
        return someStringMulti;
    }

    public void setSomeStringMulti(final String someStringMulti) {
        this.someStringMulti = someStringMulti;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeStringMulti(final @Optional @MultiLine(numberOfLines = 10, preventWrapping = false) @MaxLength(2048)  String i) {
        setSomeStringMulti(i);
        return this;
    }
    public String default0UpdateSomeStringMulti() {
        return getSomeStringMulti();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject resetSomeStringMulti() {
        setSomeStringMulti(null);
        return this;
    }
    //endregion

    //region > someStringMultiNoWrap (property)
    private String someStringMultiNoWrap;

    @MultiLine(numberOfLines = 4, preventWrapping = true)
    @Column(allowsNull = "true", length = 2048)
    public String getSomeStringMultiNoWrap() {
        return someStringMultiNoWrap;
    }

    public void setSomeStringMultiNoWrap(final String someStringMultiNoWrap) {
        this.someStringMultiNoWrap = someStringMultiNoWrap;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject updateSomeStringMultiNoWrap(final @Optional @MultiLine(numberOfLines = 4, preventWrapping = true) @MaxLength(2048) String i) {
        setSomeStringMultiNoWrap(i);
        return this;
    }
    public String default0UpdateSomeStringMultiNoWrap() {
        return getSomeStringMultiNoWrap();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public TextObject resetSomeStringMultiNoWrap() {
        setSomeStringMultiNoWrap(null);
        return this;
    }
    //endregion


    //region > compareTo

    @Override
    public int compareTo(TextObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    //endregion

}
