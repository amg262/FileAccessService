
package fileaccessservice;

import java.io.IOException;
import java.util.List;

/**
 * 
 * @param <D> 
 * @author Andy
 */
public interface FileReadingStrategy<D> {
    
    
    /**
     *
     * @return D
     * @throws IOException
     */
    D readFile() throws IOException;
    
    /**
     *
     * @throws IOException
     */
    public abstract void outputFile() throws IOException ;
    
}
