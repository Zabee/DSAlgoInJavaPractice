import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.DoubleSupplier;

public class SupplierFnInterfaceDemo {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Supplier<LocalDateTime> dateSupplier = () -> LocalDateTime.now();
        print(dateSupplier);
        
        IntSupplier intSup = () -> 10;
        System.out.println(intSup.getAsInt());
        
        LongSupplier longSup = () -> 10L;
        System.out.println(longSup.getAsLong());
        
        DoubleSupplier dblSup = () -> 10.0;
        System.out.println(dblSup.getAsDouble());
    }
    
    private static void print(Supplier<LocalDateTime> dateTimeSupplier){
        System.out.println(dateTimeSupplier.get());
    }

}

/** Output
  2022-02-25T17:09:45.930338150
    10
    10
    10.0
**/
