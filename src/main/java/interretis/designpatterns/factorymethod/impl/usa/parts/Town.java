package interretis.designpatterns.factorymethod.impl.usa.parts;

import interretis.designpatterns.factorymethod.api.Part;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Town implements Part {

    @Getter
    private County parent;
}
