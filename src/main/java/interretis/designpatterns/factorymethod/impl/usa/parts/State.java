package interretis.designpatterns.factorymethod.impl.usa.parts;

import interretis.designpatterns.factorymethod.api.Part;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class State implements Part {

    @Getter
    private America parent;
}
