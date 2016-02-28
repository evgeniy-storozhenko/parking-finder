# Contribution Guide

## Quick start
### Requirements for backend
- Java 8
- FFmpeg
- MariaDB (MySQL)
- OpenCV Framework
- [OpenCV Processing Library](https://github.com/atduskgreg/opencv-processing/releases)

### Environment variables
You need to define var **OPEN_CV_LIB** and set path to OpenCV Processing Library

### Database
Create database **parkingFinder** and invoke sql from [backup/parkingFinder.sql](backup/parkingFinder.sql)

### Deploy 
Deploy parkingfinder-${version}.war to your server


## Contribution
- Don't create pull request without unit tests.
- Don't add any dependencies, which are contrary to the license.
- Use code formatting.
- Do not write the methods that are more than 50 lines.
- Call variables intelligently.
