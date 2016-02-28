package com.parkingfinder.analyzer.capture;

import java.io.File;

public interface CaptureService {

    String recordsPath = "classpath:../../resources/images/records";

    File captureLastImage() throws Exception;

}
