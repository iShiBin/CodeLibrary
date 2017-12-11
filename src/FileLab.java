import java.io.File;
import java.io.IOException;

public class FileLab {

	public static void main(String[] args) throws IOException {
		File file = new File ("..", "new_file.txt");;
		if(!file.exists()) {
			file.createNewFile();
		}
	}
}