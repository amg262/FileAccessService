
package fileaccessservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * Interface that has methods each Formatter object must
 * implement and define.
 * 
 * @param <D> 
 * @param <E> 
 * @author Andy
 */
public interface FileFormattingStrategy<D, E> {

    /**
     *
     * @param dataFromFile
     * @return E
     */
    public D decode(E dataFromFile);
    /**
     *
     * @param dataFromFile
     * @return D
     */
    public String encode (D dataFromFile);
    
}
