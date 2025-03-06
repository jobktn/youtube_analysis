import java.io.FileNotFoundException;
import java.util.Scanner;

/** @author group08
 * A command-line interface for the YouTubeTrender application.
 */

public class YouTubeVideoCLI {

    /**
     * The main method of the YouTubeVideoCLI class.
     * @param args The command-line interface arguments.
     * @throws FileNotFoundException If a YouTube video data file is not found.
     * @throws YouTubeDataParserException If a YouTube video data file cannot be parsed.
     */
    public static void main(String[] args) throws FileNotFoundException, YouTubeDataParserException {

        System.out.println("---YouTube Trender Application---");
        YouTubeAnalyseProgram prog = new YouTubeAnalyseProgram();
        prog.progCombined();

    }
}
