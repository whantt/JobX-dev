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
package org.opencron.rpc.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.opencron.common.job.Response;
import org.opencron.common.logging.LoggerFactory;
import org.opencron.rpc.Promise;
import org.slf4j.Logger;


@ChannelHandler.Sharable
public class NettyClientHandler extends SimpleChannelInboundHandler<Response> {

    private Logger logger = LoggerFactory.getLogger(NettyClientHandler.class);

    private Promise.Getter promiseGetter;

    public NettyClientHandler(Promise.Getter promiseGetter) {
        this.promiseGetter = promiseGetter;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Response response) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info("[opencron] nettyRPC client receive response id:{}", response.getId());
        }
        Promise promise = promiseGetter.getPromise(response.getId());
        promise.setResult(response);
        if (promise.isAsync()) {   //异步调用
            if (logger.isInfoEnabled()) {
                logger.info("[opencron] nettyRPC client async callback invoke");
            }
            promise.execCallback();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        if (logger.isErrorEnabled()) {
            logger.error("捕获异常", cause);
        }
    }
}
