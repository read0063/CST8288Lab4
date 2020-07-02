/**
 *
 */
package com.algonquin.loggy;

import java.util.Arrays;
import java.util.List;

/**@author mreade using source material provided in Lab instructions
 * @version Assignment4
 */
public class VideoFile extends File {

    /**
     * @param name
     * @param type
     * @param content
     * @param size
     */
    public VideoFile(String name, String type, String content, Long size) {
        super(name, type, content, size);
    }


    private static final List<String> contentTypes = Arrays.asList("MP4", "MPG", "MPEG", "M4V");//Moira moved here from VideoLog and made private

    //method from Attachable
    @Override
    public boolean isValidContentType(String type) {//Moira moved this here from AudioLog and removed reference to the AudioLog
        return contentTypes.contains(type);
    }
    //method from Attachable

    /**
     *
     */
    @Override
    public void postProcess() {
        super.postProcess();
        System.out.println("This video file is going to be closed captioned");
    }

}
