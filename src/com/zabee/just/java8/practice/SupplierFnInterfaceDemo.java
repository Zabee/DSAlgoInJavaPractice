import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class SupplierFnInterfaceDemo {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Supplier<LocalDateTime> dateSupplier = () -> LocalDateTime.now();
        print(dateSupplier);
    }
    
    private static void print(Supplier<LocalDateTime> dateTimeSupplier){
        System.out.println(dateTimeSupplier.get());
    }

}

/** Output
  2022-02-25T14:43:43.023498352
**/
