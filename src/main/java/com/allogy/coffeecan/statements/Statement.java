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

package com.allogy.coffeecan.statements;

import com.allogy.coffeecan.Identifiable;
import com.allogy.coffeecan.statements.validation.ExistsInLearningRecordStore;
import com.allogy.coffeecan.statements.validation.NotPresentInLearningRecordStore;
import com.allogy.json.jackson.joda.ISODateTimeDeserializer;
import com.allogy.json.jackson.joda.ISODateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Map;

public class Statement extends Triple implements Identifiable
{
    @Null(groups = { NotPresentInLearningRecordStore.class })
    @NotNull(groups = { ExistsInLearningRecordStore.class })
    private String ID;

    private Result result;
    private Context context;
    private DateTime timestamp;

    @Null(groups = { NotPresentInLearningRecordStore.class })
    @NotNull(groups = { ExistsInLearningRecordStore.class })
    private DateTime stored;

    private Map<String, Object> extensions;

    public Statement(@JsonProperty("actor") Actor actor,
                     @JsonProperty("verb") Verb verb,
                     @JsonProperty("object") StatementObject object)
    {
        super(actor, verb, object);
    }

    @JsonProperty("id")
    public String getID()
    {
        return ID;
    }

    @JsonProperty("id")
    public void setID(String ID)
    {
        this.ID = ID;
    }

    public Result getResult()
    {
        return result;
    }

    public void setResult(Result result)
    {
        this.result = result;
    }

    public Context getContext()
    {
        return context;
    }

    public void setContext(Context context)
    {
        this.context = context;
    }

    @JsonSerialize(using = ISODateTimeSerializer.class)
    public DateTime getTimestamp()
    {
        return timestamp;
    }

    @JsonDeserialize(using = ISODateTimeDeserializer.class)
    public void setTimestamp(DateTime timestamp)
    {
        this.timestamp = timestamp;
    }

    @JsonSerialize(using = ISODateTimeSerializer.class)
    public DateTime getStored()
    {
        return stored;
    }

    @JsonDeserialize(using = ISODateTimeDeserializer.class)
    public void setStored(DateTime stored)
    {
        this.stored = stored;
    }

    public Map<String, Object> getExtensions()
    {
        return extensions;
    }

    public void setExtensions(Map<String, Object> extensions)
    {
        this.extensions = extensions;
    }
}
