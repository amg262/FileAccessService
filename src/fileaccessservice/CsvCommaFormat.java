

package fileaccessservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 *
 * Format Strategy object that when used can be used to Encode and decode the 
 * file that is written/read from the file. Will append appropriate characters
 * and spaces as specified by specific format.
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class CsvCommaFormat implements FileFormattingStrategy<List<LinkedHashMap<String, String>>,List<String>>{

    //No magic Numbers
    private static final String LINE = "\n";
    private static final String COM = ",";
    private static final String CHAR = "";
    private boolean hasHeader;
    
    /**
     * 
     * @param hasHeader
     */
    public CsvCommaFormat(boolean hasHeader){
        this.hasHeader = hasHeader;
    }

    /**
     *
     * A List of Maps that will format the passed in data and assess if it has
     * headers, and format it to how a CSVComma file would look.
     * 
     * Decodes the data
     * 
     * @param dataFromSource
     * @return decodedData
     */
    @Override
    public List<LinkedHashMap<String, String>> decode(List<String> dataFromSource) {
        //List of decoded data
        List<LinkedHashMap<String, String>> decodedData =
                new ArrayList<LinkedHashMap<String, String>>();
        
        //holds fields for header
        String[] headerValues = null;
        
        for (int recNum=0; recNum < dataFromSource.size(); recNum++){
            
            String rowOne = dataFromSource.get(recNum);
            String[] fields = dataFromSource.get(recNum).split(COM);
            //Recognizes first row is header
            if (hasHeader && (recNum == 0)){
                headerValues = fields;
            }
            
            LinkedHashMap<String,String> record = new LinkedHashMap<String,String>();
            
            for(int i=0; i < fields.length; i++){
                if (hasHeader && (recNum == 0)){
                    //Skip the header row
                    break;
                    
                } else if (hasHeader){
                    //store header values (key, value) (1st row)
                    record.put(headerValues[i], fields[i]);
                    
                } else {
                    record.put(CHAR + i, fields[i]);
                }
            }//end of 2nd for
            if (recNum != 0){
                decodedData.add(record);
            }
        }//end of 1st for
        
        return decodedData;
    }

    
    /**
     *
     * Encodes the rawdata to a format that is much easier to read, and
     * can be swapped out at any time
     * 
     * @param dataFromSource
     * @return encodedData
     */
    @Override
    public String encode(List<LinkedHashMap<String, String>> dataFromSource) {
        StringBuilder encodedData = new StringBuilder();
        
        boolean noHeaderSet = true;
        Set<String> fieldNames = null;
        
        if (hasHeader){
            fieldNames = dataFromSource.get(0).keySet();
        }
        
        for (int recNum=0; recNum < dataFromSource.size(); recNum++){
            //making sure noHeader is set
            if (fieldNames != null && noHeaderSet){
                for (String f : fieldNames){
                    encodedData.append(f);
                    encodedData.append(COM);
                }
                //remove the last comma ??
                encodedData.deleteCharAt(encodedData.length() - 1);
                encodedData.append(LINE);
                addFields(dataFromSource, recNum, encodedData);
                noHeaderSet = false;
            } else {
                addFields(dataFromSource, recNum, encodedData);
            }
            
        }//end of 1st for
        
        return encodedData.toString();
    }

    /**
     * Appends the fields to the data that exists
     * 
     * @param dataFromFile
     * @param recNum
     * @param encodedData 
     */
    private void addFields(List<LinkedHashMap<String, String>> dataFromFile, int recNum, StringBuilder encodedData) {
    
        Collection<String> column = dataFromFile.get(recNum).values();
        for (String c : column){
            encodedData.append(c);
            encodedData.append(COM);
        }//end of 1st for
            encodedData.deleteCharAt(encodedData.length() - 1);
            encodedData.append(LINE);
    }
}
