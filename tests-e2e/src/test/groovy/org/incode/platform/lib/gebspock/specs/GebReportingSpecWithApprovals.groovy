package org.incode.platform.lib.gebspock.specs

import com.github.approval.Approval
import com.github.approval.Reporter
import com.github.approval.converters.Converter
import com.github.approval.reporters.ExecutableDifferenceReporter
import com.google.common.io.Resources
import geb.spock.GebReportingSpec
import org.incode.platform.lib.gebspock.spi.Screenshot

import javax.annotation.Nullable
import java.nio.file.Files
abstract class GebReportingSpecWithApprovals extends GebReportingSpec {

// use 'gradle clean test' to do a cleanup of reporting directory first

//    @Override
//    def setupSpec() {
//        def dir = config.reportsDir
//        if(dir.exists()) {
//            if (dir.exists() && !dir.deleteDir()) {
//                throw new IllegalStateException("Could not clean report dir '${dir}'")
//            }
//        }
//    }

//    @Override
//    def cleanupSpec() {
//        def dir = config.reportsDir
//        if(dir != null && dir.exists()) {
//            Desktop.desktop.browse(dir.toPath().toUri())
//        }
//    }


    void reportAndApprove(final String label) {
        super.report(label)

        def approvedFileName = gebReportingSpecTestName.methodName + "-" + label + ".png"

        def approvedUrl = Resources.getResource(getClass(), approvedFileName)
        def approvedPath = new File(approvedUrl.toURI()).toPath()

        def actualBytes = Resources.toByteArray(Screenshot.file.toURI().toURL())

        approval().verify(actualBytes, approvedPath)
    }

    private Approval<byte[]> approval() {
        def identity = new Converter<byte[]>() {
            @Override
            byte[] getRawForm(@Nullable final byte[] value) {
                return value
            }
        }
        Approval.of(byte[].class)
                .withConveter(identity)
                .withReporter(imageReporter())
                .build()
    }

    protected Reporter imageReporter() {
        beyondCompareReporter()
        //intellijReporter()
    }

    Reporter beyondCompareReporter() {
        new WindowsDifferenceReport(
                [],
                null,
                $/C:\Program Files (x86)\Beyond Compare 3\BCompare.exe/$,
                [],
                []
        )
    }

    // unfortunately (even though it's a better comparison tool) this doesn't work
    // if IntelliJ is already running (doesn't wait for process)
    ExecutableDifferenceReporter intellijReporter() {
        new WindowsDifferenceReport(
                [],
                null,
                $/C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2017.3\bin/idea.bat/$,
                ["diff"],
                [])
    }

    class WindowsDifferenceReport extends ExecutableDifferenceReporter {

        List<String> priorFlags
        String exeDir
        String exeName
        List<String> preFlags
        List<String> postFlags
        WindowsDifferenceReport(List<String> priorFlags, String exeDir, String exeName, List<String> preFlags, List<String> postFlags) {
            super(null, null, null)
            this.exeDir = exeDir
            this.exeName = exeName
            this.priorFlags = priorFlags
            this.preFlags = preFlags
            this.postFlags = postFlags
        }

        @Override
        void notTheSame(
                final byte[] oldValue, final File approvedFile,
                final byte[] newValue, final File toApproveFile) {

            def approvedAbsPathInSrc = approvedFile.absolutePath
                                    .replace("/out/","/src/")
                                    .replace("\\out\\","\\src\\")
                                    .replace("/build/","/src/")
                                    .replace("\\build\\","\\src\\")
                                    .replace("/target/classes/","/src/")
                                    .replace("\\target\\classes\\","\\src\\")
            def toApproveAbsPathInOut = toApproveFile.absolutePath

            def commandline = cmdLineFor(approvedAbsPathInSrc, toApproveAbsPathInOut)
            try {
                final ProcessBuilder processBuilder = new ProcessBuilder(commandline)
                if (exeDir != null) {
                    processBuilder.directory(new File(exeDir))
                }
                def process = processBuilder.inheritIO().start()

                process.waitFor()
            } catch (IOException e) {
                throw new AssertionError("There was a problem while executing: ${e.message}", e)
            } catch (InterruptedException e) {
                throw new AssertionError("Thread was interrupted while waiting for process to finish", e)
            }

            def approvedAfterBytes = Files.readAllBytes(new File(approvedAbsPathInSrc).toPath())
            def toApproveAfterBytes = Files.readAllBytes(new File(toApproveAbsPathInOut).toPath())

            if(! Arrays.equals(approvedAfterBytes, toApproveAfterBytes)) {
                throw new AssertionError("""
Difference in files: 
    ${new File(approvedAbsPathInSrc).toPath()} 
and 
    ${new File(toApproveAbsPathInOut).toPath()} 
was not approved.""")
            }
        }

        List<String> cmdLineFor(String... cmdParts) {
            List<String> cmd = new ArrayList<String>()
            priorFlags.each {
                cmd.add(it)
            }
            cmd.add(exeName)
            preFlags.each {
                cmd.add(it)
            }
            cmd.addAll(cmdParts.toList())
            postFlags.each {
                cmd.add(it)
            }
            cmd
        }
    }

}
