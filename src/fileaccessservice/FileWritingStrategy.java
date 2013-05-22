
package fileaccessservice;

import java.io.IOException;

/**
 *
 * Has methods that each WritingStrategy must implement
 * 
 * @param <T> 
 * @author Andy
 */
public interface FileWritingStrategy<T> {
    
    /**
     *
     * @return 
     * @throws IOException
     */
    public abstract T writeFile() throws IOException ;
    
}
