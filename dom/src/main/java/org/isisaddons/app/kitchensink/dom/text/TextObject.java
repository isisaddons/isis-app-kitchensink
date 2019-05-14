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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

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
import org.apache.isis.schema.utils.jaxbadapters.PersistentEntityAdapter;

import org.isisaddons.app.kitchensink.dom.Entity;

import lombok.Getter;
import lombok.Setter;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "datatypes.TextObject"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
public class TextObject implements Entity<TextObject> {


    @Column(allowsNull="false")
    @Title(sequence="1")
    @Getter @Setter
    private String name;

    //region > someChar (property)

    @Getter @Setter
    private char someChar;

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomeChar(final char i) {
        setSomeChar(i);
        return this;
    }
    public char default0UpdateSomeChar() {
        return getSomeChar();
    }
    //endregion


    @Property(hidden = Where.EVERYWHERE)
    @Getter @Setter
    private char someCharHidden;


    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private char someCharDisabled;


    //region > someCharWithValidation (property)
    @Getter @Setter
    private char someCharWithValidation;

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
    @Getter @Setter
    private char someCharWithChoices;

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
    @Column(allowsNull = "false")
    @Getter @Setter
    private Character someCharacterWrapperMandatory;

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
    @Column(allowsNull = "true")
    @Getter @Setter
    private Character someCharacterWrapperOptional;

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

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    @Getter @Setter
    private java.lang.Character someCharacterWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private java.lang.Character someCharacterWrapperDisabled;

    //region > someCharacterWrapperWithValidation (property)
    @javax.jdo.annotations.Column(allowsNull = "false")
    @Getter @Setter
    private java.lang.Character someCharacterWrapperWithValidation;

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
    @Column(allowsNull = "false")
    @Getter @Setter
    private Character someCharacterWrapperMandatoryWithChoices;

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
    @Column(allowsNull = "true")
    @Getter @Setter
    private Character someCharacterWrapperOptionalWithChoices;

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
    @Column(allowsNull = "false")
    @Getter @Setter
    private String someStringMandatory;

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
    @Column(allowsNull = "true")
    @Getter @Setter
    private String someStringOptional;

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

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    @Getter @Setter
    private String someStringHidden;


    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private String someStringDisabled;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.ENABLED)
    @Getter @Setter
    private String someStringProgrammaticallyDisabled;
    public String disableSomeStringProgrammaticallyDisabled() {
        return getSomeStringWithValidation().endsWith("a") ?
                null :
                "Enabled only if 'someStringWithValidation' end with an 'a'";
    }


    //region > someStringWithValidation (property)
    @javax.jdo.annotations.Column(allowsNull = "false")
    @Getter @Setter
    private String someStringWithValidation;

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
    @Column(allowsNull = "false")
    @Getter @Setter
    private String someStringMandatoryWithChoices;

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
    @Column(allowsNull = "true")
    @Getter @Setter
    private String someStringOptionalWithChoices;

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
    @Property(editing = Editing.ENABLED)
    @Column(allowsNull = "true")
    @Getter @Setter
    private String someStringOptionalWithMultiChoices;

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
    @Property(
            editing = Editing.DISABLED,
            hidden = Where.EVERYWHERE  // autocomplete on values is NOT SUPPORTED
    )
    @Column(allowsNull = "true")
    @Getter @Setter
    private String someStringOptionalWithMultiAutoComplete;

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
    @Column(allowsNull = "true", length = 20)
    @Getter @Setter
    private String someString20;

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
    @PropertyLayout(typicalLength = 20)
    @Column(allowsNull = "true", length = 50)
    @Getter @Setter
    private String someString50;

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
    @Column(allowsNull = "false")
    @Getter @Setter
    private String somePasswordMandatoryStr;

    @Programmatic
    public String getSomePasswordMandatoryStr() {
        return somePasswordMandatoryStr;
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
    @Column(allowsNull = "true")
    @Getter @Setter
    private String somePasswordOptionalStr;

    @Programmatic
    public String getSomePasswordOptionalStr() {
        return somePasswordOptionalStr;
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
    @javax.jdo.annotations.Column(allowsNull = "false")
    @Getter @Setter
    private String somePasswordHiddenStr;

    @Programmatic
    public String getSomePasswordHiddenStr() {
        return somePasswordHiddenStr;
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
    @javax.jdo.annotations.Column(allowsNull = "false")
    @Getter @Setter
    private String somePasswordDisabledStr;

    @Programmatic
    public String getSomePasswordDisabledStr() {
        return somePasswordDisabledStr;
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
    @javax.jdo.annotations.Column(allowsNull = "false")
    @Getter @Setter
    private String somePasswordWithValidationStr;

    @Programmatic
    public String getSomePasswordWithValidationStr() {
        return somePasswordWithValidationStr;
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
    @Column(allowsNull = "false")
    @Getter @Setter
    private String somePasswordMandatoryWithChoicesStr;

    @Programmatic
    public String getSomePasswordMandatoryWithChoicesStr() {
        return somePasswordMandatoryWithChoicesStr;
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
    @Getter @Setter
    @Column(allowsNull = "true")
    private String somePasswordOptionalWithChoicesStr;

    @Programmatic
    public String getSomePasswordOptionalWithChoicesStr() {
        return somePasswordOptionalWithChoicesStr;
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
    @Column(allowsNull = "true", length = 2048)
    @PropertyLayout(multiLine = 10)
    @Getter @Setter
    private String someStringMultiline;


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
    @PropertyLayout(multiLine = 4)
    @Column(allowsNull = "true", length = 2048)
    @Getter @Setter
    private String someStringMultilineNoWrap;


    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public TextObject updateSomeStringMultilineNoWrap(
            @Parameter(optionality=Optionality.OPTIONAL, maxLength = 2048)
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


    @Override
    public int compareTo(TextObject other) {
        return ObjectContracts.compare(this, other, "name");
    }


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


}
