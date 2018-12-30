package dgallagher.decode;

import dgallagher.PayLoad;

import java.util.function.BiConsumer;
import java.util.function.UnaryOperator;

public class DecodeConsumer implements BiConsumer<UnaryOperator<PayLoad>, PayLoad> {

    @Override
    public void accept(UnaryOperator<PayLoad> operator, PayLoad payload) {
        operator.apply(payload);
    }
}
