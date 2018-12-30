package dgallagher.decode;

import dgallagher.requests.IRequest;
import dgallagher.requests.RequestBase;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.function.Function;

public class NameDecode implements Function<IRequest, String> {

    @Override
    public final String apply(IRequest request){
        return ((RequestBase)request).getName();
    }
}
