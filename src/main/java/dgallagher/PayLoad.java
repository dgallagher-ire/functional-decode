package dgallagher;

import dgallagher.requests.IRequest;
import lombok.Data;

@Data
public class PayLoad {

    private IRequest request;
    private String name;
    private String type;
}
