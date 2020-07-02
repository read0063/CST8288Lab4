/**@author mreade using source material provided in Lab instructions
 * @version Assignment4
 */
package com.algonquin.loggy;

import java.util.Arrays;
import java.util.List;

/**@author mreade using source material provided in Lab instructions
 * @version Assignment4
 */
public class TextFile extends File {

    /**
     *
     */
    public TextFile() {
    }

    /**
     * @param name
     * @param type
     * @param content
     * @param size
     */
    public TextFile(String name, String type, String content, Long size) {
        super(name, type, content, size);
    }

    private static final List<String> contentTypes = Arrays.asList("DOC", "TXT", "PDF");//Moira moved this here from TextLog and changed from public to private

    //methods from Attachable
    @Override
    public boolean isValidContentType(String type) {//Moira moved this here from Textlog and removed reference to the TextLog
        return contentTypes.contains(type);
    }

    /**
     *
     */
    @Override
    public void postProcess() {
        super.postProcess();
        // trigger translation
        System.out.println("This text file is going to be translated");
    }

}
