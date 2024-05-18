import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {
	private Set<String> wordsSet;

	public Dictionary() throws IOException {
		Path path = Paths.get("words.txt");
		byte[] readBytes = Files.readAllBytes(path);
		// Added .toLowerCase() so that every word would be scanned regardless of
		// lower/upper case.
		String wordListContents = new String(readBytes, "UTF-8").toLowerCase();
		String[] words = wordListContents.split("\n");
		wordsSet = new HashSet<>();
		Collections.addAll(wordsSet, words);
	}

	public boolean contains(String word) {
		return wordsSet.contains(word);
	}
}

// God bless stackoverflow.
// https://stackoverflow.com/questions/11607270/how-to-check-whether-given-string-is-a-word