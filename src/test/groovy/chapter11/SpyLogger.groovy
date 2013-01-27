package chapter11

import java.util.logging.Logger

class SpyLogger extends Logger {
    final Logger base;
    final StringBuffer log = new StringBuffer()

    SpyLogger(Logger base) {
        super(base.name, base.resourceBundleName)
        this.base = base
    }

    @Override
    void info(String msg) {
        log.append(msg)
        base.info(msg)
    }

}
