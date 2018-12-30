package dgallagher.decode;

import dgallagher.PayLoad;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public interface IDecode {

    static Stream<UnaryOperator<PayLoad>> DECODE_SET_CHAIN = null;//Stream.of(new NameDecodeSet());

    default Stream<UnaryOperator<PayLoad>> getDecodeSetChain(){
        return DECODE_SET_CHAIN;
    }

    default Stream<Function> getDecodeChain(){
        return Stream.of(new NameDecode(), new TypeDecode());
    }

}
