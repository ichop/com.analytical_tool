import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataAnalyzer {
    private List<WaitingTimeline> waitingTimelineList = new ArrayList<>();

    static {
        File file = new File("src/output.txt");
        if( file.exists()) {
            file.delete();
        }
    }

    public void analyze() {
        String[] lines = readFromFile();
        Arrays.stream(lines).forEach(l -> {
            if (l.charAt(0) == 'C') {
                WaitingTimeline waitingTimeline = new WaitingTimeline(l.substring(2, l.length()));
                waitingTimelineList.add(waitingTimeline);
            } else if (l.charAt(0) == 'D') {
                QueryLine queryLine = new QueryLine(l.substring(2, l.length()));
                selectMatches(queryLine);
            }
        });
    }

    private void selectMatches(QueryLine queryLine) {
        List<WaitingTimeline> matchedWaitingTimelines = new ArrayList<>();
        waitingTimelineList.forEach(e -> {
            if(queryLine.isMatch(e)) {
                matchedWaitingTimelines.add(e);
            }
        });
        String averageCount = countAverageTime(matchedWaitingTimelines);
        writeToFile(averageCount);
    }

    private String countAverageTime(List<WaitingTimeline> matchedWaitingTimelines) {

        int matchedElementsSum = matchedWaitingTimelines.stream().mapToInt(e -> e.time).sum();
        long matchedElementsCount = matchedWaitingTimelines.size();
        if (matchedElementsCount != 0) {
            return Long.toString(matchedElementsSum/matchedElementsCount);
        }
        else return "-";
    }

    private void writeToFile(String string) {
        File file = new File("src/output.txt");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(string);
            writer.newLine();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private String[] readFromFile() {
        try {
            File file = new File("src/input.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            int lineCount = Integer.parseInt(line);
            String[] lines = new String[lineCount + 1];
            for (int i = 0; i < lines.length; i++) {
                lines[i] = line;
                line = reader.readLine();
            }
            return lines;
        }
            catch(IOException e){
                e.printStackTrace();
            }
        return null;
        }
    }
