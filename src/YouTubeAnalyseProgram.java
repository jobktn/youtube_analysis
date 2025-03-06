import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;


/** @author group08
 * The class to provide menus for a command line interface.
 */

public class YouTubeAnalyseProgram {
    List<YouTubeVideo> list = new ArrayList<>();
    YouTubeVideoIndexer indexer = new YouTubeVideoIndexer();
    YouTubeDataParser parser = new YouTubeDataParser();


    /**
     * Displays a menu of video data and prompt the user to choose one option.
     * If the user enters "7", they will be prompted to enter their own file path.
     * Then, parse the selected file and store the data in the 'list' field of the class.
     *
     * @throws YouTubeDataParserException If there is an error parsing the YouTube video data.
     */

    public void selectFile() throws YouTubeDataParserException {
        indexer = new YouTubeVideoIndexer();
        list = new ArrayList<>();
        System.out.println("---Performing YouTube Trending Analysis---");
        System.out.println("""
                1: youtubedata.json
                2: youtubedata_15_50.json
                3: youtubedata_indextest.json
                4: youtubedata_loremipsum.json
                5: youtubedata_malformed.json
                6: youtubedata_singleitem.json
                7: Enter your path file""");
        System.out.println("Enter the file number to analyse: ");
        Scanner scan = new Scanner(System.in);
        String fileNo = scan.nextLine();

        switch (fileNo) {
            case "1" -> list = parser.parse("data/youtubedata.json");
            case "2" -> list = parser.parse("data/youtubedata_15_50.json");
            case "3" -> list = parser.parse("data/youtubedata_indextest.json");
            case "4" -> list = parser.parse("data/youtubedata_loremipsum.json");
            case "5" -> list = parser.parse("data/youtubedata_malformed.json");
            case "6" -> list = parser.parse("data/youtubedata_singleitem.json");
            case "7" -> {
                System.out.println("Enter the file path: ");
                Scanner input = new Scanner(System.in);
                String path = input.nextLine();
                list = parser.parse(path);
            }
            default -> {
                System.out.println("Input the wrong number. Please try again.");
                selectFile();
            }
        }
    }

    /**
     * Displays a menu for selecting various actions.
     * This menu allows to choose from the following options:
     * 1: Sorting videos by...
     * 2: Analysing words in videos
     * 3: Back to the file selection menu
     * 4: Closing the program
     * After displaying the menu, it prompts to select a menu option.
     */

    public void menuSelection() throws YouTubeDataParserException {
        System.out.println("---Main menu---");
        System.out.println("""
                1: Sorting videos by...
                2: Analysing word in video
                3: Back to choose file menu
                4: Close program""");
        System.out.println("Enter the number from the menu to analyse: ");

    }


    /**
     * Displays a menu to the user to select a sorting method.
     * The method displays a list of available sorting methods and prompts the user to choose one.
     * After the user chooses a method, the list of videos is sorted using the appropriate comparator..
     *
     * Available Sorting Methods:
     * 1: Sorting by Channel
     * 2: Sorting by Date
     * 3: Sorting by Description
     * 4: Sorting by View Count
     *
     * @see YouTubeVideoChannelComparator
     * @see YouTubeVideoDateComparator
     * @see YouTubeVideoDescriptionComparator
     * @see YouTubeVideoViewComparator
     */

    public void sortMenu(){
        System.out.println("""
                1: Sorting by Channel
                2: Sorting by Date
                3: Sorting by Description
                4: Sorting by View""");
        System.out.println("Enter the number of sorting methods to analyse: ");

        Scanner scan = new Scanner(System.in);
        String methNo = scan.nextLine();
        switch (methNo) {
            case "1" -> list.sort(new YouTubeVideoChannelComparator());
            case "2" -> list.sort(new YouTubeVideoDateComparator());
            case "3" -> list.sort(new YouTubeVideoDescriptionComparator());
            case "4" -> list.sort(new YouTubeVideoViewComparator());
            default -> {
                System.out.println("Input the wrong number. Please try again.");
                sortMenu();
            }
        }
        System.out.println(list);
    }

    /**
     * Displays a menu for analyzing the words in a list of videos.
     * Word Analysis Options:
     * 1: Find the most used word in the list of videos.
     * 2: Sort and display word analysis results.
     * 3: Initiate custom word analysis.
     * @throws YouTubeDataParserException If there is an error parsing the YouTube video data.
     */

    public void wordMenu() throws YouTubeDataParserException {
        System.out.println("""
                1: Most used word in video
                2: Sort word video
                3: Find my own word""");
        System.out.println("Enter the number of sorting methods to analyse: ");

        Scanner scan = new Scanner(System.in);
        String methNo = scan.nextLine();
        indexer.index(list);
        list = new ArrayList<>();
        switch (methNo) {
            case "1" -> {
                System.out.println("The word is most appear in the list of videos is " + "\"" + indexer.findMostUsed() + "\"");
                System.out.println("appears " + indexer.wordCount(indexer.findMostUsed()) + " times in the list of videos.");
                System.out.println("Which are from "+ indexer.findAllVid(indexer.findMostUsed()).size()+" Videos");
                wantToshow(indexer.findMostUsed());
            }
            case "2" -> System.out.println(indexer.getSortedYoutubeWordItems());
            case "3" -> wordAnalysis();
            default -> {
                System.out.println("Input the wrong number. Please try again.");
                wordMenu();
            }
        }
    }

    /**
     * Prompts the user to enter a word and then prints the number of times the word appears in the list of videos
     * and the videos in which it appears.
     */

    public void wordAnalysis(){
        System.out.println( "Try a word in your mind: ");

        Scanner scan = new Scanner(System.in);
        String aword = scan.nextLine();

        if(aword != null && indexer.wordCount(aword)>0){

            System.out.println("The word \""+aword+"\" appears " + indexer.wordCount(aword) + " times in the list of videos.");
            System.out.println("Which are from "+ indexer.findAllVid(aword).size()+" Videos");
            wantToshow(aword);
        }else{
            System.out.println("Your word is not found. Please try again.");
            wordAnalysis();
        }

    }

    /**
     * Displays a list of videos option.
     * @param word The word to search for related videos.
     */
    public void wantToshow(String word){
        System.out.println("\nDo you want to show the list of videos (Y/N) ?");
        Scanner scan = new Scanner(System.in);
        String ans = scan.nextLine();

        if(ans.equalsIgnoreCase("y")){
            System.out.println("---This is the list of videos---");
            System.out.println(indexer.findAllVid(word));

        } else if (ans.equalsIgnoreCase("n")){
            //menuSelection();
        } else {
            System.out.println("Wrong input. Please try again.");
            wantToshow(word);
        }

    }

    /**
     * Implements the YouTube video analysis program.
     * @throws YouTubeDataParserException If there is an error parsing the YouTube video data.
     * @throws FileNotFoundException If can not find the selected file.
     */
    public static void progCombined() throws YouTubeDataParserException, FileNotFoundException {
        YouTubeAnalyseProgram prog = new YouTubeAnalyseProgram();
        Scanner input = new Scanner(System.in);

        boolean startOver;
        do {
            startOver = false;
            prog.selectFile();
            do {
                prog.menuSelection();

                switch (input.nextLine()) {
                    case "1" -> prog.sortMenu();
                    case "2" -> prog.wordMenu();
                    case "3" -> startOver = true;
                    case "4" -> {
                        System.out.println("---Closed Program---");
                        System.exit(0);
                    }
                    default -> System.out.println("Input the wrong number. Please try again.");
                }
            } while (!startOver);
        }while (startOver);
    }

}

