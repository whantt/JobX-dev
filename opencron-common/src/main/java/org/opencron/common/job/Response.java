/**
 * Copyright (c) 2015 The Opencron Project
 * <p>
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.opencron.common.job;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class Response implements Serializable {
    /**
     * @see Action
     */
    private Action action; // required
    private Map<String, String> result; // required
    private int exitCode; // required
    private boolean success; // required
    private long startTime; // required
    private long endTime; // required
    private String message; // required
    private Integer id;
    private Throwable throwable;

    public Action getAction() {
        return action;
    }

    public Response setAction(Action action) {
        this.action = action;
        return this;
    }

    public Map<String, String> getResult() {
        return result;
    }

    public Response setResult(Map<String, String> result) {
        this.result = result;
        return this;
    }

    public int getExitCode() {
        return exitCode;
    }

    public Response setExitCode(int exitCode) {
        this.exitCode = exitCode;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public Response setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public long getStartTime() {
        return startTime;
    }

    public Response setStartTime(long startTime) {
        this.startTime = startTime;
        return this;
    }

    public long getEndTime() {
        return endTime;
    }

    public Response setEndTime(long endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    public Response start() {
        this.startTime = new Date().getTime();
        return this;
    }

    public Response end() {
        this.endTime = new Date().getTime();
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public static Response response(Request request) {
        return new Response().setAction(request.getAction()).start();
    }
}
