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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.MinLength;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.PropertyLayout;
import org.apache.isis.applib.annotation.Publishing;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.util.ObjectContracts;
import org.apache.isis.applib.value.Password;

import org.isisaddons.app.kitchensink.dom.Entity;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "TEXT"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Property(hidden = Where.EVERYWHERE)
    public char getSomeCharHidden() {
        return someCharHidden;
    }

    public void setSomeCharHidden(final char someCharHidden) {
        this.someCharHidden = someCharHidden;
    }

    //endregion

    //region > someCharDisabled (property)
    private char someCharDisabled;

    @Property(editing = Editing.DISABLED)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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
    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomeCharacterWrapperOptional(@Parameter(optionality=Optionality.OPTIONAL) final  Character i) {
        setSomeCharacterWrapperOptional(i);
        return this;
    }
    public Character default0UpdateSomeCharacterWrapperOptional() {
        return getSomeCharacterWrapperOptional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject resetSomeCharacterWrapperOptional() {
        setSomeCharacterWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someCharacterWrapperHidden (property)
    private java.lang.Character someCharacterWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
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
    @Property(editing = Editing.DISABLED)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomeCharacterWrapperOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  Character i) {
        setSomeCharacterWrapperOptionalWithChoices(i);
        return this;
    }
    public Character default0UpdateSomeCharacterWrapperOptionalWithChoices() {
        return getSomeCharacterWrapperOptionalWithChoices();
    }
    public List<Character> choices0UpdateSomeCharacterWrapperOptionalWithChoices() {
        return Lists.newArrayList('a','b','c','d');
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomeStringOptional(@Parameter(optionality=Optionality.OPTIONAL) final  String i) {
        setSomeStringOptional(i);
        return this;
    }
    public String default0UpdateSomeStringOptional() {
        return getSomeStringOptional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject resetSomeStringOptional() {
        setSomeStringOptional(null);
        return this;
    }
    //endregion

    //region > someStringHidden (property)
    private String someStringHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
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
    @Property(editing = Editing.DISABLED)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomeStringWithValidation(final String i) {
        setSomeStringWithValidation(i);
        return this;
    }

    public String validate0UpdateSomeStringWithValidation(final String i) {
        return !i.startsWith("a") ? "Must start with letter 'a'": null;
    }
    public String validateUpdateSomeStringWithValidation(final String x) {
        return !x.endsWith("z") ? "Must end with letter 'z'": null;
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomeStringOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  String i) {
        setSomeStringOptionalWithChoices(i);
        return this;
    }
    public String default0UpdateSomeStringOptionalWithChoices() {
        return getSomeStringOptionalWithChoices();
    }
    public List<String> choices0UpdateSomeStringOptionalWithChoices() {
        return Lists.newArrayList("a", "ab", "abcd", "abcdefgh", "abcdefghijklmnop", "abcdefghijklmnopqrstuvwxyz");
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject resetSomeStringOptionalWithChoices() {
        setSomeStringOptionalWithChoices(null);
        return this;
    }
    //endregion

    //region > someStringOptionalWithMultiChoices (property)
    private String someStringOptionalWithMultiChoices;

    @Property(editing = Editing.ENABLED)
    @Column(allowsNull = "true")
    public String getSomeStringOptionalWithMultiChoices() {
        return someStringOptionalWithMultiChoices;
    }

    public void setSomeStringOptionalWithMultiChoices(final String someStringOptionalWithMultiChoices) {
        this.someStringOptionalWithMultiChoices = someStringOptionalWithMultiChoices;
    }

    public List<String> choicesSomeStringOptionalWithMultiChoices() {
        return Lists.newArrayList("a", "ab", "abcd", "abcdefgh", "abcdefghijklmnop", "abcdefghijklmnopqrstuvwxyz");
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT, publishing = Publishing.ENABLED)
    public TextObject updateSomeStringOptionalWithMultiChoices(
            // @Nullable
            @ParameterLayout(named = "Choose some string(s)")
            final List<String> strings) {
        final String asStr = SeparatorUtil.asStr(strings);
        setSomeStringOptionalWithMultiChoices(asStr);
        return this;
    }

    public List<String> default0UpdateSomeStringOptionalWithMultiChoices() {
        return SeparatorUtil.asList(getSomeStringOptionalWithMultiChoices());
    }

    public List<String> choices0UpdateSomeStringOptionalWithMultiChoices() {
        return choicesSomeStringOptionalWithMultiChoices();
    }



    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject resetSomeStringOptionalWithMultiChoices() {
        setSomeStringOptionalWithMultiChoices(null);
        return this;
    }
    //endregion

    //region > someStringOptionalWithMultiAutoComplete (property - NOT SUPPORTED)
    private String someStringOptionalWithMultiAutoComplete;


    @Property(
            editing = Editing.DISABLED,
            hidden = Where.EVERYWHERE  // autocomplete on values is NOT SUPPORTED
    )
    @Column(allowsNull = "true")
    public String getSomeStringOptionalWithMultiAutoComplete() {
        return someStringOptionalWithMultiAutoComplete;
    }

    public void setSomeStringOptionalWithMultiAutoComplete(final String someStringOptionalWithMultiAutoComplete) {
        this.someStringOptionalWithMultiAutoComplete = someStringOptionalWithMultiAutoComplete;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT, publishing = Publishing.ENABLED)
    public TextObject updateSomeStringOptionalWithMultiAutoComplete(
            @Nullable
            final List<String> strings) {
        setSomeStringOptionalWithMultiAutoComplete(SeparatorUtil.asStr(strings));
        return this;
    }
    public List<String> default0UpdateSomeStringOptionalWithMultiAutoComplete() {
        final String current = getSomeStringOptionalWithMultiAutoComplete();
        return SeparatorUtil.asList(current);
    }
    public List<String> autoComplete0UpdateSomeStringOptionalWithMultiAutoComplete(final @MinLength(1) String search) {
        final ArrayList<String> strings = Lists
                .newArrayList("a", "ab", "abcd", "abcdefgh", "abcdefghijklmnop", "abcdefghijklmnopqrstuvwxyz");
        return strings.stream().filter(x -> x.contains(search)).collect(Collectors.toList());
    }



    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject resetSomeStringOptionalWithMultiAutoComplete() {
        setSomeStringOptionalWithMultiAutoComplete(null);
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomeString20(@Parameter(optionality=Optionality.OPTIONAL, maxLength = 20) final  String i) {
        setSomeString20(i);
        return this;
    }
    public String default0UpdateSomeString20() {
        return getSomeString20();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject resetSomeString20() {
        setSomeString20(null);
        return this;
    }
    //endregion

    //region > someString50 (property)
    private String someString50;

    @PropertyLayout(typicalLength = 20)
    @Column(allowsNull = "true", length = 50)
    public String getSomeString50() {
        return someString50;
    }

    public void setSomeString50(final String someString50) {
        this.someString50 = someString50;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomeString50(@Parameter(optionality=Optionality.OPTIONAL, maxLength = 50) final  @ParameterLayout(typicalLength = 20) String i) {
        setSomeString50(i);
        return this;
    }
    public String default0UpdateSomeString50() {
        return getSomeString50();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject resetSomeString50() {
        setSomeString50(null);
        return this;
    }
    //endregion


    //region > somePasswordMandatory (property)
    private String somePasswordMandatoryStr;

    @Programmatic
    @Column(allowsNull = "false")
    public String getSomePasswordMandatoryStr() {
        return somePasswordMandatoryStr;
    }

    public void setSomePasswordMandatoryStr(final String somePasswordMandatoryStr) {
        this.somePasswordMandatoryStr = somePasswordMandatoryStr;
    }

    @javax.jdo.annotations.NotPersistent
    public Password getSomePasswordMandatory() {
        return new Password(somePasswordMandatoryStr);
    }
    public void setSomePasswordMandatory(final Password somePasswordMandatory) {
        this.somePasswordMandatoryStr = somePasswordMandatory.getPassword();
    }


    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomePasswordMandatory(final Password password) {
        setSomePasswordMandatory(password);
        return this;
    }
    public Password default0UpdateSomePasswordMandatory() {
        return getSomePasswordMandatory();
    }
    //endregion

    //region > somePasswordOptional (property)
    private String somePasswordOptionalStr;

    @Column(allowsNull = "true")
    @Programmatic
    public String getSomePasswordOptionalStr() {
        return somePasswordOptionalStr;
    }

    public void setSomePasswordOptionalStr(final String somePasswordOptionalStr) {
        this.somePasswordOptionalStr = somePasswordOptionalStr;
    }

    @javax.jdo.annotations.NotPersistent
    @Property(optionality=Optionality.OPTIONAL)
    public Password getSomePasswordOptional() {
        return new Password(somePasswordOptionalStr);
    }
    public void setSomePasswordOptional(final Password somePasswordOptional) {
        this.somePasswordOptionalStr = somePasswordOptional != null? somePasswordOptional.getPassword(): null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomePasswordOptional(@Parameter(optionality=Optionality.OPTIONAL) final  Password password) {
        setSomePasswordOptional(password);
        return this;
    }
    public Password default0UpdateSomePasswordOptional() {
        return getSomePasswordOptional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject resetSomePasswordOptional() {
        setSomePasswordOptionalStr(null);
        return this;
    }
    //endregion


    //region > somePasswordHidden (property)
    private String somePasswordHiddenStr;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Programmatic
    public String getSomePasswordHiddenStr() {
        return somePasswordHiddenStr;
    }

    public void setSomePasswordHiddenStr(final String somePasswordHiddenStr) {
        this.somePasswordHiddenStr = somePasswordHiddenStr;
    }

    @javax.jdo.annotations.NotPersistent
    @Property(hidden = Where.EVERYWHERE)
    public Password getSomePasswordHidden() {
        return new Password(somePasswordHiddenStr);
    }
    public void setSomePasswordHidden(final Password somePasswordHidden) {
        this.somePasswordHiddenStr = somePasswordHidden.getPassword();
    }

    //endregion

    //region > somePasswordDisabled (property)
    private String somePasswordDisabledStr;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Programmatic
    public String getSomePasswordDisabledStr() {
        return somePasswordDisabledStr;
    }

    public void setSomePasswordDisabledStr(final String somePasswordDisabledStr) {
        this.somePasswordDisabledStr = somePasswordDisabledStr;
    }

    @javax.jdo.annotations.NotPersistent
    @Property(editing = Editing.DISABLED)
    public Password getSomePasswordDisabled() {
        return new Password(somePasswordDisabledStr);
    }
    public void setSomePasswordDisabled(final Password somePasswordDisabled) {
        this.somePasswordDisabledStr = somePasswordDisabled.getPassword();
    }

    //endregion

    //region > somePasswordWithValidation (property)
    private String somePasswordWithValidationStr;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Programmatic
    public String getSomePasswordWithValidationStr() {
        return somePasswordWithValidationStr;
    }

    public void setSomePasswordWithValidationStr(final String somePasswordWithValidationStr) {
        this.somePasswordWithValidationStr = somePasswordWithValidationStr;
    }


    @javax.jdo.annotations.NotPersistent
    public Password getSomePasswordWithValidation() {
        return new Password(somePasswordWithValidationStr);
    }
    public void setSomePasswordWithValidation(final Password somePasswordWithValidation) {
        this.somePasswordWithValidationStr = somePasswordWithValidation.getPassword();
    }

    public String validateSomePasswordWithValidation(final Password x) {
        return x != null && x.getPassword() != null && x.getPassword().length() < 4
                ? "Must be 4 characters or more"
                : null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomePasswordWithValidation(final Password password) {
        setSomePasswordWithValidation(password);
        return this;
    }

    public String validateUpdateSomePasswordWithValidation(final Password password) {
        return validateSomePasswordWithValidation(password);
    }
    public Password default0UpdateSomePasswordWithValidation() {
        return getSomePasswordWithValidation();
    }

    //endregion

    //region > somePasswordMandatoryWithChoices (property)
    private String somePasswordMandatoryWithChoicesStr;

    @Column(allowsNull = "false")
    @Programmatic
    public String getSomePasswordMandatoryWithChoicesStr() {
        return somePasswordMandatoryWithChoicesStr;
    }

    public void setSomePasswordMandatoryWithChoicesStr(final String somePasswordMandatoryWithChoicesStr) {
        this.somePasswordMandatoryWithChoicesStr = somePasswordMandatoryWithChoicesStr;
    }

    @javax.jdo.annotations.NotPersistent
    public Password getSomePasswordMandatoryWithChoices() {
        return new Password(somePasswordMandatoryWithChoicesStr);
    }
    public void setSomePasswordMandatoryWithChoices(final Password somePasswordMandatoryWithChoices) {
        this.somePasswordMandatoryWithChoicesStr = somePasswordMandatoryWithChoices.getPassword();
    }

    public Collection<Password> choicesSomePasswordMandatoryWithChoices() {
        return Lists.newArrayList(
                new Password("a"),
                new Password("ab"),
                new Password("abcd"),
                new Password("abcdefgh"),
                new Password("abcdefghijklmnop"),
                new Password("abcdefghijklmnopqrstuvwxyz"));
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomePasswordMandatoryWithChoices(final Password password) {
        setSomePasswordMandatoryWithChoices(password);
        return this;
    }
    public Password default0UpdateSomePasswordMandatoryWithChoices() {
        return getSomePasswordMandatoryWithChoices();
    }
    public Collection<Password> choices0UpdateSomePasswordMandatoryWithChoices() {
        return choicesSomePasswordMandatoryWithChoices();
    }
    //endregion

    //region > somePasswordOptionalWithChoices (property)
    private String somePasswordOptionalWithChoicesStr;

    @Column(allowsNull = "true")
    @Programmatic
    public String getSomePasswordOptionalWithChoicesStr() {
        return somePasswordOptionalWithChoicesStr;
    }

    public void setSomePasswordOptionalWithChoicesStr(final String somePasswordOptionalWithChoicesStr) {
        this.somePasswordOptionalWithChoicesStr = somePasswordOptionalWithChoicesStr;
    }

    @javax.jdo.annotations.NotPersistent
    @Property(optionality=Optionality.OPTIONAL)
    public Password getSomePasswordOptionalWithChoices() {
        return new Password(somePasswordOptionalWithChoicesStr);
    }
    public void setSomePasswordOptionalWithChoices(final Password somePasswordOptionalWithChoices) {
        this.somePasswordOptionalWithChoicesStr = somePasswordOptionalWithChoices != null? somePasswordOptionalWithChoices.getPassword(): null;
    }

    public Collection<Password> choicesSomePasswordOptionalWithChoices() {
        return Lists.newArrayList(
                new Password("a"),
                new Password("ab"),
                new Password("abcd"),
                new Password("abcdefgh"),
                new Password("abcdefghijklmnop"),
                new Password("abcdefghijklmnopqrstuvwxyz"));
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomePasswordOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  Password password) {
        setSomePasswordOptionalWithChoices(password);
        return this;
    }
    public Password default0UpdateSomePasswordOptionalWithChoices() {
        return getSomePasswordOptionalWithChoices();
    }
    public Collection<Password> choices0UpdateSomePasswordOptionalWithChoices() {
        return choicesSomePasswordOptionalWithChoices();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject resetSomePasswordOptionalWithChoices() {
        setSomePasswordOptionalWithChoices(null);
        return this;
    }
    //endregion


    //region > someStringMultiline (property)
    private String someStringMultiline;

    @Column(allowsNull = "true", length = 2048)
    @PropertyLayout(multiLine = 10)
    public String getSomeStringMultiline() {
        return someStringMultiline;
    }

    public void setSomeStringMultiline(final String someStringMultiline) {
        this.someStringMultiline = someStringMultiline;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomeStringMultiline(@Parameter(optionality=Optionality.OPTIONAL, maxLength = 2048) final  @ParameterLayout(multiLine = 10)  String i) {
        setSomeStringMultiline(i);
        return this;
    }
    public String default0UpdateSomeStringMultiline() {
        return getSomeStringMultiline();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject resetSomeStringMultiline() {
        setSomeStringMultiline(null);
        return this;
    }
    //endregion

    //region > someStringMultilineNoWrap (property)
    private String someStringMultilineNoWrap;

    @PropertyLayout(multiLine = 4)
    @Column(allowsNull = "true", length = 2048)
    public String getSomeStringMultilineNoWrap() {
        return someStringMultilineNoWrap;
    }

    public void setSomeStringMultilineNoWrap(final String someStringMultilineNoWrap) {
        this.someStringMultilineNoWrap = someStringMultilineNoWrap;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomeStringMultilineNoWrap(@Parameter(optionality=Optionality.OPTIONAL, maxLength = 2048)
                                                  @ParameterLayout(multiLine = 4)
                                                  final String i) {
        setSomeStringMultilineNoWrap(i);
        return this;
    }
    public String default0UpdateSomeStringMultilineNoWrap() {
        return getSomeStringMultilineNoWrap();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject resetSomeStringMultilineNoWrap() {
        setSomeStringMultilineNoWrap(null);
        return this;
    }
    //endregion


    //region > compareTo

    @Override
    public int compareTo(TextObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion


    static class SeparatorUtil {
        private SeparatorUtil(){}

        private static final String SEPARATOR = "; ";

        private static String asStr(final List<String> strings) {
            return strings == null ? null : Joiner.on(SEPARATOR).join(strings);
        }

        private static List<String> asList(final String val) {
            if(val == null) {
                return Collections.emptyList();
            }
            return Splitter.on(SEPARATOR)
                    .splitToList(val)
                    .stream()
                    .filter(x -> !Strings.isNullOrEmpty(x))
                    .collect(Collectors.toList());
        }

    }

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    //endregion

}
