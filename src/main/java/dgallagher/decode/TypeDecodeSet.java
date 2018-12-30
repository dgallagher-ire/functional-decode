package dgallagher.decode;

import dgallagher.PayLoad;
import dgallagher.requests.AvailRequest;

import java.util.function.UnaryOperator;

public class TypeDecodeSet implements UnaryOperator<PayLoad>, IDecode {

    @Override
    public final PayLoad apply(PayLoad payLoad) {
        payLoad.setType(((AvailRequest) payLoad.getRequest()).getType());
        return payLoad;
    }
}
