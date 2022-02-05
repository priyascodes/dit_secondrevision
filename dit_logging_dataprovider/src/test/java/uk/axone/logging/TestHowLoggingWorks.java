package uk.axone.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestHowLoggingWorks {

    protected static final Logger LOG = LogManager.getLogger();

    @Test
    public void testhowloggingworks() {

        LOG.debug("This is a debug message");
        LOG.info("This is info");
        LOG.warn("This is a warn");
        LOG.error("This is an error");
        LOG.fatal("This is a fatal error");

    }
}
