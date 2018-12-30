package dgallagher.decode;

import dgallagher.PayLoad;
import dgallagher.requests.IRequest;
import dgallagher.requests.RequestBase;

import java.util.function.UnaryOperator;

public class NameDecodeSet implements UnaryOperator<PayLoad>, IDecode {

    @Override
    public final PayLoad apply(PayLoad payLoad){
        payLoad.setName(((RequestBase)payLoad.getRequest()).getName());
        return payLoad;
    }
}
