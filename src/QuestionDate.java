import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QuestionDate {
    Date dateFrom;
    Date dateTo;

    public QuestionDate(String string) {
        String[] dateSubStr =  string.split("-");

        try {
            dateFrom = new SimpleDateFormat("dd.MM.yyyy").parse(dateSubStr[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dateSubStr.length == 2) {
            try {
                dateTo = new SimpleDateFormat("dd.MM.yyyy").parse(dateSubStr[1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            dateTo = null;
        }
    }


    public boolean match(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionDate)) return false;
        QuestionDate that = (QuestionDate) o;
        if (dateTo != null){
           return  (that.dateFrom.after(dateFrom) || that.dateFrom.equals(dateFrom)) &&
                    (that.dateFrom.before(dateTo)  || that.dateFrom.equals(dateTo));
        }
        else return that.dateFrom.equals(dateFrom);
    }

    @Override
    public String toString() {
        return "QuestionDate{" +
                "dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
