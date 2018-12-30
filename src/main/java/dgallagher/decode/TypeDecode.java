package dgallagher.decode;

import dgallagher.requests.AvailRequest;
import dgallagher.requests.IRequest;

import java.util.function.Function;

public class TypeDecode implements Function<IRequest, String> {

    @Override
    public final String apply(IRequest request){
        return ((AvailRequest)request).getType();
    }
}
