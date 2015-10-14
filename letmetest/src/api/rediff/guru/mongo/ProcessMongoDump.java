package api.rediff.guru.mongo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


public class ProcessMongoDump {
	public static String PREFIX_PATH = "/home/santoshm/Downloads/outdata_again.csv/";
	
	public static void main(String[] args) throws Exception{
		processDump();
	}
	
	public static void processDump() throws Exception {
		File dir = new File(PREFIX_PATH);
        FilenameFilter fileNameFilter = new FilenameFilter() {
  
           @Override
           public boolean accept(File dir, String name) {
              if(name.endsWith(".csv")) {
                 return true;
              } else {
            	  return false;
              }
           }
        };
        
        LinkedList<String[]> responseCsv = new LinkedList<>();
		
        File[] listFiles = dir.listFiles(fileNameFilter);
		for(File csvFile : listFiles) {
			CSVReader csvReader = new CSVReader(new FileReader(csvFile.getCanonicalPath()), ',');
			List<String[]> allRows = (List<String[]>) csvReader.readAll();
			for(String[] row : allRows) {
				if(row != null && row.length >= 3 && !"profile_id".equals(row[0])) {
					String profile_id = row[0];
					String url = row[2];
					
					responseCsv.add(new String[]{profile_id, "#NO_TOPIC", url});
				}
			}
			
			csvReader.close();
		}
		
		String[] header = new String[]{"AUTHOR", "TOPIC", "URL" };
		responseCsv.addFirst(header);
		
		File output = new File(PREFIX_PATH + File.separator + "output");
		if(!output.exists()) {
			output.mkdirs();
		}
		
		CSVWriter writer = new CSVWriter(new FileWriter(PREFIX_PATH + "/output/author_url.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER,
				CSVWriter.NO_ESCAPE_CHARACTER);
		writer.writeAll(responseCsv);
		writer.close();
		
	
	}
}
