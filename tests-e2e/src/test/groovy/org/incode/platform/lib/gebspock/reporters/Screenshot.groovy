package org.incode.platform.lib.gebspock.reporters

import geb.report.ScreenshotReporter

class Screenshot extends ScreenshotReporter {

    static File file

    @Override
    protected File saveScreenshotPngBytes(File outputDir, String label, byte[] bytes) {
        return file = super.saveScreenshotPngBytes(outputDir, label, bytes)
    }

}


