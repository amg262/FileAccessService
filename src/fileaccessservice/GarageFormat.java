

import fileaccessservice.FileFormattingStrategy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * Custom Garage format classObject
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class GarageFormat implements FileFormattingStrategy <List<LinkedHashMap<String, String>>,List<String>>  {
    private static final String LINE = "\n";
    private static final String TOL_HOURS = "totalHours";
    private static final String TOL_FEE = "totalFees";
    
    /**
     *
     * Decodes the object specifically how it would be done for Garage
     * project
     * 
     * @param dataFromSource
     * @return decodedData
     */
    @Override
    public List<LinkedHashMap<String, String>> decode(List<String> dataFromSource) {

        List<LinkedHashMap<String, String>> decodedData =
                new ArrayList<LinkedHashMap<String,String>>();
        
        LinkedHashMap<String, String> valueMap = 
                new LinkedHashMap<String, String>();
        valueMap.put(TOL_HOURS, dataFromSource.get(0));
        valueMap.put(TOL_FEE, dataFromSource.get(1));
        decodedData.add(valueMap);
        
        return decodedData;
    }

    /**
     *
     * Encodes data that is consistent with Garage project class
     * 
     * @param dataFromSource
     * @return formattedData.toString();
     */
    @Override
    public String encode(List<LinkedHashMap<String, String>> dataFromSource) {
        StringBuilder formattedData = new StringBuilder();
        
        LinkedHashMap<String,String> record = dataFromSource.get(0);
        formattedData.append(record.get(TOL_HOURS)).append(LINE);
        formattedData.append(record.get(TOL_FEE)).append(LINE);
        
        return formattedData.toString();
    }

}
