package dgallagher.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class AvailRequest extends RequestBase implements IRequest {

    public String type;

}
