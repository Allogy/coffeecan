/*
 * Copyright (c) 2013 Allogy Interactive.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.allogy.coffeecan.jackson;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.joda.time.Period;

import java.io.IOException;
import java.io.InvalidObjectException;

public class ISOPeriodDeserializer extends StdDeserializer<Period>
{
    protected ISOPeriodDeserializer()
    {
        super(Period.class);
    }

    @Override
    public Period deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException
    {
        String textValue = jsonParser.getText();
        try
        {
            return new Period(textValue);
        }
        catch (Throwable throwable)
        {
            throw new InvalidObjectException(throwable.getMessage() + textValue);
        }
    }
}
