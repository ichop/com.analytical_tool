
public class WaitingTimeline {
    ServiceId serviceId;
    QuestionType questionType;
    Character responseType;
    QuestionDate questionDate;
    Integer time;

    public WaitingTimeline(String line) {
        String[] subStr;
        subStr = line.split(" ");
        serviceId = new ServiceId(subStr[0]);
        questionType = new QuestionType(subStr[1]);
        responseType = subStr[2].charAt(0);
        questionDate = new QuestionDate(subStr[3]);
        time = Integer.parseInt(subStr[4]);
    }

    @Override
    public String toString() {
        return "WaitingTimeline{" +
                "serviceId=" + serviceId +
                ", questionType=" + questionType +
                ", responseType=" + responseType +
                ", questionDate=" + questionDate +
                ", time=" + time +
                '}';
    }
}
