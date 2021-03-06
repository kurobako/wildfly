/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.jpa.util;

import org.jboss.msc.service.ServiceName;

/**
 * For JPA service names
 *
 * @author Scott Marlow
 */
public class JPAServiceNames {

    // identifies the (instance per) persistence unit service name
    private static final ServiceName PERSISTENCE_UNIT_SERVICE_NAME = ServiceName.JBOSS.append("persistenceunit");

    // identifies the (singleton) JPA service
    public static final ServiceName JPA_SERVICE_NAME = ServiceName.JBOSS.append("jpa");

    public static ServiceName getPUServiceName(String scopedPersistenceUnitName) {
        return PERSISTENCE_UNIT_SERVICE_NAME.append(scopedPersistenceUnitName);
    }

    public static ServiceName getJPAServiceName() {
        return JPA_SERVICE_NAME;
    }

    /**
     * Name of the capability that ensures a local provider of transactions is present.
     * Once its service is started, calls to the getInstance() methods of ContextTransactionManager,
     * ContextTransactionSynchronizationRegistry and LocalUserTransaction can be made knowing
     * that the global default TM, TSR and UT will be from that provider.
     */
    public static final String LOCAL_TRANSACTION_PROVIDER_CAPABILITY = "org.wildfly.transactions.global-default-local-provider";
}
