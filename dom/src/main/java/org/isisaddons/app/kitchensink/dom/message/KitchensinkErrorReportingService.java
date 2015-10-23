/*
 *  Copyright 2014 Dan Haywood
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.isisaddons.app.kitchensink.dom.message;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.services.error.ErrorDetails;
import org.apache.isis.applib.services.error.ErrorReportingService;
import org.apache.isis.applib.services.error.Ticket;

@DomainService(
        nature = NatureOfService.DOMAIN
)
public class KitchensinkErrorReportingService implements ErrorReportingService {

    private int ticketNumber = 1;

    @Override
    public Ticket reportError(final ErrorDetails errorDetails) {
        return new Ticket(
                nextTicketReference(),
                "The Kitchen sink app is sorry to report that: " + errorDetails.getMainMessage(),
                  "These are additional details for the end-user to read.\n"
                + "This content should be able to span many lines.\n"
                + "More detail.\n"
                + "Some suggested work-arounds.\n"
                + "Details of how to contact help desk.\n"
                + "And so on");
    }

    String nextTicketReference() {
        return "" + ticketNumber++;
    }
}
