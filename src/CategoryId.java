import java.util.Objects;

public class CategoryId {
    String categoryId;
    String subCategoryId;

    public CategoryId(String string) {
        String[] subStr = string.split("\\.");
        categoryId = subStr[0];
        if(subStr.length == 2) {
            subCategoryId = subStr[1];
        }
    }

    public boolean match(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryId)) return false;
        CategoryId that = (CategoryId) o;
        return Objects.equals(categoryId, that.categoryId) &&
                (Objects.equals(subCategoryId, that.subCategoryId) || subCategoryId == null);
    }


    @Override
    public String toString() {
        return "CategoryId{" +
                "categoryId='" + categoryId + '\'' +
                ", subCategoryId='" + subCategoryId + '\'' +
                '}';
    }
}

