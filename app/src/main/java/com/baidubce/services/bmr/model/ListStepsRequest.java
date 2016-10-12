/*
 * Copyright (c) 2014 Baidu.com, Inc. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.baidubce.services.bmr.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;

/**
 * Provides options for listing steps.
 *
 * The essential option is cluster ID, and the optional query parameters are marker and max keys.
 */
public class ListStepsRequest extends AbstractBceRequest {
    private String clusterId;
    private String marker;
    private int maxKeys = -1;

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public int getMaxKeys() {
        return maxKeys;
    }

    public void setMaxKeys(int maxKeys) {
        this.maxKeys = maxKeys;
    }

    /**
     * Configure the cluster ID on which the target steps run.
     *
     * @param clusterId The cluster ID.
     * @return ListStepsRequest
     */
    public ListStepsRequest withClusterId(String clusterId) {
        this.setClusterId(clusterId);
        return this;
    }

    /**
     * Configure the marker for the query request.
     * The marker marks the starting point for the query.
     *
     * @param marker
     * @return ListStepsRequest
     */
    public ListStepsRequest withMarker(String marker) {
        this.setMarker(marker);
        return this;
    }

    /**
     * Configure the max count for each response page.
     * The max keys can not more than 1000, any number exceeding 1000 will be
     * reset to 1000.
     *
     * @param maxKeys The max count for each response page.
     * @return ListStepsRequest
     */
    public ListStepsRequest withMaxKeys(int maxKeys) {
        this.setMaxKeys(maxKeys);
        return this;
    }

    /**
     * Configure request credential for the request.
     *
     * @param credentials a valid instance of BceCredentials.
     * @return ListStepsRequest
     */
    public ListStepsRequest withRequestCredentials(BceCredentials credentials) {
        this.setRequestCredentials(credentials);
        return this;
    }
}
