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

import com.allogy.coffeecan.jackson.ISOPeriodDeserializer;
import com.allogy.coffeecan.jackson.ISOPeriodSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.Period;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result
{
    private ResultScore score;
    private Boolean success;
    private Boolean completion;
    @JsonDeserialize(using = ISOPeriodDeserializer.class)
    private Period duration;

    public ResultScore getScore()
    {
        return score;
    }

    public Boolean getSuccess()
    {
        return success;
    }

    public Boolean getCompletion()
    {
        return completion;
    }

    @JsonSerialize(using = ISOPeriodSerializer.class)
    public Period getDuration()
    {
        return duration;
    }
}
