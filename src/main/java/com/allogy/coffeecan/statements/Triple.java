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

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Triple
{
    @NotNull
    @Valid
    private final Actor actor;

    @NotNull
    @Valid
    private final Verb verb;

    @NotNull
    @Valid
    private final StatementObject object;

    public Triple(@JsonProperty("actor") Actor actor,
                  @JsonProperty("verb") Verb verb,
                  @JsonProperty("object") StatementObject object)
    {
        this.actor = actor;
        this.verb = verb;
        this.object = object;
    }

    public Actor getActor()
    {
        return actor;
    }

    public Verb getVerb()
    {
        return verb;
    }

    public StatementObject getObject()
    {
        return object;
    }
}
