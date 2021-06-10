
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
public class PyramidCSVDAO {
	
	public Pyramid createPyramid(String[] fields ) 
	{
		
		 String pharaoh = fields[0];
		 String modern_name = fields[2] ;
		 String site = fields[4];
		 String height = fields[7];
		
		Pyramid pyr = new Pyramid(pharaoh , modern_name, site, height);
		return pyr ; 
		
	}

	public List<Pyramid> readPyramidFromCsv(String fileName)
	{
		
		List<Pyramid> pyramid_list = new ArrayList<Pyramid>(); 
		File pyramid = new File(fileName);
		
		List<String> lines = new ArrayList<String>();
		try {
			
			lines = Files.readAllLines(pyramid.toPath());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("an assue had been happend during reading");
		}
		
		for(int lineIdx=1 ;lineIdx<lines.size();lineIdx++) 
		{
			String line = lines.get(lineIdx);
			
			String[] fields = line.split(",");
			
			
			Pyramid pyr = createPyramid(fields);
			pyramid_list.add(pyr);
		}
		
		return pyramid_list;
		
	}
}
