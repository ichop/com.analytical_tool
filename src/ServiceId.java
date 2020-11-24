import java.util.Objects;

public class ServiceId{
    String serviceId;
    String variationId;

    public ServiceId(String string) {
        String[] subStr = string.split("\\.");
        serviceId = subStr[0];
        if(subStr.length == 2){
            variationId = subStr[1];
        }
    }

    public boolean isMatch(Object o) {
        if (this == o) return true;
        if(serviceId.equals("*")) return true;
        if (!(o instanceof ServiceId)) return false;
        ServiceId serviceId1 = (ServiceId) o;

        return Objects.equals(serviceId, serviceId1.serviceId) &&
                (Objects.equals(variationId, serviceId1.variationId) || variationId == null) ;
    }

    @Override
    public String toString() {
        return "ServiceId{" +
                "serviceId='" + serviceId + '\'' +
                ", variationId='" + variationId + '\'' +
                '}';
    }
}
