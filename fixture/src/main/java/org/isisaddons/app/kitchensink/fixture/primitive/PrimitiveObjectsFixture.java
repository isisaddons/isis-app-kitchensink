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
package org.isisaddons.app.kitchensink.fixture.primitive;

import java.util.List;
import javax.inject.Inject;
import com.google.common.collect.Lists;
import org.isisaddons.app.kitchensink.dom.primitive.PrimitiveObject;
import org.isisaddons.app.kitchensink.dom.primitive.PrimitiveObjects;
import org.isisaddons.module.fakedata.dom.FakeDataService;
import org.apache.isis.applib.fixturescripts.FixtureScript;

public class PrimitiveObjectsFixture extends FixtureScript {


    //region > numberToCreate
    private Integer numberToCreate;

    /**
     * Defaults to 3
     */
    public Integer getNumberToCreate() {
        return numberToCreate;
    }

    public void setNumberToCreate(final Integer numberToCreate) {
        this.numberToCreate = numberToCreate;
    }
    //endregion


    //region > name
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    //endregion

    
    //region > aByte (input property)
    private Byte aByte;
    public Byte getByte() {
        return aByte;
    }
    public void setByte(final Byte aByte) {
        this.aByte = aByte;
    }
    //endregion
    
    //region > aShort (input property)
    private Short aShort;
    public Short getShort() {
        return aShort;
    }
    public void setShort(final Short aShort) {
        this.aShort = aShort;
    }
    //endregion
    
    //region > anInt (input property)
    private Integer anInt;
    public Integer getInteger() {
        return anInt;
    }
    public void setInteger(final Integer anInt) {
        this.anInt = anInt;
    }
    //endregion
    
    //region > aLong (input property)
    private Long aLong;
    public Long getLong() {
        return aLong;
    }
    public void setLong(final Long aLong) {
        this.aLong = aLong;
    }
    //endregion
    
    //region > aFloat (input property)
    private Float aFloat;
    public Float getFloat() {
        return aFloat;
    }
    public void setFloat(final Float aFloat) {
        this.aFloat = aFloat;
    }
    //endregion

    //region > aDouble (input property)
    private Double aDouble;
    public Double getDouble() {
        return aDouble;
    }
    public void setDouble(final Double aDouble) {
        this.aDouble = aDouble;
    }
    //endregion

    //region > objects (output)
    private final List<PrimitiveObject> objects = Lists.newArrayList();

    public List<PrimitiveObject> getObjects() {
        return objects;
    }
    //endregion


    @Override
    protected void execute(final ExecutionContext ec) {

        defaultParam("numberToCreate", ec, 3);

        defaultParam("name", ec, fake.lorem().words(1));

        defaultParam("byte", ec, fake.bytes().any());
        defaultParam("short", ec, fake.shorts().any());
        defaultParam("integer", ec, fake.ints().any());
        defaultParam("long", ec, fake.longs().any());
        defaultParam("float", ec, fake.floats().any());
        defaultParam("double", ec, fake.doubles().any());

        for (int k = 0; k < getNumberToCreate(); k++) {
            final String str = getName() + " #" + k;

            final byte b = (byte) (getByte() + k);
            final short s = (short) (getShort() + k);
            final int i = getInteger() + k;
            final long l = getLong() + k;
            final float f = getFloat() + k;
            final double d = getDouble() + k;

            final PrimitiveObject object =
                    primitiveObjects.createPrimitiveObject(str, b, s, i, l, f, d);

            objects.add(object);

            ec.addResult(this, object);
        }
    }

    @javax.inject.Inject
    private PrimitiveObjects primitiveObjects;

    @Inject
    FakeDataService fake;

}
