package com.lectures.lecture11;
import org.apache.log4j.Logger;
class LoggerEx {
    final static Logger logger = Logger.getLogger(LoggerEx.class);

    public static void main(String[] args) {
        LoggerEx obj = new LoggerEx();
        obj.runMe("Serge");
    }

    private void runMe(String parameter) {
        if (logger.isDebugEnabled()) {
            logger.debug("This is debug : " + parameter);
        }
        if (logger.isInfoEnabled()) {
            logger.info("This is info : " + parameter);
        }
        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);
    }
}
