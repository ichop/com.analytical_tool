import java.util.Objects;

public class QuestionType {
    String questionTypeId;
    CategoryId categoryId;

    public QuestionType(String string) {
        String[] subStr = string.split("\\.");
        questionTypeId = subStr[0];
        if(subStr.length == 2) {
            categoryId = new CategoryId(subStr[1]);
        } else if (subStr.length == 3) {
            categoryId = new CategoryId(subStr[1] + "." + subStr[2]);
        }
    }

    public boolean isMatch(Object o) {
        if (this == o) return true;
        if (questionTypeId.equals("*")) return true;
        if (!(o instanceof QuestionType)) return false;
        QuestionType that = (QuestionType) o;
        if(categoryId != null) {
            return Objects.equals(questionTypeId, that.questionTypeId) &&
                    (categoryId.match(that.categoryId) || categoryId == null);
        } else return Objects.equals(questionTypeId, that.questionTypeId);

    }

    @Override
    public String toString() {
        return "QuestionType{" +
                "questionTypeId='" + questionTypeId + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

}
