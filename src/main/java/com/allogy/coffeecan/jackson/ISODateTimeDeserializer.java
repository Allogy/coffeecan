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
import org.codehaus.jackson.map.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;
import java.io.InvalidObjectException;

public class ISODateTimeDeserializer extends JsonDeserializer<DateTime>
{
    private final DateTimeFormatter dateTimeFormatter;

    public ISODateTimeDeserializer()
    {
        dateTimeFormatter = ISODateTimeFormat.dateTime().withOffsetParsed();
    }

    @Override
    public DateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException
    {
        String text = jsonParser.getText();
        try
        {
            return dateTimeFormatter.parseDateTime(text);
        }
        catch (Throwable throwable)
        {
            throw new InvalidObjectException(throwable.getMessage() + text);
        }
    }
}
