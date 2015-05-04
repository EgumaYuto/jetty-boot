/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.dbflute.jetty;

/**
 * @author jflute
 */
public class BootsPasser {

    protected final JettyBoot[] boots;

    public BootsPasser(JettyBoot... boots) {
        if (boots == null || boots.length == 0) {
            String msg = "The argument 'boots' should have one or more boots: " + boots;
            throw new IllegalArgumentException(msg);
        }
        this.boots = boots;
    }

    public void bootAwait() {
        for (JettyBoot boot : boots) {
            boot.bootAwait();
        }
        for (JettyBoot boot : boots) {
            boot.await();
        }
    }
}