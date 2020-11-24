import java.util.Objects;

public class QueryLine {
    ServiceId serviceId;
    QuestionType questionType;
    Character responseType;
    QuestionDate questionDate;

    public QueryLine(String line) {
        String[] subStr;
        subStr = line.split(" ");
        serviceId = new ServiceId(subStr[0]);
        questionType = new QuestionType(subStr[1]);
        responseType = subStr[2].charAt(0);
        questionDate = new QuestionDate(subStr[3]);
    }

    public boolean isMatch(WaitingTimeline waitingTimeline) {
        return  serviceId.isMatch(waitingTimeline.serviceId) &&
                questionType.isMatch(waitingTimeline.questionType) &&
                Objects.equals(responseType, waitingTimeline.responseType) &&
                questionDate.match(waitingTimeline.questionDate);
    }


    @Override
    public String toString() {
        return "QueryLine{" +
                "serviceId=" + serviceId +
                ", questionType=" + questionType +
                ", responseType=" + responseType +
                ", questionDate=" + questionDate +
                '}';
    }
}
