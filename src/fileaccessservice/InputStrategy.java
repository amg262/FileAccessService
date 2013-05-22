
package fileaccessservice;

/**
 * 
 * Input Strategy interface where it only needs to retreieve the filePath
 *
 * @author Andy
 */
public interface InputStrategy {
    
    /**
     *
     * Get the passed or specified in filePath
     * 
     * @return filePath
     */
    public abstract String getFilePath();
    
}
