package interretis.designpatterns.factorymethod.impl.poland.parts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import interretis.designpatterns.factorymethod.api.Part;

@AllArgsConstructor
public class Commune implements Part {

    @Getter
    private District parent;
}
