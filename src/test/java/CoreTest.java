import com.fasterxml.jackson.databind.ObjectMapper;
import dgallagher.PayLoad;
import dgallagher.decode.*;
import dgallagher.requests.AvailRequest;
import dgallagher.requests.IRequest;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class CoreTest {

    @Test
    void functionality(){
        ObjectMapper mapper = new ObjectMapper();
        final IRequest ar = new AvailRequest();
        ((AvailRequest)ar).setType("Declan");
        Stream.of(new NameDecode(), new TypeDecode()).forEachOrdered(val -> System.out.println(val.apply(ar)));
        try {
            System.out.println(mapper.writeValueAsString(ar));
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
        // Payload
        final PayLoad pl = new PayLoad();
        final IRequest rq = new AvailRequest();
        ((AvailRequest)rq).setName("declan");
        ((AvailRequest)rq).setType("mytype");
        pl.setRequest(rq);
        try {
            System.out.println(mapper.writeValueAsString(pl));
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
        // use reflection to list all classes to use
        //Class<?> clazz = Class.forName(className.get());
        // PaymentMethod method = (PaymentMethod) clazz.newInstance();
        final DecodeConsumer dc = new DecodeConsumer();
        Stream.of(new NameDecodeSet(), new TypeDecodeSet()).forEachOrdered(fn -> dc.accept(fn, pl));
        try {
            System.out.println(mapper.writeValueAsString(pl));
        } catch(Exception ex){
            System.out.println(ex.toString());
        }

        Stream.of("A","B").forEachOrdered(String::toUpperCase);
    }
}
