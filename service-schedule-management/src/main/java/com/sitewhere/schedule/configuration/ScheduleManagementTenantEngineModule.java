/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.schedule.configuration;

import com.sitewhere.microservice.api.schedule.IScheduleManagement;
import com.sitewhere.microservice.multitenant.TenantEngineModule;
import com.sitewhere.schedule.persistence.rdb.RdbScheduleManagement;

/**
 * Guice module used for configuring components associated with a schedule
 * management tenant engine.
 */
public class ScheduleManagementTenantEngineModule extends TenantEngineModule<ScheduleManagementTenantConfiguration> {

    public ScheduleManagementTenantEngineModule(ScheduleManagementTenantConfiguration configuration) {
	super(configuration);
    }

    /*
     * @see com.google.inject.AbstractModule#configure()
     */
    @Override
    protected void configure() {
	bind(ScheduleManagementTenantConfiguration.class).toInstance(getConfiguration());
	bind(IScheduleManagement.class).to(RdbScheduleManagement.class);
    }
}
