package com.parkingfinder.analyzer.capture.impl;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.core.io.DefaultResourceLoader;

import com.parkingfinder.analyzer.capture.CaptureService;
import com.parkingfinder.web.model.Parking;
import com.parkingfinder.web.model.Source;

public class CaptureM3u8 implements CaptureService {

    private final Parking parking;
    private final Source source;
    private final DefaultResourceLoader loader;

    public CaptureM3u8(Parking parking) {
        this.parking = parking;
        this.source = parking.getSource();
        this.loader = new DefaultResourceLoader();
    }

    public File captureLastImage() throws Exception {
        File recordsDir = loader.getResource(recordsPath).getFile();
        String absolutePath = recordsDir.getAbsolutePath() + File.separator
                + "image_" + +parking.getId() + "_tmp.jpg";

        String[] command = { "ffmpeg", "-i", source.getValue(), "-f", "image2",
                "-vframes", "1", absolutePath };

        ProcessBuilder captureProcessBuilder = new ProcessBuilder(command);
        captureProcessBuilder.directory(recordsDir);
        captureProcessBuilder.start();

        return replaceOldImage(absolutePath);
    }

    /**
     * Image capturing can takes time, so will use tmp file
     *
     * @param absolutePath
     * @return
     * @throws IOException
     */
    private File replaceOldImage(String absolutePath) throws IOException {
        File imageTmp = new File(absolutePath);
        if (!imageTmp.exists()) {
            return null;
        }
        File target = new File(absolutePath.replace("_tmp", ""));
        Files.move(imageTmp.toPath(), target.toPath(), REPLACE_EXISTING);
        return target;
    }
}
