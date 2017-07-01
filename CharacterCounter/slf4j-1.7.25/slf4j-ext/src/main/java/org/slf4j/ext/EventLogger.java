/**
 * Copyright (c) 2004-2011 QOS.ch
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package org.slf4j.ext;

import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.spi.LocationAwareLogger;

/**
 * Simple Logger used to log events. All events are directed to a logger named "EventLogger"
 * with a level of INFO and with an Event marker.
 *
 * @author Ralph Goers
 */
public class EventLogger {

    private static final String FQCN = EventLogger.class.getName();

    static Marker EVENT_MARKER = MarkerFactory.getMarker("EVENT");

    private static LoggerWrapper eventLogger = new LoggerWrapper(LoggerFactory.getLogger("EventLogger"), FQCN);

    /**
     * There can only be a single EventLogger.
     */
    private EventLogger() {
    }

    /**
     * Logs the event.
     *
     * @param data The EventData.
     */
    public static void logEvent(EventData data) {
        if (eventLogger.instanceofLAL) {
            ((LocationAwareLogger) eventLogger.logger).log(EVENT_MARKER, FQCN, LocationAwareLogger.INFO_INT, data.toXML(), new Object[] { data }, null);
        } else {
            eventLogger.logger.info(EVENT_MARKER, data.toXML(), data);
        }
    }
}
