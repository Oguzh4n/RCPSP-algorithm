
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Resource {
	
	// Number of a resource
	private int nummer;
	
	// Maximum availability 
	 int maxVerfuegbarkeit;
		
	public Resource(int verfuegbarkeit, int nummer){
		this.maxVerfuegbarkeit = verfuegbarkeit;
		this.nummer = nummer;
	}
	
	public int maxVerfuegbarkeit(){
		return maxVerfuegbarkeit;
	}
	
	public int nummer(){
		return nummer;
	}
	
	public static Resource[] read(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		Resource[] resources = new Resource[4];
		boolean found = false;
		while(scanner.hasNext()) {
			String nextLine = scanner.nextLine();
			if(nextLine.equals("")){
				continue;
			}
			Scanner next = new Scanner(nextLine);
			String nextString = next.next();

			if (! found && nextString.equals("R")) {
				found = true;
				continue;
			} 	
			if(found){
				resources[0] = new Resource(Integer.parseInt(nextString),1);
				if(next.hasNext()){
					resources[1] = new Resource(next.nextInt(),2);
					if(next.hasNext()){
						resources[2] = new Resource(next.nextInt(),3);
						if(next.hasNext()){
							resources[3] = new Resource(next.nextInt(),4);
						}
					}
				}
				break;
			}
		}
		return resources;
	}
}
