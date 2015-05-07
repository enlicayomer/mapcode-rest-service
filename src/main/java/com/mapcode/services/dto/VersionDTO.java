/*
 * Copyright (C) 2015 Stichting Mapcode Foundation (http://www.mapcode.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mapcode.services.dto;

import com.mapcode.services.ApiConstants;
import com.tomtom.speedtools.apivalidation.ApiDTO;

import javax.annotation.Nonnull;

@SuppressWarnings({"NonFinalFieldReferenceInEquals", "NonFinalFieldReferencedInHashCode", "NullableProblems"})
public final class VersionDTO extends ApiDTO {

    @Nonnull
    private String version;

    @Override
    public void validate() {
        validator().start();
        validator().checkString(true, "version", version, ApiConstants.API_VERSION_LEN_MIN, ApiConstants.API_VERSION_LEN_MAX);
        validator().done();
    }

    public VersionDTO(@Nonnull final String version) {
        this.version = version;
    }

    @SuppressWarnings("UnusedDeclaration")
    @Deprecated
    private VersionDTO() {
        // Default constructor required by JAX-B.
        super();
    }

    @Nonnull
    public String getVersion() {
        beforeGet();
        return version;
    }

    public void setVersion(@Nonnull final String version) {
        beforeSet();
        assert version != null;
        this.version = version;
    }
}
